package com.xir.NHUtilities.mixins.late.ExtraUtilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rwtema.extrautils.item.ItemHealingAxe;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ItemHealingAxe.class, remap = false)
public class EnhanceExUHealingAxe_Mixin {

    @Inject(
        method = "onUpdate",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/util/FoodStats;addStats(IF)V", shift = At.Shift.AFTER),
        require = 1,
        remap = true)
    private void nhu$enhanceHealingAxe(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4,
        boolean par5, CallbackInfo ci) {
        ((EntityPlayer) par3Entity).getFoodStats()
            .addStats(20, 5.0F);
    }

}
