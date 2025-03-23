package com.xir.NHUtilities.common.api.interfaces;

import static com.xir.NHUtilities.common.api.UtilHelper.HatchesBoxed.buildHatchBoxed;
import static com.xir.NHUtilities.common.api.UtilHelper.WarpBox.newWarpBox;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.UtilHelper.HatchesBoxed;
import com.xir.NHUtilities.common.api.UtilHelper.WarpBox;
import com.xir.NHUtilities.common.api.enums.HatchAmperes;
import com.xir.NHUtilities.common.api.enums.HatchType;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.api.enums.VoltageTier;
import com.xir.NHUtilities.common.api.enums.WirelessHatchMore;

import gregtech.api.enums.ItemList;
import tectech.thing.CustomItemList;

@SuppressWarnings("unused")
public final class LazyHatchHelper {

    public static final WarpBox<ImmutableList<HatchesBoxed>> allCommonHatch;

    public static final WarpBox<ImmutableList<HatchesBoxed>> allWirelessHatch;

    static {
        // region Hatch init
        // spotless:off
        allCommonHatch = newWarpBox(
            () -> ImmutableList.of(
                // 2A energy
                buildHatchBoxed(    VoltageTier.ULV,        ItemList.Hatch_Energy_ULV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.LV,         ItemList.Hatch_Energy_LV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MV,         ItemList.Hatch_Energy_MV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.HV,         ItemList.Hatch_Energy_HV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.EV,         ItemList.Hatch_Energy_EV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         ItemList.Hatch_Energy_IV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        ItemList.Hatch_Energy_LuV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        ItemList.Hatch_Energy_ZPM.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         ItemList.Hatch_Energy_UV.get(1),        HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        ItemList.Hatch_Energy_UHV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        ItemList.Hatch_Energy_UEV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        ItemList.Hatch_Energy_UIV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        ItemList.Hatch_Energy_UMV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        ItemList.Hatch_Energy_UXV.get(1),       HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        NHUItemList.Hatch_Energy_MAX.get(1),             HatchAmperes.AMP_2_A,       HatchType.EnergyHatch),

                // 2A dynamo
                buildHatchBoxed(    VoltageTier.ULV,        ItemList.Hatch_Dynamo_ULV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.LV,         ItemList.Hatch_Dynamo_LV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.MV,         ItemList.Hatch_Dynamo_MV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.HV,         ItemList.Hatch_Dynamo_HV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.EV,         ItemList.Hatch_Dynamo_EV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         ItemList.Hatch_Dynamo_IV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        ItemList.Hatch_Dynamo_LuV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        ItemList.Hatch_Dynamo_ZPM.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         ItemList.Hatch_Dynamo_UV.get(1),        HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        ItemList.Hatch_Dynamo_UHV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        ItemList.Hatch_Dynamo_UEV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        ItemList.Hatch_Dynamo_UIV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        ItemList.Hatch_Dynamo_UMV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        ItemList.Hatch_Dynamo_UXV.get(1),       HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.MAX,        NHUItemList.Hatch_Dynamo_MAX.get(1),             HatchAmperes.AMP_2_A,       HatchType.DynamoHatch),

                // 4A energy
                buildHatchBoxed(    VoltageTier.LV,         NHUItemList.Hatch_EnergyMulti4_LV.get(1),                    HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MV,         NHUItemList.Hatch_EnergyMulti4_MV.get(1),                    HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.HV,         NHUItemList.Hatch_EnergyMulti4_HV.get(1),                    HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyMulti4_EV.get(1),           HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyMulti4_IV.get(1),           HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyMulti4_LuV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyMulti4_ZPM.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyMulti4_UV.get(1),           HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyMulti4_UHV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyMulti4_UEV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyMulti4_UIV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyMulti4_UMV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyMulti4_UXV.get(1),          HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        NHUItemList.Hatch_EnergyMulti4_MAX.get(1),                   HatchAmperes.AMP_4_A,       HatchType.EnergyHatch),

                // 4A dynamo
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_dynamoMulti4_EV.get(1),           HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoMulti4_IV.get(1),           HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoMulti4_LuV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoMulti4_ZPM.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoMulti4_UV.get(1),           HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoMulti4_UHV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoMulti4_UEV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoMulti4_UIV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoMulti4_UMV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoMulti4_UXV.get(1),          HatchAmperes.AMP_4_A,       HatchType.DynamoHatch),

                // 16A energy
                buildHatchBoxed(    VoltageTier.LV,         NHUItemList.Hatch_EnergyMulti16_LV.get(1),                    HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MV,         NHUItemList.Hatch_EnergyMulti16_MV.get(1),                    HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.HV,         NHUItemList.Hatch_EnergyMulti16_HV.get(1),                    HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyMulti16_EV.get(1),           HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyMulti16_IV.get(1),           HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyMulti16_LuV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyMulti16_ZPM.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyMulti16_UV.get(1),           HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyMulti16_UHV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyMulti16_UEV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyMulti16_UIV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyMulti16_UMV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyMulti16_UXV.get(1),          HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        NHUItemList.Hatch_EnergyMulti16_MAX.get(1),                   HatchAmperes.AMP_16_A,       HatchType.EnergyHatch),

                // 16A dynamo
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_dynamoMulti16_EV.get(1),           HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoMulti16_IV.get(1),           HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoMulti16_LuV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoMulti16_ZPM.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoMulti16_UV.get(1),           HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoMulti16_UHV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoMulti16_UEV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoMulti16_UIV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoMulti16_UMV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoMulti16_UXV.get(1),          HatchAmperes.AMP_16_A,     HatchType.DynamoHatch),

                // 64A energy
                buildHatchBoxed(    VoltageTier.LV,         NHUItemList.Hatch_EnergyMulti64_LV.get(1),                    HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MV,         NHUItemList.Hatch_EnergyMulti64_MV.get(1),                    HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.HV,         NHUItemList.Hatch_EnergyMulti64_HV.get(1),                    HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyMulti64_EV.get(1),           HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyMulti64_IV.get(1),           HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyMulti64_LuV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyMulti64_ZPM.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyMulti64_UV.get(1),           HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyMulti64_UHV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyMulti64_UEV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyMulti64_UIV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyMulti64_UMV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyMulti64_UXV.get(1),          HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        NHUItemList.Hatch_EnergyMulti64_MAX.get(1),                   HatchAmperes.AMP_64_A,      HatchType.EnergyHatch),

                // 64A dynamo
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_dynamoMulti64_EV.get(1),           HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoMulti64_IV.get(1),           HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoMulti64_LuV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoMulti64_ZPM.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoMulti64_UV.get(1),           HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoMulti64_UHV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoMulti64_UEV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoMulti64_UIV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoMulti64_UMV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoMulti64_UXV.get(1),          HatchAmperes.AMP_64_A,     HatchType.DynamoHatch),

