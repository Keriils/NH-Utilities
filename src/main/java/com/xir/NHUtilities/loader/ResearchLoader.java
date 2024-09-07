package com.xir.NHUtilities.loader;

import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.enumPackages.CustomItemList;
import com.xir.NHUtilities.main.NHUtilities;

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
            NHUtilities.MODIDUPPER,
            new ResourceLocation(NHUtilities.MODIDLOWER, "textures/items/NHUInBookicon.png"),
            new ResourceLocation(NHUtilities.MODIDLOWER, "textures/gui/gui_researchback.png"));
        (new ResearchItem(
            ThaumicEBF.toUpperCase(),
            NHUtilities.MODIDUPPER,
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
