package com.xir.NHUtilities.common.api.enums;

import com.google.common.collect.ImmutableList;

@SuppressWarnings("unused")
public enum VoltageTier {

    ULV,
    LV,
    MV,
    HV,
    EV,
    IV,
    LuV,
    ZPM,
    UV,
    UHV,
    UEV,
    UIV,
    UMV,
    UXV,
    MAX;

    public static final ImmutableList<VoltageTier> VOLTAGE_TIER_LIST = ImmutableList.copyOf(VoltageTier.values());
}
