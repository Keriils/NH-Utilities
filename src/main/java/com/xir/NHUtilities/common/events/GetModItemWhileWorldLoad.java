package com.xir.NHUtilities.common.events;

import net.minecraft.item.Item;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public class GetModItemWhileWorldLoad {

    private static int healingAxe;
    private static Item itemHealingAxe;

    @SubscribeEvent
    public void initHealingAxeIdOnWorldLoad(EntityJoinWorldEvent event) {
        itemHealingAxe = GameRegistry.findItem("ExtraUtilities", "defoliageAxe");
        healingAxe = Item.getIdFromItem(itemHealingAxe);
    }

    public static int getHealingAxeID() {
        return healingAxe;
    }

    public static Item getItemHealingAxe() {
        return itemHealingAxe;
    }
}
