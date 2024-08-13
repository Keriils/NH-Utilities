package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.nhutilies.items.GluttonyRing;
import com.xir.NHUtilities.common.nhutilies.items.HungerRing;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    public static void registerNHUtilitiesItems() {
        GameRegistry.registerItem(new GluttonyRing(), "GluttonyRing");
        GameRegistry.registerItem(new HungerRing(), "HungerRing");
    }
}
