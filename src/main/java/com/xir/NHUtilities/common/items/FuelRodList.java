package com.xir.NHUtilities.common.items;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.aItemCore.ItemBase;
import com.xir.NHUtilities.common.items.itemFuelRod.DepletedFuelRod;
import com.xir.NHUtilities.common.items.itemFuelRod.FuelRod;
import com.xir.NHUtilities.utils.RegisterUtil;

public class FuelRodList {

    public static ItemBase ichorFuelRod;
    public static ItemBase shadowFuelRod;

    public static ItemBase ichorDroplet;
    public static ItemBase primordialPearlDust;

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

        ichorFuelRod = new ItemBase("ichorFuelRod");
        shadowFuelRod = new ItemBase("radianceFuelRod");

        ichorDroplet = new ItemBase("ichorDroplet");
        primordialPearlDust = new ItemBase("primordialPearlDust");

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

        RegisterUtil.registerItem(ichorFuelRod);
        RegisterUtil.registerItem(shadowFuelRod);
        RegisterUtil.registerItem(ichorDroplet);
        RegisterUtil.registerItem(primordialPearlDust);

        RegisterUtil.registerItem(depletedFuelRodExcitedRadianceUranium);
        RegisterUtil.registerItem(depletedFuelRodExcitedRadianceUranium2);
        RegisterUtil.registerItem(depletedFuelRodExcitedRadianceUranium4);

        RegisterUtil.registerItem(fuelRodExcitedRadianceUranium);
        RegisterUtil.registerItem(fuelRodExcitedRadianceUranium2);
        RegisterUtil.registerItem(fuelRodExcitedRadianceUranium4);

        RegisterUtil.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtil.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium2);
        RegisterUtil.registerItem(depletedFuelRodSuperExcitedPrimordialPearlPlutonium4);

        RegisterUtil.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium);
        RegisterUtil.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium2);
        RegisterUtil.registerItem(fuelRodSuperExcitedPrimordialPearlPlutonium4);

    }
}
