package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.ModsItemsList;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.items.LudicrousItems;
import singulariteam.eternalsingularity.item.EternalSingularityItem;

public class RecipeLoader {

    public static void registerNHUtilitiesRecipes() {
        if (enableGluttonyRingAndHungerRing) {
            GameRegistry.addShapedRecipe(
                new ItemStack(ModsItemsList.gluttonyRing),
                "SIS",
                "IAI",
                "SIS",
                'A',
                Items.apple,
                'S',
                Items.string,
                'I',
                Items.iron_ingot);
            GameRegistry
                .addShapelessRecipe(new ItemStack(ModsItemsList.hungerRing), new ItemStack(ModsItemsList.gluttonyRing));
            GameRegistry
                .addShapelessRecipe(new ItemStack(ModsItemsList.gluttonyRing), new ItemStack(ModsItemsList.hungerRing));
        }
        if (enableTimeVial) {
            GameRegistry.addShapedRecipe(
                new ItemStack(ModsItemsList.timeVial),
                "GGG",
                "DCD",
                "QBQ",
                'B',
                Items.glass_bottle,
                'G',
                Items.gold_ingot,
                'C',
                Items.clock,
                'D',
                Items.diamond,
                'Q',
                new ItemStack(Items.dye, 1, 4));
            GameRegistry.addShapedRecipe(
                new ItemStack(ModsItemsList.timeVial),
                "CCC",
                "CTC",
                "CCC",
                'C',
                Blocks.cobblestone,
                'T',
                ModsItemsList.timeVial);
        }
        if (enableEternityVial) {
            if (!Loader.isModLoaded("gregtech") && Loader.isModLoaded("Avaritia")) {
                GameRegistry.addShapedRecipe(
                    new ItemStack(ModsItemsList.eternityVial),
                    "ICI",
                    "CTC",
                    "ICI",
                    'T',
                    ModsItemsList.timeVial,
                    'C',
                    new ItemStack(LudicrousItems.resource, 1, 5),
                    'I',
                    new ItemStack(LudicrousItems.resource, 1, 6));
            } else if (Loader.isModLoaded("gregtech")) {
                GameRegistry.addShapedRecipe(
                    new ItemStack(ModsItemsList.eternityVial),
                    "SSS",
                    "STS",
                    "SSS",
                    'T',
                    ModsItemsList.timeVial,
                    'S',
                    EternalSingularityItem.instance);
            }
        }

    }
}
