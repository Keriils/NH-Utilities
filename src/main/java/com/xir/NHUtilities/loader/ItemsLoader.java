package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.items.ModsItemsList.KamiRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.ancientDragonEgg;
import static com.xir.NHUtilities.common.items.ModsItemsList.chaosDragonEgg;
import static com.xir.NHUtilities.common.items.ModsItemsList.eternityVial;
import static com.xir.NHUtilities.common.items.ModsItemsList.focusTape;
import static com.xir.NHUtilities.common.items.ModsItemsList.gluttonyRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.hungerRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.lunchBoxPlus;
import static com.xir.NHUtilities.common.items.ModsItemsList.metaItem01;
import static com.xir.NHUtilities.common.items.ModsItemsList.metaItemBlock01;
import static com.xir.NHUtilities.common.items.ModsItemsList.timeVial;
import static com.xir.NHUtilities.common.items.ModsItemsList.warpWardRing;
import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import com.xir.NHUtilities.common.items.FuelRodList;
import com.xir.NHUtilities.utils.RegisterUtil;

public class ItemsLoader {

    public static void registerNHUtilitiesItems() {

        FuelRodList.fuelRodInit();
        RegisterUtil.registerItem(gluttonyRing, enableGluttonyRingAndHungerRing);
        RegisterUtil.registerItem(hungerRing, enableGluttonyRingAndHungerRing);
        RegisterUtil.registerItem(KamiRing, true);
        RegisterUtil.registerItem(timeVial, enableTimeVial);
        RegisterUtil.registerItem(eternityVial, enableEternityVial);
        RegisterUtil.registerItem(lunchBoxPlus, "LunchBoxPlus", enableLunchBoxPlus);
        RegisterUtil.registerItem(focusTape, "focusTape");
        RegisterUtil.registerItem(warpWardRing, "warpRing");
        RegisterUtil.registerBlock(chaosDragonEgg, "ChaosDragonEgg");
        RegisterUtil.registerBlock(ancientDragonEgg, "AncientDragonEgg");

        metaItem01.initializeMetaTypeObject();
        metaItemBlock01.initializeMetaTypeObject();
    }

}
