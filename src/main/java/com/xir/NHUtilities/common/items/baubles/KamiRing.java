package com.xir.NHUtilities.common.items.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.interfaces.IEntityInvulnerable;
import com.xir.NHUtilities.common.items.aItemCore.ItemBase;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.common.Optional;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "Baubles")
public class KamiRing extends ItemBase implements IBauble, IVisDiscountGear {

    public KamiRing() {
        super("KamiRing");
        setMaxStackSize(1);
        setTextureName("Baubles/KamiRing");
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onWornTick(ItemStack itemstack, @NotNull EntityLivingBase player) {

        if (!player.isEntityInvulnerable() && (player instanceof IEntityInvulnerable entityInvulnerable)) {
            entityInvulnerable.setEntityInvulnerable(true);
        }

        if (player instanceof EntityPlayer entityPlayer) {
            if (entityPlayer.isDead) entityPlayer.isDead = false;
            if (entityPlayer.worldObj.getTotalWorldTime() % 10 == 0) {
                if (entityPlayer.getFoodStats()
                    .getFoodLevel() != 20) {
                    entityPlayer.getFoodStats()
                        .addStats(20, 5.0F);
                }
            }
        }
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

        if (player.isEntityInvulnerable() && (player instanceof IEntityInvulnerable entityInvulnerable)) {
            entityInvulnerable.setEntityInvulnerable(false);
        }

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

    @Override
    public int getVisDiscount(ItemStack var1, EntityPlayer var2, Aspect var3) {
        return 60;
    }
}
