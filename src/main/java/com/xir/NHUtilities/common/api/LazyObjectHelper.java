package com.xir.NHUtilities.common.api;

import static com.xir.NHUtilities.common.api.UtilHelper.WarpBox.newWarpBox;
import static com.xir.NHUtilities.common.api.enums.VoltageTier.VOLTAGE_TIER_LIST;
import static com.xir.NHUtilities.common.api.interfaces.LazyHatchHelper.allCommonHatch;
import static com.xir.NHUtilities.common.api.interfaces.LazyHatchHelper.allWirelessHatch;
import static com.xir.NHUtilities.utils.CommonUtil.newFluidStack;
import static com.xir.NHUtilities.utils.CommonUtil.newItemStack;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.UtilHelper.BiParamSupplier;
import com.xir.NHUtilities.common.api.UtilHelper.HatchesBoxed;
import com.xir.NHUtilities.common.api.UtilHelper.ParamSupplier;
import com.xir.NHUtilities.common.api.UtilHelper.TriFunction;
import com.xir.NHUtilities.common.api.UtilHelper.WarpBox;
import com.xir.NHUtilities.common.api.enums.HatchAmperes;
import com.xir.NHUtilities.common.api.enums.VoltageTier;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

@SuppressWarnings("unused")
public final class LazyObjectHelper {

    private LazyObjectHelper() {}

    public static final ItemStack NULL_BYPASS_STACK;

    public static final ParamSupplier<Integer, FluidStack> solder_indalloy_140;

    public static final ParamSupplier<Integer, FluidStack> mutated_living_solder;

    public static final ImmutableList<Materials> TieredMaterials;

    public static final ImmutableList<Materials> SuperconductorMaterials;

    public static final ImmutableList<Materials> allMachineHullWireMaterials;

    public static final ParamSupplier<Integer, ImmutableList<ItemStack>> allEmitter;

    public static final ParamSupplier<Integer, ImmutableList<ItemStack>> allSensor;

    public static final ParamSupplier<Integer, ImmutableList<ItemStack>> allCircuit;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Hatch_2A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Wireless_Hatch_2A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Hatch_4A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Wireless_Hatch_4A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Hatch_16A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Wireless_Hatch_16A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Hatch_64A;

    public static final WarpBox<ImmutableList<HatchesBoxed>> Wireless_Hatch_64A;

    public static final ParamSupplier<Integer, ImmutableList<ItemStack>> allMaterialPlateOfMachineHousing;

    public static final BiParamSupplier<Integer, TriFunction<VoltageTier, Materials, Integer, ItemStack>, ImmutableList<ItemStack>> allTieredMaterial;

    public static final BiParamSupplier<Integer, TriFunction<VoltageTier, Materials, Integer, ItemStack>, ImmutableList<ItemStack>> allMaterialWireOfMachineHull;

