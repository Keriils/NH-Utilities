package com.xir.NHUtilities.common.items.aItemCore;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The aim is to simplify some writing as well as others
 */
public class ItemBasic extends Item {

    private static final String ITEM_LANG_KEY_STRING = "item.NHUtilities:";
    private String name;

    public ItemBasic(String name) {
        this.name = name;
        this.setTextureName(name);
    }

    @Override
    public Item setTextureName(String TextureName) {
        this.iconString = "nhutilities:" + TextureName;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getIconString() {
        return this.iconString == null ? "MISSING_ICON_ITEM_" + itemRegistry.getIDForObject(this) + "_" + this.name
            : this.iconString;
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        this.name = unlocalizedName;
        return this;
    }

    @Override
    public String getUnlocalizedName() {
        return ITEM_LANG_KEY_STRING + this.name;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

    public String getItemName() {
        return this.name;
    }
}
