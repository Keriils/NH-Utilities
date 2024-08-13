package com.xir.NHUtilities.loader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.nhutilies.items.NHUtilitiesItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class NHUtilitiesRecipe {

    public static void init() {
        GameRegistry.addShapedRecipe(
            new ItemStack(NHUtilitiesItems.gluttonyRing),
            new Object[] { "SIS", "IAI", "SIS", 'A', Items.apple, 'S', Items.string, 'I', Items.iron_ingot });
        GameRegistry.addShapelessRecipe(
            new ItemStack(NHUtilitiesItems.hungerRing),
            new ItemStack(NHUtilitiesItems.gluttonyRing));
        GameRegistry.addShapelessRecipe(
            new ItemStack(NHUtilitiesItems.gluttonyRing),
            new ItemStack(NHUtilitiesItems.hungerRing));
    }
}
