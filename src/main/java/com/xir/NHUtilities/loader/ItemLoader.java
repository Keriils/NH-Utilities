package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.nhutilies.items.NHUtilitiesItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    public static void registerNHUtilitiesItems() {
        GameRegistry.registerItem(NHUtilitiesItems.gluttonyRing, "GluttonyRing");
        GameRegistry.registerItem(NHUtilitiesItems.hungerRing, "HungerRing");
    }
}
