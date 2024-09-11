package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodPrimordialPearlPlutonium;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodPrimordialPearlPlutonium_2;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodPrimordialPearlPlutonium_4;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodRadianceUranium;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodRadianceUranium_2;
import static com.xir.NHUtilities.common.items.FuelFod.depletedFuelRodRadianceUranium_4;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodPrimordialPearlPlutonium;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodPrimordialPearlPlutonium_2;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodPrimordialPearlPlutonium_4;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodRadianceUranium;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodRadianceUranium_2;
import static com.xir.NHUtilities.common.items.FuelFod.fuelRodRadianceUranium_4;
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

        RegisterUtils.registerItem(depletedFuelRodRadianceUranium);
        RegisterUtils.registerItem(depletedFuelRodRadianceUranium_2);
        RegisterUtils.registerItem(depletedFuelRodRadianceUranium_4);

        RegisterUtils.registerItem(depletedFuelRodPrimordialPearlPlutonium);
        RegisterUtils.registerItem(depletedFuelRodPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(depletedFuelRodPrimordialPearlPlutonium_4);

        RegisterUtils.registerItem(fuelRodRadianceUranium);
        RegisterUtils.registerItem(fuelRodRadianceUranium_2);
        RegisterUtils.registerItem(fuelRodRadianceUranium_4);

        RegisterUtils.registerItem(fuelRodPrimordialPearlPlutonium);
        RegisterUtils.registerItem(fuelRodPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(fuelRodPrimordialPearlPlutonium_4);
    }

}
