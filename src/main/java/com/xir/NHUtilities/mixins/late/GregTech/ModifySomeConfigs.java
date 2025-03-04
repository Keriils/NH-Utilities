package com.xir.NHUtilities.mixins.late.GregTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.xir.NHUtilities.config.Config;

import gregtech.GTMod;
import gregtech.loaders.preload.GTPreLoad;

@SuppressWarnings("UnusedMixin")
@Mixin(value = GTPreLoad.class, remap = false)
public class ModifySomeConfigs {

    @Inject(
        method = "loadClientConfig",
        at = @At(value = "INVOKE", target = "Lgregtech/common/GTProxy;reloadNEICache()V", shift = At.Shift.BEFORE),
        require = 1)
    private static void nhu$modification(CallbackInfo ci) {
        if (Config.enableAlwaysDisplayRecipeOwner) GTMod.gregtechproxy.mNEIRecipeOwner = true;
        if (Config.enableAlwaysDisplayWailaAverageNS) GTMod.gregtechproxy.wailaAverageNS = true;
        if (Config.enableAlwaysDisplayNEIOriginalVoltage) GTMod.gregtechproxy.mNEIOriginalVoltage = true;
    }

}
