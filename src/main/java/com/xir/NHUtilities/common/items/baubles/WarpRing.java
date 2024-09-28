package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import baubles.common.items.ItemRing;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.config.Config;

public class WarpRing extends ItemRing implements IVisDiscountGear {

    public WarpRing() {
        this.setUnlocalizedName("WarpWardRing");
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(Config.potionWarpWardID, 200, 0));
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.removePotionEffect(Config.potionWarpWardID);
    }

    @Override
    public int getVisDiscount(ItemStack var1, EntityPlayer var2, Aspect var3) {
        return 10;
    }
}
