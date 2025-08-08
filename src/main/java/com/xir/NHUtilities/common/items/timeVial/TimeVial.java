package com.xir.NHUtilities.common.items.timeVial;

import static com.xir.NHUtilities.common.entity.EntityTimeAccelerator.ACCELERATION_TICK;
import static com.xir.NHUtilities.config.Config.defaultTimeVialVolumeValue;
import static com.xir.NHUtilities.config.Config.enableLogInfo;
import static com.xir.NHUtilities.config.Config.enableResetRemainingTime;
import static com.xir.NHUtilities.config.Config.enableTimeAcceleratorBoost;
import static com.xir.NHUtilities.config.Config.limitOneTimeVial;
import static com.xir.NHUtilities.config.Config.timeVialDiscountValue;
import static com.xir.NHUtilities.main.NHUtilities.LOG;
import static com.xir.NHUtilities.utils.InformationHelper.dividingLine;
import static com.xir.NHUtilities.utils.InformationHelper.holdShiftForDetails;

import java.util.List;
import java.util.Optional;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

import com.github.bsideup.jabel.Desugar;
import com.xir.NHUtilities.common.entity.EntityTimeAccelerator;
import com.xir.NHUtilities.common.items.aItemCore.ItemBase;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.entity.EntityImmortalItem;

public class TimeVial extends ItemBase {

    protected static final int TIME_INIT_RATE = enableTimeAcceleratorBoost ? 8 : 4;
    // referenced RandomThings
    protected static final float[] SOUND_ARRAY_F = new float[] { 0.749154F, 0.793701F, 0.890899F, 1.059463F, 0.943874F,
        0.890899F, 0.690899F };
    protected static final int MAX_ACCELERATION = enableTimeAcceleratorBoost ? 256 : 128;
    protected static final int NUMBER_EER = -846280; // ha,.... 114514
    protected int storedTimeTick = 0;

    protected static final double tHalfSize = 0.01D; // 实体一半的大小
    protected static final String NBT_STORED_TICK = "storedTimeTick";

    public TimeVial() {
        super("TimeVial");
        setMaxStackSize(1);
        setTextureName("TimeVial/TimeVial");
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, @NotNull World world, int x, int y, int z,
        int side, float hitX, float hitY, float hitZ) {

        if (world.isRemote) return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);

        // 实体中心坐标
        double targetPosX = x + 0.5D;
        double targetPosY = y + 0.5D;
        double targetPosZ = z + 0.5D;

        // 计算碰撞箱大小
        double minX = targetPosX - tHalfSize;
        double minY = targetPosY - tHalfSize;
        double minZ = targetPosZ - tHalfSize;
        double maxX = targetPosX + tHalfSize;
        double maxY = targetPosY + tHalfSize;
        double maxZ = targetPosZ + tHalfSize;

        // 获取碰撞箱对应实体
        Optional<EntityTimeAccelerator> box = world
            .getEntitiesWithinAABB(
                EntityTimeAccelerator.class,
                AxisAlignedBB.getBoundingBox(minX, minY, minZ, maxX, maxY, maxZ))
            .stream()
            .findFirst();

