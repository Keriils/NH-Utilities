package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.ModsItemsList;
import com.xir.NHUtilities.loader.ResearchLoader;

import gregtech.api.enums.ItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;

public class InfusionRecipes {

    public static HashMap<String, Object> InfusionRecipes = new HashMap<>();
    private static final AspectList WarpWardRing = new AspectList().add(Aspect.ORDER, 512)
        .add(Aspect.FIRE, 512)
        .add(Aspect.WATER, 512)
        .add(Aspect.EARTH, 512)
        .add(Aspect.AIR, 512)
        .add(Aspect.ENTROPY, 512)
        .add(Aspect.WEATHER, 16);

    public static void run() {
        InfusionRecipes.put(
            "warpwardring",
            ThaumcraftApi.addInfusionCraftingRecipe(
                ResearchLoader.WarpWardRing.toUpperCase(),
                new ItemStack(ModsItemsList.warpRing, 1),
                16,
                WarpWardRing,
                ItemList.Field_Generator_EV.get(1L),
                new ItemStack[] { new ItemStack(ConfigItems.itemBaubleBlanks, 1, 3),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 4),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 5),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 6),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 7),
                    new ItemStack(ConfigItems.itemBaubleBlanks, 1, 8) }));
    }
}
