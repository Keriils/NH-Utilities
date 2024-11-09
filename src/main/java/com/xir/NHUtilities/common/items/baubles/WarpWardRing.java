package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import com.xir.NHUtilities.common.items.aItemCore.ItemBase;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.config.Config;

public class WarpWardRing extends ItemBase implements IBauble, IVisDiscountGear {

    public WarpWardRing() {
        super("WarpWardRing");
        this.setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(Config.potionWarpWardID, 200, 0));
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.removePotionEffect(Config.potionWarpWardID);
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public int getVisDiscount(ItemStack var1, EntityPlayer var2, Aspect var3) {
        return 10;
    }
}