                // 256A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel1_IV.get(1),              HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel1_LuV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel1_ZPM.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel1_UV.get(1),              HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel1_UHV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel1_UEV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel1_UIV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel1_UMV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel1_UXV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserEnergyHatch),

                // 256A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel1_IV.get(1),              HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel1_LuV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel1_ZPM.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel1_UV.get(1),              HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel1_UHV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel1_UEV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel1_UIV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel1_UMV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel1_UXV.get(1),             HatchAmperes.AMP_256_A,     HatchType.LaserDynamoHatch),

                // 1024A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel2_IV.get(1),              HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel2_LuV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel2_ZPM.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel2_UV.get(1),              HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel2_UHV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel2_UEV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel2_UIV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel2_UMV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel2_UXV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserEnergyHatch),

                // 1024A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel2_IV.get(1),              HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel2_LuV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel2_ZPM.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel2_UV.get(1),              HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel2_UHV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel2_UEV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel2_UIV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel2_UMV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel2_UXV.get(1),             HatchAmperes.AMP_1_024_A,   HatchType.LaserDynamoHatch),

                // 4096A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel3_IV.get(1),              HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel3_LuV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel3_ZPM.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel3_UV.get(1),              HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel3_UHV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel3_UEV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel3_UIV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel3_UMV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel3_UXV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserEnergyHatch),

                // 4096A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel3_IV.get(1),              HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel3_LuV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel3_ZPM.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel3_UV.get(1),              HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel3_UHV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel3_UEV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel3_UIV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel3_UMV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel3_UXV.get(1),             HatchAmperes.AMP_4_096_A,   HatchType.LaserDynamoHatch),

                // 16384A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel4_IV.get(1),              HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel4_LuV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel4_ZPM.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel4_UV.get(1),              HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel4_UHV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel4_UEV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel4_UIV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel4_UMV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel4_UXV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserEnergyHatch),

