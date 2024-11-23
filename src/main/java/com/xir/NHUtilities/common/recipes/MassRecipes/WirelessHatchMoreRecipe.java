package com.xir.NHUtilities.common.recipes.MassRecipes;

import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.xir.NHUtilities.common.api.enums.WirelessHatchMore;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import tectech.thing.CustomItemList;
import tectech.thing.item.ItemTeslaCoilCapacitor;

@SuppressWarnings("unused")
public class WirelessHatchMoreRecipe {

    public static void initWirelessHatchMore() {

        // region Energy

        // energy 2A
        ItemStack[] energyHatches_2A = { ItemList.Hatch_Energy_ULV.get(1), ItemList.Hatch_Energy_LV.get(1),
            ItemList.Hatch_Energy_MV.get(1), ItemList.Hatch_Energy_HV.get(1), ItemList.Hatch_Energy_EV.get(1),
            ItemList.Hatch_Energy_IV.get(1), ItemList.Hatch_Energy_LuV.get(1), ItemList.Hatch_Energy_ZPM.get(1),
            ItemList.Hatch_Energy_UV.get(1), ItemList.Hatch_Energy_UHV.get(1), ItemList.Hatch_Energy_UEV.get(1),
            ItemList.Hatch_Energy_UIV.get(1), ItemList.Hatch_Energy_UMV.get(1), ItemList.Hatch_Energy_UXV.get(1) };

        ItemStack[] wirelessEnergyHatches_2A = { ItemList.Wireless_Hatch_Energy_ULV.get(1),
            ItemList.Wireless_Hatch_Energy_LV.get(1), ItemList.Wireless_Hatch_Energy_MV.get(1),
            ItemList.Wireless_Hatch_Energy_HV.get(1), ItemList.Wireless_Hatch_Energy_EV.get(1),
            ItemList.Wireless_Hatch_Energy_IV.get(1), ItemList.Wireless_Hatch_Energy_LuV.get(1),
            ItemList.Wireless_Hatch_Energy_ZPM.get(1), ItemList.Wireless_Hatch_Energy_UV.get(1),
            ItemList.Wireless_Hatch_Energy_UHV.get(1), ItemList.Wireless_Hatch_Energy_UEV.get(1),
            ItemList.Wireless_Hatch_Energy_UIV.get(1), ItemList.Wireless_Hatch_Energy_UMV.get(1),
            ItemList.Wireless_Hatch_Energy_UXV.get(1) };

        // energy 4A
        ItemStack[] energyHatches_4A = { CustomItemList.eM_energyMulti4_EV.get(1),
            CustomItemList.eM_energyMulti4_IV.get(1), CustomItemList.eM_energyMulti4_LuV.get(1),
            CustomItemList.eM_energyMulti4_ZPM.get(1), CustomItemList.eM_energyMulti4_UV.get(1),
            CustomItemList.eM_energyMulti4_UHV.get(1), CustomItemList.eM_energyMulti4_UEV.get(1),
            CustomItemList.eM_energyMulti4_UIV.get(1), CustomItemList.eM_energyMulti4_UMV.get(1),
            CustomItemList.eM_energyMulti4_UXV.get(1) };

        ItemStack[] wirelessEnergyHatches_4A = { CustomItemList.eM_energyWirelessMulti4_EV.get(1),
            CustomItemList.eM_energyWirelessMulti4_IV.get(1), CustomItemList.eM_energyWirelessMulti4_LuV.get(1),
            CustomItemList.eM_energyWirelessMulti4_ZPM.get(1), CustomItemList.eM_energyWirelessMulti4_UV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UHV.get(1), CustomItemList.eM_energyWirelessMulti4_UEV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UIV.get(1), CustomItemList.eM_energyWirelessMulti4_UMV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UXV.get(1) };

        // energy 16A
        ItemStack[] energyHatches_16A = { CustomItemList.eM_energyMulti16_EV.get(1),
            CustomItemList.eM_energyMulti16_IV.get(1), CustomItemList.eM_energyMulti16_LuV.get(1),
            CustomItemList.eM_energyMulti16_ZPM.get(1), CustomItemList.eM_energyMulti16_UV.get(1),
            CustomItemList.eM_energyMulti16_UHV.get(1), CustomItemList.eM_energyMulti16_UEV.get(1),
            CustomItemList.eM_energyMulti16_UIV.get(1), CustomItemList.eM_energyMulti16_UMV.get(1),
            CustomItemList.eM_energyMulti16_UXV.get(1) };

        ItemStack[] wirelessEnergyHatches_16A = { CustomItemList.eM_energyWirelessMulti16_EV.get(1),
            CustomItemList.eM_energyWirelessMulti16_IV.get(1), CustomItemList.eM_energyWirelessMulti16_LuV.get(1),
            CustomItemList.eM_energyWirelessMulti16_ZPM.get(1), CustomItemList.eM_energyWirelessMulti16_UV.get(1),
            CustomItemList.eM_energyWirelessMulti16_UHV.get(1), CustomItemList.eM_energyWirelessMulti16_UEV.get(1),
            CustomItemList.eM_energyWirelessMulti16_UIV.get(1), CustomItemList.eM_energyWirelessMulti16_UMV.get(1),
            CustomItemList.eM_energyWirelessMulti16_UXV.get(1) };

        // energy 64A
        ItemStack[] energyHatches_64A = { CustomItemList.eM_energyMulti64_EV.get(1),
            CustomItemList.eM_energyMulti64_IV.get(1), CustomItemList.eM_energyMulti64_LuV.get(1),
            CustomItemList.eM_energyMulti64_ZPM.get(1), CustomItemList.eM_energyMulti64_UV.get(1),
            CustomItemList.eM_energyMulti64_UHV.get(1), CustomItemList.eM_energyMulti64_UEV.get(1),
            CustomItemList.eM_energyMulti64_UIV.get(1), CustomItemList.eM_energyMulti64_UMV.get(1),
            CustomItemList.eM_energyMulti64_UXV.get(1) };

        ItemStack[] wirelessEnergyHatches_64A = { CustomItemList.eM_energyWirelessMulti64_EV.get(1),
            CustomItemList.eM_energyWirelessMulti64_IV.get(1), CustomItemList.eM_energyWirelessMulti64_LuV.get(1),
            CustomItemList.eM_energyWirelessMulti64_ZPM.get(1), CustomItemList.eM_energyWirelessMulti64_UV.get(1),
            CustomItemList.eM_energyWirelessMulti64_UHV.get(1), CustomItemList.eM_energyWirelessMulti64_UEV.get(1),
            CustomItemList.eM_energyWirelessMulti64_UIV.get(1), CustomItemList.eM_energyWirelessMulti64_UMV.get(1),
            CustomItemList.eM_energyWirelessMulti64_UXV.get(1) };

        // energy 256A
        ItemStack[] energyHatches_256A = { CustomItemList.eM_energyTunnel1_IV.get(1),
            CustomItemList.eM_energyTunnel1_LuV.get(1), CustomItemList.eM_energyTunnel1_ZPM.get(1),
            CustomItemList.eM_energyTunnel1_UV.get(1), CustomItemList.eM_energyTunnel1_UHV.get(1),
            CustomItemList.eM_energyTunnel1_UEV.get(1), CustomItemList.eM_energyTunnel1_UIV.get(1),
            CustomItemList.eM_energyTunnel1_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_256A = { WirelessHatchMore.energyMulti_IV_256.get(1),
            WirelessHatchMore.energyMulti_LuV_256.get(1), WirelessHatchMore.energyMulti_ZPM_256.get(1),
            WirelessHatchMore.energyMulti_UV_256.get(1), WirelessHatchMore.energyMulti_UHV_256.get(1),
            WirelessHatchMore.energyMulti_UEV_256.get(1), WirelessHatchMore.energyMulti_UIV_256.get(1),
            WirelessHatchMore.energyMulti_UMV_256.get(1) };

        // energy 1024A
        ItemStack[] energyHatches_1024A = { CustomItemList.eM_energyTunnel2_LuV.get(1),
            CustomItemList.eM_energyTunnel2_ZPM.get(1), CustomItemList.eM_energyTunnel2_UV.get(1),
            CustomItemList.eM_energyTunnel2_UHV.get(1), CustomItemList.eM_energyTunnel2_UEV.get(1),
            CustomItemList.eM_energyTunnel2_UIV.get(1), CustomItemList.eM_energyTunnel2_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_1024A = { WirelessHatchMore.energyMulti_LuV_1024.get(1),
            WirelessHatchMore.energyMulti_ZPM_1024.get(1), WirelessHatchMore.energyMulti_UV_1024.get(1),
            WirelessHatchMore.energyMulti_UHV_1024.get(1), WirelessHatchMore.energyMulti_UEV_1024.get(1),
            WirelessHatchMore.energyMulti_UIV_1024.get(1), WirelessHatchMore.energyMulti_UMV_1024.get(1) };

        // energy 4096A
        ItemStack[] energyHatches_4096A = { CustomItemList.eM_energyTunnel3_ZPM.get(1),
            CustomItemList.eM_energyTunnel3_UV.get(1), CustomItemList.eM_energyTunnel3_UHV.get(1),
            CustomItemList.eM_energyTunnel3_UEV.get(1), CustomItemList.eM_energyTunnel3_UIV.get(1),
            CustomItemList.eM_energyTunnel3_UMV.get(1), };

        ItemStack[] wirelessEnergyHatches_4096A = { WirelessHatchMore.energyMulti_ZPM_4096.get(1),
            WirelessHatchMore.energyMulti_UV_4096.get(1), WirelessHatchMore.energyMulti_UHV_4096.get(1),
            WirelessHatchMore.energyMulti_UEV_4096.get(1), WirelessHatchMore.energyMulti_UIV_4096.get(1),
            WirelessHatchMore.energyMulti_UMV_4096.get(1) };

        // energy 16384A
        ItemStack[] energyHatches_16384A = { CustomItemList.eM_energyTunnel4_UV.get(1),
            CustomItemList.eM_energyTunnel4_UHV.get(1), CustomItemList.eM_energyTunnel4_UEV.get(1),
            CustomItemList.eM_energyTunnel4_UIV.get(1), CustomItemList.eM_energyTunnel4_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_16384A = { WirelessHatchMore.energyMulti_UV_16384.get(1),
            WirelessHatchMore.energyMulti_UHV_16384.get(1), WirelessHatchMore.energyMulti_UEV_16384.get(1),
            WirelessHatchMore.energyMulti_UIV_16384.get(1), WirelessHatchMore.energyMulti_UMV_16384.get(1) };

        // energy 65536A
        ItemStack[] energyHatches_65536A = { CustomItemList.eM_energyTunnel5_UHV.get(1),
            CustomItemList.eM_energyTunnel5_UEV.get(1), CustomItemList.eM_energyTunnel5_UIV.get(1),
            CustomItemList.eM_energyTunnel5_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_65536A = { WirelessHatchMore.energyMulti_UHV_65536.get(1),
            WirelessHatchMore.energyMulti_UEV_65536.get(1), WirelessHatchMore.energyMulti_UIV_65536.get(1),
            WirelessHatchMore.energyMulti_UMV_65536.get(1) };

        // energy 262144A
        ItemStack[] energyHatches_262144A = { CustomItemList.eM_energyTunnel6_UEV.get(1),
            CustomItemList.eM_energyTunnel6_UIV.get(1), CustomItemList.eM_energyTunnel6_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_262144A = { WirelessHatchMore.energyMulti_UEV_262144.get(1),
            WirelessHatchMore.energyMulti_UIV_262144.get(1), WirelessHatchMore.energyMulti_UMV_262144.get(1) };

        // energy 1048576A
        ItemStack[] energyHatches_1048576A = { CustomItemList.eM_energyTunnel7_UIV.get(1),
            CustomItemList.eM_energyTunnel7_UMV.get(1) };

        ItemStack[] wirelessEnergyHatches_1048576A = { WirelessHatchMore.energyMulti_UIV_1048576.get(1),
            WirelessHatchMore.energyMulti_UMV_1048576.get(1) };

        // endregion

        // region Dynamo

        // dynamo 2A
        ItemStack[] dynamoHatches_2A = { ItemList.Hatch_Dynamo_ULV.get(1), ItemList.Hatch_Dynamo_LV.get(1),
            ItemList.Hatch_Dynamo_MV.get(1), ItemList.Hatch_Dynamo_HV.get(1), ItemList.Hatch_Dynamo_EV.get(1),
            ItemList.Hatch_Dynamo_IV.get(1), ItemList.Hatch_Dynamo_LuV.get(1), ItemList.Hatch_Dynamo_ZPM.get(1),
            ItemList.Hatch_Dynamo_UV.get(1), ItemList.Hatch_Dynamo_UHV.get(1), ItemList.Hatch_Dynamo_UEV.get(1),
            ItemList.Hatch_Dynamo_UIV.get(1), ItemList.Hatch_Dynamo_UMV.get(1), ItemList.Hatch_Dynamo_UXV.get(1) };

        ItemStack[] wirelessDynamoHatches_2A = { ItemList.Wireless_Dynamo_Energy_ULV.get(1),
            ItemList.Wireless_Dynamo_Energy_LV.get(1), ItemList.Wireless_Dynamo_Energy_MV.get(1),
            ItemList.Wireless_Dynamo_Energy_HV.get(1), ItemList.Wireless_Dynamo_Energy_EV.get(1),
            ItemList.Wireless_Dynamo_Energy_IV.get(1), ItemList.Wireless_Dynamo_Energy_LuV.get(1),
            ItemList.Wireless_Dynamo_Energy_ZPM.get(1), ItemList.Wireless_Dynamo_Energy_UV.get(1),
            ItemList.Wireless_Dynamo_Energy_UHV.get(1), ItemList.Wireless_Dynamo_Energy_UEV.get(1),
            ItemList.Wireless_Dynamo_Energy_UIV.get(1), ItemList.Wireless_Dynamo_Energy_UMV.get(1),
            ItemList.Wireless_Dynamo_Energy_UXV.get(1) };

        // dynamo 4A
        ItemStack[] dynamoHatches_4A = { CustomItemList.eM_dynamoMulti4_IV.get(1),
            CustomItemList.eM_dynamoMulti4_LuV.get(1), CustomItemList.eM_dynamoMulti4_ZPM.get(1),
            CustomItemList.eM_dynamoMulti4_UV.get(1), CustomItemList.eM_dynamoMulti4_UHV.get(1),
            CustomItemList.eM_dynamoMulti4_UEV.get(1), CustomItemList.eM_dynamoMulti4_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_4A = { WirelessHatchMore.dynamoMulti_IV_4.get(1),
            WirelessHatchMore.dynamoMulti_LuV_4.get(1), WirelessHatchMore.dynamoMulti_ZPM_4.get(1),
            WirelessHatchMore.dynamoMulti_UV_4.get(1), WirelessHatchMore.dynamoMulti_UHV_4.get(1),
            WirelessHatchMore.dynamoMulti_UEV_4.get(1), WirelessHatchMore.dynamoMulti_UIV_4.get(1) };

        // dynamo 16A
        ItemStack[] dynamoHatches_16A = { CustomItemList.eM_dynamoMulti16_IV.get(1),
            CustomItemList.eM_dynamoMulti16_LuV.get(1), CustomItemList.eM_dynamoMulti16_ZPM.get(1),
            CustomItemList.eM_dynamoMulti16_UV.get(1), CustomItemList.eM_dynamoMulti16_UHV.get(1),
            CustomItemList.eM_dynamoMulti16_UEV.get(1), CustomItemList.eM_dynamoMulti16_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_16A = { WirelessHatchMore.dynamoMulti_IV_16.get(1),
            WirelessHatchMore.dynamoMulti_LuV_16.get(1), WirelessHatchMore.dynamoMulti_ZPM_16.get(1),
            WirelessHatchMore.dynamoMulti_UV_16.get(1), WirelessHatchMore.dynamoMulti_UHV_16.get(1),
            WirelessHatchMore.dynamoMulti_UEV_16.get(1), WirelessHatchMore.dynamoMulti_UIV_16.get(1) };

        // dynamo 64A
        ItemStack[] dynamoHatches_64A = { CustomItemList.eM_dynamoMulti64_IV.get(1),
            CustomItemList.eM_dynamoMulti64_LuV.get(1), CustomItemList.eM_dynamoMulti64_ZPM.get(1),
            CustomItemList.eM_dynamoMulti64_UV.get(1), CustomItemList.eM_dynamoMulti64_UHV.get(1),
            CustomItemList.eM_dynamoMulti64_UEV.get(1), CustomItemList.eM_dynamoMulti64_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_64A = { WirelessHatchMore.dynamoMulti_IV_64.get(1),
            WirelessHatchMore.dynamoMulti_LuV_64.get(1), WirelessHatchMore.dynamoMulti_ZPM_64.get(1),
            WirelessHatchMore.dynamoMulti_UV_64.get(1), WirelessHatchMore.dynamoMulti_UHV_64.get(1),
            WirelessHatchMore.dynamoMulti_UEV_64.get(1), WirelessHatchMore.dynamoMulti_UIV_64.get(1) };

        // dynamo 256A
        ItemStack[] dynamoHatches_256A = { CustomItemList.eM_dynamoTunnel1_IV.get(1),
            CustomItemList.eM_dynamoTunnel1_LuV.get(1), CustomItemList.eM_dynamoTunnel1_ZPM.get(1),
            CustomItemList.eM_dynamoTunnel1_UV.get(1), CustomItemList.eM_dynamoTunnel1_UHV.get(1),
            CustomItemList.eM_dynamoTunnel1_UEV.get(1), CustomItemList.eM_dynamoTunnel1_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_256A = { WirelessHatchMore.dynamoMulti_IV_256.get(1),
            WirelessHatchMore.dynamoMulti_LuV_256.get(1), WirelessHatchMore.dynamoMulti_ZPM_256.get(1),
            WirelessHatchMore.dynamoMulti_UV_256.get(1), WirelessHatchMore.dynamoMulti_UHV_256.get(2),
            WirelessHatchMore.dynamoMulti_UEV_256.get(1), WirelessHatchMore.dynamoMulti_UIV_256.get(1) };

        // dynamo 1024A
        ItemStack[] dynamoHatches_1024A = { CustomItemList.eM_dynamoTunnel2_LuV.get(1),
            CustomItemList.eM_dynamoTunnel2_ZPM.get(1), CustomItemList.eM_dynamoTunnel2_UV.get(1),
            CustomItemList.eM_dynamoTunnel2_UHV.get(1), CustomItemList.eM_dynamoTunnel2_UEV.get(1),
            CustomItemList.eM_dynamoTunnel2_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_1024A = { WirelessHatchMore.dynamoMulti_LuV_1024.get(1),
            WirelessHatchMore.dynamoMulti_ZPM_1024.get(1), WirelessHatchMore.dynamoMulti_UV_1024.get(1),
            WirelessHatchMore.dynamoMulti_UHV_1024.get(1), WirelessHatchMore.dynamoMulti_UEV_1024.get(1),
            WirelessHatchMore.dynamoMulti_UIV_1024.get(1) };

        // dynamo 4096A
        ItemStack[] dynamoHatches_4096A = { CustomItemList.eM_dynamoTunnel3_ZPM.get(1),
            CustomItemList.eM_dynamoTunnel3_UV.get(1), CustomItemList.eM_dynamoTunnel3_UHV.get(1),
            CustomItemList.eM_dynamoTunnel3_UEV.get(1), CustomItemList.eM_dynamoTunnel3_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_4096A = { WirelessHatchMore.dynamoMulti_ZPM_4096.get(1),
            WirelessHatchMore.dynamoMulti_UV_4096.get(1), WirelessHatchMore.dynamoMulti_UHV_4096.get(1),
            WirelessHatchMore.dynamoMulti_UEV_4096.get(1), WirelessHatchMore.dynamoMulti_UIV_4096.get(1) };

        // dynamo 16384A
        ItemStack[] dynamoHatches_16384A = { CustomItemList.eM_dynamoTunnel4_UV.get(1),
            CustomItemList.eM_dynamoTunnel4_UHV.get(1), CustomItemList.eM_dynamoTunnel4_UEV.get(1),
            CustomItemList.eM_dynamoTunnel4_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_16384A = { WirelessHatchMore.dynamoMulti_UV_16384.get(1),
            WirelessHatchMore.dynamoMulti_UHV_16384.get(1), WirelessHatchMore.dynamoMulti_UEV_16384.get(1),
            WirelessHatchMore.dynamoMulti_UIV_16384.get(1) };

        // dynamo 65536A
        ItemStack[] dynamoHatches_65536A = { CustomItemList.eM_dynamoTunnel5_UHV.get(1),
            CustomItemList.eM_dynamoTunnel5_UEV.get(1), CustomItemList.eM_dynamoTunnel5_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_65536A = { WirelessHatchMore.dynamoMulti_UHV_65536.get(1),
            WirelessHatchMore.dynamoMulti_UEV_65536.get(1), WirelessHatchMore.dynamoMulti_UIV_65536.get(1), };

        // dynamo 262144A
        ItemStack[] dynamoHatches_262144A = { CustomItemList.eM_energyTunnel6_UEV.get(1),
            CustomItemList.eM_energyTunnel7_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_262144A = { WirelessHatchMore.dynamoMulti_UEV_262144.get(1),
            WirelessHatchMore.dynamoMulti_UIV_262144.get(1) };

        // dynamo 1048576A
        ItemStack[] dynamoHatches_1048576A = { CustomItemList.eM_dynamoTunnel7_UIV.get(1) };

        ItemStack[] wirelessDynamoHatches_1048576A = { WirelessHatchMore.dynamoMulti_UIV_1048576.get(1) };

        // endregion

        ItemStack[] allSensor = { ItemList.Sensor_LV.get(1), ItemList.Sensor_LV.get(1), ItemList.Sensor_MV.get(1),
            ItemList.Sensor_HV.get(1), ItemList.Sensor_EV.get(1), ItemList.Sensor_IV.get(1), ItemList.Sensor_LuV.get(1),
            ItemList.Sensor_ZPM.get(1), ItemList.Sensor_UV.get(1), ItemList.Sensor_UHV.get(1),
            ItemList.Sensor_UEV.get(1), ItemList.Sensor_UIV.get(1), ItemList.Sensor_UMV.get(1),
            ItemList.Sensor_UXV.get(1), ItemList.Sensor_MAX.get(1) };

        ItemStack[] allEmitter = { ItemList.Emitter_LV.get(1), ItemList.Emitter_LV.get(1), ItemList.Emitter_MV.get(1),
            ItemList.Emitter_HV.get(1), ItemList.Emitter_EV.get(1), ItemList.Emitter_IV.get(1),
            ItemList.Emitter_LuV.get(1), ItemList.Emitter_ZPM.get(1), ItemList.Emitter_UV.get(1),
            ItemList.Emitter_UHV.get(1), ItemList.Emitter_UEV.get(1), ItemList.Emitter_UIV.get(1),
            ItemList.Emitter_UMV.get(1), ItemList.Emitter_UXV.get(1), ItemList.Emitter_MAX.get(1) };

        ItemStack[] calInput_2 = { new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 0),
            new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 0), new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 1),
            new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 2), new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 3),
            new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 4), new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 5),
            new ItemStack(ItemTeslaCoilCapacitor.INSTANCE, 1, 6),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 1),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 2),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 4),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 8),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 16),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 32),
            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 64) };

        ItemStack[] calInput_3 = { ItemList.Circuit_Parts_Crystal_Chip_Master.get(1),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(2), ItemList.Circuit_Parts_Crystal_Chip_Master.get(4),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(8), ItemList.Circuit_Parts_Crystal_Chip_Master.get(16),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(32), ItemList.Circuit_Parts_Crystal_Chip_Master.get(48),
            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64), };

