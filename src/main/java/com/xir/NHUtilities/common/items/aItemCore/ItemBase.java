package com.xir.NHUtilities.common.items.aItemCore;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.nhuCreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The aim is to simplify some writing as well as others
 */
@SuppressWarnings("unused")
public class ItemBase extends Item {

    protected static final String ITEM_LANG_KEY_STRING = "item.NHUtilities:";
    protected String name;

    public ItemBase() {
        this("_null_", nhuCreativeTab);
    }

    public ItemBase(String name) {
        this(name, nhuCreativeTab);
    }

    public ItemBase(String name, CreativeTabs creativeTabs) {
        this.setTextureName(this.name = name);
        this.setCreativeTab(creativeTabs);
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
