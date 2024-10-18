package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.loader.ResearchLoader;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;

public class ArcaneCraftingRecipes {

    public static HashMap<String, Object> ArcaneCraftingRecipes = new HashMap<>();
    private static final AspectList gtcthaumicebf = new AspectList().add(Aspect.FIRE, 64)
        .add(Aspect.ORDER, 64)
        .add(Aspect.ENTROPY, 64)
        .add(Aspect.WATER, 64)
        .add(Aspect.AIR, 64)
        .add(Aspect.EARTH, 64);

    public static void run() {
        ArcaneCraftingRecipes.put(
            "gtcthaumicebf",
            ThaumcraftApi.addArcaneCraftingRecipe(
                ResearchLoader.ThaumicEBF.toUpperCase(),
                CustomItemList.Machine_Multi_TCBlastFurnace.get(1L),
                gtcthaumicebf,
                new Object[] { "aaa", "bcb", "dbd", 'a', ItemList.Machine_Multi_BlastFurnace.get(1L), 'b',
                    ItemList.Field_Generator_LV.get(1L), 'c', new ItemStack(ConfigItems.itemFocusFire, 1), 'd',
                    GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Kanthal, 1L) }));
    }
}
