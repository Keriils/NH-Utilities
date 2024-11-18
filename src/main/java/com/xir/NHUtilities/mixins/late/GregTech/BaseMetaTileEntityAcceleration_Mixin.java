package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.config.Config.accelerateGregTechMachineDiscount;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_research;
import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_PrimitiveBlastFurnace;

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
            IMetaTileEntity metaTileEntity = this.getMetaTileEntity();

            // for accelerating Research Station
            if (metaTileEntity instanceof GT_MetaTileEntity_EM_research researchStation) {
                if (researchStation instanceof ITileEntityTickAcceleration resAte) {
                    resAte.tickAcceleration(tickAcceleratedRate);
                }
                return true;
            }

            if (maxProgress >= 2) { // obviously
                // discount for accelerating gregtech machines
                tickAcceleratedRate = (int) (tickAcceleratedRate * accelerateGregTechMachineDiscount);
                int NHUtilities$modify = Math.min(maxProgress, currentProgress + tickAcceleratedRate);

                // for accelerating basic machine
                if (metaTileEntity instanceof GT_MetaTileEntity_BasicMachine basicMachine) {
                    basicMachine.mProgresstime = NHUtilities$modify;
                    return true;
                }

                // for accelerating multi machine
                if (metaTileEntity instanceof GT_MetaTileEntity_MultiBlockBase multiBlockBase) {
                    multiBlockBase.mProgresstime = NHUtilities$modify;
                    return true;
                }

                // for accelerating primitive blast furnace
                if (metaTileEntity instanceof GT_MetaTileEntity_PrimitiveBlastFurnace primitiveBlastFurnace) {
                    primitiveBlastFurnace.mProgresstime = NHUtilities$modify;
                    return true;
                }

                return false; // this for accelerating gt machine by executing TE update method

            }
        }
        return true; // this for not acceleration while machine is shutdown
    }
}
