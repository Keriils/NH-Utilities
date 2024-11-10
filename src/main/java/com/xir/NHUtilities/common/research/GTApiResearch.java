package com.xir.NHUtilities.common.research;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;
import static goodgenerator.items.GGMaterial.atomicSeparationCatalyst;
import static goodgenerator.items.GGMaterial.plutoniumBasedLiquidFuelExcited;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.xir.NHUtilities.common.items.FuelRodList;
import com.xir.NHUtilities.utils.TcText;

import goodgenerator.util.ItemRefer;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.util.GTOreDictUnificator;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.ItemBrightNitor;

public class GTApiResearch {

    public static void addGTApiResearchAndRecipes() {
        GregTechAPI.sThaumcraftCompat.addResearch(
            TcText.shadowMetalFuelRod.toUpperCase(),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "name." + TcText.shadowMetalFuelRod.toUpperCase()),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "text." + TcText.shadowMetalFuelRod.toUpperCase()),
            new String[] { "INFUSION" },
            MOD_ID_UPPER,
            new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium, 1),
            8,
            0,
            2,
            0,
            Arrays.asList(
                new TCAspects.TC_AspectStack(TCAspects.PRAECANTATIO, 6),
                new TCAspects.TC_AspectStack(TCAspects.RADIO, 8),
                new TCAspects.TC_AspectStack(TCAspects.POTENTIA, 16)),
            null,
            new Object[] { TcText.researchPrefixInLang + TcText.shadowMetalFuelRod + "_1",
                GregTechAPI.sThaumcraftCompat.addInfusionRecipe(
                    TcText.shadowMetalFuelRod.toUpperCase(),
                    new ItemStack(FuelRodList.shadowFuelRod, 1),
                    new ItemStack[] { ItemRefer.High_Density_Uranium.get(1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(FuelRodList.ichorDroplet, 1), ItemRefer.High_Density_Uranium.get(1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemBrightNitor.class), 1),
                        new ItemStack(FuelRodList.ichorDroplet, 1) },
                    new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium, 1),
                    8,
                    Arrays.asList(
                        new TCAspects.TC_AspectStack(TCAspects.RADIO, 16),
                        new TCAspects.TC_AspectStack(TCAspects.PRAECANTATIO, 16),
                        new TCAspects.TC_AspectStack(TCAspects.POTENTIA, 16))) });
        GregTechAPI.sThaumcraftCompat.addResearch(
            TcText.ichoriumFuelRod.toUpperCase(),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "name." + TcText.ichoriumFuelRod.toUpperCase()),
            StatCollector.translateToLocal(
                TcText.prefixOfResearchInThaumonomicon + "text." + TcText.ichoriumFuelRod.toUpperCase()),
            new String[] { "PRIMPEARL", "ICHOR", TcText.shadowMetalFuelRod.toUpperCase() },
            MOD_ID_UPPER,
            new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium, 1),
            9,
            0,
            2,
            -1,
            Arrays.asList(
                new TCAspects.TC_AspectStack(TCAspects.PRAECANTATIO, 6),
                new TCAspects.TC_AspectStack(TCAspects.RADIO, 8),
                new TCAspects.TC_AspectStack(TCAspects.POTENTIA, 16)),
            null,
            new Object[] { TcText.researchPrefixInLang + TcText.ichoriumFuelRod + "_1",
                GregTechAPI.sThaumcraftCompat.addInfusionRecipe(
                    TcText.ichoriumFuelRod.toUpperCase(),
                    new ItemStack(FuelRodList.ichorFuelRod, 1),
                    new ItemStack[] { plutoniumBasedLiquidFuelExcited.get(OrePrefixes.cell, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        new ItemStack(FuelRodList.primordialPearlDust, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1) },
                    new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium, 1),
                    16,
                    Arrays.asList(
                        new TCAspects.TC_AspectStack(TCAspects.RADIO, 64),
                        new TCAspects.TC_AspectStack(TCAspects.PRAECANTATIO, 64),
                        new TCAspects.TC_AspectStack(TCAspects.POTENTIA, 64))) });
    }
}
