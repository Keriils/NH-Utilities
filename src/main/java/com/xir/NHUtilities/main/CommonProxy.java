package com.xir.NHUtilities.main;

import static com.xir.NHUtilities.main.NHUtilities.LOG;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;

import com.xir.NHUtilities.common.recipes.GTRecipes.GTRecipes;
import com.xir.NHUtilities.common.research.GTApiResearch;
import com.xir.NHUtilities.loader.CreativeTabsLoader;
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

        LOG.info("Pre-initializing " + MOD_NAME + "!");

        CreativeTabsLoader.registerNHUCreativeTabs();
        LOG.info("Loaded Creative Tabs.");

        ItemsLoader.registerNHUtilitiesItems();
        LOG.info("Loaded Items.");

        EventLoader.registerNHUtilitiesEvents();
        LOG.info("Loaded Events.");

        MachineLoader.registerNHUtilitiesMachine();
        LOG.info("Loaded GregTechMachines.");

    }

    public void init(FMLInitializationEvent event) {

        LOG.info("Initializing " + MOD_NAME + "!");

        RecipeLoader.registerNHUtilitiesRecipes();
        LOG.info("Loaded Recipes.");

        EntityLoader.registerNHUtilitiesEntity();
        LOG.info("Loaded Entities.");

    }

    public void postInit(FMLPostInitializationEvent event) {

        LOG.info("Post-initializing " + MOD_NAME + "!");

        ResearchLoader.registerNHUtilitiesResearch();
        LOG.info("Loaded Researches");

        GTRecipes.registerNHUtilitiesGTRecipe();
        LOG.info("Loaded NHUtilities GTRecipes");

        GTApiResearch.addGTApiResearchAndRecipes();
        LOG.info("Loaded TC_Researches and TC_Recipes through GTAPI");

    }

    public void serverStarting(FMLServerStartingEvent event) {}
}
