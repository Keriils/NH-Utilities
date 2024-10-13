package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import thaumcraft.common.config.ConfigResearch;

public class AllTCRecipes {

    public static HashMap<String, Object> AllTCRecipes = new HashMap<>();

    public static void addAllNHUTCRecipes() {
        // part
        ArcaneCraftingRecipes.run();
        CrucibleRecipes.run();
        InfusionRecipes.run();
        // part->all
        AllTCRecipes.putAll(ArcaneCraftingRecipes.ArcaneCraftingRecipes);
        AllTCRecipes.putAll(CrucibleRecipes.CrucibleRecipes);
        AllTCRecipes.putAll(InfusionRecipes.InfusionRecipes);
        // all->tcAll
        ConfigResearch.recipes.putAll(AllTCRecipes);
    }
}
