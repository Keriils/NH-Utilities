package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableEnhancedExUHealingAxe;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableWEToolWithExuHealingAxe;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.EnhanceExUHealingAxe;
import com.xir.NHUtilities.common.events.GetModItemWhileWorldLoad;
import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.common.events.WarpWardRingEvent;

public class EventLoader {

    public static void registerNHUtilitiesEvents() {
        if (enableGluttonyRingAndHungerRing) {
            MinecraftForge.EVENT_BUS.register(new GluttonyRingEvent());
        }
        if (enableWEToolWithExuHealingAxe || enableEnhancedExUHealingAxe) {
            MinecraftForge.EVENT_BUS.register(new GetModItemWhileWorldLoad());
        }
        if (enableEnhancedExUHealingAxe) {
            MinecraftForge.EVENT_BUS.register(new EnhanceExUHealingAxe());
        }
        MinecraftForge.EVENT_BUS.register(new WarpWardRingEvent());
    }
}
