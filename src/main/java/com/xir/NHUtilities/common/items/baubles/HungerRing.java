package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.items.aItemCore.ItemBase;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.common.Optional;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "Baubles")
public class HungerRing extends ItemBase implements IBauble {

    public HungerRing() {
        super("HungerRing");
        setMaxStackSize(1);
        setTextureName("Baubles/HungerRing");
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onWornTick(ItemStack itemstack, @NotNull EntityLivingBase player) {
        if (player.worldObj.getTotalWorldTime() % 10 == 0 && player instanceof EntityPlayer entityPlayer) {
            int foodLevel = -entityPlayer.getFoodStats()
                .getFoodLevel();
            float saturationLevel = -entityPlayer.getFoodStats()
                .getSaturationLevel();
            entityPlayer.getFoodStats()
                .addStats(foodLevel, saturationLevel);
        }
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
