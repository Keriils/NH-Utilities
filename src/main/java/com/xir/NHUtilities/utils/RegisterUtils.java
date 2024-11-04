package com.xir.NHUtilities.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public final class RegisterUtils {

    private RegisterUtils() {}

    public static void registerItem(ItemBasic item) {
        registerItem(item, item.getItemName(), true);
    }

    public static void registerItem(ItemBasic item, boolean shouldRegister) {
        registerItem(item, item.getItemName(), shouldRegister);
    }

    public static void registerItem(Item item, String itemName) {
        registerItem(item, itemName, true);
    }

    public static void registerItem(Item item, String itemName, boolean shouldRegister) {
        if (shouldRegister) {
            GameRegistry.registerItem(item, itemName);
        }
    }

    public static void registerBlock(Block block, String blockName) {
        registerBlock(block, blockName, true);
    }

    public static void registerBlock(Block block, String blockName, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerBlock(block, blockName);
    }

}
