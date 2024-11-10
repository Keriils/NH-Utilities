package com.xir.NHUtilities.common.machine.single;

import static gregtech.api.enums.GTValues.GT;
import static gregtech.api.enums.GTValues.V;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_DRAGONEGG;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_DRAGONEGG_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_FRONT;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_FRONT_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_FRONT_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_FRONT_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.MACHINE_CASING_MAGIC_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_OUT_MULTI;
import static gregtech.api.objects.XSTR.XSTR_INSTANCE;
import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static net.minecraft.util.StatCollector.translateToLocal;
import static tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.brandon3055.draconicevolution.common.ModItems;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.api.screen.UIBuildContext;
import com.xir.NHUtilities.common.api.enums.NHUItemList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.ParticleFX;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.MTEBasicGenerator;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTUtility;
import gregtech.api.util.WorldSpawnedEventBuilder;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;

public class MTEMagicalEggMachine extends MTEBasicGenerator {

    private UUID ownerUUID;
    private int eggBonus;
    private int MaterialBonus;
    private byte currentTier;
    private long totalValidTick;
    private long currentAmperes = 1;
    private boolean isWirelessMode = false;
    private ITexture[][][] newTexture;
    private boolean shouldUpdateTexture = false;
    // this field for display common texture
    private boolean isPlaced = false;
    private static final ItemStack[] CORE_MATERIAL = new ItemStack[] { new ItemStack(ModItems.dragonHeart, 1, 0),
        new ItemStack(ModItems.draconicCore, 1, 0), new ItemStack(ModItems.wyvernCore, 1, 0),
        new ItemStack(ModItems.awakenedCore, 1, 0), new ItemStack(ModItems.chaoticCore, 1, 0) };

    // region Constructor
    public MTEMagicalEggMachine(int aID, String aNameRegional, int aTier) {
        super(aID, "egg machine" + aTier, aNameRegional, aTier, new String[0]);
        if (GT.isClientSide()) newTexture = mTextures;
        currentTier = (byte) aTier;
        isPlaced = true;
    }

    public MTEMagicalEggMachine(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
        if (GT.isClientSide()) newTexture = mTextures;
        currentTier = (byte) aTier;
        isPlaced = true;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEMagicalEggMachine(mName, mTier, mDescriptionArray, newTexture);
    }
    // endregion

    // region Setting Override
    @Override
    public int getPollution() {
        return 0;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return null;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getEfficiency() {
        return 0;
    }

    @Override
    public boolean isFluidInputAllowed(FluidStack aFluid) {
        return false;
    }

    @Override
    public boolean isLiquidInput(ForgeDirection side) {
        return false;
    }

    @Override
    public boolean allowPullStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, ForgeDirection side,
        ItemStack aStack) {
        return aIndex == getInputSlot();
    }

