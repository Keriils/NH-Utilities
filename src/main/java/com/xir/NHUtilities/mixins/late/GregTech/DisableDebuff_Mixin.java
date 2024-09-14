package com.xir.NHUtilities.mixins.late.GregTech;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import gregtech.common.blocks.GT_Item_Machines;

@Mixin(value = GT_Item_Machines.class, remap = false)
public class DisableDebuff_Mixin {

    @Redirect(
        method = "onUpdate",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/EntityLivingBase;addPotionEffect(Lnet/minecraft/potion/PotionEffect;)V"))
    private void NHUtilities$disableDebuff(EntityLivingBase instance, PotionEffect potionEffect) {
        // Null method problem
        instance.addPotionEffect(new PotionEffect(potionEffect.getPotionID(), 5, 1));
    }
}
