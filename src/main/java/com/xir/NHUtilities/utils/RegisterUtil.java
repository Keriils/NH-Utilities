package com.xir.NHUtilities.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;

import cpw.mods.fml.common.registry.GameRegistry;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public final class RegisterUtil {

    private RegisterUtil() {}

    public static Item registerItem(IRegisterProvider registerProvider) {
        return registerItem(registerProvider, true);
    }

    public static Item registerItem(IRegisterProvider registerProvider, boolean shouldRegister) {
        return registerItem((Item) registerProvider, registerProvider.getRegisterName(), shouldRegister);
    }

    public static Item registerItem(Item item, String itemName) {
        return registerItem(item, itemName, true);
    }

    public static Item registerItem(Item item, String itemName, boolean shouldRegister) {
        if (shouldRegister) return GameRegistry.registerItem(item, itemName, null);
        return null;
    }

    public static Block registerBlock(Block block, String blockName) {
        return registerBlock(block, blockName, true);
    }

    public static Block registerBlock(Block block, String blockName, boolean shouldRegister) {
        return registerBlock(block, null, blockName, shouldRegister);
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemClass, String blockName) {
        return registerBlock(block, itemClass, blockName, true);
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemClass, String blockName,
        boolean shouldRegister) {
        if (!shouldRegister) return null;
        if (itemClass == null) return GameRegistry.registerBlock(block, blockName);
        else return GameRegistry.registerBlock(block, itemClass, blockName);
    }

}
