package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.utils.TcText;

import gregtech.api.enums.ItemList;
import thaumcraft.api.ThaumcraftApi;

public class CrucibleRecipes {

    public static HashMap<String, Object> CrucibleRecipes = new HashMap<>();

    public static void run() {
        CrucibleRecipes.put(
            TcText.focusTape,
            ThaumcraftApi.addCrucibleRecipe(
                TcText.focusTape.toUpperCase(),
                NHUItemList.FocusTape.get(1),
                ItemList.Duct_Tape.get(1),
                TcText.aFocusTape));
    }
}