                // 16384A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel4_IV.get(1),              HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel4_LuV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel4_ZPM.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel4_UV.get(1),              HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel4_UHV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel4_UEV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel4_UIV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel4_UMV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel4_UXV.get(1),             HatchAmperes.AMP_16_384_A,      HatchType.LaserDynamoHatch),

                // 65536A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel5_IV.get(1),              HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel5_LuV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel5_ZPM.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel5_UV.get(1),              HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel5_UHV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel5_UEV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel5_UIV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel5_UMV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel5_UXV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserEnergyHatch),

                // 65536A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel5_IV.get(1),              HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel5_LuV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel5_ZPM.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel5_UV.get(1),              HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel5_UHV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel5_UEV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel5_UIV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel5_UMV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel5_UXV.get(1),             HatchAmperes.AMP_65_536_A,      HatchType.LaserDynamoHatch),

                // 262144A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel6_IV.get(1),              HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel6_LuV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel6_ZPM.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel6_UV.get(1),              HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel6_UHV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel6_UEV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel6_UIV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel6_UMV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel6_UXV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserEnergyHatch),

                // 262144A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel6_IV.get(1),              HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel6_LuV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel6_ZPM.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel6_UV.get(1),              HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel6_UHV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel6_UEV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel6_UIV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel6_UMV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel6_UXV.get(1),             HatchAmperes.AMP_262_144_A,     HatchType.LaserDynamoHatch),

