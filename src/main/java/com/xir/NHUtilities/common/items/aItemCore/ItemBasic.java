package com.xir.NHUtilities.common.items.aItemCore;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The aim is to simplify some writing as well as others
 */
public class ItemBasic extends Item {

    private static final String MODID = "item.NHUtilities:";
    private String unlocalizedName;

    @Override
    public Item setTextureName(String TextureName) {
        this.iconString = "nhutilities:" + TextureName;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getIconString() {
        return this.iconString == null
            ? "MISSING_ICON_ITEM_" + itemRegistry.getIDForObject(this) + "_" + this.unlocalizedName
            : this.iconString;
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
        return this;
    }

    @Override
    public String getUnlocalizedName() {
        return MODID + this.unlocalizedName;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }
}
