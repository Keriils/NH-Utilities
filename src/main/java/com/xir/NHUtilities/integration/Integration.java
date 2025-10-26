package com.xir.NHUtilities.integration;

import com.xir.NHUtilities.integration.bogoSortApi.LunchBoxSort;

import cpw.mods.fml.common.event.FMLInitializationEvent;

@SuppressWarnings("unused")
public final class Integration {

    public static void integrate(FMLInitializationEvent event) {
        LunchBoxSort.integrate();
    }

}
