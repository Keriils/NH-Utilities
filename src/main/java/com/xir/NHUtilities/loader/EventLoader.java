package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableWEToolWithExuHealingAxe;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.common.events.WorldLoad;

public class EventLoader {

    public static void registerNHUtilitiesEvents() {
        if (enableGluttonyRingAndHungerRing) {
            MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
        }
        if (enableWEToolWithExuHealingAxe) {
            MinecraftForge.EVENT_BUS.register(new WorldLoad());
        }
    }
}
