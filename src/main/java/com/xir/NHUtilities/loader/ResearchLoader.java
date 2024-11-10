package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_LOWER;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.common.items.ModsItemsList;
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

    public static void registerNHUtilitiesResearch() {
        ResearchCategories.registerCategory(
            MOD_ID_UPPER,
            new ResourceLocation(MOD_ID_LOWER, "textures/items/NHUInBookicon.png"),
            new ResourceLocation(MOD_ID_LOWER, "textures/gui/gui_researchback.png"));
        (new ResearchItem(
            TcText.thaumicEBF.toUpperCase(),
            MOD_ID_UPPER,
            TcText.resThaumicEBF,
            0,
            0,
            9,
            CustomItemList.Machine_Multi_TCBlastFurnace.get(1L))).setSpecial()
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
            new ItemStack(ModsItemsList.focusTape))).setSecondary()
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
            new ItemStack(ModsItemsList.warpWardRing))).setParents("INFUSION")
                .setPages(
                    new ResearchPage[] { new ResearchPage(TcText.researchPrefixInLang + TcText.warpWardRing + "_1"),
                        new ResearchPage((InfusionRecipe) ConfigResearch.recipes.get(TcText.warpWardRing)) })
                .registerResearchItem();
    }
}
