package com.xir.NHUtilities.common.recipes.MassRecipes;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.enums.WirelessHatchMore;

import gregtech.api.enums.ItemList;
import tectech.thing.CustomItemList;

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
        ItemStack[] energyHatches_4A = { CustomItemList.eM_energyMulti16_EV.get(1),
            CustomItemList.eM_energyMulti16_IV.get(1), CustomItemList.eM_energyMulti16_LuV.get(1),
            CustomItemList.eM_energyMulti16_ZPM.get(1), CustomItemList.eM_energyMulti16_UV.get(1),
            CustomItemList.eM_energyMulti16_UHV.get(1), CustomItemList.eM_energyMulti16_UEV.get(1),
            CustomItemList.eM_energyMulti16_UIV.get(1), CustomItemList.eM_energyMulti16_UMV.get(1),
            CustomItemList.eM_energyMulti16_UXV.get(1) };

        ItemStack[] wirelessEnergyHatches_4A = { CustomItemList.eM_energyWirelessMulti4_EV.get(1),
            CustomItemList.eM_energyWirelessMulti4_IV.get(1), CustomItemList.eM_energyWirelessMulti4_LuV.get(1),
            CustomItemList.eM_energyWirelessMulti4_ZPM.get(1), CustomItemList.eM_energyWirelessMulti4_UV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UHV.get(1), CustomItemList.eM_energyWirelessMulti4_UEV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UIV.get(1), CustomItemList.eM_energyWirelessMulti4_UMV.get(1),
            CustomItemList.eM_energyWirelessMulti4_UXV.get(1) };

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
        ItemStack[] energyHatches_1048576A = { CustomItemList.eM_energyTunnel7_UEV.get(1),
            CustomItemList.eM_energyTunnel7_UIV.get(1), CustomItemList.eM_energyTunnel7_UMV.get(1) };

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
        ItemStack[] dynamoHatch_16384A = { CustomItemList.eM_dynamoTunnel4_UV.get(1),
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

        // --------------- Special recipe ---------------

        // GTValues.RA.stdBuilder().itemInputs()

    }

}
