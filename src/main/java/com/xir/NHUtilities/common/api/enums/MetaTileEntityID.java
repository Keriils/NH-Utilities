package com.xir.NHUtilities.common.api.enums;

public enum MetaTileEntityID {

    TC_BLAST_FURNACE(14350),
    EGG_MACHINE_EV(25101),
    EGG_MACHINE_IV(25102),
    EGG_MACHINE_LuV(25103),
    EGG_MACHINE_ZPM(25104),
    EGG_MACHINE_UV(25105),
    EGG_MACHINE_UHV(25106),
    EGG_MACHINE_UEV(25107),
    EGG_MACHINE_UIV(25108),
    EGG_MACHINE_UMV(25109),
    EGG_MACHINE_UXV(25110),
    EGG_MACHINE_MAX(25111),

    ;

    public final int ID;

    MetaTileEntityID(int ID) {
        this.ID = ID;
    }
}
