package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.enumPackages.CustomItemList;
import com.xir.NHUtilities.loader.ResearchLoader;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigBlocks;

public class ArcaneCraftingRecipes {

    public static HashMap<String, Object> ArcaneCraftingRecipes = new HashMap<>();
    private static final AspectList gtcthaumicebf = new AspectList().add(Aspect.FIRE, 25)
        .add(Aspect.ORDER, 25)
        .add(Aspect.ENTROPY, 25);

    public static void run() {
        ArcaneCraftingRecipes.put(
            "gtcthaumicebf",
            ThaumcraftApi.addArcaneCraftingRecipe(
                ResearchLoader.ThaumicEBF.toUpperCase(),
                CustomItemList.Machine_Multi_TCBlastFurnace.get(1L),
                gtcthaumicebf,
                new Object[] { " a ", "aba", " c ", 'a', ItemList.Machine_Multi_BlastFurnace.get(1L), 'b',
                    new ItemStack(ConfigBlocks.blockCrystal, 1, 1), 'c',
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L) }));
    }
}
