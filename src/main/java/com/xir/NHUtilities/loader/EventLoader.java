package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableEggMachine;
import static com.xir.NHUtilities.config.Config.enableEnhancedExUHealingAxe;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.DragonDeathHandler;
import com.xir.NHUtilities.common.events.EnhanceExUHealingAxe;
import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.common.events.WarpWardRingEvent;

import cpw.mods.fml.common.FMLCommonHandler;

public class EventLoader {

    public static void initNHUtilitiesEvents() {
        registerEvent(true, new GluttonyRingEvent(), enableGluttonyRingAndHungerRing);
        registerEvent(false, new EnhanceExUHealingAxe(), enableEnhancedExUHealingAxe);
        registerEvent(true, new WarpWardRingEvent());
        registerEvent(true, new DragonDeathHandler(), enableEggMachine);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerEvent(boolean isMinecraftForgeEvent, Object event) {
        registerEvent(isMinecraftForgeEvent, event, true);
    }

    private static void registerEvent(boolean isMinecraftForgeEvent, Object event, boolean shouldRegister) {
        if (!shouldRegister) return;
        if (isMinecraftForgeEvent) {
            MinecraftForge.EVENT_BUS.register(event);
        } else {
            FMLCommonHandler.instance()
                .bus()
                .register(event);
        }
    }
}
