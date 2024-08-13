package com.xir.NHUtilities.common;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.nhutilies.events.GluttonyRingEvent;
import com.xir.NHUtilities.loader.ItemLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ItemLoader.registerNHUtilitiesItems();
        MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    public void serverStarting(FMLServerStartingEvent event) {}
}
