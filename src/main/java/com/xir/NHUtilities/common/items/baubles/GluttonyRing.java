package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;

import baubles.api.BaubleType;
import baubles.api.IBauble;

public class GluttonyRing extends ItemBasic implements IBauble {

    public GluttonyRing() {
        setMaxStackSize(1);
        setUnlocalizedName("GluttonyRing");
        setTextureName("GluttonyRing");

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
