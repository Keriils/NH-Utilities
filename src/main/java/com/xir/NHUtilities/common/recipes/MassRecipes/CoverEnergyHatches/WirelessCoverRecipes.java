package com.xir.NHUtilities.common.recipes.MassRecipes.CoverEnergyHatches;

import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.dreammaster.gthandler.CustomItemList;
import com.xir.NHUtilities.common.api.enums.NHUItemList;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class WirelessCoverRecipes {

    public static void initWirelessCover() {

        // Energy Wireless Cover 2A
        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_LV.get(1),
                ItemList.Robot_Arm_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2),
                ItemList.LV_Coil.get(1),
                GTOreDictUnificator.get(OrePrefixes.spring, Materials.Tin, 1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_MV.get(1),
                ItemList.Robot_Arm_MV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2),
                ItemList.MV_Coil.get(1),
                ItemList.Circuit_Chip_ULPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_HV.get(1),
                ItemList.Robot_Arm_HV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2),
                ItemList.HV_Coil.get(1),
                ItemList.Circuit_Chip_LPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_EV.get(1),
                ItemList.Robot_Arm_EV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 2),
                ItemList.EV_Coil.get(1),
                ItemList.Circuit_Chip_PIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_IV.get(1),
                ItemList.Robot_Arm_IV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 2),
                ItemList.IV_Coil.get(1),
                ItemList.Circuit_Chip_HPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_LuV.get(1),
                ItemList.Robot_Arm_LuV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 2),
                ItemList.LuV_Coil.get(1),
                ItemList.Circuit_Chip_HPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.plate, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_ZPM.get(1),
                ItemList.Robot_Arm_ZPM.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 2),
                ItemList.ZPM_Coil.get(1),
                ItemList.Circuit_Chip_UHPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UV.get(1),
                ItemList.Robot_Arm_UV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 2),
                ItemList.UV_Coil.get(1),
                ItemList.Circuit_Chip_UHPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UHV.get(1),
                ItemList.Robot_Arm_UHV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 2),
                ItemList.UHV_Coil.get(1),
                ItemList.Circuit_Chip_NPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UEV.get(1),
                ItemList.Robot_Arm_UEV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 2),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Chip_NPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UIV.get(1),
                ItemList.Robot_Arm_UIV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UIV, 2),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Chip_PPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UMV.get(1),
                ItemList.Robot_Arm_UMV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UMV, 2),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Chip_PPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.SpaceTime, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_UXV.get(1),
                ItemList.Robot_Arm_UXV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UXV, 2),
                ItemList.UHV_Coil.get(32),
                CustomItemList.RawPicoWafer.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.MagMatter, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Sensor_MAX.get(1),
                ItemList.Robot_Arm_MAX.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 2),
                ItemList.UHV_Coil.get(64),
                CustomItemList.PicoWafer.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator
                    .get(OrePrefixes.plate, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_2A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Dynamo Wireless Cover 2A
        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_LV.get(1),
                ItemList.Robot_Arm_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2),
                ItemList.LV_Coil.get(1),
                GTOreDictUnificator.get(OrePrefixes.spring, Materials.Tin, 1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_MV.get(1),
                ItemList.Robot_Arm_MV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2),
                ItemList.MV_Coil.get(1),
                ItemList.Circuit_Chip_ULPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_HV.get(1),
                ItemList.Robot_Arm_HV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2),
                ItemList.HV_Coil.get(1),
                ItemList.Circuit_Chip_LPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_EV.get(1),
                ItemList.Robot_Arm_EV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 2),
                ItemList.EV_Coil.get(1),
                ItemList.Circuit_Chip_PIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_IV.get(1),
                ItemList.Robot_Arm_IV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 2),
                ItemList.IV_Coil.get(1),
                ItemList.Circuit_Chip_HPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_LuV.get(1),
                ItemList.Robot_Arm_LuV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 2),
                ItemList.LuV_Coil.get(1),
                ItemList.Circuit_Chip_HPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.plate, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_ZPM.get(1),
                ItemList.Robot_Arm_ZPM.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 2),
                ItemList.ZPM_Coil.get(1),
                ItemList.Circuit_Chip_UHPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UV.get(1),
                ItemList.Robot_Arm_UV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 2),
                ItemList.UV_Coil.get(1),
                ItemList.Circuit_Chip_UHPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UHV.get(1),
                ItemList.Robot_Arm_UHV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 2),
                ItemList.UHV_Coil.get(1),
                ItemList.Circuit_Chip_NPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UEV.get(1),
                ItemList.Robot_Arm_UEV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 2),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Chip_NPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UIV.get(1),
                ItemList.Robot_Arm_UIV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UIV, 2),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Chip_PPIC.get(1),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UMV.get(1),
                ItemList.Robot_Arm_UMV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UMV, 2),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Chip_PPIC.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.SpaceTime, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_UXV.get(1),
                ItemList.Robot_Arm_UXV.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UXV, 2),
                ItemList.UHV_Coil.get(32),
                CustomItemList.RawPicoWafer.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.MagMatter, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Emitter_MAX.get(1),
                ItemList.Robot_Arm_MAX.get(1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 2),
                ItemList.UHV_Coil.get(64),
                CustomItemList.PicoWafer.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 2),
                GTOreDictUnificator
                    .get(OrePrefixes.plate, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_2A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Energy Wireless Cover Multi 4A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_LV.get(2),
                ItemList.LV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_MV.get(2),
                ItemList.MV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_HV.get(2),
                ItemList.HV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_EV.get(2),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_IV.get(2),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_LuV.get(2),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_ZPM.get(2),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UV.get(2),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UHV.get(2),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UEV.get(2),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_InductorXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UIV.get(2),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_InductorXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UMV.get(2),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_InductorXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_UXV.get(2),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_InductorXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_2A_MAX.get(2),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_InductorXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_4A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Dynamo Wireless Cover Multi 4A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_LV.get(2),
                ItemList.LV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_MV.get(2),
                ItemList.MV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_HV.get(2),
                ItemList.HV_Coil.get(2),
                ItemList.Circuit_Parts_Coil.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_EV.get(2),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_IV.get(2),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_LuV.get(2),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_InductorSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_ZPM.get(2),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UV.get(2),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UHV.get(2),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_InductorASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UEV.get(2),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_InductorXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UIV.get(2),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_InductorXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UMV.get(2),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_InductorXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_UXV.get(2),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_InductorXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_2A_MAX.get(2),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_InductorXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_4A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Energy Wireless Cover Multi 16A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_LV.get(4),
                ItemList.LV_Coil.get(2),
                ItemList.Credit_Platinum.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_MV.get(4),
                ItemList.MV_Coil.get(2),
                ItemList.Credit_Platinum.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_HV.get(4),
                ItemList.HV_Coil.get(2),
                ItemList.Credit_Platinum.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_EV.get(4),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_IV.get(4),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_LuV.get(4),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_ZPM.get(4),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UV.get(4),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UHV.get(4),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UEV.get(4),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_DiodeXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UIV.get(4),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_DiodeXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UMV.get(4),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_DiodeXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_UXV.get(4),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_DiodeXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_4A_MAX.get(4),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_DiodeXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_16A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Dynamo Wireless Cover Multi 16A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_LV.get(4),
                ItemList.LV_Coil.get(2),
                ItemList.Credit_Platinum.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_MV.get(4),
                ItemList.MV_Coil.get(2),
                ItemList.Credit_Platinum.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_HV.get(4),
                ItemList.HV_Coil.get(2),
                ItemList.Credit_Platinum.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_EV.get(4),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_IV.get(4),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_LuV.get(4),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_ZPM.get(4),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UV.get(4),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UHV.get(4),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_DiodeASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UEV.get(4),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_DiodeXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UIV.get(4),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_DiodeXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UMV.get(4),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_DiodeXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_UXV.get(4),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_DiodeXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_4A_MAX.get(4),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_DiodeXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.BatteryAlloy, 4))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_16A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Energy Wireless Cover Multi 64A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_LV.get(4),
                ItemList.LV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(4),
                ItemList.Circuit_Parts_Wiring_Elite.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_MV.get(4),
                ItemList.MV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(8),
                ItemList.Circuit_Parts_Wiring_Elite.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_HV.get(4),
                ItemList.HV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(16),
                ItemList.Circuit_Parts_Wiring_Elite.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_EV.get(4),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(4),
                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_IV.get(4),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(8),
                ItemList.Circuit_Parts_CapacitorSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_LuV.get(4),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(16),
                ItemList.Circuit_Parts_CapacitorSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_ZPM.get(4),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(4),
                ItemList.Circuit_Parts_CapacitorASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UV.get(4),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(8),
                ItemList.Circuit_Parts_CapacitorASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UHV.get(4),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(16),
                ItemList.Circuit_Parts_CapacitorASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UEV.get(4),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_TransistorXSMD.get(4),
                ItemList.Circuit_Parts_CapacitorXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UIV.get(4),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_TransistorXSMD.get(8),
                ItemList.Circuit_Parts_CapacitorXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UMV.get(4),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_TransistorXSMD.get(16),
                ItemList.Circuit_Parts_CapacitorXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_UXV.get(4),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_TransistorXSMD.get(32),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Energy_Multi_16A_MAX.get(4),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_TransistorXSMD.get(64),
                ItemList.Circuit_Parts_CapacitorXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Energy_Multi_64A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);

        // Dynamo Wireless Cover Multi 64A
        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_LV.get(4),
                ItemList.LV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(4),
                ItemList.Circuit_Parts_Wiring_Elite.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_LV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_MV.get(4),
                ItemList.MV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(8),
                ItemList.Circuit_Parts_Wiring_Elite.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Copper, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_MV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_HV.get(4),
                ItemList.HV_Coil.get(2),
                ItemList.Circuit_Parts_Wiring_Advanced.get(16),
                ItemList.Circuit_Parts_Wiring_Elite.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_HV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_EV.get(4),
                ItemList.EV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(4),
                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_EV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_IV.get(4),
                ItemList.IV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(8),
                ItemList.Circuit_Parts_CapacitorSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Platinum, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_IV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_LuV.get(4),
                ItemList.LuV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorSMD.get(16),
                ItemList.Circuit_Parts_CapacitorSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NiobiumTitanium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_LuV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_ZPM.get(4),
                ItemList.ZPM_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(4),
                ItemList.Circuit_Parts_CapacitorASMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.VanadiumGallium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_ZPM.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UV.get(4),
                ItemList.UV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(8),
                ItemList.Circuit_Parts_CapacitorASMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NaquadahAlloy, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UHV.get(4),
                ItemList.UHV_Coil.get(2),
                ItemList.Circuit_Parts_TransistorASMD.get(16),
                ItemList.Circuit_Parts_CapacitorASMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.HSSS, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UHV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UEV.get(4),
                ItemList.UHV_Coil.get(4),
                ItemList.Circuit_Parts_TransistorXSMD.get(4),
                ItemList.Circuit_Parts_CapacitorXSMD.get(4),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Draconium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UEV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UIV.get(4),
                ItemList.UHV_Coil.get(8),
                ItemList.Circuit_Parts_TransistorXSMD.get(8),
                ItemList.Circuit_Parts_CapacitorXSMD.get(8),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NetherStar, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UIV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UMV.get(4),
                ItemList.UHV_Coil.get(16),
                ItemList.Circuit_Parts_TransistorXSMD.get(16),
                ItemList.Circuit_Parts_CapacitorXSMD.get(16),
                GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Quantium, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UMV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_UXV.get(4),
                ItemList.UHV_Coil.get(32),
                ItemList.Circuit_Parts_TransistorXSMD.get(32),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Infinity, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_UXV.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_UXV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Cover_Wireless_Dynamo_Multi_16A_MAX.get(4),
                ItemList.UHV_Coil.get(64),
                ItemList.Circuit_Parts_TransistorXSMD.get(64),
                ItemList.Circuit_Parts_CapacitorXSMD.get(64),
                GTOreDictUnificator.get(OrePrefixes.wireGt16, MaterialsUEVplus.SpaceTime, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.BatteryAlloy, 2))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .itemOutputs(NHUItemList.Cover_Wireless_Dynamo_Multi_64A_MAX.get(1))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MAX)
            .noOptimize()
            .addTo(assemblerRecipes);
    }
}
