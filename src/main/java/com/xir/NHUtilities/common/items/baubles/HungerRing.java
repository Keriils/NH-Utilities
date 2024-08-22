package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;

import baubles.api.BaubleType;
import baubles.api.IBauble;

public class HungerRing extends ItemBasic implements IBauble {

    public HungerRing() {
        setMaxStackSize(1);
        setUnlocalizedName("HungerRing");
        setTextureName("HungerRing");

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        FoodStats foodStats = ((EntityPlayer) player).getFoodStats();
        if (foodStats.getFoodLevel() >= 1) {
            foodStats.setFoodLevel(0);
        }
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
