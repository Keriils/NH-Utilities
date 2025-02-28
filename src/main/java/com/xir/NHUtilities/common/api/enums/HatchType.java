package com.xir.NHUtilities.common.api.enums;

import org.jetbrains.annotations.Contract;

@SuppressWarnings("unused")
public enum HatchType {

    EnergyHatch,
    DynamoHatch,
    LaserEnergyHatch,
    LaserDynamoHatch,
    WirelessEnergyHatch,
    WirelessDynamoHatch,
    WirelessLaserEnergyHatch,
    WirelessLaserDynamoHatch;

    @Contract(pure = true)
    public static int hatchSort(HatchType hatchType) {
        return switch (hatchType) {
            case EnergyHatch, WirelessLaserEnergyHatch, WirelessEnergyHatch, LaserEnergyHatch -> -2147;
            case DynamoHatch, WirelessLaserDynamoHatch, WirelessDynamoHatch, LaserDynamoHatch -> 2147;
        };
    }
}
