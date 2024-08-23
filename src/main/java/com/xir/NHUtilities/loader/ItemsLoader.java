package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import com.xir.NHUtilities.common.items.ModsItemsList;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsLoader {

    public static void registerNHUtilitiesItems() {
        if (enableGluttonyRingAndHungerRing) {
            GameRegistry.registerItem(ModsItemsList.gluttonyRing, "GluttonyRing");
            GameRegistry.registerItem(ModsItemsList.hungerRing, "HungerRing");
        }
        if (enableTimeVial) {
            GameRegistry.registerItem(ModsItemsList.timeVial, "TimeVial");
        }
        if (enableTimeVial) {
            GameRegistry.registerItem(ModsItemsList.eternityVial, "EternityVial");
        }
    }
}
