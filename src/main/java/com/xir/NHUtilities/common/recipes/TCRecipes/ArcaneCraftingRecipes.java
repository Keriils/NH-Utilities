package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.utils.TcText;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.common.config.ConfigItems;

public class ArcaneCraftingRecipes {

    public static HashMap<String, Object> ArcaneCraftingRecipes = new HashMap<>();

    public static void run() {
        ArcaneCraftingRecipes.put(
            TcText.thaumicEBF,
            ThaumcraftApi.addArcaneCraftingRecipe(
                TcText.thaumicEBF.toUpperCase(),
                CustomItemList.Machine_Multi_TCBlastFurnace.get(1L),
                TcText.aThaumicEbf,
                new Object[] { "aaa", "bcb", "dbd", 'a', ItemList.Machine_Multi_BlastFurnace.get(1L), 'b',
                    ItemList.Field_Generator_LV.get(1L), 'c', new ItemStack(ConfigItems.itemFocusFire, 1), 'd',
                    GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Kanthal, 1L) }));
    }
}
