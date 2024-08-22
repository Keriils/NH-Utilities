package com.xir.NHUtilities.loader;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.config.Config;

public class EventLoader {

    public static void registerNHUtilitiesEvents() {
        if (Config.enableGluttonyRingAndHungerRing) {
            MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
        }
    }
}
