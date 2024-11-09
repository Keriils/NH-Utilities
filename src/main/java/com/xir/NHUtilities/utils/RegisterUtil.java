package com.xir.NHUtilities.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.xir.NHUtilities.common.blocks.aBlockCore.BlockBase;
import com.xir.NHUtilities.common.items.aItemCore.ItemBase;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings("unused")
public final class RegisterUtil {

    private RegisterUtil() {}

    public static void registerItem(ItemBase item) {
        registerItem(item, item.getItemName(), true);
    }

    public static void registerItem(ItemBase item, boolean shouldRegister) {
        registerItem(item, item.getItemName(), shouldRegister);
    }

    public static void registerItem(Item item, String itemName) {
        registerItem(item, itemName, true);
    }

    public static void registerItem(Item item, String itemName, boolean shouldRegister) {
        if (shouldRegister) GameRegistry.registerItem(item, itemName);
    }

    public static void registerBlock(BlockBase block) {
        registerBlock(block, block.getBlockName());
    }

    public static void registerBlock(Block block, String blockName) {
        registerBlock(block, blockName, true);
    }

    public static void registerBlock(BlockBase block, boolean shouldRegister) {
        registerBlock(block, block.getBlockName(), shouldRegister);
    }

    public static void registerBlock(Block block, String blockName, boolean shouldRegister) {
        registerBlock(block, null, blockName, shouldRegister);
    }

    public static void registerBlock(BlockBase block, Class<? extends ItemBlock> itemClass) {
        registerBlock(block, itemClass, block.getBlockName());
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemClass, String blockName) {
        registerBlock(block, itemClass, blockName, true);
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemClass, String blockName,
        boolean shouldRegister) {
        if (!shouldRegister) return;
        if (itemClass == null) GameRegistry.registerBlock(block, blockName);
        else GameRegistry.registerBlock(block, itemClass, blockName);
    }

}
