package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.config.Config.accelerateGregTechMachineDiscount;
import static com.xir.NHUtilities.main.NHUtilities.LOG;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;
import com.xir.NHUtilities.common.api.interfaces.mixinHelper.IAccelerationState;

import ggfab.mte.MTEAdvAssLine;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.CommonMetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEBasicMachine;
import gregtech.api.metatileentity.implementations.MTEMultiBlockBase;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;
import tectech.thing.metaTileEntity.multi.MTEResearchStation;

@SuppressWarnings("UnusedMixin")
@Mixin(BaseMetaTileEntity.class)
public abstract class BaseMetaTileEntityAcceleration_Mixin extends CommonMetaTileEntity
    implements ITileEntityTickAcceleration {

    @Shadow(remap = false)
    public abstract int getProgress();

    @Shadow(remap = false)
    public abstract int getMaxProgress();

    @Shadow(remap = false)
    public abstract IMetaTileEntity getMetaTileEntity();

    @Shadow(remap = false)
    public abstract boolean isActive();

    @Shadow
    public abstract void updateEntity();

    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    public boolean tickAcceleration(int tickAcceleratedRate) {
        if (this.isActive()) {
            // safely calling
            int currentProgress = this.getProgress();
            int maxProgress = this.getMaxProgress();
            IMetaTileEntity metaTileEntity = this.getMetaTileEntity();

            // for accelerating Research Station
            if (metaTileEntity instanceof MTEResearchStation researchStation) {
                if (researchStation instanceof ITileEntityTickAcceleration resAte) {
                    resAte.tickAcceleration(tickAcceleratedRate);
                }
                return true;
            }

            // for accelerating Adv Ass Line
            if (metaTileEntity instanceof MTEAdvAssLine advAssLine) {
                if (advAssLine instanceof IAccelerationState accelerationState) {
                    tickAcceleratedRate = (int) (tickAcceleratedRate * accelerateGregTechMachineDiscount);
                    accelerationState.setAccelerationState(true);
                    try {

                        // Referenced GTNH to control the performance in 1ms
                        long tMaxTime = System.nanoTime() + 1000000;

                        for (int i = 0; i < tickAcceleratedRate; i++) {
                            // skip if assLine stuck
                            if (accelerationState.getMachineAccelerationState()) break;
                            this.updateEntity();
                            if (System.nanoTime() > tMaxTime) {
                                break;
                            }
                        }

                    } catch (Exception e) {
                        LOG.warn(
                            "An error occurred accelerating TileEntity at ( {}, {}, {}, {})",
                            this.xCoord,
                            this.yCoord,
                            this.zCoord,
                            e.getMessage());
                    } finally {
                        accelerationState.setAccelerationState(false);
                    }
                }
            }

            if (maxProgress >= 2) { // obviously
                // discount for accelerating gregtech machines
                tickAcceleratedRate = (int) (tickAcceleratedRate * accelerateGregTechMachineDiscount);
                int NHUtilities$modify = Math.min(maxProgress, currentProgress + tickAcceleratedRate);

                // for accelerating basic machine
                if (metaTileEntity instanceof MTEBasicMachine basicMachine) {
                    basicMachine.mProgresstime = NHUtilities$modify;
                    return true;
                }

                // for accelerating multi machine
                if (metaTileEntity instanceof MTEMultiBlockBase multiBlockBase) {
                    multiBlockBase.mProgresstime = NHUtilities$modify;
                    return true;
                }

                // for accelerating primitive blast furnace
                if (metaTileEntity instanceof MTEPrimitiveBlastFurnace primitiveBlastFurnace) {
                    primitiveBlastFurnace.mProgresstime = NHUtilities$modify;
                    return true;
                }

                return false; // this for accelerating gt machine by executing TE update method

            }
        }
        return true; // this for not acceleration while machine is shutdown
    }
}
