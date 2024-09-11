package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.recipes.MassRecipes.CommonRecipes;
import com.xir.NHUtilities.common.recipes.TCRecipes.AllTCRecipes;

public class RecipeLoader {

    public static void registerNHUtilitiesRecipes() {

        // For Workbench Crafting
        CommonRecipes.addAllCommonRecipes();

        // For TC Recipes
        AllTCRecipes.addAllNHUTCRecipes();
    }
}
