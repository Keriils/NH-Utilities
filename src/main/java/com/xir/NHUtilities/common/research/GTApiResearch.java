package com.xir.NHUtilities.common.research;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID_UPPER;
import static goodgenerator.items.MyMaterial.atomicSeparationCatalyst;
import static goodgenerator.items.MyMaterial.plutoniumBasedLiquidFuelExcited;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.xir.NHUtilities.common.items.FuelRodList;

import goodgenerator.util.ItemRefer;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.util.GT_OreDictUnificator;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.ItemBrightNitor;

public class GTApiResearch {

    private static final String PrefixOfResearchInThaumonomicon = "tc.research_";
    private static final String ShadowMetalFuelRod = "SHADOWMETALFUELROD";
    private static final String IchoriumFuelRod = "ICHORIUMFUELROD";

    public static void addGTApiResearchAndRecipes() {
        GregTech_API.sThaumcraftCompat.addResearch(
            ShadowMetalFuelRod,
            StatCollector.translateToLocal(
                PrefixOfResearchInThaumonomicon + "name." + ShadowMetalFuelRod),
            StatCollector.translateToLocal(
                PrefixOfResearchInThaumonomicon + "text." + ShadowMetalFuelRod),
            new String[] { "INFUSION" },
            MOD_ID_UPPER,
            new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium, 1),
            8,
            0,
            2,
            0,
            Arrays.asList(
                new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 6),
                new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 8),
                new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 16)),
            null,
            new Object[] { "nhu.research.shadowmetalfuelrod_1",
                GregTech_API.sThaumcraftCompat.addInfusionRecipe(
                    ShadowMetalFuelRod,
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
                        new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 256),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 256),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 256))) });
        GregTech_API.sThaumcraftCompat.addResearch(
            IchoriumFuelRod,
            StatCollector.translateToLocal(
                PrefixOfResearchInThaumonomicon + "name." + IchoriumFuelRod),
            StatCollector.translateToLocal(
                PrefixOfResearchInThaumonomicon + "text." + IchoriumFuelRod),
            new String[] { "PRIMPEARL", "ICHOR", ShadowMetalFuelRod },
            MOD_ID_UPPER,
            new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium, 1),
            9,
            0,
            2,
            -1,
            Arrays.asList(
                new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 6),
                new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 8),
                new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 16)),
            null,
            new Object[] { "nhu.research.ichoriumfuelrod_1",
                GregTech_API.sThaumcraftCompat.addInfusionRecipe(
                    IchoriumFuelRod,
                    new ItemStack(FuelRodList.ichorFuelRod, 1),
                    new ItemStack[] { plutoniumBasedLiquidFuelExcited.get(OrePrefixes.cell, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        new ItemStack(FuelRodList.primordialPearlDust, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cellMolten, Materials.Ichorium, 1),
                        atomicSeparationCatalyst.get(OrePrefixes.dust, 1) },
                    new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium, 1),
                    16,
                    Arrays.asList(
                        new TC_Aspects.TC_AspectStack(TC_Aspects.RADIO, 1024),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1024),
                        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 1024))) });
    }
}
