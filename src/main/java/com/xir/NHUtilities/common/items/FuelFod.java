package com.xir.NHUtilities.common.items;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.itemFuelRod.DepletedFuelRod;
import com.xir.NHUtilities.common.items.itemFuelRod.FuelRod;

public class FuelFod {

    public static final DepletedFuelRod depletedFuelRodRadianceUranium;
    public static final DepletedFuelRod depletedFuelRodRadianceUranium_2;
    public static final DepletedFuelRod depletedFuelRodRadianceUranium_4;

    public static final DepletedFuelRod depletedFuelRodPrimordialPearlPlutonium;
    public static final DepletedFuelRod depletedFuelRodPrimordialPearlPlutonium_2;
    public static final DepletedFuelRod depletedFuelRodPrimordialPearlPlutonium_4;

    public static final FuelRod fuelRodRadianceUranium;
    public static final FuelRod fuelRodRadianceUranium_2;
    public static final FuelRod fuelRodRadianceUranium_4;

    public static final FuelRod fuelRodPrimordialPearlPlutonium;
    public static final FuelRod fuelRodPrimordialPearlPlutonium_2;
    public static final FuelRod fuelRodPrimordialPearlPlutonium_4;

    static {

        depletedFuelRodRadianceUranium = new DepletedFuelRod("depletedFuelRodRadianceUranium", 100);
        depletedFuelRodRadianceUranium_2 = new DepletedFuelRod("depletedFuelRodRadianceUranium_2", 200);
        depletedFuelRodRadianceUranium_4 = new DepletedFuelRod("depletedFuelRodRadianceUranium_4", 400);

        depletedFuelRodPrimordialPearlPlutonium = new DepletedFuelRod("depletedFuelRodPrimordialPearlPlutonium", 800);
        depletedFuelRodPrimordialPearlPlutonium_2 = new DepletedFuelRod(
            "depletedFuelRodPrimordialPearlPlutonium_2",
            1600);
        depletedFuelRodPrimordialPearlPlutonium_4 = new DepletedFuelRod(
            "depletedFuelRodPrimordialPearlPlutonium_4",
            3200);

        fuelRodRadianceUranium = new FuelRod(
            "fuelRodRadianceUranium",
            1,
            150,
            6,
            800,
            70000,
            0F,
            new ItemStack(depletedFuelRodRadianceUranium, 1));
        fuelRodRadianceUranium_2 = new FuelRod(
            "fuelRodRadianceUranium_2",
            2,
            600,
            36,
            1600,
            70000,
            0F,
            new ItemStack(depletedFuelRodRadianceUranium_2, 1));
        fuelRodRadianceUranium_4 = new FuelRod(
            "fuelRodRadianceUranium_4",
            4,
            1800,
            144,
            3200,
            70000,
            0F,
            new ItemStack(depletedFuelRodRadianceUranium_4, 1));

        fuelRodPrimordialPearlPlutonium = new FuelRod(
            "fuelRodPrimordialPearlPlutonium",
            1,
            3200,
            128,
            6400,
            10000,
            3.3F,
            new ItemStack(depletedFuelRodPrimordialPearlPlutonium, 1));
        fuelRodPrimordialPearlPlutonium_2 = new FuelRod(
            "fuelRodPrimordialPearlPlutonium_2",
            2,
            12800,
            768,
            12800,
            10000,
            3.3F,
            new ItemStack(depletedFuelRodPrimordialPearlPlutonium_2, 1));
        fuelRodPrimordialPearlPlutonium_4 = new FuelRod(
            "fuelRodPrimordialPearlPlutonium_4",
            4,
            38400,
            3064,
            25600,
            10000,
            3.3F,
            new ItemStack(depletedFuelRodPrimordialPearlPlutonium_4, 1));
    }
}
