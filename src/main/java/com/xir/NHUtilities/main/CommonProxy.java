package com.xir.NHUtilities.main;

import com.xir.NHUtilities.loader.EntityLoader;
import com.xir.NHUtilities.loader.EventLoader;
import com.xir.NHUtilities.loader.ItemsLoader;
import com.xir.NHUtilities.loader.MachineLoader;
import com.xir.NHUtilities.loader.RecipeLoader;
import com.xir.NHUtilities.loader.ResearchLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("unused")
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        NHUtilities.LOG.info("Pre-initializing " + NHUtilities.MOD_NAME + "!");
        ItemsLoader.registerNHUtilitiesItems();
        NHUtilities.LOG.info("Loaded Items.");
        EventLoader.registerNHUtilitiesEvents();
        NHUtilities.LOG.info("Loaded Events.");
    }

    public void init(FMLInitializationEvent event) {
        NHUtilities.LOG.info("Initializing " + NHUtilities.MOD_NAME + "!");
        new MachineLoader().run();
        NHUtilities.LOG.info("Loaded TileEntities.");
        RecipeLoader.registerNHUtilitiesRecipes();
        NHUtilities.LOG.info("Loaded Recipes.");
        EntityLoader.registerNHUtilitiesEntity();
        NHUtilities.LOG.info("Loaded Entities.");
    }

    public void postInit(FMLPostInitializationEvent event) {
        NHUtilities.LOG.info("Post-initializing " + NHUtilities.MOD_NAME + "!");
        ResearchLoader.registerNHUtilitiesResearch();
        NHUtilities.LOG.info("Loaded Researches");
        NHUtilities.LOG.info(NHUtilities.MOD_NAME + " loading complete!");
    }

    public void serverStarting(FMLServerStartingEvent event) {}
}
