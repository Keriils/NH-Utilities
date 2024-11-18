package com.xir.NHUtilities.common.research;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;
import static goodgenerator.items.MyMaterial.atomicSeparationCatalyst;
import static goodgenerator.items.MyMaterial.plutoniumBasedLiquidFuelExcited;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.utils.TcText;

import goodgenerator.util.ItemRefer;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.util.GT_OreDictUnificator;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.ItemBrightNitor;

public class GTApiResearch {

    public static void addGTApiResearchAndRecipes() {
        GregTech_API.sThaumcraftCompat.addResearch(
            TcText.shadowMetalFuelRod.toUpperCase(),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "name." + TcText.shadowMetalFuelRod.toUpperCase()),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "text." + TcText.shadowMetalFuelRod.toUpperCase()),
            new String[] { "INFUSION" },
            MOD_ID_UPPER,
            NHUItemList.RodRadianceUranium.get(1),
            8,
            0,
            2,
            0,
            Arrays.asList(
                new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 6),
                new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 8),
                new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 16)),
            null,
            new Object[] { TcText.researchPrefixInLang + TcText.shadowMetalFuelRod + "_1",
                GregTech_API.sThaumcraftCompat.addInfusionRecipe(
                    TcText.shadowMetalFuelRod.toUpperCase(),
                    NHUItemList.ShadowFuelRod.get(1),
                    new ItemStack[] { ItemRefer.High_Density_Uranium.get(1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        NHUItemList.IchorDroplet.get(1), ItemRefer.High_Density_Uranium.get(1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        NHUItemList.IchorDroplet.get(1) },
                    NHUItemList.RodRadianceUranium.get(1),
                    8,
                    Arrays.asList(
                        new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 16),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 16),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 16))) });
        GregTech_API.sThaumcraftCompat.addResearch(
            TcText.ichoriumFuelRod.toUpperCase(),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "name." + TcText.ichoriumFuelRod.toUpperCase()),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "text." + TcText.ichoriumFuelRod.toUpperCase()),
            new String[] { "PRIMPEARL", "ICHOR", TcText.shadowMetalFuelRod.toUpperCase() },
            MOD_ID_UPPER,
            NHUItemList.RodPrimordialPearlPlutonium.get(1),
            9,
            0,
            2,
            -1,
            Arrays.asList(
                new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 6),
                new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 8),
                new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 16)),
            null,
            new Object[] { TcText.researchPrefixInLang + TcText.ichoriumFuelRod + "_1",
                GregTech_API.sThaumcraftCompat.addInfusionRecipe(
                    TcText.ichoriumFuelRod.toUpperCase(),
                    NHUItemList.IchorFuelRod.get(1),
                    new ItemStack[] { plutoniumBasedLiquidFuelExcited.get(OrePrefixes.cell, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1), NHUItemList.PrimordialPearlDust.get(1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1) },
                    NHUItemList.RodPrimordialPearlPlutonium.get(1),
                    16,
                    Arrays.asList(
                        new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 64),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 64),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 64))) });
    }
}
