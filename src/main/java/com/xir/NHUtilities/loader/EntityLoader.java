package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.entity.EntityTimeAccelerator;
import com.xir.NHUtilities.main.NHUtilities;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityLoader {

    public static void initNHUtilitiesEntity() {
        EntityRegistry
            .registerModEntity(EntityTimeAccelerator.class, "Accelerator", 0, NHUtilities.instance, 64, 10, false);
    }
}
