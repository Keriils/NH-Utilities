package com.xir.NHUtilities.common.events;

import net.minecraft.item.Item;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class WorldLoad {

    public static int healingAxe;

    @SubscribeEvent
    public void initHealingAxeIdOnWorldLoad(EntityJoinWorldEvent event) {
        healingAxe = Item.getIdFromItem(GameRegistry.findItem("ExtraUtilities", "defoliageAxe"));
    }

    public static int getHealingAxeID() {
        return healingAxe;
    }
}
