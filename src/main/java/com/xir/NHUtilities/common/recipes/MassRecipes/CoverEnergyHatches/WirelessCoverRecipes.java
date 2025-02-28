package com.xir.NHUtilities.common.recipes.MassRecipes.CoverEnergyHatches;

import static com.xir.NHUtilities.common.api.LazyObjectHelper.NULL_BYPASS_STACK;
import static com.xir.NHUtilities.utils.CommonUtil.copyAmount;
import static com.xir.NHUtilities.utils.CommonUtil.newFluidStack;
import static com.xir.NHUtilities.utils.CommonUtil.newItemStack;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.function.Function;
import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.LazyObjectHelper;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.api.enums.VoltageTier;
import com.xir.NHUtilities.main.NHUtilities;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class WirelessCoverRecipes {

    public static void loadRecipes() {
        long startTime = System.nanoTime();

        ImmutableList<ItemStack> allSensor = LazyObjectHelper.allSensor.get(1);

        ImmutableList<ItemStack> allEmitter = LazyObjectHelper.allEmitter.get(1);

        ImmutableList<ItemStack> allCircuit = LazyObjectHelper.allTieredMaterial.get(
            2,
            (tier, material, defaultAmount) -> tier.equals(VoltageTier.ULV) ? NULL_BYPASS_STACK
                : GTOreDictUnificator.get(OrePrefixes.circuit, material, defaultAmount));

        ImmutableList<ItemStack> machineHousingPlate = LazyObjectHelper.allMaterialPlateOfMachineHousing.get(1);

        ImmutableList<ItemStack> coverWires = LazyObjectHelper.allMaterialWireOfMachineHull.get(
            1,
            (tier, material, defaultAmount) -> tier.equals(VoltageTier.ULV) ? NULL_BYPASS_STACK
                : GTOreDictUnificator.get(
                    tier.ordinal() > 5 ? OrePrefixes.wireGt04 : OrePrefixes.wireGt02,
                    material,
                    tier.ordinal() > 8 ? tier.equals(VoltageTier.MAX) ? 8 : 4 : 2));

        ImmutableList<ItemStack> coverPhasedPlate = ImmutableList.of(
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4));

        ImmutableList<ItemStack> coverCoverCoils = ImmutableList.of(
            ItemList.LV_Coil.get(2),
            ItemList.MV_Coil.get(2),
            ItemList.HV_Coil.get(2),
            ItemList.EV_Coil.get(2),
            ItemList.IV_Coil.get(2),
            ItemList.LuV_Coil.get(2),
            ItemList.ZPM_Coil.get(2),
            ItemList.UV_Coil.get(2),
            ItemList.UHV_Coil.get(2),
            ItemList.UHV_Coil.get(4),
            ItemList.UHV_Coil.get(8),
            ItemList.UHV_Coil.get(16),
            ItemList.UHV_Coil.get(32),
            ItemList.UHV_Coil.get(64));

        ImmutableList<ItemStack> coverChipPIC = ImmutableList.of(
            ItemList.Circuit_Chip_ULPIC.get(1),
            ItemList.Circuit_Chip_ULPIC.get(2),
            ItemList.Circuit_Chip_LPIC.get(2),
            ItemList.Circuit_Chip_PIC.get(2),
            ItemList.Circuit_Chip_HPIC.get(2),
            ItemList.Circuit_Chip_UHPIC.get(2),
            ItemList.Circuit_Chip_NPIC.get(2),
            ItemList.Circuit_Chip_PPIC.get(2),
            ItemList.Circuit_Chip_QPIC.get(2),
            ItemList.Circuit_Chip_QPIC.get(4),
            ItemList.Circuit_Chip_QPIC.get(4),
            ItemList.Circuit_Chip_QPIC.get(4),
            ItemList.Circuit_Chip_QPIC.get(16),
            ItemList.Circuit_Chip_QPIC.get(32));

        ImmutableList<FluidStack> coverSolder = ImmutableList.of(
            Materials.SolderingAlloy.getMolten(144 * 4),
            Materials.SolderingAlloy.getMolten(144 * 8),
            Materials.SolderingAlloy.getMolten(144 * 16),
            Materials.SolderingAlloy.getMolten(144 * 32),
            Materials.SolderingAlloy.getMolten(144 * 64),
            Materials.SolderingAlloy.getMolten(144 * 128),
            LazyObjectHelper.solder_indalloy_140.get(144 * 4),
            LazyObjectHelper.solder_indalloy_140.get(144 * 8),
            LazyObjectHelper.solder_indalloy_140.get(144 * 16),
            LazyObjectHelper.solder_indalloy_140.get(144 * 32),
            LazyObjectHelper.mutated_living_solder.get(144 * 4),
            LazyObjectHelper.mutated_living_solder.get(144 * 8),
            LazyObjectHelper.mutated_living_solder.get(144 * 16),
            LazyObjectHelper.mutated_living_solder.get(144 * 32));

        // LV -> MAX 2A
        for (int i = 0; i < 14; i++) {
            // energy
            GTValues.RA.stdBuilder()
                .itemInputs(
                    allSensor.get(i),
                    machineHousingPlate.get(i),
                    coverPhasedPlate.get(i),
                    allCircuit.get(i),
                    coverChipPIC.get(i),
                    coverCoverCoils.get(i),
                    coverWires.get(i))
                .fluidInputs(coverSolder.get(i))
                .itemOutputs(
                    NHUItemList.WIRELESS_ENERGY_COVERS_2_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            // dynamo
            GTValues.RA.stdBuilder()
                .itemInputs(
                    allEmitter.get(i),
                    machineHousingPlate.get(i),
                    coverPhasedPlate.get(i),
                    allCircuit.get(i),
                    coverChipPIC.get(i),
                    coverCoverCoils.get(i),
                    coverWires.get(i))
                .fluidInputs(coverSolder.get(i))
                .itemOutputs(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_2_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);
        }

        ImmutableList<ItemStack> coverTransistor = ImmutableList.of(
            ItemList.Circuit_Parts_Transistor.get(32),
            ItemList.Circuit_Parts_Transistor.get(32),
            ItemList.Circuit_Parts_Transistor.get(32),
            ItemList.Circuit_Parts_Transistor.get(32),
            ItemList.Circuit_Parts_Transistor.get(32),
            ItemList.Circuit_Parts_TransistorASMD.get(32),
            ItemList.Circuit_Parts_TransistorASMD.get(32),
            ItemList.Circuit_Parts_TransistorASMD.get(32),
            ItemList.Circuit_Parts_TransistorASMD.get(32),
            ItemList.Circuit_Parts_TransistorASMD.get(32),
            ItemList.Circuit_Parts_TransistorXSMD.get(32),
            ItemList.Circuit_Parts_TransistorXSMD.get(32),
            ItemList.Circuit_Parts_TransistorXSMD.get(32),
            ItemList.Circuit_Parts_TransistorXSMD.get(64));

        ImmutableList<ItemStack> coverCapacitor = ImmutableList.of(
            ItemList.Circuit_Parts_Capacitor.get(32),
            ItemList.Circuit_Parts_Capacitor.get(32),
            ItemList.Circuit_Parts_Capacitor.get(32),
            ItemList.Circuit_Parts_Capacitor.get(32),
            ItemList.Circuit_Parts_Capacitor.get(32),
            ItemList.Circuit_Parts_CapacitorASMD.get(32),
            ItemList.Circuit_Parts_CapacitorASMD.get(32),
            ItemList.Circuit_Parts_CapacitorASMD.get(32),
            ItemList.Circuit_Parts_CapacitorASMD.get(32),
            ItemList.Circuit_Parts_CapacitorASMD.get(32),
            ItemList.Circuit_Parts_CapacitorXSMD.get(32),
            ItemList.Circuit_Parts_CapacitorXSMD.get(32),
            ItemList.Circuit_Parts_CapacitorXSMD.get(32),
            ItemList.Circuit_Parts_CapacitorXSMD.get(64));

        ImmutableList<ItemStack> coverDiode = ImmutableList.of(
            ItemList.Circuit_Parts_Diode.get(32),
            ItemList.Circuit_Parts_Diode.get(32),
            ItemList.Circuit_Parts_Diode.get(32),
            ItemList.Circuit_Parts_Diode.get(32),
            ItemList.Circuit_Parts_Diode.get(32),
            ItemList.Circuit_Parts_DiodeASMD.get(32),
            ItemList.Circuit_Parts_DiodeASMD.get(32),
            ItemList.Circuit_Parts_DiodeASMD.get(32),
            ItemList.Circuit_Parts_DiodeASMD.get(32),
            ItemList.Circuit_Parts_DiodeASMD.get(32),
            ItemList.Circuit_Parts_DiodeXSMD.get(32),
            ItemList.Circuit_Parts_DiodeXSMD.get(32),
            ItemList.Circuit_Parts_DiodeXSMD.get(32),
            ItemList.Circuit_Parts_DiodeXSMD.get(64));

        ImmutableList<ItemStack> coverInductor = ImmutableList.of(
            ItemList.Circuit_Parts_Coil.get(32),
            ItemList.Circuit_Parts_Coil.get(32),
            ItemList.Circuit_Parts_Coil.get(32),
            ItemList.Circuit_Parts_Coil.get(32),
            ItemList.Circuit_Parts_Coil.get(32),
            ItemList.Circuit_Parts_InductorASMD.get(32),
            ItemList.Circuit_Parts_InductorASMD.get(32),
            ItemList.Circuit_Parts_InductorASMD.get(32),
            ItemList.Circuit_Parts_InductorASMD.get(32),
            ItemList.Circuit_Parts_InductorASMD.get(32),
            ItemList.Circuit_Parts_InductorXSMD.get(32),
            ItemList.Circuit_Parts_InductorXSMD.get(32),
            ItemList.Circuit_Parts_InductorXSMD.get(32),
            ItemList.Circuit_Parts_InductorXSMD.get(64));

        Function<ItemStack, ItemStack> itemToDouble = is -> copyAmount(is, is.stackSize * 2);
        Function<FluidStack, FluidStack> fluidToDouble = fs -> newFluidStack(fs, fs.amount * 2);
        Function<ItemStack, ItemStack> itemToQuadruple = is -> copyAmount(is, is.stackSize * 4);
        Function<ItemStack, ItemStack> itemToUltimate = is -> copyAmount(is, is.stackSize * 16);
        Function<FluidStack, FluidStack> fluidToQuadruple = fs -> newFluidStack(fs, fs.amount * 4);

        ImmutableList<FluidStack> coverSuperconductor = LazyObjectHelper.SuperconductorMaterials.stream()
            .map(v -> v.getMolten(144 * 32))
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        // LV -> MAX | 2A ->4A | 4A -> 16A | 16A -> 64A
        for (int i = 0; i < 14; i++) {

            // 2A -> 4A
            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_ENERGY_COVERS_2_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToDouble),
                    newItemStack(coverChipPIC.get(i), itemToDouble),
                    newItemStack(coverCoverCoils.get(i), itemToQuadruple),
                    coverTransistor.get(i))
                .fluidInputs(newFluidStack(coverSolder.get(i), fluidToDouble))
                .itemOutputs(
                    NHUItemList.WIRELESS_ENERGY_COVERS_MULTI_4_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_2_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToDouble),
                    newItemStack(coverChipPIC.get(i), itemToDouble),
                    newItemStack(coverCoverCoils.get(i), itemToQuadruple),
                    coverTransistor.get(i))
                .fluidInputs(newFluidStack(coverSolder.get(i), fluidToDouble))
                .itemOutputs(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_MULTI_4_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            // 4A -> 16A
            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_ENERGY_COVERS_MULTI_4_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToDouble),
                    newItemStack(coverChipPIC.get(i), itemToDouble),
                    newItemStack(coverCoverCoils.get(i), itemToUltimate),
                    coverCapacitor.get(i))
                .fluidInputs(newFluidStack(coverSolder.get(i), fluidToQuadruple))
                .itemOutputs(
                    NHUItemList.WIRELESS_ENERGY_COVERS_MULTI_16_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_MULTI_4_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToDouble),
                    newItemStack(coverChipPIC.get(i), itemToDouble),
                    newItemStack(coverCoverCoils.get(i), itemToUltimate),
                    coverCapacitor.get(i))
                .fluidInputs(newFluidStack(coverSolder.get(i), fluidToQuadruple))
                .itemOutputs(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_MULTI_16_A.get(i)
                        .get(1))
                .duration(10 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            // 16A -> 64A
            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_ENERGY_COVERS_MULTI_16_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToQuadruple),
                    newItemStack(coverChipPIC.get(i), itemToQuadruple),
                    coverDiode.get(i),
                    coverInductor.get(i))
                .fluidInputs(coverSuperconductor.get(i))
                .itemOutputs(
                    NHUItemList.WIRELESS_ENERGY_COVERS_MULTI_64_A.get(i)
                        .get(1))
                .duration(20 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                .itemInputsUnsafe(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_MULTI_16_A.get(i)
                        .get(1),
                    newItemStack(allCircuit.get(i), itemToQuadruple),
                    newItemStack(coverChipPIC.get(i), itemToQuadruple),
                    coverDiode.get(i),
                    coverInductor.get(i))
                .fluidInputs(coverSuperconductor.get(i))
                .itemOutputs(
                    NHUItemList.WIRELESS_DYNAMO_COVERS_MULTI_64_A.get(i)
                        .get(1))
                .duration(20 * SECONDS)
                .eut(GTValues.VP[i])
                .noOptimize()
                .addTo(assemblerRecipes);

        }

        long res = System.nanoTime() - startTime;
        NHUtilities.LOG
            .info("NHU Wireless Cover Recipes is complete, taking {} ns, {} ms. ", res, (double) res / 1_000_000);
    }
}
