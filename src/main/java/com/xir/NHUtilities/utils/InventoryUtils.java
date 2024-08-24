package com.xir.NHUtilities.utils;

import static com.xir.NHUtilities.main.NHUtilities.BAUBLES_MOD_IS_LOADED;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import baubles.common.lib.PlayerHandler;

/**
 * referenced draconic evolution
 */
public final class InventoryUtils {

    private InventoryUtils() {}

    public static Optional<ItemStack> getItemInAnyPlayerInventory(EntityPlayer player,
        Class<? extends Item> itemClass) {
        if (BAUBLES_MOD_IS_LOADED) {
            Optional<ItemStack> itemInBaubles = getItemInPlayerBaublesInventory(player, itemClass);
            if (itemInBaubles.isPresent()) {
                return itemInBaubles;
            }
        }
        return getItemInPlayerInventory(player, itemClass);
    }

    public static Optional<ItemStack> getItemInPlayerInventory(EntityPlayer player, Class<? extends Item> itemClass) {
        if (itemClass != null) {
            for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                ItemStack itemStack = player.inventory.getStackInSlot(i);

                if (itemStack != null && itemClass.isInstance(itemStack.getItem())) {
                    return Optional.of(itemStack);
                }
            }
        }
        return Optional.empty();
    }

    public static Optional<ItemStack> getItemInPlayerBaublesInventory(EntityPlayer player,
        Class<? extends Item> itemClass) {
        if (BAUBLES_MOD_IS_LOADED && itemClass != null) {
            for (int i = 0; i < PlayerHandler.getPlayerBaubles(player)
                .getSizeInventory(); i++) {
                ItemStack itemStack = PlayerHandler.getPlayerBaubles(player)
                    .getStackInSlot(i);
                if (itemStack != null && itemClass.isInstance(itemStack.getItem())) {
                    return Optional.of(itemStack);
                }
            }
        }
        return Optional.empty();
    }
}
