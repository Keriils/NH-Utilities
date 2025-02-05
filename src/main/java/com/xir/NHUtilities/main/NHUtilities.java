package com.xir.NHUtilities.main;

import static com.xir.NHUtilities.main.ReferencedInfo.CLIENT_SIDE;
import static com.xir.NHUtilities.main.ReferencedInfo.DEPENDENCIES;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;
import static com.xir.NHUtilities.main.ReferencedInfo.SERVER_SIDE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xir.NHUtilities.Tags;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@SuppressWarnings("unused")
@Mod(
    modid = MOD_ID,
    version = Tags.VERSION,
    name = MOD_NAME,
    dependencies = DEPENDENCIES,
    acceptedMinecraftVersions = "[1.7.10]")
public class NHUtilities {

    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    @Mod.Instance(MOD_ID)
    public static NHUtilities instance;

    @SidedProxy(clientSide = CLIENT_SIDE, serverSide = SERVER_SIDE)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void completeInit(FMLLoadCompleteEvent event) {
        proxy.completeInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
