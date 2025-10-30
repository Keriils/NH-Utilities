package com.xir.NHUtilities.integration.bogoSortApi;

import com.cleanroommc.bogosorter.BogoSortAPI;
import com.xir.NHUtilities.container.ContainerFoodContainerPlus;

import squeek.spiceoflife.inventory.ContainerFoodContainer;

public final class LunchBoxSort {

    public static void integrate() {
        BogoSortAPI.INSTANCE.addGenericCompat(ContainerFoodContainerPlus.class);
        BogoSortAPI.INSTANCE.addGenericCompat(ContainerFoodContainer.class);
    }

}
