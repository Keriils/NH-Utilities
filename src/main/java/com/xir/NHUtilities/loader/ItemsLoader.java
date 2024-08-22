package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.items.ModsItemsList;
import com.xir.NHUtilities.config.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsLoader {

    public static void registerNHUtilitiesItems() {
        if (Config.enableGluttonyRingAndHungerRing) {
            GameRegistry.registerItem(ModsItemsList.gluttonyRing, "GluttonyRing");
            GameRegistry.registerItem(ModsItemsList.hungerRing, "HungerRing");
        }
        if (Config.enableTimeVial) {
            GameRegistry.registerItem(ModsItemsList.timeVial, "TimeVial");
        }
    }
}
