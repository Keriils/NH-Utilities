package com.xir.NHUtilities.common.items.aItemCore;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import gregtech.api.util.GT_Utility;
import ic2.core.IC2Potion;

public class RadioactiveItem extends ItemBase {

    private final int mRadio;

    public RadioactiveItem(String name, int mRadio) {
        super(name);
        this.mRadio = mRadio;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int slot, boolean isHeld) {
        super.onUpdate(stack, worldIn, entityIn, slot, isHeld);
        EntityLivingBase tPlayer = (EntityPlayer) entityIn;
        if (!GT_Utility.isWearingFullRadioHazmat(tPlayer)) {
            tPlayer.addPotionEffect(new PotionEffect(IC2Potion.radiation.id, mRadio, 4));
        }
    }
}
