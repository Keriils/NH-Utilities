package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_LOWER;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;

import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.utils.TcText;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigResearch;

public class ResearchLoader {

    public static void initNHUtilitiesResearch() {
        ResearchCategories.registerCategory(
            MOD_ID_UPPER,
            new ResourceLocation(MOD_ID_LOWER, "textures/items/ResearchIcon.png"),
            new ResourceLocation(MOD_ID_LOWER, "textures/gui/research_background.png"));
        (new ResearchItem(
            TcText.thaumicEBF.toUpperCase(),
            MOD_ID_UPPER,
            TcText.resThaumicEBF,
            0,
            0,
            9,
            NHUItemList.TCBlastFurnace.get(1))).setSpecial()
                .setPages(
                    new ResearchPage[] { new ResearchPage(TcText.researchPrefixInLang + TcText.thaumicEBF + "_1"),
                        new ResearchPage((ShapedArcaneRecipe) ConfigResearch.recipes.get(TcText.thaumicEBF)) })
                .setHidden()
                .setAspectTriggers(Aspect.MECHANISM)
                .registerResearchItem();
        (new ResearchItem(
            TcText.focusTape.toUpperCase(),
            MOD_ID_UPPER,
            TcText.resFocusTape,
            0,
            2,
            1,
            NHUItemList.FocusTape.get(1))).setSecondary()
                .setPages(
                    new ResearchPage[] { new ResearchPage(TcText.researchPrefixInLang + TcText.focusTape + "_1"),
                        new ResearchPage((CrucibleRecipe) ConfigResearch.recipes.get(TcText.focusTape)) })
                .registerResearchItem();
        (new ResearchItem(
            TcText.warpWardRing.toUpperCase(),
            MOD_ID_UPPER,
            TcText.resWarpWardRing,
            -2,
            0,
            3,
            NHUItemList.WarpWardRing.get(1))).setParents("INFUSION")
                .setPages(
                    new ResearchPage[] { new ResearchPage(TcText.researchPrefixInLang + TcText.warpWardRing + "_1"),
                        new ResearchPage((InfusionRecipe) ConfigResearch.recipes.get(TcText.warpWardRing)) })
                .registerResearchItem();
    }
}
