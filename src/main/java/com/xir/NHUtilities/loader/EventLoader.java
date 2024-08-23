package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.GluttonyRingEvent;

public class EventLoader {

    public static void registerNHUtilitiesEvents() {
        if (enableGluttonyRingAndHungerRing) {
            MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
        }
    }
}
