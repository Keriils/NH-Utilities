package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_LOWER;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.common.items.ModsItemsList;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigResearch;

public class ResearchLoader {

    private static final String prefixNHUResearchWithDotEnding = "nhu.research.";
    public static final String ThaumicEBF = "thaumicebf";
    public static final String focus_tape = "focustape";
    public static final String WarpWardRing = "warpwardring";

    public static void registerNHUtilitiesResearch() {
        ResearchCategories.registerCategory(
            MOD_ID_UPPER,
            new ResourceLocation(MOD_ID_LOWER, "textures/items/NHUInBookicon.png"),
            new ResourceLocation(MOD_ID_LOWER, "textures/gui/gui_researchback.png"));
        (new ResearchItem(
            ThaumicEBF.toUpperCase(),
            MOD_ID_UPPER,
            new AspectList().add(Aspect.ENERGY, 4)
                .add(Aspect.MECHANISM, 4)
                .add(Aspect.FIRE, 4),
            0,
            0,
            9,
            CustomItemList.TCBlastFurnace.get(1L))).setSpecial()
                .setPages(
                    new ResearchPage[] { new ResearchPage(prefixNHUResearchWithDotEnding + ThaumicEBF + "_1"),
                        new ResearchPage((ShapedArcaneRecipe) ConfigResearch.recipes.get("gtcthaumicebf")) })
                .setHidden()
                .setAspectTriggers(Aspect.MECHANISM)
                .registerResearchItem();
        (new ResearchItem(
            focus_tape.toUpperCase(),
            MOD_ID_UPPER,
            new AspectList().add(Aspect.ORDER, 10),
            0,
            2,
            1,
            new ItemStack(ModsItemsList.focusTape))).setSecondary()
                .setPages(
                    new ResearchPage[] { new ResearchPage(prefixNHUResearchWithDotEnding + focus_tape + "_1"),
                        new ResearchPage((CrucibleRecipe) ConfigResearch.recipes.get("focustape")) })
                .registerResearchItem();
        (new ResearchItem(
            WarpWardRing.toUpperCase(),
            MOD_ID_UPPER,
            new AspectList().add(Aspect.ORDER, 4)
                .add(Aspect.FIRE, 4)
                .add(Aspect.WATER, 4)
                .add(Aspect.EARTH, 4)
                .add(Aspect.AIR, 4)
                .add(Aspect.ENTROPY, 4),
            -2,
            0,
            3,
            new ItemStack(ModsItemsList.warpWardRing))).setParents("INFUSION")
                .setPages(
                    new ResearchPage[] { new ResearchPage(prefixNHUResearchWithDotEnding + WarpWardRing + "_1"),
                        new ResearchPage((InfusionRecipe) ConfigResearch.recipes.get("warpwardring")) })
                .registerResearchItem();
    }
}