        @NotNull
        var eta = box.orElseGet(() -> new EntityTimeAccelerator(world, x, y, z));
        if (box.isPresent()) {
            if (player.isSneaking()) recyclingTime(stack, eta);
            else applyNextAcceleration(stack, eta);
        } else if (consumeTimeData(stack, (int) (TIME_INIT_RATE * 600 * timeVialDiscountValue))) {
            // set the GregTechMachineMode
            if (player.isSneaking()) eta.setGregTechMachineMode(false);
            world.spawnEntityInWorld(eta);
        }
        etaInteract(eta, world, targetPosX, targetPosY, targetPosZ);
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, @NotNull World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ) {
        return true;
    }

    protected void applyNextAcceleration(ItemStack stack, EntityTimeAccelerator eta) {
        var currentRate = eta.getTimeRate();
        if (currentRate < MAX_ACCELERATION) {
            var remained = currentRate * eta.getRemainingTime();
            var nextRateTimeRequired = enableResetRemainingTime
                ? (int) ((2 * currentRate * ACCELERATION_TICK - remained) * timeVialDiscountValue)
                : (int) (remained * timeVialDiscountValue);
            if (consumeTimeData(stack, nextRateTimeRequired)) {
                eta.setTimeRate(currentRate * 2);
                if (enableResetRemainingTime) eta.setRemainingTime(ACCELERATION_TICK);
            }
        }
    }

    protected static void recyclingTime(ItemStack stack, EntityTimeAccelerator eta) {
        NBTTagCompound nbtTagCompound = stack.getTagCompound();
        if (nbtTagCompound != null) {
            nbtTagCompound.setInteger(
                NBT_STORED_TICK,
                nbtTagCompound.getInteger(NBT_STORED_TICK) + eta.getTimeRate() * eta.getRemainingTime());
            stack.setTagCompound(nbtTagCompound);
        }
        eta.setDead();
    }

    protected void etaInteract(@NotNull EntityTimeAccelerator eta, World world, double targetPosX, double targetPosY,
        double targetPosZ) {
        int i = (int) (Math.log(eta.getTimeRate()) / Math.log(2)) - (enableTimeAcceleratorBoost ? 3 : 2);
        // security considerations
        if (i < 0 || i >= SOUND_ARRAY_F.length) i = 0;
        world.playSoundEffect(
            targetPosX,
            targetPosY,
            targetPosZ,
            "note.harp",
            defaultTimeVialVolumeValue,
            SOUND_ARRAY_F[i]);
        if (enableLogInfo) {
            var remainingTime = eta.getRemainingTime();
            LOG.info("xxxxx remainingTime: {} xxxxx", remainingTime);
            LOG.info(
                "An entity entityTimeAccelerator has been spawned ({}, {}, {}).",
                targetPosX,
                targetPosY,
                targetPosZ);
        }
    }

    protected boolean consumeTimeData(@NotNull ItemStack stack, int consumedTick) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        int timeTick = tagCompound.getInteger(NBT_STORED_TICK);
        if (timeTick >= consumedTick) {
            tagCompound.setInteger(NBT_STORED_TICK, timeTick - consumedTick);
            return true;
        }
        return false;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity playerIn, int slot, boolean isHeld) {
        if (worldIn.isRemote) return;
        if (!(playerIn instanceof EntityPlayer player)) return;
        if (limitOneTimeVial && worldIn.getTotalWorldTime() % 600 == 0) mergeSameVialTime(player, stack);
        NBTTagCompound nbtTagCompound = stack.getTagCompound();
        if (nbtTagCompound == null) {
            nbtTagCompound = new NBTTagCompound();
            nbtTagCompound.setInteger(NBT_STORED_TICK, storedTimeTick);
        } else if (worldIn.getTotalWorldTime() % 20 == 0) {
            int t = nbtTagCompound.getInteger(NBT_STORED_TICK);
            if (t == NUMBER_EER) return;
            nbtTagCompound.setInteger(NBT_STORED_TICK, t + 20);
        }
        stack.setTagCompound(nbtTagCompound);
    }

    protected void mergeSameVialTime(@NotNull EntityPlayer player, ItemStack stack) {
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (itemStack != null && itemStack.getItem() == this && itemStack != stack) {
                int thisTimeTick = stack.getTagCompound()
                    .getInteger(NBT_STORED_TICK);
                int otherTimeTick = itemStack.getTagCompound()
                    .getInteger(NBT_STORED_TICK);
                if (otherTimeTick >= 0 && thisTimeTick >= otherTimeTick) {
                    stack.getTagCompound()
                        .setInteger(NBT_STORED_TICK, thisTimeTick + otherTimeTick);
                    itemStack.getTagCompound()
                        .setInteger(NBT_STORED_TICK, NUMBER_EER);
                }
            }
        }
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack); // make this item Immortal
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(final @NotNull ItemStack stack, final EntityPlayer player, final List<String> list,
        final boolean extraInformation) {
        getInfoFromNBT(stack, list);
        if (holdShiftForDetails(list)) {
            list.add(dividingLine);
            list.add(StatCollector.translateToLocal("text.TimeVial.details_0"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_1"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_2"));
            list.add(dividingLine);
            list.add(StatCollector.translateToLocal("text.TimeVial.details_3"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_4"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_5"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_6"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_7"));
            list.add(dividingLine);
            list.add(StatCollector.translateToLocal("text.TimeVial.details_8"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_9"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_10"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_11"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_12"));
            list.add(dividingLine);
            list.add(StatCollector.translateToLocal("text.TimeVial.details_13"));
            list.add(StatCollector.translateToLocal("text.TimeVial.details_14"));
            list.add(dividingLine);
        }
    }

    @Desugar
    protected record TimeComponents(int hours, int minutes, int seconds) {}

    @SideOnly(Side.CLIENT)
    protected TimeComponents getStoredTimeComponents(ItemStack stack) {
        NBTTagCompound nbtTagCompound = stack.getTagCompound();
        if (nbtTagCompound == null) nbtTagCompound = new NBTTagCompound();
        int storedTimeSeconds = nbtTagCompound.getInteger(NBT_STORED_TICK) / 20;
        int hours = storedTimeSeconds / 3600;
        int minutes = (storedTimeSeconds % 3600) / 60;
        int seconds = storedTimeSeconds % 60;
        return new TimeComponents(hours, minutes, seconds);
    }

    @SideOnly(Side.CLIENT)
    protected void getInfoFromNBT(@NotNull ItemStack stack, List<String> list) {
        TimeComponents time = getStoredTimeComponents(stack);
        list.add(I18n.format("text.TimeVial.tips", time.hours, time.minutes, time.seconds));
    }

    public String getItemStackDisplayName(ItemStack stack) {
        if (FMLCommonHandler.instance()
            .getSide()
            .isClient()) {
            TimeComponents time = getStoredTimeComponents(stack);
            return I18n.format(this.getUnlocalizedNameInefficiently(stack) + ".name")
                + I18n.format("text.TimeVial.tips", time.hours, time.minutes, time.seconds);
        } else {
            return super.getItemStackDisplayName(stack);
        }
    }
}
