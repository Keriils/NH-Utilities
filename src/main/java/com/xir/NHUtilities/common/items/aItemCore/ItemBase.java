package com.xir.NHUtilities.common.items.aItemCore;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.NHUCreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The aim is to simplify some writing as well as others
 */
@SuppressWarnings("unused")
public class ItemBase extends Item implements IRegisterProvider {

    protected String name;
    protected String extraFolder;

    public ItemBase() {
        this("_null_", NHUCreativeTab);
    }

    public ItemBase(String name) {
        this(name, NHUCreativeTab);
    }

    public ItemBase(String name, CreativeTabs creativeTabs) {
        this.setTextureName(this.name = name);
        this.setCreativeTab(creativeTabs);
    }

    @Override
    public Item setTextureName(String textureName) {
        this.iconString = "nhutilities:" + textureName;
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
        return "item." + this.name;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

    @Override
    public String getRegisterName() {
        return this.name;
    }
}
