package com.xir.NHUtilities.common.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class EnhanceExUHealingAxe {

    // spotless:off
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onHeldHealingAxe(PlayerEvent event) {
        EntityPlayer entityPlayer = event.entityPlayer;

        if (entityPlayer == null) return;
        if (entityPlayer.worldObj.getTotalWorldTime() % 40L != 0L) return;
        if (entityPlayer.getFoodStats().getFoodLevel() > 19) return;
        var heldItem = entityPlayer.getHeldItem();
        if (heldItem == null) return;
        if (heldItem.getItem() != GameRegistry.findItem("ExtraUtilities", "defoliageAxe")) return;
        // ha....
        entityPlayer.getFoodStats().addStats(20, 5.0F);
    }
    // spotless:on
}
