package com.xir.NHUtilities.common.tiles;

import static com.xir.NHUtilities.inventory.lunchBoxPlus.FoodContainerInventoryPlus.TOKEN_AE_STACK;
import static com.xir.NHUtilities.inventory.lunchBoxPlus.FoodContainerInventoryPlus.TOKEN_ITEM_STACK;

import java.util.Comparator;
import java.util.HashSet;
import java.util.UUID;
import java.util.function.Predicate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.tiles.utils.DispatchUnit;
import com.xir.NHUtilities.main.NHUtilities;
import com.xir.NHUtilities.utils.CommonUtil;

import appeng.api.config.Actionable;
import appeng.api.config.PowerMultiplier;
import appeng.api.networking.GridFlags;
import appeng.api.networking.IGridNode;
import appeng.api.networking.energy.IEnergyGrid;
import appeng.api.networking.security.BaseActionSource;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.MachineSource;
import appeng.api.storage.IMEMonitor;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.util.AECableType;
import appeng.api.util.DimensionalCoord;
import appeng.items.tools.ToolBiometricCard;
import appeng.me.GridAccessException;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import appeng.tile.inventory.AppEngInternalInventory;
import appeng.tile.inventory.IAEAppEngInventory;
import appeng.tile.inventory.InvOperation;
import appeng.util.item.AEItemStack;
import cpw.mods.fml.relauncher.Side;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import lombok.NonNull;
import squeek.applecore.api.food.IEdible;
import squeek.spiceoflife.items.ItemFoodContainer;

