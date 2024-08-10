package com.xir.NHUtilities.client;

import com.xir.NHUtilities.common.CommonProxy;
import com.xir.NHUtilities.config.Config;

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
    }
}
