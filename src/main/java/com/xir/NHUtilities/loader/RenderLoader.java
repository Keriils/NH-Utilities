package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.client.render.RenderTimeAccelerator;
import com.xir.NHUtilities.common.entity.EntityTimeAccelerator;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLoader {

    public static void registerNHUtilitiesEntityRendering() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTimeAccelerator.class, new RenderTimeAccelerator());
    }
}