public class TileLunchDispatcher extends TileEntity
    implements IActionHost, IGridProxyable, IAEAppEngInventory, ISidedInventory {

    // constants
    // spotless:off
    public static final int level = 5;
    protected static final UUID defaultUUid = null;
    protected static final Predicate<ItemStack> predicate_level =
        x -> x.getMaxStackSize() > 1 && x.stackSize < Math.min(x.getMaxStackSize(), level);
    protected static final ObjectOpenHashSet<IAEItemStack> EMPTY_AESTACK_SET = ObjectOpenHashSet.of();
    public static final int ROW_SIZE = 5;
    public static final int COLUMN_SIZE = 3;

    // only used for server-logic-side
    protected UUID ownerUUid = null;
    protected static final String KEY_UUID = "ownerUUid";
    // 30s per operation
    protected static final long WORK_TICK = 20L * 30;
    protected AENetworkProxy gridProxy = null;
    protected long mTickTimer = 0;
    protected MachineSource requestSource;
    protected final AppEngInternalInventory internalInv = new AppEngInternalInventory(this, ROW_SIZE * COLUMN_SIZE);
    // spotless:on

    @Override
    public void invalidate() {
        super.invalidate();
        if (gridProxy != null) gridProxy.invalidate();
    }

    @Override
    public void onChunkUnload() {
        super.onChunkUnload();
        if (gridProxy != null) gridProxy.invalidate();
    }

    @Override
    public void validate() {
        super.validate();
        this.mTickTimer = 0;
    }

    public void setOwnerUUid(UUID uniqueID) {
        this.ownerUUid = uniqueID;
        this.markDirty();
    }

    @Override
    public void updateEntity() {
        CommonUtil.sideApply(Side.SERVER, () -> {
            mTickTimer++;
            if (mTickTimer == 1) getProxy().onReady();
            if (mTickTimer % WORK_TICK != 0) return;

            if (!getProxy().isActive()) return;

            var time = System.nanoTime();
            var units = findValidDispatchUnit();
            if (units.isEmpty()) return;

            var edibleItemList = getEdibleItemListFromAE();
            if (edibleItemList.isEmpty()) return;

            try {
                var extractor = getProxy().getStorage()
                    .getItemInventory();
                var energyExtractor = getProxy().getEnergy();

                for (var unit : units) {

                    var inventoryPlus = unit.getInventoryPlus()
                        .sortItemBy(Comparator.comparing(ItemStack::getDisplayName));
                    var recordFoods = new ObjectOpenHashSet<>(inventoryPlus.getAvailableFoods(TOKEN_AE_STACK));
                    for (ItemStack food : inventoryPlus.getAvailableFoods(TOKEN_ITEM_STACK, predicate_level)) {
                        var req = AEItemStack.create(food);
                        var ori = edibleItemList.get(req);
                        if (ori != null) {
                            var count = Math.min(ori.getStackSize(), level - food.stackSize);
                            if (count <= 0) continue;
                            var res = extractFromAe(req, count, extractor, energyExtractor);
                            if (res == null) continue;
                            CommonUtil.setItemStackSize(res.getStackSize() + food.stackSize, food);
                            recordFoods.add(ori);
                        }
                    }

                    var itrList = new ObjectOpenHashSet<IAEItemStack>();
                    for (IAEItemStack fo : edibleItemList)
                        if (!recordFoods.contains(fo) && fo.getStackSize() > 0) itrList.add(fo);

                    for (Integer index : inventoryPlus.getEmptySlotIndexes()) {
                        for (IAEItemStack food : itrList) {
                            var cis = food.getItemStack();
                            var count = Math.min(food.getStackSize(), Math.min(cis.getMaxStackSize(), level));
                            var res = extractFromAe(food.copy(), count, extractor, energyExtractor);
                            if (res == null) continue;
                            inventoryPlus.setSlotContent(index, CommonUtil.setItemStackSize(res.getStackSize(), cis));
                            itrList.remove(food);
                            break;
                        }
                    }

                    unit.markDirty();
                }

            } catch (GridAccessException ignored) {

            } finally {
                time = System.nanoTime() - time;
                NHUtilities.LOG.info("Time ==> ms: {}, ns: {},", (double) time / 1_000_000L, time);
            }
        });
    }

    private IAEItemStack extractFromAe(IAEItemStack req, long count, IMEMonitor<IAEItemStack> extractor,
        IEnergyGrid energyExtractor) {
        var res = extractor.extractItems(req.setStackSize(count), Actionable.MODULATE, getRequestSource());
        energyExtractor.extractAEPower(req.getStackSize(), Actionable.MODULATE, PowerMultiplier.CONFIG);
        return res;
    }

    protected ImmutableList<DispatchUnit> findValidDispatchUnit() {
        if (worldObj == null) return ImmutableList.of();
        var builder = ImmutableList.<DispatchUnit>builder();
        var hash = new HashSet<UUID>();
        for (ItemStack card : internalInv) {
            if (CommonUtil.isStackInvalid(card)) continue;
            if (card.getItem() instanceof ToolBiometricCard biometricCard) {
                var profile = biometricCard.getProfile(card);
                if (profile != null && profile.getId() != null) {
                    var uid = profile.getId();
                    if (!hash.contains(uid)) {
                        hash.add(uid);
                        EntityPlayer player = worldObj.func_152378_a(profile.getId());
                        if (player == null) continue;
                        var unit = new DispatchUnit(player);
                        if (unit.isValid() && unit.canProcess()) builder.add(unit);
                    }
                }
            }
        }
        return builder.build();
    }

    private @NotNull ObjectOpenHashSet<IAEItemStack> getEdibleItemListFromAE() {
        if (getProxy().isActive()) {
            var proxy = getProxy();
            try {
                var storageList = proxy.getStorage()
                    .getItemInventory()
                    .getStorageList();
                if (storageList.isEmpty()) return EMPTY_AESTACK_SET;
                var edibleItemList = new ObjectOpenHashSet<IAEItemStack>();
                for (IAEItemStack stack : storageList) if (stack != null && isEdible(stack)) edibleItemList.add(stack);
                return edibleItemList;
            } catch (GridAccessException ignored) {}
        }
        return EMPTY_AESTACK_SET;
    }

    protected BaseActionSource getRequestSource() {
        return requestSource != null ? requestSource : (requestSource = new MachineSource(this));
    }

    // 考虑性能问题, 遍历不应该aeStack.getItemStack
    // 所以 只考虑实现IEdible或继承自ItemFood 的food
    private boolean isEdible(@NonNull IAEItemStack aeStack) {
        var item = aeStack.getItem();
        if (item instanceof ItemFoodContainer || item == Items.cake) return false;
        return item instanceof ItemFood || item instanceof IEdible;
    }

    @NotNull
    @Override
    public AENetworkProxy getProxy() {
        if (this.gridProxy == null) {
            this.gridProxy = new AENetworkProxy(this, "proxy", NHUItemList.LunchDispatcher.get(1), true);
            this.gridProxy.setFlags(GridFlags.REQUIRE_CHANNEL, GridFlags.DENSE_CAPACITY);

            if (worldObj != null && ownerUUid != null) {
                var player = worldObj.func_152378_a(ownerUUid);
                if (player != null) this.gridProxy.setOwner(player);
            }
        }
        return this.gridProxy;
    }

    @Override
    public DimensionalCoord getLocation() {
        return new DimensionalCoord(this);
    }

    @Override
    public IGridNode getActionableNode() {
        return getProxy().getNode();
    }

    @Override
    public IGridNode getGridNode(ForgeDirection dir) {
        return getProxy().getNode();
    }

    @Override
    public AECableType getCableConnectionType(ForgeDirection dir) {
        return AECableType.COVERED;
    }

    @Override
    public void gridChanged() {
        // not use
    }

    @Override
    public void securityBreak() {
        // not use
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        try {
            this.ownerUUid = UUID.fromString(tagCompound.getString(KEY_UUID));
        } catch (IllegalArgumentException ignored) {
            this.ownerUUid = defaultUUid;
        }

        // inventory
        var inv = tagCompound.getCompoundTag("inv");
        for (int i = 0; i < internalInv.getSizeInventory(); i++) {
            var item = inv.getCompoundTag("item" + i);
            internalInv.setInventorySlotContents(i, ItemStack.loadItemStackFromNBT(item));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setString(KEY_UUID, ownerUUid == null ? "" : ownerUUid.toString());

        // inventory
        var inv = new NBTTagCompound();
        for (int i = 0; i < internalInv.getSizeInventory(); i++) {
            var item = new NBTTagCompound();
            var is = internalInv.getStackInSlot(i);
            if (is != null) {
                is.writeToNBT(item);
            }
            inv.setTag("item" + i, item);
        }
        tagCompound.setTag("inv", inv);
    }

    public AppEngInternalInventory getIdCardInv() {
        return this.internalInv;
    }

    @Override
    public void saveChanges() {
        this.markDirty();
    }

    @Override
    public void onChangeInventory(IInventory inv, int slot, InvOperation mc, ItemStack removedStack,
        ItemStack newStack) {}

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack insert, int side) {
        return true;
    }

    @Override
    public boolean canExtractItem(final int index, final ItemStack extract, int side) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return this.internalInv.getSizeInventory();
    }

    @Override
    public ItemStack getStackInSlot(int slotIn) {
        return this.internalInv.getStackInSlot(slotIn);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return this.internalInv.decrStackSize(index, count);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return this.internalInv.getStackInSlotOnClosing(index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.internalInv.setInventorySlotContents(index, stack);
    }

    @Override
    public String getInventoryName() {
        return this.getClass()
            .getSimpleName();
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return this.internalInv.getInventoryStackLimit();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj != null && (worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this);
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }
}
