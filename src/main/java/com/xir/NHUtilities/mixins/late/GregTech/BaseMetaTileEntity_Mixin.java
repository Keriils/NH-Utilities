package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.config.Config.enableLogInfo;
import static com.xir.NHUtilities.main.NHUtilities.LOG;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.ITileEntityTickAcceleration;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_PrimitiveBlastFurnace;

@Mixin(BaseMetaTileEntity.class)
public abstract class BaseMetaTileEntity_Mixin implements ITileEntityTickAcceleration {

    @Shadow(remap = false)
    public abstract int getProgress();

    @Shadow(remap = false)
    public abstract int getMaxProgress();

    @Shadow(remap = false)
    public abstract IMetaTileEntity getMetaTileEntity();

    @Override
    public boolean tickAcceleration(int tickAcceleratedRate) {
        // safely calling
        int currentProgress = this.getProgress();
        int maxProgress = this.getMaxProgress();

        if (maxProgress >= 2) { // obviously
            tickAcceleratedRate = (int) (tickAcceleratedRate * 0.8f); // discount for accelerating gregtech machines
            int newProgress = currentProgress + tickAcceleratedRate;
            int NHUtilities$modify = Math.min(maxProgress, newProgress);
            if (enableLogInfo) LOG.info("modifyArg {}", NHUtilities$modify);

            IMetaTileEntity metaTileEntity = this.getMetaTileEntity();

            // for accelerating basic machine
            if (metaTileEntity instanceof GT_MetaTileEntity_BasicMachine basicMachine) {
                basicMachine.mProgresstime = NHUtilities$modify;
                if (enableLogInfo) LOG.info("success accelerating basicMachine");
            }

            // for accelerating multi machine
            if (metaTileEntity instanceof GT_MetaTileEntity_MultiBlockBase multiBlockBase) {
                multiBlockBase.mProgresstime = NHUtilities$modify;
                if (enableLogInfo) LOG.info("success accelerating multiBlockBase");
            }

            // for accelerating primitive blast furnace
            if (metaTileEntity instanceof GT_MetaTileEntity_PrimitiveBlastFurnace primitiveBlastFurnace) {
                primitiveBlastFurnace.mProgresstime = NHUtilities$modify;
                if (enableLogInfo) LOG.info("success accelerating primitiveBlastFurnace");
            }
        } else {
            return false; // this for accelerating gt machine by executing TE update method
        }
        return true;
    }
}
