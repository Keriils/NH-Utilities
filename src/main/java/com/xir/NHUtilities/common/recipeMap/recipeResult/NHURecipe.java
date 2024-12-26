package com.xir.NHUtilities.common.recipeMap.recipeResult;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.recipeMap.recipeMapFrontends.NHU_IndustrialAlchemicalFrontend;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;

public class NHURecipe {

    public static final RecipeMap<RecipeMapBackend> IndustrialAlchemicalRecipe = RecipeMapBuilder
        .of("nhu.recipe.IndustrialAlchemicalRecipe")
        .maxIO(2, 1, 0, 0)
        .neiHandlerInfo(builder -> builder.setDisplayStack(NHUItemList.TestMachine.get(1)))
        .neiTransferRect(100, 45, 18, 72)
        .useSpecialSlot()
        .frontend(NHU_IndustrialAlchemicalFrontend::new)
        .disableOptimize()
        .build();
}
