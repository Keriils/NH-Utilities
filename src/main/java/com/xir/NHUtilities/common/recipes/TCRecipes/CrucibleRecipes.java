package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.loader.ResearchLoader;

import gregtech.api.enums.ItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class CrucibleRecipes {

    public static HashMap<String, Object> CrucibleRecipes = new HashMap<>();
    private static final AspectList focus_tape = new AspectList().add(Aspect.ORDER, 20)
        .add(Aspect.ENTROPY, 20)
        .add(Aspect.TOOL, 40);

    public static void run() {
        CrucibleRecipes.put(
            "focustape",
            ThaumcraftApi.addCrucibleRecipe(
                ResearchLoader.focus_tape.toUpperCase(),
                NHUItemList.FocusTape.get(1),
                ItemList.Duct_Tape.get(1),
                focus_tape));
    }
}