    static {

        // region Fluid Or Item Stacks
        NULL_BYPASS_STACK = newItemStack(Blocks.air).setStackDisplayName("Used to bypass null checks");

        solder_indalloy_140 = amount -> newFluidStack(FluidRegistry.getFluid("molten.indalloy140"), amount);

        mutated_living_solder = amount -> newFluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), amount);
        // endregion

        // region Materials
        TieredMaterials = ImmutableList.of(
            Materials.ULV,
            Materials.LV,
            Materials.MV,
            Materials.HV,
            Materials.EV,
            Materials.IV,
            Materials.LuV,
            Materials.ZPM,
            Materials.UV,
            Materials.UHV,
            Materials.UEV,
            Materials.UIV,
            Materials.UMV,
            Materials.UXV,
            Materials.MAX);

        SuperconductorMaterials = ImmutableList.of(
            Materials.RedstoneAlloy,
            Materials.Pentacadmiummagnesiumhexaoxid,
            Materials.Titaniumonabariumdecacoppereikosaoxid,
            Materials.Uraniumtriplatinid,
            Materials.Vanadiumtriindinid,
            Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
            Materials.Tetranaquadahdiindiumhexaplatiumosminid,
            Materials.Longasssuperconductornameforuvwire,
            Materials.Longasssuperconductornameforuhvwire,
            Materials.SuperconductorUEVBase,
            Materials.SuperconductorUIVBase,
            Materials.SuperconductorUMVBase,
            MaterialsUEVplus.SpaceTime,
            MaterialsUEVplus.Universium);

        allMachineHullWireMaterials = ImmutableList.of(
            Materials.Lead,
            Materials.Tin,
            Materials.AnyCopper,
            Materials.Gold,
            Materials.Aluminium,
            Materials.Tungsten,
            Materials.VanadiumGallium,
            Materials.Naquadah,
            Materials.NaquadahAlloy,
            Materials.SuperconductorUV,
            Materials.Draconium,
            Materials.NetherStar,
            Materials.Quantium,
            Materials.BlackPlutonium,
            MaterialsUEVplus.SpaceTime);
        // endregion

        allTieredMaterial = (defaultAmount, function) -> IntStream.range(0, TieredMaterials.size())
            .mapToObj(i -> function.apply(VOLTAGE_TIER_LIST.get(i), TieredMaterials.get(i), defaultAmount))
            .filter(v -> v != NULL_BYPASS_STACK)
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        allCircuit = amount -> allTieredMaterial.get(
            amount,
            (tier, material, defaultAmount) -> GTOreDictUnificator.get(OrePrefixes.circuit, material, defaultAmount));

        allEmitter = amount -> ImmutableList.of(
            ItemList.Emitter_LV.get(amount),
            ItemList.Emitter_MV.get(amount),
            ItemList.Emitter_HV.get(amount),
            ItemList.Emitter_EV.get(amount),
            ItemList.Emitter_IV.get(amount),
            ItemList.Emitter_LuV.get(amount),
            ItemList.Emitter_ZPM.get(amount),
            ItemList.Emitter_UV.get(amount),
            ItemList.Emitter_UHV.get(amount),
            ItemList.Emitter_UEV.get(amount),
            ItemList.Emitter_UIV.get(amount),
            ItemList.Emitter_UMV.get(amount),
            ItemList.Emitter_UXV.get(amount),
            ItemList.Emitter_MAX.get(amount));

        allSensor = amount -> ImmutableList.of(
            ItemList.Sensor_LV.get(amount),
            ItemList.Sensor_MV.get(amount),
            ItemList.Sensor_HV.get(amount),
            ItemList.Sensor_EV.get(amount),
            ItemList.Sensor_IV.get(amount),
            ItemList.Sensor_LuV.get(amount),
            ItemList.Sensor_ZPM.get(amount),
            ItemList.Sensor_UV.get(amount),
            ItemList.Sensor_UHV.get(amount),
            ItemList.Sensor_UEV.get(amount),
            ItemList.Sensor_UIV.get(amount),
            ItemList.Sensor_UMV.get(amount),
            ItemList.Sensor_UXV.get(amount),
            ItemList.Sensor_MAX.get(amount));

        allMaterialPlateOfMachineHousing = amount -> ImmutableList.of(
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, amount),
            WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.plate, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.SpaceTime, amount),
            GTOreDictUnificator
                .get(OrePrefixes.plate, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, amount),
            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.MagMatter, amount));

        allMaterialWireOfMachineHull = (defaultAmount, function) -> IntStream
            .range(0, allMachineHullWireMaterials.size())
            .mapToObj(i -> function.apply(VOLTAGE_TIER_LIST.get(i), allMachineHullWireMaterials.get(i), defaultAmount))
            .filter(v -> v != NULL_BYPASS_STACK)
            .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));

        Hatch_2A = newWarpBox(
            () -> allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_2_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Wireless_Hatch_2A = newWarpBox(
            () -> allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_2_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Hatch_4A = newWarpBox(
            () -> allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Wireless_Hatch_4A = newWarpBox(
            () -> allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_4_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Hatch_16A = newWarpBox(
            () -> allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Wireless_Hatch_16A = newWarpBox(
            () -> allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_16_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Hatch_64A = newWarpBox(
            () -> allCommonHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_64_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

        Wireless_Hatch_64A = newWarpBox(
            () -> allWirelessHatch.get()
                .stream()
                .filter(v -> v.hatchAmperes.equals(HatchAmperes.AMP_64_A))
                .sorted(Comparator.comparingInt(v -> v.hatchType.ordinal()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf)));

    }

}
