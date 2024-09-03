package com.xir.NHUtilities.common.entity;

import static com.xir.NHUtilities.config.Config.accelerateBlockInterval;
import static com.xir.NHUtilities.config.Config.enableBlockMode;
import static com.xir.NHUtilities.config.Config.enableTimeAcceleratorBoost;
import static com.xir.NHUtilities.main.NHUtilities.LOG;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.ITileEntityTickAcceleration;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTimeAccelerator extends Entity {

    // region Fields
    private int timeRate = enableTimeAcceleratorBoost ? 8 : 4; // must be set in here for texture render init
    private int remainingTime = 600;
    private boolean isGregTechMachineMode = true;

    private int targetIntX;
    private int targetIntY;
    private int targetIntZ;

    public void setGregTechMachineMode(boolean mode) {
        this.isGregTechMachineMode = mode;
    }

    public boolean getGregTechMachineMode() {
        return this.isGregTechMachineMode;
    }

    public int getTimeRate() {
        return timeRate;
    }

    public void setTimeRate(int timeRate) {
        this.timeRate = timeRate;
        this.dataWatcher.updateObject(2, timeRate);
    }

    public int getTimeRateForRender() {
        return this.dataWatcher.getWatchableObjectInt(2);
    }

    public int getRemainingTime() {
        return remainingTime;
    }
    // endregion

    // region Constructor
    public EntityTimeAccelerator(World worldIn) {
        super(worldIn);
        this.noClip = true;
        this.preventEntitySpawning = false;
        // this entity setting must modify with TimeVial field double tHalfSize = 0.05D
        this.setSize(0.02F, 0.02F);
        this.dataWatcher.addObject(2, timeRate);
    }

    public EntityTimeAccelerator(World worldIn, int targetIntX, int targetIntY, int targetIntZ) {
        this(worldIn);
        this.targetIntX = targetIntX;
        this.targetIntY = targetIntY;
        this.targetIntZ = targetIntZ;
        this.setPosition(targetIntX + 0.5D, targetIntY + 0.5D, targetIntZ + 0.5D);
    }
    // endregion

    // region Main Logic
    /**
     * Gets called every tick from main Entity class
     */
    @Override
    public void onEntityUpdate() {
        if (this.worldObj.isRemote) return;
        if (remainingTime-- > 0) this.tAccelerate();
        if (remainingTime <= 0) {
            this.setDead();
            this.resetTileEntity();
        }
    }

    public void resetTileEntity() {
        TileEntity tileEntity = this.worldObj.getTileEntity(targetIntX, targetIntY, targetIntZ);
        if (shouldAccelerate(tileEntity)) {
            this.worldObj.loadedTileEntityList.removeIf(k -> k == tileEntity);
            this.worldObj.loadedTileEntityList.add(tileEntity);
        }
    }

    private void tAccelerate() {

        Block block = this.worldObj.getBlock(targetIntX, targetIntY, targetIntZ);
        TileEntity tileEntity = this.worldObj.getTileEntity(targetIntX, targetIntY, targetIntZ);

        // Referenced GTNH to control the performance in 1ms
        long tMaxTime = System.nanoTime() + 1000000;

        if (shouldAccelerate(block)) {
            accelerateBlock(block, tMaxTime);
        }

        if (shouldAccelerate(tileEntity)) {
            if (isGregTechMachineMode && tileEntity instanceof ITileEntityTickAcceleration tileEntityITEA) {
                if (tileEntityITEA.tickAcceleration(timeRate)) return;
            }
            accelerateTileEntity(tileEntity, tMaxTime);
        }
    }

    private boolean shouldAccelerate(TileEntity tileEntity) {
        return tileEntity != null && !tileEntity.isInvalid() && tileEntity.canUpdate();
    }

    private boolean shouldAccelerate(Block block) {
        return enableBlockMode && block != null
            && block.getTickRandomly()
            && worldObj.getTotalWorldTime() % accelerateBlockInterval == 0;
    }

    private void accelerateTileEntity(TileEntity tileEntity, long tMaxTime) {
        try {
            for (int i = 0; i < timeRate; i++) {
                tileEntity.updateEntity();
                if (System.nanoTime() > tMaxTime) {
                    break;
                }
            }
        } catch (Exception e) {
            LOG.warn(
                "An error occurred accelerating TileEntity at ( {}, {}, {}, {})",
                targetIntX,
                targetIntY,
                targetIntZ,
                e.getMessage());
        }
    }

    private void accelerateBlock(Block block, long tMaxTime) {
        try {
            for (int i = 0; i < timeRate; i++) {
                block.updateTick(worldObj, targetIntX, targetIntY, targetIntZ, worldObj.rand);
                if (System.nanoTime() > tMaxTime) {
                    break;
                }
            }
        } catch (Exception e) {
            LOG.warn(
                "An error occurred accelerating block at ( {}, {}, {}, {})",
                targetIntX,
                targetIntY,
                targetIntZ,
                e.getMessage());
        }
    }
    // endregion

    // region NBT Setting
    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound tagCompound) {
        timeRate = tagCompound.getInteger("timeRate");
        this.dataWatcher.updateObject(2, tagCompound.getInteger("timeRate"));
        isGregTechMachineMode = tagCompound.getBoolean("isGregTechMachineMode");
        targetIntX = tagCompound.getInteger("targetIntX");
        targetIntY = tagCompound.getInteger("targetIntY");
        targetIntZ = tagCompound.getInteger("targetIntZ");
        remainingTime = tagCompound.getInteger("remainingTime");
    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound tagCompound) {
        tagCompound.setInteger("timeRate", timeRate);
        tagCompound.setBoolean("isGregTechMachineMode", isGregTechMachineMode);
        tagCompound.setInteger("targetIntX", targetIntX);
        tagCompound.setInteger("targetIntY", targetIntY);
        tagCompound.setInteger("targetIntZ", targetIntZ);
        tagCompound.setInteger("remainingTime", remainingTime);
    }
    // endregion

    // region Entity Definitions
    @Override
    protected void entityInit() {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        return distance < 128 * 128;
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean isEntityInvulnerable() {
        return true;
    }

    @Override
    public void moveEntity(double x, double y, double z) {}

    @Override
    protected void updateFallState(double distanceFallenThisTick, boolean isOnGround) {}

    @Override
    public void mountEntity(Entity entityIn) {}

    @Override
    public void moveFlying(float strafe, float forward, float friction) {}

    @Override
    public void applyEntityCollision(Entity entityIn) {}

    @Override
    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        // no yaw no pitch
        this.ySize = 0.0F;
        this.prevPosX = this.posX = x;
        this.prevPosY = this.posY = y;
        this.prevPosZ = this.posZ = z;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int rotationIncrements) {
        // makeSure this boundingBox not be moving
        this.yOffset = 0.0F;
        this.prevPosX = this.posX = x;
        this.prevPosY = this.posY = y;
        this.prevPosZ = this.posZ = z;
        this.setPosition(x, y, z);
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return true;
    }
    // endregion
}
