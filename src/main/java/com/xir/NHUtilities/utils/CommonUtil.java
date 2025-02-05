package com.xir.NHUtilities.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import cpw.mods.fml.common.FMLCommonHandler;

@SuppressWarnings("unused")
public class CommonUtil {

    private CommonUtil() {}

    public static String trans(String langKey) {
        return StatCollector.translateToLocal(langKey);
    }

    public static ItemStack copyAmount(int aAmount, Item aItem) {
        return copyAmount(aAmount, new ItemStack(aItem, 1, 0));
    }

    public static ItemStack copyAmount(int aAmount, ItemStack aItemStack) {
        ItemStack rStack = copy(aItemStack);
        if (rStack == null) return null;
        if (aAmount > 64 || aAmount < 0) aAmount = 111;
        return setItemStackSize(aAmount, rStack);
    }

    public static ItemStack setItemStackSize(int aAmount, ItemStack aItemStack) {
        aItemStack.stackSize = (byte) aAmount;
        return aItemStack;
    }

    public static ItemStack copy(ItemStack aItemStack) {
        if (isStackValid(aItemStack)) return aItemStack.copy();
        return null;
    }

    public static boolean isStackValid(ItemStack aItemStack) {
        return (aItemStack != null) && aItemStack.getItem() != null && aItemStack.stackSize >= 0;
    }

    public static boolean isStackInvalid(ItemStack aItemStack) {
        return aItemStack == null || aItemStack.getItem() == null || aItemStack.stackSize < 0;
    }

    public static boolean isClientSide() {
        return FMLCommonHandler.instance()
            .getSide()
            .isClient();
    }

    public static boolean isServerSide() {
        return FMLCommonHandler.instance()
            .getSide()
            .isServer();
    }

    @Contract(value = "_ -> new", pure = true)
    public static <T> StructureDefinition.@NotNull Builder<T> StructureDefinitionBuilder(Class<T> typeToken) {
        return StructureDefinition.builder();
    }

}
