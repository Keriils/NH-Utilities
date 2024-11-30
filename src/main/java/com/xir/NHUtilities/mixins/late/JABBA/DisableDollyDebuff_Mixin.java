package com.xir.NHUtilities.mixins.late.JABBA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import mcp.mobius.betterbarrels.common.items.dolly.ItemBarrelMover;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ItemBarrelMover.class)
public class DisableDollyDebuff_Mixin {

    @Redirect(
        method = "onUpdate",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/EntityPlayer;addPotionEffect(Lnet/minecraft/potion/PotionEffect;)V"))
    private void NHUtilities$disableDebuff(EntityPlayer instance, PotionEffect potionEffect) {
        // Null method problem
    }
}
