package com.xir.NHUtilities.utils;

import net.minecraft.item.Item;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public final class RegisterUtils {

    private RegisterUtils() {}

    public static void registerItem(ItemBasic item) {
        GameRegistry.registerItem(item, item.getItemName());
    }

    public static void registerItem(ItemBasic item, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, item.getItemName());
    }

    public static void registerItem(Item item, String itemName) {
        GameRegistry.registerItem(item, itemName);
    }

    public static void registerItem(Item item, String itemName, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, itemName);
    }

}
