package com.xir.NHUtilities.main;

import com.xir.NHUtilities.loader.*;

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
        new MachineLoader().run();
        RecipeLoader.registerNHUtilitiesRecipes();
        EntityLoader.registerNHUtilitiesEntity();
    }

    public void postInit(FMLPostInitializationEvent event) {
        ResearchLoader.registerNHUtilitiesResearch();
    }

    public void serverStarting(FMLServerStartingEvent event) {}
}
