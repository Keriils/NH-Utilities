package com.xir.NHUtilities.loader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.ModsItemsList;
import com.xir.NHUtilities.config.Config;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeLoader {

    public static void registerNHUtilitiesRecipes() {
        if (Config.enableGluttonyRingAndHungerRing) {
            GameRegistry.addShapedRecipe(
                new ItemStack(ModsItemsList.gluttonyRing),
                new Object[] { "SIS", "IAI", "SIS", 'A', Items.apple, 'S', Items.string, 'I', Items.iron_ingot });
            GameRegistry
                .addShapelessRecipe(new ItemStack(ModsItemsList.hungerRing), new ItemStack(ModsItemsList.gluttonyRing));
            GameRegistry
                .addShapelessRecipe(new ItemStack(ModsItemsList.gluttonyRing), new ItemStack(ModsItemsList.hungerRing));
        }
        if (Config.enableTimeVial) {
            GameRegistry.addShapedRecipe(
                new ItemStack(ModsItemsList.timeVial),
                new Object[] { "GGG", "DCD", "QBQ", 'B', Items.glass_bottle, 'G', Items.gold_ingot, 'C', Items.clock,
                    'D', Items.diamond, 'Q', new ItemStack(Items.dye, 1, 4) });
        }
    }
}
