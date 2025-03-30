package com.xir.NHUtilities.mixins.late.GregTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import appeng.api.networking.GridFlags;
import appeng.me.helpers.AENetworkProxy;
import goodgenerator.blocks.tileEntity.GTMetaTileEntity.MTEYOTTAHatch;
import gregtech.common.tileentities.machines.MTEHatchCraftingInputME;
import gregtech.common.tileentities.machines.MTEHatchInputBusME;
import gregtech.common.tileentities.machines.MTEHatchInputME;
import gregtech.common.tileentities.machines.MTEHatchOutputBusME;
import gregtech.common.tileentities.machines.MTEHatchOutputME;

@SuppressWarnings("UnusedMixin")
@Mixin(
    value = { MTEHatchCraftingInputME.class, MTEHatchInputBusME.class, MTEHatchInputME.class, MTEHatchOutputBusME.class,
        MTEHatchOutputME.class, MTEYOTTAHatch.class },
    remap = false)
public class MEHatchesDenseChannel_Mixin {

    @Redirect(
        method = "getProxy",
        at = @At(
            value = "INVOKE",
            target = "Lappeng/me/helpers/AENetworkProxy;setFlags([Lappeng/api/networking/GridFlags;)V"),
        require = 1)
    private void nhu$denseMEHatches(AENetworkProxy instance, GridFlags[] requireChannel) {
        if (requireChannel.length == 1 && requireChannel[0] == GridFlags.REQUIRE_CHANNEL) {
            instance.setFlags(GridFlags.REQUIRE_CHANNEL, GridFlags.DENSE_CAPACITY);
        } else throw new IllegalStateException("Require to maintenance...");
    }
}