        ItemStack[] calInput_4 = { GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 1),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 1),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 2),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 4),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 8),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 2),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 8),
            GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 16) };

        Integer[] energySkip = { 0, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11 };
        ItemStack[][] energyHatchAll = { energyHatches_2A, energyHatches_4A, energyHatches_16A, energyHatches_64A,
            energyHatches_256A, energyHatches_1024A, energyHatches_4096A, energyHatches_16384A, energyHatches_65536A,
            energyHatches_262144A, energyHatches_1048576A };
        ItemStack[][] wirelessEnergyHatchAll = { wirelessEnergyHatches_2A, wirelessEnergyHatches_4A,
            wirelessEnergyHatches_16A, wirelessEnergyHatches_64A, wirelessEnergyHatches_256A,
            wirelessEnergyHatches_1024A, wirelessEnergyHatches_4096A, wirelessEnergyHatches_16384A,
            wirelessEnergyHatches_65536A, wirelessEnergyHatches_262144A, wirelessEnergyHatches_1048576A };

        Integer[] dynamoSkip = { 0, 5, 5, 5, 5, 6, 7, 8, 9, 10, 11 };
        ItemStack[][] dynamoHatchAll = { dynamoHatches_2A, dynamoHatches_4A, dynamoHatches_16A, dynamoHatches_64A,
            dynamoHatches_256A, dynamoHatches_1024A, dynamoHatches_4096A, dynamoHatches_16384A, dynamoHatches_65536A,
            dynamoHatches_262144A, dynamoHatches_1048576A };
        ItemStack[][] wirelessDynamoHatchAll = { wirelessDynamoHatches_2A, wirelessDynamoHatches_4A,
            wirelessDynamoHatches_16A, wirelessDynamoHatches_64A, wirelessDynamoHatches_256A,
            wirelessDynamoHatches_1024A, wirelessDynamoHatches_4096A, wirelessDynamoHatches_16384A,
            wirelessDynamoHatches_65536A, wirelessDynamoHatches_262144A, wirelessDynamoHatches_1048576A };

        for (int i = 0; i < energyHatchAll.length; i++) {
            recipeArc(
                energyHatchAll[i],
                wirelessEnergyHatchAll[i],
                energySkip[i],
                allSensor,
                calInput_2,
                calInput_3,
                calInput_4);
        }

        for (int i = 0; i < dynamoHatchAll.length; i++) {
            recipeArc(
                dynamoHatchAll[i],
                wirelessDynamoHatchAll[i],
                dynamoSkip[i],
                allSensor,
                calInput_2,
                calInput_3,
                calInput_4);
        }

        var indalloy140 = FluidRegistry.getFluid("molten.indalloy140");

        GTValues.RA.stdBuilder()
            .itemInputs(
                allSensor[WirelessHatchMore.energyMulti_UMV_4194304.aTier],
                calInput_2[WirelessHatchMore.energyMulti_UMV_4194304.aTier],
                CustomItemList.eM_energyTunnel8_UMV.get(1),
                GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 64))
            .fluidInputs(
                Materials.Radon.getGas(16000),
                Materials.Polytetrafluoroethylene.getMolten(16000),
                new FluidStack(indalloy140, 21 * 144),
                Materials.BorosilicateGlass.getMolten(21 * 144L))
            .itemOutputs(WirelessHatchMore.energyMulti_UMV_4194304.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .noOptimize()
            .metadata(PRECISE_ASSEMBLER_CASING_TIER, 1)
            .addTo(preciseAssemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Wireless_Hatch_Energy_HV.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(4),
                GTUtility.getIntegratedCircuit(24))
            .fluidInputs(Materials.Radon.getGas(4000))
            .itemOutputs(WirelessHatchMore.energyMulti_HV_4.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                WirelessHatchMore.energyMulti_HV_4.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(4),
                GTUtility.getIntegratedCircuit(24))
            .fluidInputs(Materials.Radon.getGas(4000))
            .itemOutputs(WirelessHatchMore.energyMulti_HV_16.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                WirelessHatchMore.energyMulti_HV_16.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(4),
                GTUtility.getIntegratedCircuit(24))
            .fluidInputs(Materials.Radon.getGas(4000))
            .itemOutputs(WirelessHatchMore.energyMulti_HV_64.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .noOptimize()
            .addTo(assemblerRecipes);
    }

    private static void recipeArc(ItemStack[] input, ItemStack[] output, int offsetID, ItemStack[] allSensor,
        ItemStack[] calInput_2, ItemStack[] calInput_3, ItemStack[] calInput_4) {
        var indalloy140 = FluidRegistry.getFluid("molten.indalloy140");
        for (int i = 0; i < input.length; i++) {
            var offset = i + offsetID;

            if (offset <= 7) {
                GTValues.RA.stdBuilder()
                    .itemInputs(allSensor[offset], calInput_2[offset], input[i], calInput_3[offset], calInput_4[offset])
                    .fluidInputs(Materials.Radon.getGas(8000))
                    .itemOutputs(output[i])
                    .duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_EV)
                    .noOptimize()
                    .addTo(assemblerRecipes);
            } else {
                GTValues.RA.stdBuilder()
                    .itemInputs(
                        allSensor[offset],
                        calInput_2[offset],
                        input[i],
                        GTModHandler.getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 64))
                    .fluidInputs(
                        Materials.Radon.getGas(16000),
                        Materials.Polytetrafluoroethylene.getMolten(16000),
                        new FluidStack(indalloy140, 21 * 144),
                        Materials.BorosilicateGlass.getMolten(21 * 144L))
                    .itemOutputs(output[i])
                    .duration(60 * SECONDS)
                    .eut(TierEU.ZPM)
                    .noOptimize()
                    .metadata(PRECISE_ASSEMBLER_CASING_TIER, 1)
                    .addTo(preciseAssemblerRecipes);
            }
        }
    }
}
