package com.xir.NHUtilities.common.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class EnhanceExUHealingAxe {

    @SubscribeEvent
    public void onHeldHealingAxe(PlayerEvent event) {
        EntityPlayer entityPlayer = event.entityPlayer;
        if (entityPlayer != null && entityPlayer.worldObj.getTotalWorldTime() % 40L == 0L
            && entityPlayer.getHeldItem() != null
            && (entityPlayer.getHeldItem()
                .getItem() == GameRegistry.findItem("ExtraUtilities", "defoliageAxe"))) {
            entityPlayer.getFoodStats()
                .addStats(20, 5.0F); // ha....
        }
    }
}
