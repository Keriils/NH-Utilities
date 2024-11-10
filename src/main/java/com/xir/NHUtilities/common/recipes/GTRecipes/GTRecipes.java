package com.xir.NHUtilities.common.recipes.GTRecipes;

import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static tectech.thing.CustomItemList.hatch_CreativeMaintenance;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.NHUItemList;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class GTRecipes {

    private static final int SECOND = 20;

    public static void initNHUtilitiesGTRecipe() {

        // ichor fuel rod
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ichorium, 4),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Ichorium, 2),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1))
            .duration(50 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium2.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(4),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Ichorium, 6),
                GTUtility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium2.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GTUtility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // radiance fuel rod
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 4),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 2),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.ShadowFuelRod.get(1))
            .duration(50 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodRadianceUranium2.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(4),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Shadow, 6),
                GTUtility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium2.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GTUtility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECOND)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // centrifuge
        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(1000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted2.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(2), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 1500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(2000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted4.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(4), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 3500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(4000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(1),
                Materials.Uranium.getDust(16),
                Materials.Plutonium.getDust(4),
                Materials.Graphite.getDust(16),
                Materials.Uranium235.getDust(2),
                Materials.Plutonium241.getDust(2))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(64))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted2.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(2),
                Materials.Uranium.getDust(32),
                Materials.Plutonium.getDust(8),
                Materials.Graphite.getDust(32),
                Materials.Uranium235.getDust(4),
                Materials.Plutonium241.getDust(4))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(128))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted4.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(4),
                Materials.Uranium.getDust(64),
                Materials.Plutonium.getDust(16),
                Materials.Graphite.getDust(64),
                Materials.Uranium235.getDust(8),
                Materials.Plutonium241.getDust(8))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(256))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .itemOutputs(NHUItemList.PrimordialPearlDust.get(4))
            .duration(100 * SECOND)
            .eut(TierEU.RECIPE_EV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemKamiResource.class), 1, 0))
            .itemOutputs(NHUItemList.IchorDroplet.get(3))
            .duration(100 * SECOND)
            .eut(TierEU.RECIPE_EV)
            .addTo(extractorRecipes);

        // for adding debug maintenance recipe
        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Hull_EV.get(1), ItemList.Duct_Tape.get(1), GTUtility.getIntegratedCircuit(16))
            .itemOutputs(hatch_CreativeMaintenance.get(1))
            .duration(25 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);
    }
}