                // 1048576A energy
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyTunnel7_IV.get(1),              HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyTunnel7_LuV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyTunnel7_ZPM.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyTunnel7_UV.get(1),              HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyTunnel7_UHV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyTunnel7_UEV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyTunnel7_UIV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel7_UMV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel7_UXV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserEnergyHatch),

                // 1048576A dynamo
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_dynamoTunnel7_IV.get(1),              HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_dynamoTunnel7_LuV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_dynamoTunnel7_ZPM.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_dynamoTunnel7_UV.get(1),              HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_dynamoTunnel7_UHV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_dynamoTunnel7_UEV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel7_UIV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_dynamoTunnel7_UMV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel7_UXV.get(1),             HatchAmperes.AMP_1_048_576_A,       HatchType.LaserDynamoHatch),

                // 4194304A energy
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyTunnel8_UMV.get(1),             HatchAmperes.AMP_4_194_304_A,       HatchType.LaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel8_UXV.get(1),             HatchAmperes.AMP_4_194_304_A,       HatchType.LaserEnergyHatch),

                // 4194304A dynamo
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_dynamoTunnel8_UMV.get(1),             HatchAmperes.AMP_4_194_304_A,       HatchType.LaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel8_UXV.get(1),             HatchAmperes.AMP_4_194_304_A,       HatchType.LaserDynamoHatch),

                // 16777216A energy
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyTunnel9_UXV.get(1),             HatchAmperes.AMP_16_777_216_A,       HatchType.LaserEnergyHatch),

                // 16777216A dynamo
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_dynamoTunnel9_UXV.get(1),             HatchAmperes.AMP_16_777_216_A,       HatchType.LaserDynamoHatch)

            ));

        allWirelessHatch = newWarpBox(
            () -> ImmutableList.of(
                // 2A energy
                buildHatchBoxed(    VoltageTier.ULV,        ItemList.Wireless_Hatch_Energy_ULV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.LV,         ItemList.Wireless_Hatch_Energy_LV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.MV,         ItemList.Wireless_Hatch_Energy_MV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.HV,         ItemList.Wireless_Hatch_Energy_HV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.EV,         ItemList.Wireless_Hatch_Energy_EV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         ItemList.Wireless_Hatch_Energy_IV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        ItemList.Wireless_Hatch_Energy_LuV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        ItemList.Wireless_Hatch_Energy_ZPM.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         ItemList.Wireless_Hatch_Energy_UV.get(1),         HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        ItemList.Wireless_Hatch_Energy_UHV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        ItemList.Wireless_Hatch_Energy_UEV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        ItemList.Wireless_Hatch_Energy_UIV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        ItemList.Wireless_Hatch_Energy_UMV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        ItemList.Wireless_Hatch_Energy_UXV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        ItemList.Wireless_Hatch_Energy_MAX.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessEnergyHatch),

                // 2A dynamoWireless
                buildHatchBoxed(    VoltageTier.ULV,        ItemList.Wireless_Dynamo_Energy_ULV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.LV,         ItemList.Wireless_Dynamo_Energy_LV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.MV,         ItemList.Wireless_Dynamo_Energy_MV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.HV,         ItemList.Wireless_Dynamo_Energy_HV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.EV,         ItemList.Wireless_Dynamo_Energy_EV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         ItemList.Wireless_Dynamo_Energy_IV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        ItemList.Wireless_Dynamo_Energy_LuV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        ItemList.Wireless_Dynamo_Energy_ZPM.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         ItemList.Wireless_Dynamo_Energy_UV.get(1),        HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        ItemList.Wireless_Dynamo_Energy_UHV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        ItemList.Wireless_Dynamo_Energy_UEV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        ItemList.Wireless_Dynamo_Energy_UIV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UMV,        ItemList.Wireless_Dynamo_Energy_UMV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UXV,        ItemList.Wireless_Dynamo_Energy_UXV.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.MAX,        ItemList.Wireless_Dynamo_Energy_MAX.get(1),       HatchAmperes.AMP_2_A,     HatchType.WirelessDynamoHatch),

                // 4A energy
                buildHatchBoxed(    VoltageTier.LV,         WirelessHatchMore.energyMulti_LV_4.get(1),                         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.MV,         WirelessHatchMore.energyMulti_MV_4.get(1),                         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.HV,         WirelessHatchMore.energyMulti_HV_4.get(1),                         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyWirelessMulti4_EV.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyWirelessMulti4_IV.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyWirelessMulti4_LuV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyWirelessMulti4_ZPM.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyWirelessMulti4_UV.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyWirelessMulti4_UHV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyWirelessMulti4_UEV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyWirelessMulti4_UIV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyWirelessMulti4_UMV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyWirelessMulti4_UXV.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.MAX,        CustomItemList.eM_energyWirelessMulti4_MAX.get(1),        HatchAmperes.AMP_4_A,     HatchType.WirelessEnergyHatch ),

                // 4A dynamo
                buildHatchBoxed(    VoltageTier.EV,         WirelessHatchMore.dynamoMulti_EV_4.get(1),          HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         WirelessHatchMore.dynamoMulti_IV_4.get(1),          HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        WirelessHatchMore.dynamoMulti_LuV_4.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_4.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_4.get(1),          HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_4.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_4.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_4.get(1),         HatchAmperes.AMP_4_A,     HatchType.WirelessDynamoHatch),

                // 16A energy
                buildHatchBoxed(    VoltageTier.LV,         WirelessHatchMore.energyMulti_LV_16.get(1),                         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.MV,         WirelessHatchMore.energyMulti_MV_16.get(1),                         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.HV,         WirelessHatchMore.energyMulti_HV_16.get(1),                         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyWirelessMulti16_EV.get(1),         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyWirelessMulti16_IV.get(1),         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyWirelessMulti16_LuV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyWirelessMulti16_ZPM.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyWirelessMulti16_UV.get(1),         HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyWirelessMulti16_UHV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyWirelessMulti16_UEV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyWirelessMulti16_UIV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyWirelessMulti16_UMV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyWirelessMulti16_UXV.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        CustomItemList.eM_energyWirelessMulti16_MAX.get(1),        HatchAmperes.AMP_16_A,       HatchType.WirelessEnergyHatch),

                // 16A dynamo
                buildHatchBoxed(    VoltageTier.EV,         WirelessHatchMore.dynamoMulti_EV_16.get(1),          HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         WirelessHatchMore.dynamoMulti_IV_16.get(1),          HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        WirelessHatchMore.dynamoMulti_LuV_16.get(1),         HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_16.get(1),         HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_16.get(1),          HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_16.get(1),         HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_16.get(1),         HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_16.get(1),         HatchAmperes.AMP_16_A,     HatchType.WirelessDynamoHatch),

                // 64A energy
                buildHatchBoxed(    VoltageTier.LV,         WirelessHatchMore.energyMulti_LV_64.get(1),                         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.MV,         WirelessHatchMore.energyMulti_MV_64.get(1),                         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.HV,         WirelessHatchMore.energyMulti_HV_64.get(1),                         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch ),
                buildHatchBoxed(    VoltageTier.EV,         CustomItemList.eM_energyWirelessMulti64_EV.get(1),         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.IV,         CustomItemList.eM_energyWirelessMulti64_IV.get(1),         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,        CustomItemList.eM_energyWirelessMulti64_LuV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        CustomItemList.eM_energyWirelessMulti64_ZPM.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,         CustomItemList.eM_energyWirelessMulti64_UV.get(1),         HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,        CustomItemList.eM_energyWirelessMulti64_UHV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,        CustomItemList.eM_energyWirelessMulti64_UEV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,        CustomItemList.eM_energyWirelessMulti64_UIV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,        CustomItemList.eM_energyWirelessMulti64_UMV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,        CustomItemList.eM_energyWirelessMulti64_UXV.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,        CustomItemList.eM_energyWirelessMulti64_MAX.get(1),        HatchAmperes.AMP_64_A,       HatchType.WirelessEnergyHatch),

                // 64A dynamo
                buildHatchBoxed(    VoltageTier.EV,         WirelessHatchMore.dynamoMulti_EV_64.get(1),          HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.IV,         WirelessHatchMore.dynamoMulti_IV_64.get(1),          HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        WirelessHatchMore.dynamoMulti_LuV_64.get(1),         HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_64.get(1),         HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_64.get(1),          HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_64.get(1),         HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_64.get(1),         HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_64.get(1),         HatchAmperes.AMP_64_A,     HatchType.WirelessDynamoHatch),

                // 256A energy
                buildHatchBoxed(    VoltageTier.IV,          WirelessHatchMore.energyMulti_IV_256.get(1),                           HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.LuV,         WirelessHatchMore.energyMulti_LuV_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,         WirelessHatchMore.energyMulti_ZPM_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,          WirelessHatchMore.energyMulti_UV_256.get(1),                           HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,         WirelessHatchMore.energyMulti_UHV_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel1_UXV.get(1),           HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_256.get(1),                          HatchAmperes.AMP_256_A,    HatchType.WirelessLaserEnergyHatch),

                // 256A dynamo
                buildHatchBoxed(    VoltageTier.IV,         WirelessHatchMore.dynamoMulti_IV_256.get(1),          HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.LuV,        WirelessHatchMore.dynamoMulti_LuV_256.get(1),         HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_256.get(1),         HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_256.get(1),          HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_256.get(1),         HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_256.get(1),         HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_256.get(1),         HatchAmperes.AMP_256_A,     HatchType.WirelessLaserDynamoHatch),

                // 1024A energy
                buildHatchBoxed(    VoltageTier.LuV,         WirelessHatchMore.energyMulti_LuV_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.ZPM,         WirelessHatchMore.energyMulti_ZPM_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,          WirelessHatchMore.energyMulti_UV_1024.get(1),                           HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,         WirelessHatchMore.energyMulti_UHV_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel2_UXV.get(1),            HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_1024.get(1),                          HatchAmperes.AMP_1_024_A,    HatchType.WirelessLaserEnergyHatch),

                // 1024A dynamo
                buildHatchBoxed(    VoltageTier.LuV,        WirelessHatchMore.dynamoMulti_LuV_1024.get(1),         HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_1024.get(1),         HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_1024.get(1),          HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_1024.get(1),         HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_1024.get(1),         HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_1024.get(1),         HatchAmperes.AMP_1_024_A,     HatchType.WirelessLaserDynamoHatch),

                // 4096A energy
                buildHatchBoxed(    VoltageTier.ZPM,         WirelessHatchMore.energyMulti_ZPM_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UV,          WirelessHatchMore.energyMulti_UV_4096.get(1),                           HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,         WirelessHatchMore.energyMulti_UHV_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel3_UXV.get(1),            HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_4096.get(1),                          HatchAmperes.AMP_4_096_A,    HatchType.WirelessLaserEnergyHatch),

                // 4096A dynamo
                buildHatchBoxed(    VoltageTier.ZPM,        WirelessHatchMore.dynamoMulti_ZPM_4096.get(1),         HatchAmperes.AMP_4_096_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_4096.get(1),          HatchAmperes.AMP_4_096_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_4096.get(1),         HatchAmperes.AMP_4_096_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_4096.get(1),         HatchAmperes.AMP_4_096_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_4096.get(1),         HatchAmperes.AMP_4_096_A,     HatchType.WirelessLaserDynamoHatch),

                // 16384A energy
                buildHatchBoxed(    VoltageTier.UV,          WirelessHatchMore.energyMulti_UV_16384.get(1),                           HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UHV,         WirelessHatchMore.energyMulti_UHV_16384.get(1),                          HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_16384.get(1),                          HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_16384.get(1),                          HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_16384.get(1),                          HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel4_UXV.get(1),             HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_16384.get(1),                          HatchAmperes.AMP_16_384_A,    HatchType.WirelessLaserEnergyHatch),

                // 16384A dynamo
                buildHatchBoxed(    VoltageTier.UV,         WirelessHatchMore.dynamoMulti_UV_16384.get(1),          HatchAmperes.AMP_16_384_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_16384.get(1),         HatchAmperes.AMP_16_384_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_16384.get(1),         HatchAmperes.AMP_16_384_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_16384.get(1),         HatchAmperes.AMP_16_384_A,     HatchType.WirelessLaserDynamoHatch),

                // 65536A energy
                buildHatchBoxed(    VoltageTier.UHV,         WirelessHatchMore.energyMulti_UHV_65536.get(1),                          HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_65536.get(1),                          HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_65536.get(1),                          HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_65536.get(1),                          HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel5_UXV.get(1),             HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_65536.get(1),                          HatchAmperes.AMP_65_536_A,    HatchType.WirelessLaserEnergyHatch),

                // 65536A dynamo
                buildHatchBoxed(    VoltageTier.UHV,        WirelessHatchMore.dynamoMulti_UHV_65536.get(1),         HatchAmperes.AMP_65_536_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_65536.get(1),         HatchAmperes.AMP_65_536_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_65536.get(1),         HatchAmperes.AMP_65_536_A,     HatchType.WirelessLaserDynamoHatch),

                // 262144A energy
                buildHatchBoxed(    VoltageTier.UEV,         WirelessHatchMore.energyMulti_UEV_262144.get(1),                          HatchAmperes.AMP_262_144_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_262144.get(1),                          HatchAmperes.AMP_262_144_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_262144.get(1),                          HatchAmperes.AMP_262_144_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel6_UXV.get(1),             HatchAmperes.AMP_262_144_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_262144.get(1),                          HatchAmperes.AMP_262_144_A,    HatchType.WirelessLaserEnergyHatch),

                // 262144A dynamo
                buildHatchBoxed(    VoltageTier.UEV,        WirelessHatchMore.dynamoMulti_UEV_262144.get(1),         HatchAmperes.AMP_262_144_A,     HatchType.WirelessLaserDynamoHatch),
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_262144.get(1),         HatchAmperes.AMP_262_144_A,     HatchType.WirelessLaserDynamoHatch),

                // 1048576A energy
                buildHatchBoxed(    VoltageTier.UIV,         WirelessHatchMore.energyMulti_UIV_1048576.get(1),                          HatchAmperes.AMP_1_048_576_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_1048576.get(1),                          HatchAmperes.AMP_1_048_576_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel7_UXV.get(1),               HatchAmperes.AMP_1_048_576_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_1048576.get(1),                          HatchAmperes.AMP_1_048_576_A,    HatchType.WirelessLaserEnergyHatch),

                // 1048576A dynamo
                buildHatchBoxed(    VoltageTier.UIV,        WirelessHatchMore.dynamoMulti_UIV_1048576.get(1),         HatchAmperes.AMP_1_048_576_A,     HatchType.WirelessLaserDynamoHatch),

                // 4194304A energy
                buildHatchBoxed(    VoltageTier.UMV,         WirelessHatchMore.energyMulti_UMV_4194304.get(1),                          HatchAmperes.AMP_4_194_304_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel8_UXV.get(1),               HatchAmperes.AMP_4_194_304_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_4194304.get(1),                          HatchAmperes.AMP_4_194_304_A,    HatchType.WirelessLaserEnergyHatch),

                // 16777216A energy
                buildHatchBoxed(    VoltageTier.UXV,         CustomItemList.eM_energyWirelessTunnel9_UXV.get(1),               HatchAmperes.AMP_16_777_216_A,    HatchType.WirelessLaserEnergyHatch),
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_16777216.get(1),                         HatchAmperes.AMP_16_777_216_A,    HatchType.WirelessLaserEnergyHatch),

                // 67108864A energy
                buildHatchBoxed(    VoltageTier.MAX,         WirelessHatchMore.energyMulti_MAX_67108864.get(1),                         HatchAmperes.AMP_67_108_864_A,    HatchType.WirelessLaserEnergyHatch)

            ));
        // spotless:on
        // endregion
    }

}
