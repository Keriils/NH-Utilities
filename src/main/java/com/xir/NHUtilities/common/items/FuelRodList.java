package com.xir.NHUtilities.common.items;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;
import com.xir.NHUtilities.common.items.itemFuelRod.DepletedFuelRod;
import com.xir.NHUtilities.common.items.itemFuelRod.FuelRod;
import com.xir.NHUtilities.utils.RegisterUtils;

public class FuelRodList {

    public static ItemBasic ichorFuelRod;
    public static ItemBasic shadowFuelRod;

    public static ItemBasic ichorDroplet;
    public static ItemBasic primordialPearlDust;

    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium;
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium_2;
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium_4;

    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4;

    public static FuelRod fuelRodExcitedRadianceUranium;
    public static FuelRod fuelRodExcitedRadianceUranium_2;
    public static FuelRod fuelRodExcitedRadianceUranium_4;

    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium_2;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium_4;

    public static void fuelRodInit() {

        ichorFuelRod = new ItemBasic("ichorFuelRod");
        shadowFuelRod = new ItemBasic("radianceFuelRod");

        ichorDroplet = new ItemBasic("ichorDroplet");
        primordialPearlDust = new ItemBasic("primordialPearlDust");

        depletedFuelRodExcitedRadianceUranium = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium", 100);
        depletedFuelRodExcitedRadianceUranium_2 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_2", 200);
        depletedFuelRodExcitedRadianceUranium_4 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_4", 400);

        depletedFuelRodSuperExcitedPrimordialPearlPlutonium = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium",
            800);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2",
            1600);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4",
            3200);

        fuelRodExcitedRadianceUranium = new FuelRod(
            "fuelRodExcitedRadianceUranium",
            1,
            100,
            6,
            800,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium, 1));
        fuelRodExcitedRadianceUranium_2 = new FuelRod(
            "fuelRodExcitedRadianceUranium_2",
            2,
            400,
            36,
            1600,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium_2, 1));
        fuelRodExcitedRadianceUranium_4 = new FuelRod(
            "fuelRodExcitedRadianceUranium_4",
            4,
            1200,
            144,
            3200,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium_4, 1));

        fuelRodSuperExcitedPrimordialPearlPlutonium = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium",
            1,
            2000,
            80,
            6400,
            15000,
            1.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium_2 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_2",
            2,
            8000,
            480,
            12800,
            15000,
            3.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium_4 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_4",
            4,
            24000,
            1915,
            25600,
            15000,
            1.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4, 1));

        RegisterUtils.registerItem(ichorFuelRod);
        RegisterUtils.registerItem(shadowFuelRod);
        RegisterUtils.registerItem(ichorDroplet);
        RegisterUtils.registerItem(primordialPearlDust);

        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium_2);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium_4);

        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium_2);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium_4);

        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4);

        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium_2);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium_4);

    }
}
