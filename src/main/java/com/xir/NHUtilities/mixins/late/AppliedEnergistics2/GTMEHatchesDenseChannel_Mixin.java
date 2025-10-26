package com.xir.NHUtilities.mixins.late.AppliedEnergistics2;

import java.util.EnumSet;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import appeng.api.networking.GridFlags;
import appeng.me.helpers.AENetworkProxy;
import appeng.me.helpers.IGridProxyable;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatch;

@SuppressWarnings("UnusedMixin")
@Mixin(value = AENetworkProxy.class, remap = false)
public class GTMEHatchesDenseChannel_Mixin {

    @Shadow
    private EnumSet<GridFlags> flags;

    @Shadow
    @Final
    private IGridProxyable gp;

    @Inject(method = "setFlags", at = @At(value = "TAIL"), require = 1)
    private void nhu$denseChannel(GridFlags[] requireChannel, CallbackInfo ci) {
        if (gp instanceof BaseMetaTileEntity || gp instanceof MTEHatch) flags.add(GridFlags.DENSE_CAPACITY);
    }

}
