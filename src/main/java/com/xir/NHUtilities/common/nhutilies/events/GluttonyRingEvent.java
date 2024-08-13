package com.xir.NHUtilities.common.nhutilies.events;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

import com.brandon3055.draconicevolution.common.utills.InventoryUtils;
import com.xir.NHUtilities.common.nhutilies.items.GluttonyRing;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GluttonyRingEvent {

    @SubscribeEvent
    public void onGluttonyRingEating(PlayerUseItemEvent.Start event) {
        EntityPlayer entityPlayer = event.entityPlayer;
        if (entityPlayer.getHeldItem() == null) return;
        Optional<ItemStack> baublesItem = InventoryUtils
            .getItemInPlayerBaublesInventory(entityPlayer, GluttonyRing.class);
        if (baublesItem.isPresent() && (event.item.getItemUseAction() == EnumAction.eat)) {
            event.duration = 2;
        }
    }
}
