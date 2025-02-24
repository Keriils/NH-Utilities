package com.xir.NHUtilities.common.recipes.MassRecipes;

import static com.brandon3055.draconicevolution.common.ModBlocks.draconiumBlock;
import static com.brandon3055.draconicevolution.common.ModBlocks.infusedObsidian;
import static com.xir.NHUtilities.config.Config.enableDebugMaintenanceHatchRecipe;
import static com.xir.NHUtilities.config.Config.enableEggMachine;
import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableWirelessHatchMore;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.neutroniumCompressorRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaForgeRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;
import static tectech.thing.CustomItemList.hatch_CreativeMaintenance;

import com.xir.NHUtilities.common.recipes.MassRecipes.CoverEnergyHatches.WirelessCoverRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.NHUItemList;

import bartworks.system.material.WerkstoffLoader;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.metadata.CompressionTierKey;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import singulariteam.eternalsingularity.item.EternalSingularityItem;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class NHURecipes {

    public static void initNHURecipeCrossMod() {

        initFuelRodRecipe();
        if (enableEggMachine) initEggMachineRecipe();
        if (enableEternityVial) initEternityTimeVialRecipe();
        if (enableWirelessHatchMore) WirelessHatchMoreRecipe.initWirelessHatchMore();
        if (enableWirelessHatchMore) WirelessCoverRecipes.initWirelessCover();

        // for adding debug maintenance recipe
        if (enableDebugMaintenanceHatchRecipe) {
            GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Hull_EV.get(1), ItemList.Duct_Tape.get(1), GTUtility.getIntegratedCircuit(16))
                .itemOutputs(hatch_CreativeMaintenance.get(1))
                .duration(25 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        }
    }

    private static void initFuelRodRecipe() {

        // ichor fuel rod
        GTValues.RA.stdBuilder()
            .itemInputs(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ichorium, 4),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Ichorium, 2),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1))
            .duration(50 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium2.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(4),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Ichorium, 6),
                GTUtility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium2.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GTUtility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECONDS)
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
            .duration(50 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GTUtility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodRadianceUranium2.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(4),
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Shadow, 6),
                GTUtility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium2.get(2),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GTUtility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // centrifuge
        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(1000))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted2.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(2), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 1500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(2000))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted4.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(4), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 3500)
            .fluidOutputs(GGMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(4000))
            .duration(20 * SECONDS)
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
            .duration(20 * SECONDS)
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
            .duration(20 * SECONDS)
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
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .itemOutputs(NHUItemList.PrimordialPearlDust.get(4))
            .duration(100 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemKamiResource.class), 1, 0))
            .itemOutputs(NHUItemList.IchorDroplet.get(3))
            .duration(100 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(extractorRecipes);
    }

    private static void initEggMachineRecipe() {

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.ChaosDragonEgg.get(1))
            .fluidInputs(Materials.Radon.getGas(16384))
            .itemOutputs(NHUItemList.ChaosDraconiumEgg.get(2))
            .duration(127 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .metadata(COIL_HEAT, 6400)
            .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.ChaosDraconiumEgg.get(1))
            .fluidInputs(Materials.Draconium.getMolten(1008L))
            .itemOutputs(NHUItemList.ChaosDragonEgg.get(1))
            .duration(3600 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.AncientDragonEgg.get(1))
            .fluidInputs(Materials.Radon.getPlasma(16384))
            .itemOutputs(NHUItemList.AncientDraconiumEgg.get(2))
            .duration(127 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .metadata(COIL_HEAT, 8001)
            .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.AncientDraconiumEgg.get(1))
            .fluidInputs(Materials.DraconiumAwakened.getMolten(1008L))
            .itemOutputs(NHUItemList.AncientDragonEgg.get(1))
            .duration(3600 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(UniversalChemical);

        NHUItemList[] eggMachineList = new NHUItemList[] { NHUItemList.Egg_Machine_EV, NHUItemList.Egg_Machine_IV,
            NHUItemList.Egg_Machine_LuV, NHUItemList.Egg_Machine_ZPM, NHUItemList.Egg_Machine_UV,
            NHUItemList.Egg_Machine_UHV, NHUItemList.Egg_Machine_UEV, NHUItemList.Egg_Machine_UIV,
            NHUItemList.Egg_Machine_UMV, NHUItemList.Egg_Machine_UXV, NHUItemList.Egg_Machine_MAX };

        for (int i = 0; i < eggMachineList.length - 1; i++) {
            GTValues.RA.stdBuilder()
                .itemInputs(eggMachineList[i].get(3), new ItemStack(Item.getItemFromBlock(Blocks.dragon_egg), 1))
                .itemOutputs(eggMachineList[i + 1].get(1))
                .fluidInputs(Materials.Radon.getGas(4000 << i))
                .duration((20 << i) * SECONDS)
                .eut(GTValues.VP[i])
                .addTo(assemblerRecipes);
        }

        GTValues.RA.stdBuilder()
            .itemInputs(
                new ItemStack(Items.egg, 64),
                ItemList.WetTransformer_EV_HV.get(1),
                ItemList.Field_Generator_HV.get(3),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(32),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 16))
            .fluidInputs(Materials.Radon.getGas(16000))
            .itemOutputs(NHUItemList.Egg_Machine_EV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.MagicEnergyAbsorber_EV.get(1),
                ItemList.WetTransformer_EV_HV.get(1),
                ItemList.Field_Generator_HV.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(32),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 4))
            .fluidInputs(Materials.Radon.getGas(4000))
            .itemOutputs(NHUItemList.Egg_Machine_EV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_EV.get(1),
                ItemList.WetTransformer_IV_EV.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 64))
            .fluidInputs(Materials.HSSG.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_IV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_IV.get(1),
                ItemList.WetTransformer_LuV_IV.get(1),
                ItemList.Energy_LapotronicOrb.get(4),
                ItemList.Emitter_LuV.get(4))
            .fluidInputs(Materials.HSSS.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_LuV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_LuV.get(1),
                ItemList.WetTransformer_ZPM_LuV.get(1),
                ItemList.Energy_LapotronicOrb2.get(4),
                ItemList.Emitter_ZPM.get(4))
            .fluidInputs(Materials.Trinium.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_ZPM.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(assemblerRecipes);

        ExtremeCraftingManager.getInstance()
            .addRecipe(
                NHUItemList.Egg_Machine_UV.get(1),
                "         ",
                " AAAAAAA ",
                " ABBBBBA ",
                " ABCCCBA ",
                " ABCZCBA ",
                " ABCCCBA ",
                " ABBBBBA ",
                " AAAAAAA ",
                'A',
                new ItemStack(infusedObsidian, 1),
                'B',
                new ItemStack(draconiumBlock, 1, 2),
                'C',
                ItemList.WetTransformer_UV_ZPM.get(1),
                'Z',
                NHUItemList.Egg_Machine_ZPM.get(1));
    }

    private static void initEternityTimeVialRecipe() {
        GTValues.RA.stdBuilder()
            .itemInputs(NHUItemList.TimeVial.get(0), new ItemStack(EternalSingularityItem.instance, 64))
            .fluidInputs(MaterialsKevlar.Kevlar.getMolten(1440L))
            .itemOutputs(NHUItemList.EternityVial.get(1))
            .outputChances(500)
            .metadata(COIL_HEAT, 13500)
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .addTo(plasmaForgeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Timepiece.get(1))
            .fluidInputs(MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(1145))
            .itemOutputs(NHUItemList.EternityVial.get(1))
            // Require stabilized black hole
            .metadata(CompressionTierKey.INSTANCE, 2)
            .duration(3 * MINUTES)
            .eut(TierEU.RECIPE_UXV)
            .addTo(neutroniumCompressorRecipes);
    }
}
