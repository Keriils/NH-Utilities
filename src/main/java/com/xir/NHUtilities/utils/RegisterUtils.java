package com.xir.NHUtilities.utils;

import static com.xir.NHUtilities.main.ReferencedInfo.MOD_ID;

import net.minecraft.item.Item;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public final class RegisterUtils {

    private RegisterUtils() {}

    public static void registerItem(ItemBasic item) {
        GameRegistry.registerItem(item, item.getItemName(), MOD_ID);
    }

    public static void registerItem(ItemBasic item, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, item.getItemName(), MOD_ID);
    }

    public static void registerItem(Item item, String itemName) {
        GameRegistry.registerItem(item, itemName, MOD_ID);
    }

    public static void registerItem(Item item, String itemName, String modId) {
        GameRegistry.registerItem(item, itemName, modId);
    }

    public static void registerItem(Item item, String itemName, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, itemName, MOD_ID);
    }

    public static void registerItem(Item item, String itemName, String modId, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, itemName, modId);
    }

}
