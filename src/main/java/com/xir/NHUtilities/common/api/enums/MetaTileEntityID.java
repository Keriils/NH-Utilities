package com.xir.NHUtilities.common.api.enums;

import static com.xir.NHUtilities.config.Config.metaIdOffset;

public enum MetaTileEntityID {

    TC_BLAST_FURNACE(0),
    EGG_MACHINE_EV(1),
    EGG_MACHINE_IV(2),
    EGG_MACHINE_LuV(3),
    EGG_MACHINE_ZPM(4),
    EGG_MACHINE_UV(5),
    EGG_MACHINE_UHV(6),
    EGG_MACHINE_UEV(7),
    EGG_MACHINE_UIV(8),
    EGG_MACHINE_UMV(9),
    EGG_MACHINE_UXV(10),
    EGG_MACHINE_MAX(11),

    ;

    public final int ID;

    MetaTileEntityID(int ID) {
        this.ID = 25000 + metaIdOffset + ID;
    }
}
