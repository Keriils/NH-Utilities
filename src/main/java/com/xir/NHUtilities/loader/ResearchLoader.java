package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_LOWER;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;

import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.api.enums.CustomItemList;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigResearch;

public class ResearchLoader {

    private static final String prefixNHUResearchWithDotEnding = "nhu.research.";
    public static final String ThaumicEBF = "thaumicebf";

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
            CustomItemList.Machine_Multi_TCBlastFurnace.get(1L))).setSpecial()
                .setPages(
                    new ResearchPage[] { new ResearchPage(prefixNHUResearchWithDotEnding + ThaumicEBF + "_1"),
                        new ResearchPage((ShapedArcaneRecipe) ConfigResearch.recipes.get("gtcthaumicebf")) })
                .setHidden()
                .setAspectTriggers(Aspect.MECHANISM)
                .registerResearchItem();
    }
}
