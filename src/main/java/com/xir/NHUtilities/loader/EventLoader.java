package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableEnhancedExUHealingAxe;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.EnhanceExUHealingAxe;
import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.common.events.WarpWardRingEvent;

public class EventLoader {

    public static void registerNHUtilitiesEvents() {
        if (enableGluttonyRingAndHungerRing) {
            MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
        }
        if (enableEnhancedExUHealingAxe) {
            MinecraftForge.EVENT_BUS.register(new EnhanceExUHealingAxe());
        }
        MinecraftForge.EVENT_BUS.register(new WarpWardRingEvent());
    }
}
