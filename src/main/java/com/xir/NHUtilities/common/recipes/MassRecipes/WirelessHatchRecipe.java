package com.xir.NHUtilities.common.recipes.MassRecipes;

import static com.xir.NHUtilities.common.api.LazyObjectHelper.NULL_BYPASS_STACK;
import static com.xir.NHUtilities.common.api.NHURecipeConstants.INGOT;
import static com.xir.NHUtilities.common.api.NHURecipeConstants.ONE_UNIT;
import static com.xir.NHUtilities.utils.CommonUtil.copyAmount;
import static com.xir.NHUtilities.utils.CommonUtil.copyFluidStackArray;
import static com.xir.NHUtilities.utils.CommonUtil.newFluidStack;
import static com.xir.NHUtilities.utils.CommonUtil.newFluidStackArray;
import static com.xir.NHUtilities.utils.CommonUtil.newItemStack;
import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.LazyObjectHelper;
import com.xir.NHUtilities.common.api.UtilHelper.HatchesBoxed;
import com.xir.NHUtilities.common.api.enums.HatchAmperes;
import com.xir.NHUtilities.common.api.enums.HatchType;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.api.enums.VoltageTier;
import com.xir.NHUtilities.common.api.interfaces.LazyHatchHelper;
import com.xir.NHUtilities.main.NHUtilities;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.GTUtility;

@SuppressWarnings("unused")
public class WirelessHatchRecipe {

    public static void loadRecipes() {
        long startTime = System.nanoTime();

        loadCompRecipe();

        GTRecipeBuilder.builder()
            .itemInputsUnsafe(
                ItemList.Energy_Module.get(1),
                copyAmount(GTOreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1), 0))
            .fluidInputs(Materials.BorosilicateGlass.getMolten(32 * 144))
            .itemOutputs(NHUItemList.Chip_EnergyModule.get(3))
            .requiresCleanRoom()
            .duration(100 * SECONDS)
            .eut(TierEU.UHV)
            .noOptimize()
            .addTo(laserEngraverRecipes);

        Predicate<HatchesBoxed> filterEnergy = v -> v.hatchType.equals(HatchType.EnergyHatch);
        Predicate<HatchesBoxed> filterDynamo = v -> v.hatchType.equals(HatchType.DynamoHatch);
        ToIntFunction<HatchesBoxed> sortByVoltageTier = v -> v.voltageTier.ordinal();

