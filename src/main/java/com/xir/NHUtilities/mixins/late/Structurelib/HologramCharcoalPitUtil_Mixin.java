package com.xir.NHUtilities.mixins.late.Structurelib;

import static gregtech.api.enums.MetaTileEntityIDs.CHARCOAL_PILE_IGNITER_CONTROLLER;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.gtnewhorizon.structurelib.item.ItemConstructableTrigger;
import com.xir.NHUtilities.common.items.hologram.CharcoalPitExtendUtil;

import gregtech.api.metatileentity.BaseMetaTileEntity;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ItemConstructableTrigger.class, remap = false)
public abstract class HologramCharcoalPitUtil_Mixin {

    @Inject(method = "onItemUseFirst", at = @At(value = "HEAD"), cancellable = true)
    private void nhu$charcoalPitUtil(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ, CallbackInfoReturnable<Boolean> cir) {
        if (world.isRemote) return;
        if (player instanceof EntityPlayerMP entityPlayerMP
            && world.getTileEntity(x, y, z) instanceof BaseMetaTileEntity baseMetaTileEntity) {
            if (baseMetaTileEntity.getMetaTileID() == CHARCOAL_PILE_IGNITER_CONTROLLER.ID) {
                cir.cancel();
                CharcoalPitExtendUtil.handle(entityPlayerMP, world, baseMetaTileEntity);
            }
        }
    }

}
