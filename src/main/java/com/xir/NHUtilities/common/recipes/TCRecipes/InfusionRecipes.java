package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.ModsItemsList;
import com.xir.NHUtilities.utils.TcText;

import gregtech.api.enums.ItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.common.config.ConfigItems;

public class InfusionRecipes {

    public static HashMap<String, Object> InfusionRecipes = new HashMap<>();

    public static void run() {
        InfusionRecipes.put(
            TcText.warpWardRing,
            ThaumcraftApi.addInfusionCraftingRecipe(
                TcText.warpWardRing.toUpperCase(),
                new ItemStack(ModsItemsList.warpWardRing, 1),
                16,
                TcText.aWarpWardRing,
                ItemList.Field_Generator_EV.get(1L),
                new ItemStack[] { new ItemStack(ConfigItems.itemBaubleBlanks, 1, 3),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 4),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 5),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 6),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 7),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 8) }));
    }
}
