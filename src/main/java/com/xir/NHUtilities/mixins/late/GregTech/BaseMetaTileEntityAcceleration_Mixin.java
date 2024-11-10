package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.config.Config.accelerateGregTechMachineDiscount;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEBasicMachine;
import gregtech.api.metatileentity.implementations.MTEMultiBlockBase;
import gregtech.common.tileentities.machines.multi.MTEPrimitiveBlastFurnace;

@Mixin(BaseMetaTileEntity.class)
public abstract class BaseMetaTileEntityAcceleration_Mixin implements ITileEntityTickAcceleration {

    @Shadow(remap = false)
    public abstract int getProgress();

    @Shadow(remap = false)
    public abstract int getMaxProgress();

    @Shadow(remap = false)
    public abstract IMetaTileEntity getMetaTileEntity();

    @Shadow(remap = false)
    public abstract boolean isActive();

    @Override
    public boolean tickAcceleration(int tickAcceleratedRate) {
        if (this.isActive()) {
            // safely calling
            int currentProgress = this.getProgress();
            int maxProgress = this.getMaxProgress();

            if (maxProgress >= 2) { // obviously
                tickAcceleratedRate = (int) (tickAcceleratedRate * accelerateGregTechMachineDiscount); // discount for
                                                                                                       // accelerating
                                                                                                       // gregtech
                                                                                                       // machines
                int NHUtilities$modify = Math.min(maxProgress, currentProgress + tickAcceleratedRate);

                IMetaTileEntity metaTileEntity = this.getMetaTileEntity();

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
