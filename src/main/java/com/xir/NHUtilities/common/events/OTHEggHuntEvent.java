package com.xir.NHUtilities.common.events;

import static com.xir.NHUtilities.common.machine.single.MTEMagicalEggMachine.OTH_EGG_HUNT_LIST_C;

import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
public class OTHEggHuntEvent {

    @SubscribeEvent
    public void mapManager(WorldEvent.Unload event) {
        if (!event.world.isRemote) OTH_EGG_HUNT_LIST_C.clear();
    }

}