    @Override
    public boolean allowPutStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, ForgeDirection side,
        ItemStack aStack) {
        return aIndex == getInputSlot();
    }
    // endregion

    // region Logic

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
        ownerUUID = aBaseMetaTileEntity.getOwnerUuid();
    }

    private void clearBuffer() {
        eggBonus = 1;
        currentAmperes = 1;
        MaterialBonus = 1;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (!aBaseMetaTileEntity.isServerSide()) return;
        if (!aBaseMetaTileEntity.isAllowedToWork()) return;
        if (!isWirelessMode && (aBaseMetaTileEntity.getUniversalEnergyStored() >= aBaseMetaTileEntity.getEUCapacity()))
            return;

        if (!hasValidEgg()) {
            clearBuffer();
            return;
        }

        currentAmperes = calculateAmp();
        eggBonus = getEggBonus();
        MaterialBonus = getMaterialBonus();

        if (isWirelessMode) {
            totalValidTick++;
            if (aTick % 256 == 0) {
                if (totalValidTick == 0) return;
                BigInteger totalEU = BigInteger.valueOf(totalValidTick * V[mTier] * eggBonus * MaterialBonus);
                if (addEUToGlobalEnergyMap(ownerUUID, totalEU)) {
                    totalValidTick = 0;
                }
            }
        } else {
            long currentPower = V[mTier] * eggBonus * MaterialBonus;
            aBaseMetaTileEntity.increaseStoredEnergyUnits(currentPower, true);
            aBaseMetaTileEntity.setActive(true);
        }
    }

    private int getMaterialBonus() {
        ItemStack item = mInventory[0];
        if (item == null) return 1;
        for (int i = 0; i < CORE_MATERIAL.length; i++) {
            if (GTUtility.areStacksEqual(item, CORE_MATERIAL[i], true)) {
                return 2 << i;
            }
        }
        return 1;
    }

    private boolean hasValidEgg() {
        Block block = getBaseMetaTileEntity().getBlockAtSide(ForgeDirection.UP);
        if (block == null) return false;
        if (block == Blocks.air) return false;
        if (block == Blocks.dragon_egg) return true;
        return block instanceof BlockDragonEgg;
    }

    private int getEggBonus() {
        Block block = getBaseMetaTileEntity().getBlockAtSide(ForgeDirection.UP);
        if (block.getUnlocalizedName()
            .contains("creeperEgg")) return 1;
        if (block == Blocks.dragon_egg) return 4;
        if (block == NHUItemList.ChaosDragonEgg.getBlock()) return 16;
        if (block.getUnlocalizedName()
            .contains("infinityegg")) return 64;
        if (block == NHUItemList.AncientDragonEgg.getBlock()) return 256;
        return 0;
    }

    @Override
    public long maxEUStore() {
        return Math.max(getEUVar(), V[mTier] * 114514L);
    }

    @Override
    public long maxEUOutput() {
        if (!getBaseMetaTileEntity().isAllowedToWork()) return 0L;
        return V[currentTier];
    }

    @Override
    public long maxAmperesOut() {
        return currentAmperes == 0 ? 1 : currentAmperes;
    }

    @Override
    public boolean isOutputFacing(ForgeDirection side) {
        return !isWirelessMode && side == getBaseMetaTileEntity().getFrontFacing();
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        aNBT.setInteger("eggBonus", eggBonus);
        aNBT.setByte("currentTier", currentTier);
        aNBT.setLong("currentAmperes", currentAmperes);
        aNBT.setLong("MaterialBonus", MaterialBonus);
        aNBT.setBoolean("isWirelessMode", isWirelessMode);
        aNBT.setLong("totalValidTick", totalValidTick);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        eggBonus = aNBT.getInteger("eggBonus");
        currentTier = aNBT.getByte("currentTier");
        currentAmperes = aNBT.getLong("currentAmperes");
        MaterialBonus = aNBT.getInteger("MaterialBonus");
        isWirelessMode = aNBT.getBoolean("isWirelessMode");
        totalValidTick = aNBT.getLong("totalValidTick");
    }

    private long calculateAmp() {
        return (long) eggBonus * MaterialBonus << ((mTier - currentTier) * 2);
    }
    // endregion

    // region Sec Info
    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ,
        ItemStack aTool) {
        if (!getBaseMetaTileEntity().isServerSide()) return;
        if (isWirelessMode) return;
        if (aPlayer.isSneaking()) {
            if (--currentTier < 0) currentTier = mTier;
        } else {
            if (++currentTier > mTier) currentTier = 0;
        }
        currentAmperes = calculateAmp();
        GTUtility.sendChatToPlayer(
            aPlayer,
            "Current EU Output: " + GTUtility.formatNumbers(V[currentTier])
                + String.format(
                    " (%s) (%s)",
                    GTUtility.getColoredTierNameFromTier(currentTier),
                    EnumChatFormatting.LIGHT_PURPLE + GTUtility.formatNumbers(currentAmperes)
                        + "A"
                        + EnumChatFormatting.RESET));
    }

    @Override
    public boolean onWireCutterRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer aPlayer,
        float aX, float aY, float aZ, ItemStack aTool) {
        if (mTier >= 9 && getBaseMetaTileEntity().isServerSide()) {
            isWirelessMode = !isWirelessMode;
            GTUtility.sendChatToPlayer(aPlayer, "Wireless Mode: " + (isWirelessMode ? "On" : "Off"));
        }
        return super.onWireCutterRightClick(side, wrenchingSide, aPlayer, aX, aY, aZ, aTool);
    }

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        final NBTTagCompound tag = accessor.getNBTData();
        final long voltage = V[tag.getByte("currentTier")];
        final long Amperes = tag.getLong("currentAmperes");

        currentTip.add(
            String.format(
                "Voltage: %s (%s)",
                GTUtility.getColoredTierNameFromVoltage(voltage),
                EnumChatFormatting.LIGHT_PURPLE + GTUtility.formatNumbers(Amperes) + "A" + EnumChatFormatting.RESET));
        currentTip.add(
            String.format(
                "TotalBonus: %sx",
                "" + EnumChatFormatting.GOLD + (tag.getInteger("eggBonus") * tag.getInteger("MaterialBonus"))));
        super.getWailaBody(itemStack, currentTip, accessor, config);
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        tag.setByte("currentTier", currentTier);
        tag.setLong("currentAmperes", currentAmperes);
        tag.setInteger("eggBonus", eggBonus);
        tag.setInteger("MaterialBonus", MaterialBonus);
    }

    @Override
    public void addUIWidgets(ModularWindow.Builder builder, UIBuildContext buildContext) {
        getBaseMetaTileEntity().add1by1Slot(builder);
    }

    @Override
    public String[] getDescription() {
        ArrayList<String> list = new ArrayList<>();
        list.add(translateToLocal("nhu.tooltips.eggMachine.type"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.line"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info0"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info1"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info2"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info3"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.line"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info4"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info5"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info6"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info7"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info8"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info9"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.line"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info10"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info11"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info12"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info13"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info14"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.info15"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.line"));
        list.add(translateToLocal("nhu.logotype.gt.logo"));
        list.add(translateToLocal("nhu.tooltips.eggMachine.line"));
        return list.toArray(new String[0]);
    }
    // endregion

    // region Texture
    @Override
    public byte getUpdateData() {
        return (byte) ((isWirelessMode ? 1 : 0) << 4 | currentTier); // 0001 1111
    }

    @Override
    public void onValueUpdate(byte aValue) {
        boolean oIsWirelessMode = isWirelessMode;
        byte oTier = currentTier;
        isWirelessMode = ((aValue & 0x10) == 0x10);
        currentTier = (byte) (aValue & 0x0F);
        if (oIsWirelessMode != isWirelessMode || oTier != currentTier) {
            shouldUpdateTexture = true;
        }
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side,
        ForgeDirection facingDirection, int colorIndex, boolean active, boolean redStoneLevel) {
        if (shouldUpdateTexture) {
            shouldUpdateTexture = false;
            if (GT.isClientSide()) newTexture = getTextureSet(null);
        }
        return newTexture[(active ? 5 : 0) + (side == facingDirection ? 0
            : side == facingDirection.getOpposite() ? 1
                : side == ForgeDirection.DOWN ? 2 : side == ForgeDirection.UP ? 3 : 4)][colorIndex + 1];
    }

    @Override
    public ITexture[] getFront(byte aColor) {
        ITexture[] ENERGY_OUT = OVERLAYS_ENERGY_OUT_MULTI;
        if (isWirelessMode) ENERGY_OUT = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
        return new ITexture[] { super.getFront(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_GLOW)
                .glow()
                .build(),
            ENERGY_OUT[isPlaced ? currentTier : mTier] };
    }

    @Override
    public ITexture[] getBack(byte aColor) {
        return new ITexture[] { super.getBack(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC_FRONT),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_FRONT_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getBottom(byte aColor) {
        return new ITexture[] { super.getBottom(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getTop(byte aColor) {
        return new ITexture[] { super.getTop(aColor)[0], TextureFactory.of(MACHINE_CASING_DRAGONEGG) };
    }

    @Override
    public ITexture[] getSides(byte aColor) {
        return new ITexture[] { super.getSides(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getFrontActive(byte aColor) {
        ITexture[] ENERGY_OUT = OVERLAYS_ENERGY_OUT_MULTI;
        if (isWirelessMode) ENERGY_OUT = OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
        return new ITexture[] { super.getFrontActive(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC_ACTIVE),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_ACTIVE_GLOW)
                .glow()
                .build(),
            ENERGY_OUT[isPlaced ? currentTier : mTier] };
    }

    @Override
    public ITexture[] getBackActive(byte aColor) {
        return new ITexture[] { super.getBackActive(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC_FRONT_ACTIVE),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_FRONT_ACTIVE_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getBottomActive(byte aColor) {
        return new ITexture[] { super.getBottomActive(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC_ACTIVE),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_ACTIVE_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getTopActive(byte aColor) {
        return new ITexture[] { super.getTopActive(aColor)[0], TextureFactory.of(MACHINE_CASING_DRAGONEGG),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_DRAGONEGG_GLOW)
                .glow()
                .build() };
    }

    @Override
    public ITexture[] getSidesActive(byte aColor) {
        return new ITexture[] { super.getSidesActive(aColor)[0], TextureFactory.of(MACHINE_CASING_MAGIC_ACTIVE),
            TextureFactory.builder()
                .addIcon(MACHINE_CASING_MAGIC_ACTIVE_GLOW)
                .glow()
                .build() };
    }
    // endregion

    /**
     * Draws random portal particles on top when active with an egg on top
     *
     * @param aBaseMetaTileEntity The entity that will handle the {@link Block#randomDisplayTick}
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void onRandomDisplayTick(IGregTechTileEntity aBaseMetaTileEntity) {

        if (aBaseMetaTileEntity.isActive()) {

            if (hasValidEgg()) {

                final double oX = aBaseMetaTileEntity.getXCoord() + 8D / 16D;
                final double oY = aBaseMetaTileEntity.getYCoord() + 17D / 32D;
                final double oZ = aBaseMetaTileEntity.getZCoord() + 8D / 16D;

                final WorldSpawnedEventBuilder.ParticleEventBuilder particleEventBuilder = new WorldSpawnedEventBuilder.ParticleEventBuilder()
                    .setWorld(getBaseMetaTileEntity().getWorld())
                    .setIdentifier(ParticleFX.PORTAL);

                for (int i = 0; i < 9; i++) {
                    final double dX = (XSTR_INSTANCE.nextFloat() - 0.5D) / 2D;
                    final double dY = XSTR_INSTANCE.nextFloat() * 1.5;
                    final double dZ = (XSTR_INSTANCE.nextFloat() - 0.5D) / 2D;

                    final double x = oX + dX;
                    final double y = oY + dY;
                    final double z = oZ + dZ;

                    final double mX = dX * 4D;
                    final double dXZ = Math.sqrt(dX * dX + dZ * dZ);
                    final double mY = -(dXZ * dY) / 4D;
                    final double mZ = dZ * 4D;

                    particleEventBuilder.setMotion(mX, mY, mZ)
                        .setPosition(x, y, z)
                        .run();
                }
            }
        }
    }

}
