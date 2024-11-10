package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.ModsItemsList;
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
                new ItemStack(ModsItemsList.focusTape, 1),
                ItemList.Duct_Tape.get(1),
                TcText.aFocusTape));
    }
}
