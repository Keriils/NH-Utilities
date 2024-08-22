package com.xir.NHUtilities.main;

import com.xir.NHUtilities.loader.EntityLoader;
import com.xir.NHUtilities.loader.EventLoader;
import com.xir.NHUtilities.loader.ItemsLoader;
import com.xir.NHUtilities.loader.RecipeLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ItemsLoader.registerNHUtilitiesItems();
        EventLoader.registerNHUtilitiesEvents();
    }

    public void init(FMLInitializationEvent event) {
        RecipeLoader.registerNHUtilitiesRecipes();
        EntityLoader.registerNHUtilitiesEntity();
    }

    public void postInit(FMLPostInitializationEvent event) {}

    public void serverStarting(FMLServerStartingEvent event) {}
}
