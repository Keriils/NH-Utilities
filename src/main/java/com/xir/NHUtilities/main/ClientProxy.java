package com.xir.NHUtilities.main;

import com.xir.NHUtilities.client.key.KeyBindings;
import com.xir.NHUtilities.client.key.KeyInputHandler;
import com.xir.NHUtilities.config.Config;
import com.xir.NHUtilities.loader.RenderLoader;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        if (Config.enableEnhancedTeleporterMKII) {
            FMLCommonHandler.instance()
                .bus()
                .register(new KeyInputHandler());
            KeyBindings.init();
        }
        RenderLoader.registerNHUtilitiesEntityRendering();
    }
}
