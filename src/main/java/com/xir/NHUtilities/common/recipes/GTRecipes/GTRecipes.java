package com.xir.NHUtilities.common.recipes.GTRecipes;

import static com.github.technus.tectech.thing.CustomItemList.hatch_CreativeMaintenance;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static thaumcraft.common.config.ConfigItems.itemEldritchObject;
import static witchinggadgets.common.WGContent.ItemMaterial;

import net.minecraft.item.ItemStack;

import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import com.xir.NHUtilities.common.items.FuelRodList;

import goodgenerator.items.MyMaterial;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class GTRecipes {

    private static final int SECOND = 20;

    public static void registerNHUtilitiesGTRecipe() {

        // ichor fuel rod
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ichorium, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Ichorium, 2),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(new ItemStack(FuelRodList.ichorFuelRod, 1))
            .duration(50 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium, 2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium_2, 1))
            .duration(10 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium_2, 2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(new ItemStack(FuelRodList.fuelRodSuperExcitedPrimordialPearlPlutonium_4, 1))
            .duration(10 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // radiance fuel rod
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 2),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(new ItemStack(FuelRodList.radianceFuelRod, 1))
            .duration(50 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium, 2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium_2, 1))
            .duration(10 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium_2, 2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(new ItemStack(FuelRodList.fuelRodExcitedRadianceUranium_4, 1))
            .duration(10 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // centrifuge
        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodSuperExcitedPrimordialPearlPlutonium, 1))
            .itemOutputs(new ItemStack(FuelRodList.ichorFuelRod, 1))
            .itemOutputs(new ItemStack(FuelRodList.ichorFuelRod, 1), new ItemStack(ItemMaterial, 1, 12))
            .outputChances(10000, 500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(1000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2, 1))
            .itemOutputs(new ItemStack(FuelRodList.ichorFuelRod, 2), new ItemStack(ItemMaterial, 1, 12))
            .outputChances(10000, 1500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(2000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4, 1))
            .itemOutputs(new ItemStack(FuelRodList.ichorFuelRod, 4), new ItemStack(ItemMaterial, 1, 12))
            .outputChances(10000, 3500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(4000))
            .duration(20 * SECOND)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodExcitedRadianceUranium, 1))
            .itemOutputs(
                new ItemStack(FuelRodList.radianceFuelRod, 1),
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

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodExcitedRadianceUranium_2, 1))
            .itemOutputs(
                new ItemStack(FuelRodList.radianceFuelRod, 2),
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

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(FuelRodList.depletedFuelRodExcitedRadianceUranium_4, 1))
            .itemOutputs(
                new ItemStack(FuelRodList.radianceFuelRod, 4),
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

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(itemEldritchObject, 1, 3))
            .itemOutputs(new ItemStack(FuelRodList.primordialPearlDust, 4))
            .duration(100 * SECOND)
            .eut(TierEU.RECIPE_EV)
            .addTo(extractorRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemKamiResource.class), 1, 0))
            .itemOutputs(new ItemStack(FuelRodList.ichorDroplet, 4))
            .duration(100 * SECOND)
            .eut(TierEU.RECIPE_EV)
            .addTo(extractorRecipes);

        // for adding debug maintenance recipe
        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Hull_EV.get(1), ItemList.Duct_Tape.get(1), GT_Utility.getIntegratedCircuit(16))
            .itemOutputs(hatch_CreativeMaintenance.get(1))
            .duration(25 * SECOND)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);
    }
}
