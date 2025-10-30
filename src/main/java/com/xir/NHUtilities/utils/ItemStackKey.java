package com.xir.NHUtilities.utils;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregtech.api.util.GTUtility;
import lombok.NonNull;

public final class ItemStackKey {

    private final int hash;
    private final ItemStack itemStack;
    private static final int DEF_OFFSET = 16;

    // hash refer from ae
    public ItemStackKey(@NonNull ItemStack itemStack) {
        this.itemStack = itemStack;
        var nbt = itemStack.getTagCompound();
        this.hash = (Item.getIdFromItem(itemStack.getItem()) << DEF_OFFSET | Items.feather.getDamage(itemStack))
            ^ (nbt == null ? 0 : System.identityHashCode(nbt));
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemStackKey isk && GTUtility.areStacksEqual(isk.itemStack, itemStack, false);
    }
}