        ImmutableList<ItemStack> energy_2A = LazyObjectHelper.Hatch_2A.get()
            .stream()
            .filter(filterEnergy)
            .sorted(Comparator.comparingInt(sortByVoltageTier))
            .map(v -> copyAmount(v.hatchStack, 1))
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        ImmutableList<ItemStack> dynamo_2A = LazyObjectHelper.Hatch_2A.get()
            .stream()
            .filter(filterDynamo)
            .sorted(Comparator.comparingInt(sortByVoltageTier))
            .map(v -> copyAmount(v.hatchStack, 1))
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        ImmutableList<ItemStack> wirelessEnergy_2A = LazyObjectHelper.Wireless_Hatch_2A.get()
            .stream()
            .filter(v -> v.hatchType.equals(HatchType.WirelessEnergyHatch))
            .sorted(Comparator.comparingInt(sortByVoltageTier))
            .map(v -> copyAmount(v.hatchStack, 1))
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        ImmutableList<ItemStack> wirelessDynamo_2A = LazyObjectHelper.Wireless_Hatch_2A.get()
            .stream()
            .filter(v -> v.hatchType.equals(HatchType.WirelessDynamoHatch))
            .sorted(Comparator.comparingInt(sortByVoltageTier))
            .map(v -> copyAmount(v.hatchStack, 1))
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        ImmutableList<ItemStack> sensor = ImmutableList.<ItemStack>builder()
            .add(GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.Lead, 1))
            .addAll(LazyObjectHelper.allSensor.get(1))
            .build();

        ImmutableList<ItemStack> emitter = ImmutableList.<ItemStack>builder()
            .add(GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Lead, 3))
            .addAll(LazyObjectHelper.allEmitter.get(1))
            .build();

        ImmutableList<ItemStack> circuit = LazyObjectHelper.allTieredMaterial
            .get(1, (tier, material, amount) -> GTOreDictUnificator.get(OrePrefixes.circuit, material, amount));

        ImmutableList<ItemStack> coils = ImmutableList.of(
            ItemList.ULV_Coil.get(4),
            ItemList.LV_Coil.get(4),
            ItemList.MV_Coil.get(4),
            ItemList.HV_Coil.get(4),
            ItemList.EV_Coil.get(4),
            ItemList.IV_Coil.get(4),
            ItemList.LuV_Coil.get(4));

        ImmutableList<ItemStack> wires = LazyObjectHelper.allMaterialWireOfMachineHull.get(
            2,
            (tier, material, amount) -> tier.ordinal() >= VoltageTier.ZPM.ordinal() ? NULL_BYPASS_STACK
                : GTOreDictUnificator.get(OrePrefixes.wireGt04, material, amount));

        ImmutableList<ItemStack> chips = ImmutableList.of(
            GTOreDictUnificator.get(OrePrefixes.spring, Materials.Lead, 8),
            GTOreDictUnificator.get(OrePrefixes.spring, Materials.Steel, 8),
            GTOreDictUnificator.get(OrePrefixes.spring, Materials.AnyCopper, 8),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(3),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(6),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(12),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(42),
            ItemList.Energy_LapotronicOrb.get(3),
            ItemList.Energy_LapotronicOrb2.get(1),
            NHUItemList.Chip_EnergyModule.get(1),
            NHUItemList.Chip_EnergyModule.get(4),
            NHUItemList.Chip_EnergyModule.get(32),
            ItemList.Energy_Cluster.get(1),
            ItemList.Energy_Cluster.get(4),
            ItemList.Energy_Cluster.get(8));

        ImmutableList<FluidStack[]> fluids = ImmutableList.of(
            // ulv
            newFluidStackArray(Materials.RedstoneAlloy.getMolten(4 * INGOT)),
            // lv
            newFluidStackArray(Materials.RedstoneAlloy.getMolten(8 * INGOT)),
            // mv
            newFluidStackArray(Materials.Kanthal.getMolten(4 * INGOT)),
            // hv
            newFluidStackArray(Materials.StainlessSteel.getMolten(4 * INGOT)),
            // ev
            newFluidStackArray(Materials.TPV.getMolten(4 * INGOT)),
            // iv
            newFluidStackArray(Materials.HSSG.getMolten(4 * INGOT)),
            // luv
            newFluidStackArray(Materials.Draconium.getMolten(4 * INGOT)),
            // zpm
            newFluidStackArray(
                Materials.HSSE.getMolten(8 * INGOT),
                Materials.Radon.getGas(50 * ONE_UNIT),
                Materials.Polytetrafluoroethylene.getMolten(16 * INGOT),
                Materials.BorosilicateGlass.getMolten(32 * INGOT)),
            // uv
            newFluidStackArray(
                Materials.Quantium.getMolten(8 * INGOT),
                WerkstoffLoader.Xenon.getFluidOrGas(8 * ONE_UNIT),
                Materials.Trinium.getMolten(8 * INGOT),
                Materials.Polytetrafluoroethylene.getMolten(48 * INGOT)),
            // uhv
            newFluidStackArray(
                Materials.Quantium.getMolten(24 * INGOT),
                WerkstoffLoader.Xenon.getFluidOrGas(16 * ONE_UNIT),
                Materials.Osmiridium.getMolten(16 * INGOT),
                Materials.Polytetrafluoroethylene.getMolten(72 * INGOT)),
            // uev
            newFluidStackArray(
                Materials.NaquadahAlloy.getMolten(16 * INGOT),
                WerkstoffLoader.Oganesson.getFluidOrGas(2 * ONE_UNIT),
                Materials.Osmiridium.getMolten(24 * INGOT),
                Materials.Polytetrafluoroethylene.getMolten(144 * INGOT)),
            // uiv
            newFluidStackArray(
                Materials.Infinity.getMolten(8 * INGOT),
                WerkstoffLoader.Oganesson.getFluidOrGas(4 * ONE_UNIT),
                Materials.NaquadahAlloy.getMolten(24 * INGOT),
                LazyObjectHelper.mutated_living_solder.get(4 * ONE_UNIT)),
            // umv
            newFluidStackArray(
                Materials.Infinity.getMolten(16 * INGOT),
                MaterialsUEVplus.SpaceTime.getMolten(8 * INGOT),
                WerkstoffLoader.Oganesson.getFluidOrGas(8 * ONE_UNIT),
                LazyObjectHelper.mutated_living_solder.get(8 * ONE_UNIT)),
            // uxv
            newFluidStackArray(
                MaterialsUEVplus.SpaceTime.getMolten(16 * INGOT),
                MaterialsUEVplus.TranscendentMetal.getMolten(16 * INGOT),
                GGMaterial.metastableOganesson.getMolten(16 * INGOT),
                MaterialsUEVplus.Space.getMolten(32 * ONE_UNIT)),
            // MAX
            newFluidStackArray(
                MaterialsUEVplus.Universium.getMolten(64 * INGOT),
                GGMaterial.metastableOganesson.getMolten(128 * INGOT),
                MaterialsUEVplus.ExcitedDTSC.getFluid(128 * ONE_UNIT),
                MaterialsUEVplus.TranscendentMetal.getMolten(256 * INGOT)));

        var iZPM_Index = 7;
        var MAX_Index = energy_2A.size(); // value = 14
        for (int i = 0; i < iZPM_Index; i++) {
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    energy_2A.get(i),
                    sensor.get(i),
                    circuit.get(i),
                    coils.get(i),
                    wires.get(i),
                    chips.get(i),
                    GTUtility.getIntegratedCircuit(24))
                .fluidInputs(fluids.get(i))
                .itemOutputs(wirelessEnergy_2A.get(i))
                .eut(GTValues.VP[i])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .addTo(assemblerRecipes);

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    dynamo_2A.get(i),
                    emitter.get(i),
                    circuit.get(i),
                    coils.get(i),
                    wires.get(i),
                    chips.get(i),
                    GTUtility.getIntegratedCircuit(24))
                .fluidInputs(fluids.get(i))
                .itemOutputs(wirelessDynamo_2A.get(i))
                .eut(GTValues.VP[i])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .addTo(assemblerRecipes);
        }

        for (int i = iZPM_Index; i < MAX_Index; i++) {
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(energy_2A.get(i), sensor.get(i), circuit.get(i), chips.get(i))
                .fluidInputs(fluids.get(i))
                .itemOutputs(wirelessEnergy_2A.get(i))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(dynamo_2A.get(i), emitter.get(i), circuit.get(i), chips.get(i))
                .fluidInputs(fluids.get(i))
                .itemOutputs(wirelessDynamo_2A.get(i))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);
        }

        ImmutableList<ImmutableList<ItemStack>> energyAll = ImmutableList.of(
            LazyObjectHelper.Hatch_4A.get()
                .stream()
                .filter(filterEnergy)
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyObjectHelper.Hatch_16A.get()
                .stream()
                .filter(filterEnergy)
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyObjectHelper.Hatch_64A.get()
                .stream()
                .filter(filterEnergy)
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        ImmutableList<ImmutableList<ItemStack>> wirelessEnergyAll = ImmutableList.of(
            LazyObjectHelper.Wireless_Hatch_4A.get()
                .stream()
                .filter(v -> v.hatchType.equals(HatchType.WirelessEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyObjectHelper.Wireless_Hatch_16A.get()
                .stream()
                .filter(v -> v.hatchType.equals(HatchType.WirelessEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyObjectHelper.Wireless_Hatch_64A.get()
                .stream()
                .filter(v -> v.hatchType.equals(HatchType.WirelessEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        // 4A -> 64A energy recipes
        iZPM_Index = iZPM_Index - 1;
        MAX_Index = MAX_Index - 1;
        for (int z = 0; z < 3; z++) {

            for (int i = 0; i < iZPM_Index; i++) {
                // energy
                var tier = i + 1;
                GTRecipeBuilder.builder()
                    .itemInputsUnsafe(
                        energyAll.get(z)
                            .get(i),
                        sensor.get(tier),
                        circuit.get(tier),
                        coils.get(tier),
                        wires.get(tier),
                        chips.get(tier),
                        GTUtility.getIntegratedCircuit(24))
                    .fluidInputs(fluids.get(tier))
                    .itemOutputs(
                        wirelessEnergyAll.get(z)
                            .get(i))
                    .eut(GTValues.VP[tier])
                    .duration(10 * SECONDS * (tier + 1))
                    .noOptimize()
                    .addTo(assemblerRecipes);
            }

            for (int i = iZPM_Index; i < MAX_Index; i++) {
                // energy
                var tier = i + 1;
                GTRecipeBuilder.builder()
                    .itemInputsUnsafe(
                        energyAll.get(z)
                            .get(i),
                        sensor.get(tier),
                        circuit.get(tier),
                        chips.get(tier))
                    .fluidInputs(fluids.get(tier))
                    .itemOutputs(
                        wirelessEnergyAll.get(z)
                            .get(i))
                    .eut(GTValues.VP[tier - 1])
                    .duration(10 * SECONDS * (tier + 1))
                    .noOptimize()
                    .metadata(PRECISE_ASSEMBLER_CASING_TIER, tier < 12 ? tier < 9 ? 1 : 2 : 3)
                    .addTo(preciseAssemblerRecipes);
            }

        }

        // Laser hatch...........
        var energyIndex = 0;
        var wirelessEnergyIndex = 1;
        var dynamoIndex = 2;
        var wirelessDynamoIndex = 3;
        var dynamoForUIVBypassIndex = 12;

        Predicate<HatchesBoxed> MAX_TIER_BYPASS = v -> !v.voltageTier.equals(VoltageTier.MAX);

        Function<ItemStack, ItemStack> itemToDouble = is -> copyAmount(is, is.stackSize * 2);
        Function<FluidStack, FluidStack> fluidToDouble = fs -> newFluidStack(fs, fs.amount * 2);
        Function<ItemStack, ItemStack> itemToQuadruple = is -> copyAmount(is, is.stackSize * 4);
        Function<ItemStack, ItemStack> itemToUltimate = is -> copyAmount(is, is.stackSize * 16);
        Function<FluidStack, FluidStack> fluidToQuadruple = fs -> newFluidStack(fs, fs.amount * 4);

        ImmutableList<ItemStack> higherMaterialWires = ImmutableList.<ItemStack>builder()
            .add(GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedstoneAlloy, 4))
            .addAll(
                (Iterable<? extends ItemStack>) LazyObjectHelper.SuperconductorMaterials.stream()
                    .map(
                        material -> material.equals(MaterialsUEVplus.Universium)
                            ? GTOreDictUnificator.get(OrePrefixes.wireGt04, MaterialsUEVplus.SpaceTime, 32)
                            : GTOreDictUnificator.get(OrePrefixes.wireGt02, material, 4))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)))
            .build();

        // 4A -> 64A dynamo hatch
        // started with IV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_4A_64A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.DynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.DynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_64_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.DynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_64_A))
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var startIndexIVc = 5;
        var commonIndex = 0;
        var wirelessIndex = 1;
        for (int z = 0; z < 3; z++) {
            for (int i = startIndexIVc; i < dynamoForUIVBypassIndex; i++) {
                var realIndex = i - startIndexIVc;

                GTRecipeBuilder builder = GTRecipeBuilder.builder()
                    .itemInputsUnsafe(
                        emitter.get(i),
                        hatch_4A_64A.get(commonIndex)
                            .get(realIndex),
                        copyAmount(higherMaterialWires.get(i), z + 1),
                        chips.get(i))
                    .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                    .itemOutputs(
                        hatch_4A_64A.get(wirelessIndex)
                            .get(realIndex))
                    .eut(GTValues.VP[i - 1])
                    .duration(10 * SECONDS * (i + 1))
                    .noOptimize();

                if (i >= 7) {
                    builder.metadata(PRECISE_ASSEMBLER_CASING_TIER, z + 1)
                        .addTo(preciseAssemblerRecipes);
                } else {
                    builder.addTo(assemblerRecipes);
                }

            }
            commonIndex += 2;
            wirelessIndex += 2;
        }

        // 256A hatch
        // started with IV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_256A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_256_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_256_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_256_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_256_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.IV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var IV_Index = 5;
        for (int i = IV_Index; i < MAX_Index; i++) {
            var realIndex = i - IV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToDouble),
                    hatch_256A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_256A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToDouble),
                    hatch_256A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_256A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 1)
                .addTo(preciseAssemblerRecipes);
        }

        // 1024A hatch
        // started with LuV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_1024A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_024_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.LuV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_024_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.LuV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_024_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.LuV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_024_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.LuV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var LuV_Index = 6;
        for (int i = LuV_Index; i < MAX_Index; i++) {
            var realIndex = i - LuV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToDouble),
                    hatch_1024A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_1024A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToDouble),
                    hatch_1024A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_1024A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 2)
                .addTo(preciseAssemblerRecipes);
        }

        // 4096A hatch
        // started with ZPM-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_4096A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_096_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_096_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_096_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_096_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var ZPM_Index = 7;
        for (int i = ZPM_Index; i < MAX_Index; i++) {
            var realIndex = i - ZPM_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToDouble),
                    hatch_4096A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_4096A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToDouble),
                    hatch_4096A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 4),
                    newItemStack(chips.get(i), itemToDouble))
                .fluidInputs(copyFluidStackArray(2, fluids.get(i)))
                .itemOutputs(
                    hatch_4096A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 2)
                .addTo(preciseAssemblerRecipes);
        }

        // 16384A hatch
        // started with UV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_16384A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_384_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_384_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_384_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_384_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UV_Index = 8;
        for (int i = UV_Index; i < MAX_Index; i++) {
            var realIndex = i - UV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToQuadruple),
                    hatch_16384A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_16384A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? i < 9 ? 1 : 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToQuadruple),
                    hatch_16384A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_16384A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 2)
                .addTo(preciseAssemblerRecipes);
        }

        // 65536A hatch
        // started with UHV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_65536A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_65_536_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UHV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_65_536_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UHV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_65_536_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UHV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_65_536_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UHV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UHV_Index = 9;
        for (int i = UHV_Index; i < MAX_Index; i++) {
            var realIndex = i - UHV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToQuadruple),
                    hatch_65536A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_65536A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToQuadruple),
                    hatch_65536A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_65536A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                .addTo(preciseAssemblerRecipes);
        }

        // 262144A hatch
        // started with UEV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_262144A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_262_144_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UEV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_262_144_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UEV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_262_144_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UEV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_262_144_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UEV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UEV_Index = 10;
        for (int i = UEV_Index; i < MAX_Index; i++) {
            var realIndex = i - UEV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToQuadruple),
                    hatch_262144A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_262144A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToQuadruple),
                    hatch_262144A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_262144A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                .addTo(preciseAssemblerRecipes);
        }

        // 1048576A hatch
        // started with UIV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_1048576A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_048_576_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UIV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_048_576_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UIV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_048_576_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UIV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_1_048_576_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UIV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserDynamoHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UIV_Index = 11;
        for (int i = UIV_Index; i < MAX_Index; i++) {
            var realIndex = i - UIV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToQuadruple),
                    hatch_1048576A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_1048576A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, i < 12 ? 2 : 3)
                .addTo(preciseAssemblerRecipes);

            if (i >= dynamoForUIVBypassIndex) continue;

            // dynamo
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(emitter.get(i), itemToQuadruple),
                    hatch_1048576A.get(dynamoIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 8),
                    newItemStack(chips.get(i), itemToQuadruple))
                .fluidInputs(copyFluidStackArray(4, fluids.get(i)))
                .itemOutputs(
                    hatch_1048576A.get(wirelessDynamoIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                .addTo(preciseAssemblerRecipes);
        }

        // 4194304A hatch
        // started with UMV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_4194304A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_194_304_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UMV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_194_304_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UMV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UMV_Index = 12;
        for (int i = UMV_Index; i < MAX_Index; i++) {
            var realIndex = i - UMV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToUltimate),
                    hatch_4194304A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 16),
                    newItemStack(chips.get(i), itemToUltimate))
                .fluidInputs(copyFluidStackArray(8, fluids.get(i)))
                .itemOutputs(
                    hatch_4194304A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                .addTo(preciseAssemblerRecipes);
        }

        // 16777216A hatch
        // started with UXV-tier
        ImmutableList<ImmutableList<ItemStack>> hatch_16777216A = ImmutableList.of(
            LazyHatchHelper.allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_777_216_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UXV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
            LazyHatchHelper.allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_777_216_A))
                .filter(MAX_TIER_BYPASS)
                .filter(v -> v.voltageTier.ordinal() >= VoltageTier.UXV.ordinal())
                .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
                .sorted(Comparator.comparingInt(sortByVoltageTier))
                .map(v -> copyAmount(v.hatchStack, 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        var UXV_Index = 13;
        for (int i = UXV_Index; i < MAX_Index; i++) {
            var realIndex = i - UXV_Index;
            // energy
            GTRecipeBuilder.builder()
                .itemInputsUnsafe(
                    newItemStack(sensor.get(i), itemToUltimate),
                    hatch_16777216A.get(energyIndex)
                        .get(realIndex),
                    copyAmount(higherMaterialWires.get(i), 16),
                    newItemStack(chips.get(i), itemToUltimate))
                .fluidInputs(copyFluidStackArray(8, fluids.get(i)))
                .itemOutputs(
                    hatch_16777216A.get(wirelessEnergyIndex)
                        .get(realIndex))
                .eut(GTValues.VP[i - 1])
                .duration(10 * SECONDS * (i + 1))
                .noOptimize()
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 4)
                .addTo(preciseAssemblerRecipes);
        }

        // / // 67108864A hatch
        // / // started with MAX-tier
        // / ImmutableList<ImmutableList<ItemStack>> hatch_67108864A = ImmutableList.of(
        // / LazyHatchHelper.allCommonHatch.get()
        // / .stream()
        // / .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_67_108_864_A))
        // / .filter(MAX_TIER_BYPASS)
        // / .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
        // / .filter(v -> v.hatchType.equals(HatchType.LaserEnergyHatch))
        // / .sorted(Comparator.comparingInt(sortByVoltageTier))
        // / .map(v -> copyAmount(v.hatchStack, 1))
        // / .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)),
        // / LazyHatchHelper.allWirelessHatch.get()
        // / .stream()
        // / .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_67_108_864_A))
        // / .filter(MAX_TIER_BYPASS)
        // / .filter(v -> v.voltageTier.ordinal() >= VoltageTier.ZPM.ordinal())
        // / .filter(v -> v.hatchType.equals(HatchType.WirelessLaserEnergyHatch))
        // / .sorted(Comparator.comparingInt(sortByVoltageTier))
        // / .map(v -> copyAmount(v.hatchStack, 1))
        // / .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));
        // /
        // / var nMAX_Index = 14;
        // / for (int i = nMAX_Index; i < MAX_Index; i++) {
        // / var realIndex = i - nMAX_Index;
        // / // energy
        // / GTRecipeBuilder.builder()
        // / .itemInputsUnsafe(
        // / newItemStack(sensor.get(i), itemToUltimate),
        // / hatch_67108864A.get(energyIndex)
        // / .get(realIndex),
        // / copyAmount(higherMaterialWires.get(i), 16),
        // / newItemStack(chips.get(i), itemToUltimate))
        // / .fluidInputs(copyFluidStackArray(8, fluids.get(i)))
        // / .itemOutputs(
        // / hatch_67108864A.get(wirelessEnergyIndex)
        // / .get(realIndex))
        // / .eut(GTValues.VP[i - 1])
        // / .duration(10 * SECONDS * (i + 1))
        // / .noOptimize()
        // / .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
        // / .addTo(preciseAssemblerRecipes);
        // / }

        long res = System.nanoTime() - startTime;
        NHUtilities.LOG
            .info("NHU Wireless Hatch Recipes is complete, taking {} ns, {} ms. ", res, (double) res / 1_000_000);
    }

    private static void loadCompRecipe() {

        // Energy Hatch LV 4A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Hatch_Energy_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti4_LV.get(1))
            .fluidInputs(Materials.Silver.getMolten(144))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(assemblerRecipes);

        // Energy Hatch LV 16A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Transformer_MV_LV.get(1),
                NHUItemList.Hatch_EnergyMulti4_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti16_LV.get(1))
            .fluidInputs(Materials.Electrum.getMolten(144))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);

        // Energy Hatch LV 64A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.WetTransformer_MV_LV.get(1),
                NHUItemList.Hatch_EnergyMulti16_LV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.Tin, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti64_LV.get(1))
            .fluidInputs(Materials.Tungsten.getMolten(144))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(assemblerRecipes);

        // Energy Hatch MV 4A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Hatch_Energy_MV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnyCopper, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti4_MV.get(1))
            .fluidInputs(Materials.Silver.getMolten(144))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(assemblerRecipes);

        // Energy Hatch MV 16A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Transformer_HV_MV.get(1),
                NHUItemList.Hatch_EnergyMulti4_MV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.AnyCopper, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti16_MV.get(1))
            .fluidInputs(Materials.Electrum.getMolten(144))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(assemblerRecipes);

        // Energy Hatch MV 64A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.WetTransformer_HV_MV.get(1),
                NHUItemList.Hatch_EnergyMulti16_MV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.AnyCopper, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 6))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti64_MV.get(1))
            .fluidInputs(Materials.Tungsten.getMolten(144))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(assemblerRecipes);

        // Energy Hatch HV 4A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Hatch_Energy_HV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti4_HV.get(1))
            .fluidInputs(Materials.Silver.getMolten(144))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(assemblerRecipes);

        // Energy Hatch HV 16A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.Transformer_EV_HV.get(1),
                NHUItemList.Hatch_EnergyMulti4_HV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti16_HV.get(1))
            .fluidInputs(Materials.Electrum.getMolten(144))
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(assemblerRecipes);

        // Energy Hatch HV 64A
        GTRecipeBuilder.builder()
            .itemInputs(
                ItemList.WetTransformer_EV_HV.get(1),
                NHUItemList.Hatch_EnergyMulti16_HV.get(1),
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.Gold, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6))
            .itemOutputs(NHUItemList.Hatch_EnergyMulti64_HV.get(1))
            .fluidInputs(Materials.Tungsten.getMolten(144))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(assemblerRecipes);

    }

}
