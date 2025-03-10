package com.xir.NHUtilities.mixins.late.NewHorizonsCoreMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.dreammaster.baubles.OvenGlove;
import com.llamalad7.mixinextras.sugar.Local;

@SuppressWarnings("UnusedMixin")
@Mixin(value = OvenGlove.EventHandler.class, remap = false)
public class EnhanceOvenGlove_Mixin {

    @Redirect(
        method = "onDamage",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/EntityPlayer;getHeldItem()Lnet/minecraft/item/ItemStack;"),
        require = 1,
        remap = true)
    private ItemStack nhu$redirectHeldItem(EntityPlayer instance, @Local(name = "cause") ItemStack nhu$cause) {
        return nhu$cause;
    }

}
