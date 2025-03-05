package com.xir.NHUtilities.common.recipes.MassRecipes;

import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableSimpleTimeVialRecipe;
import static com.xir.NHUtilities.config.Config.enableTimeVial;
import static gregtech.api.enums.Mods.SpiceOfLife;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.NHUItemList;

import cpw.mods.fml.common.registry.GameRegistry;
import singulariteam.eternalsingularity.item.EternalSingularityItem;

public class CommonRecipes {

    /**
     * added for workbench crafting & register in this
     */
    public static void addAllCommonRecipes() {

        if (enableGluttonyRingAndHungerRing) {
            GameRegistry.addShapedRecipe(
                NHUItemList.GluttonyRing.get(1),
                "SIS",
                "IAI",
                "SIS",
                'A',
                Items.apple,
                'S',
                Items.string,
                'I',
                Items.iron_ingot);
            GameRegistry.addShapelessRecipe(NHUItemList.HungerRing.get(1), NHUItemList.GluttonyRing.get(1));
            GameRegistry.addShapelessRecipe(NHUItemList.GluttonyRing.get(1), NHUItemList.HungerRing.get(1));
        }

        if (enableTimeVial) {
            GameRegistry.addShapedRecipe(
                NHUItemList.TimeVial.get(1),
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
                NHUItemList.TimeVial.get(1),
                "CCC",
                "CTC",
                "CCC",
                'C',
                Blocks.cobblestone,
                'T',
                NHUItemList.TimeVial.get(1));
        }

        if (enableTimeVial && enableEternityVial && enableSimpleTimeVialRecipe) {
            GameRegistry.addShapedRecipe(
                NHUItemList.EternityVial.get(1),
                "SSS",
                "STS",
                "SSS",
                'T',
                NHUItemList.TimeVial.get(1),
                'S',
                EternalSingularityItem.instance);
        }

        if (enableLunchBoxPlus && SpiceOfLife.isModLoaded()) {
            GameRegistry.addShapedRecipe(
                NHUItemList.LunchBoxPlus.get(1),
                "IDI",
                "DCD",
                "IDI",
                'I',
                Blocks.iron_block,
                'D',
                Items.diamond,
                'C',
                Blocks.chest);
        }

    }
}
