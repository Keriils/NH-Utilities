package com.xir.NHUtilities.common.api.enums;

import com.google.common.collect.ImmutableList;

@SuppressWarnings("unused")
public enum HatchAmperes {

    AMP_2_A(2),
    AMP_4_A(4),
    AMP_16_A(16),
    AMP_64_A(64),
    AMP_256_A(256),
    AMP_1_024_A(1_024),
    AMP_4_096_A(4_096),
    AMP_16_384_A(16_384),
    AMP_65_536_A(65_536),
    AMP_262_144_A(262_144),
    AMP_1_048_576_A(1_048_576),
    AMP_4_194_304_A(4_194_304),
    AMP_16_777_216_A(16_777_216),
    AMP_67_108_864_A(67_108_864),
    AMP_268_435_456_A(268_435_456),
    AMP_1_073_741_824_A(1_073_741_824),;

    public final int ampere;

    HatchAmperes(int ampere) {
        this.ampere = ampere;
    }

    public static final ImmutableList<HatchAmperes> HATCH_AMPERES_LIST = ImmutableList.copyOf(HatchAmperes.values());
}
