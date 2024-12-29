package com.xir.NHUtilities.common.events;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@SuppressWarnings("unused")
public class EnhanceExUHealingAxe {

    // spotless:off
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onHeldHealingAxe(TickEvent.PlayerTickEvent event) {
        if (event.side == Side.CLIENT) return;
        if (event.phase == TickEvent.Phase.START) return;
        EntityPlayer entityPlayer = event.player;
        if (entityPlayer == null) return;
        if (entityPlayer.worldObj.getTotalWorldTime() % 40L != 0L) return;
        var heldItem = entityPlayer.getHeldItem();
        if (heldItem == null) return;
        if (heldItem.getItem() != GameRegistry.findItem("ExtraUtilities", "defoliageAxe")) return;
        // ha....
        entityPlayer.getFoodStats().addStats(20, 5.0F);
    }
    // spotless:on

}
