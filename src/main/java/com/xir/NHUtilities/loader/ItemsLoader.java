package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.items.ModsItemsList.KamiRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.ancientDragonEgg;
import static com.xir.NHUtilities.common.items.ModsItemsList.chaosDragonEgg;
import static com.xir.NHUtilities.common.items.ModsItemsList.eternityVial;
import static com.xir.NHUtilities.common.items.ModsItemsList.focusTape;
import static com.xir.NHUtilities.common.items.ModsItemsList.gluttonyRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.hungerRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.lunchBoxPlus;
import static com.xir.NHUtilities.common.items.ModsItemsList.timeVial;
import static com.xir.NHUtilities.common.items.ModsItemsList.warpWardRing;
import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import com.xir.NHUtilities.common.items.FuelRodList;
import com.xir.NHUtilities.utils.RegisterUtils;

public class ItemsLoader {

    public static void registerNHUtilitiesItems() {

        FuelRodList.fuelRodInit();
        RegisterUtils.registerItem(gluttonyRing, enableGluttonyRingAndHungerRing);
        RegisterUtils.registerItem(hungerRing, enableGluttonyRingAndHungerRing);
        RegisterUtils.registerItem(KamiRing, true);
        RegisterUtils.registerItem(timeVial, enableTimeVial);
        RegisterUtils.registerItem(eternityVial, enableEternityVial);
        RegisterUtils.registerItem(lunchBoxPlus, "LunchBoxPlus", enableLunchBoxPlus);
        RegisterUtils.registerItem(focusTape, "focusTape");
        RegisterUtils.registerItem(warpWardRing, "warpRing");
        RegisterUtils.registerBlock(chaosDragonEgg, "ChaosDragonEgg");
        RegisterUtils.registerBlock(ancientDragonEgg, "AncientDragonEgg");
    }

}
