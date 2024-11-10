package com.xir.NHUtilities.mixins.late.EnderIO;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;

import crazypants.enderio.machine.AbstractPoweredMachineEntity;
import crazypants.enderio.power.ICapacitor;

@Mixin(value = AbstractPoweredMachineEntity.class, remap = false)
public class AccelerateEnergyRecive_Mixin {

    @Redirect(
        method = "getMaxEnergyRecieved",
        at = @At(value = "INVOKE", target = "Lcrazypants/enderio/power/ICapacitor;getMaxEnergyReceived()I"))
    private int NHUtilities$modifyMaxEnergyReceivedValue(ICapacitor instance) {
        if (this instanceof ITileEntityTickAcceleration tileEntityITEA) {
            int tickAcceleratedRate = tileEntityITEA.getTickAcceleratedRate();
            return instance.getMaxEnergyReceived() * tickAcceleratedRate;
        }
        return instance.getMaxEnergyReceived();
    }
}
