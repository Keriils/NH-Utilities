package com.xir.NHUtilities.main;

import static com.xir.NHUtilities.main.NHUtilities.LOG;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;

import com.xir.NHUtilities.common.api.enums.TexturesSets;
import com.xir.NHUtilities.common.recipes.MassRecipes.NHURecipes;
import com.xir.NHUtilities.common.research.GTApiResearch;
import com.xir.NHUtilities.loader.EntityLoader;
import com.xir.NHUtilities.loader.EventLoader;
import com.xir.NHUtilities.loader.ItemsLoader;
import com.xir.NHUtilities.loader.MachineLoader;
import com.xir.NHUtilities.loader.RecipeLoader;
import com.xir.NHUtilities.loader.ResearchLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("unused")
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        TexturesSets.init();

        LOG.info("Pre-initializing " + MOD_NAME + "!");

        ItemsLoader.initNHUtilitiesItems();
        LOG.info("Loaded Items.");

        EventLoader.initNHUtilitiesEvents();
        LOG.info("Loaded Events.");

    }

    public void init(FMLInitializationEvent event) {

        LOG.info("Initializing " + MOD_NAME + "!");

        MachineLoader.initNHUtilitiesMachine();
        LOG.info("Loaded GregTechMachines.");

        RecipeLoader.initNHUtilitiesRecipes();
        LOG.info("Loaded Recipes.");

        EntityLoader.initNHUtilitiesEntity();
        LOG.info("Loaded Entities.");

    }

    public void postInit(FMLPostInitializationEvent event) {

        LOG.info("Post-initializing " + MOD_NAME + "!");

    }

    public void completeInit(FMLLoadCompleteEvent event) {
        LOG.info("Complete-initializing " + MOD_NAME + "!");

        ResearchLoader.initNHUtilitiesResearch();
        LOG.info("Loaded Researches");

        NHURecipes.initNHURecipeCrossMod();
        LOG.info("Loaded NHUtilities Recipe Cross Mod");

        GTApiResearch.addGTApiResearchAndRecipes();
        LOG.info("Loaded TC_Researches and TC_Recipes through GTAPI");
    }

    public void serverStarting(FMLServerStartingEvent event) {}
}
