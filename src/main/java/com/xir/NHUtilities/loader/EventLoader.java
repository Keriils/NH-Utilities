package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.config.Config.enableEggMachine;
import static com.xir.NHUtilities.config.Config.enableEnhancedExUHealingAxe;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.main.ReferencedInfo.OTH_MOD_IS_LOADED;

import java.util.function.Supplier;

import net.minecraftforge.common.MinecraftForge;

import com.xir.NHUtilities.common.events.DragonDeathHandler;
import com.xir.NHUtilities.common.events.EnhanceExUHealingAxe;
import com.xir.NHUtilities.common.events.GluttonyRingEvent;
import com.xir.NHUtilities.common.events.OTHEggHuntEvent;
import com.xir.NHUtilities.common.events.WarpWardRingEvent;

import cpw.mods.fml.common.FMLCommonHandler;

public class EventLoader {

    public static void initNHUtilitiesEvents() {
        registerEvent(GluttonyRingEvent::new, enableGluttonyRingAndHungerRing, EventType.ForgeEvent);
        registerEvent(EnhanceExUHealingAxe::new, enableEnhancedExUHealingAxe, EventType.FmlEvent);
        registerEvent(WarpWardRingEvent::new, EventType.ForgeEvent);
        registerEvent(DragonDeathHandler::new, enableEggMachine, EventType.ForgeEvent);
        registerEvent(OTHEggHuntEvent::new, OTH_MOD_IS_LOADED, EventType.ForgeEvent);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerEvent(Supplier<?> event, EventType eventType) {
        registerEvent(event, true, eventType);
    }

    private static void registerEvent(Supplier<?> event, boolean shouldRegister, EventType eventType) {
        if (!shouldRegister) return;
        if (eventType == EventType.ForgeEvent) {
            MinecraftForge.EVENT_BUS.register(event.get());
        }
        if (eventType == EventType.FmlEvent) {
            FMLCommonHandler.instance()
                .bus()
                .register(event.get());
        }
    }

    public enum EventType {
        ForgeEvent,
        FmlEvent;
    }

}
