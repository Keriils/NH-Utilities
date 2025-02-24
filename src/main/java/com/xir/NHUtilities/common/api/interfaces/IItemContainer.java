package com.xir.NHUtilities.common.api.interfaces;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.interfaces.MTO.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public interface IItemContainer {

    Item getItem();

    Block getBlock();

    int getMeta();

    ItemStack get(int aAmount);

    default IItemContainer set(Block aBlock) {
        return set(Item.getItemFromBlock(aBlock));
    }

    default IItemContainer set(Item aItem) {
        if (aItem == null) return this;
        return set(CommonUtil.newItemStack(aItem));
    }

    IItemContainer set(ItemStack aItemStack);

    default IItemContainer setAndRegister(IRegisterProvider register, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        return this;
    }

    default IItemContainer setAndRegister(Object aObject, String aRegisterName, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        return this;
    }

    default IMetaTypeObject setMetaObject(Supplier<IMetaTypeObject> mtoSupplier) {
        return setMetaObject(true, mtoSupplier);
    }

    default IMetaTypeObject setMetaObject(boolean shouldRegister, Supplier<IMetaTypeObject> mtoSupplier) {
        if (!shouldRegister || mtoSupplier == null) return null;
        var metaTypeObject = mtoSupplier.get();
        if (metaTypeObject instanceof Block block) set(block);
        if (metaTypeObject instanceof Item item) set(item);
        return metaTypeObject;
    }

    void sanityCheck();

    boolean hasBeenSet();

}
