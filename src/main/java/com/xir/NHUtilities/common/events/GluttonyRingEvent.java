package com.xir.NHUtilities.common.events;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import com.xir.NHUtilities.common.items.baubles.GluttonyRing;
import com.xir.NHUtilities.utils.InventoryUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import vazkii.botania.common.item.ModItems;

public class GluttonyRingEvent {

    @SubscribeEvent
    public void onGluttonyRingEating(PlayerUseItemEvent.Start event) {
        EntityPlayer entityPlayer = event.entityPlayer;
        if (entityPlayer.getHeldItem() == null || entityPlayer.getHeldItem()
            .getItem() == ModItems.infiniteFruit) return;
        Optional<ItemStack> baublesItem = InventoryUtils
            .getItemInPlayerBaublesInventory(entityPlayer, GluttonyRing.class);
        if (baublesItem.isPresent() && (event.item.getItemUseAction() == EnumAction.eat)) {
            event.duration = 2;
        }
    }
}
