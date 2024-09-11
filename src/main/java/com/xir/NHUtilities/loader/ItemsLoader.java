package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodExcitedRadianceUranium;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodExcitedRadianceUranium_2;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodExcitedRadianceUranium_4;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodSuperExcitedPrimordialPearlPlutonium;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodExcitedRadianceUranium;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodExcitedRadianceUranium_2;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodExcitedRadianceUranium_4;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodInit;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodSuperExcitedPrimordialPearlPlutonium;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodSuperExcitedPrimordialPearlPlutonium_2;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodSuperExcitedPrimordialPearlPlutonium_4;
import static com.xir.NHUtilities.common.items.ModsItemsList.eternityVial;
import static com.xir.NHUtilities.common.items.ModsItemsList.gluttonyRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.hungerRing;
import static com.xir.NHUtilities.common.items.ModsItemsList.lunchBoxPlus;
import static com.xir.NHUtilities.common.items.ModsItemsList.timeVial;
import static com.xir.NHUtilities.config.Config.enableEternityVial;
import static com.xir.NHUtilities.config.Config.enableGluttonyRingAndHungerRing;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import com.xir.NHUtilities.utils.RegisterUtils;

public class ItemsLoader {

    public static void registerNHUtilitiesItems() {

        RegisterUtils.registerItem(gluttonyRing, enableGluttonyRingAndHungerRing);
        RegisterUtils.registerItem(hungerRing, enableGluttonyRingAndHungerRing);
        RegisterUtils.registerItem(timeVial, enableTimeVial);
        RegisterUtils.registerItem(eternityVial, enableEternityVial);
        RegisterUtils.registerItem(lunchBoxPlus, "LunchBoxPlus", enableLunchBoxPlus);

    }

    public static void registerNHUtilitiesFuelRod() {

        fuelRodInit();

        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium_2);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium_4);

        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4);

        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium_2);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium_4);

        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium_4);
    }

}
