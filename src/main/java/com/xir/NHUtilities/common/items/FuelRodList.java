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
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium2;
    public static DepletedFuelRod depletedFuelRodExcitedRadianceUranium4;

    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium2;
    public static DepletedFuelRod depletedFuelRodSuperExcitedPrimordialPearlPlutonium4;

    public static FuelRod fuelRodExcitedRadianceUranium;
    public static FuelRod fuelRodExcitedRadianceUranium2;
    public static FuelRod fuelRodExcitedRadianceUranium4;

    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium2;
    public static FuelRod fuelRodSuperExcitedPrimordialPearlPlutonium4;

    public static void fuelRodInit() {

        ichorFuelRod = new ItemBasic("ichorFuelRod");
        shadowFuelRod = new ItemBasic("radianceFuelRod");

        ichorDroplet = new ItemBasic("ichorDroplet");
        primordialPearlDust = new ItemBasic("primordialPearlDust");

        depletedFuelRodExcitedRadianceUranium = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium", 100);
        depletedFuelRodExcitedRadianceUranium2 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_2", 200);
        depletedFuelRodExcitedRadianceUranium4 = new DepletedFuelRod("depletedFuelRodExcitedRadianceUranium_4", 400);

        depletedFuelRodSuperExcitedPrimordialPearlPlutonium = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium",
            800);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium2 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_2",
            1600);
        depletedFuelRodSuperExcitedPrimordialPearlPlutonium4 = new DepletedFuelRod(
            "depletedFuelRodSuperExcitedPrimordialPearlPlutonium_4",
            3200);

        fuelRodExcitedRadianceUranium = new FuelRod(
            "fuelRodExcitedRadianceUranium",
            1,
            20000,
            64,
            4000,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium, 1));
        fuelRodExcitedRadianceUranium2 = new FuelRod(
            "fuelRodExcitedRadianceUranium_2",
            2,
            20000,
            64,
            4000,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium2, 1));
        fuelRodExcitedRadianceUranium4 = new FuelRod(
            "fuelRodExcitedRadianceUranium_4",
            4,
            20000,
            64,
            4000,
            86400,
            0F,
            new ItemStack(depletedFuelRodExcitedRadianceUranium4, 1));

        fuelRodSuperExcitedPrimordialPearlPlutonium = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium",
            1,
            86000,
            80,
            12800,
            15000,
            6.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium2 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_2",
            2,
            86000,
            80,
            12800,
            15000,
            6.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium2, 1));
        fuelRodSuperExcitedPrimordialPearlPlutonium4 = new FuelRod(
            "fuelRodSuperExcitedPrimordialPearlPlutonium_4",
            4,
            86000,
            80,
            12800,
            15000,
            6.3F,
            new ItemStack(depletedFuelRodSuperExcitedPrimordialPearlPlutonium4, 1));

        RegisterUtils.registerItem(ichorFuelRod);
        RegisterUtils.registerItem(shadowFuelRod);
        RegisterUtils.registerItem(ichorDroplet);
        RegisterUtils.registerItem(primordialPearlDust);

        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium2);
        RegisterUtils.registerItem(depletedFuelRodExcitedRadianceUranium4);

        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium2);
        RegisterUtils.registerItem(fuelRodExcitedRadianceUranium4);

        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium2);
        RegisterUtils.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium4);

        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium2);
        RegisterUtils.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium4);

    }
}
