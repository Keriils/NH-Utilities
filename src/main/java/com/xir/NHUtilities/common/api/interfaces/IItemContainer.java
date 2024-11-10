package com.xir.NHUtilities.common.api.interfaces;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public interface IItemContainer {

    Item getItem();

    Block getBlock();

    int getMeta();

    ItemStack get(int aAmount);

    IItemContainer set(Item aItem);

    IItemContainer set(Block aBlock);

    IItemContainer set(ItemStack aItemStack);

    default IItemContainer setAndRegister(IRegisterProvider register, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        return this;
    }

    default IItemContainer setAndRegister(Object aObject, String aRegisterName, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        return this;
    }

    default IMetaTypeObject setMetaObject(IMetaTypeObject metaTypeObject) {
        if (metaTypeObject instanceof Block block) set(block);
        if (metaTypeObject instanceof Item item) set(item);
        return metaTypeObject;
    }

    void sanityCheck();

    boolean hasBeenSet();

}
