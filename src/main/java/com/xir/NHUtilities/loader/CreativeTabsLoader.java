package com.xir.NHUtilities.loader;

import net.minecraft.creativetab.CreativeTabs;

import com.xir.NHUtilities.common.items.aCreativeTab.NHUCreativeTab;

public class CreativeTabsLoader {

    public static CreativeTabs nhuCreativeTab;

    public static void registerNHUCreativeTabs() {
        nhuCreativeTab = new NHUCreativeTab();
    }
}
