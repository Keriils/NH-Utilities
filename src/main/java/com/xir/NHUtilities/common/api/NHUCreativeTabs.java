package com.xir.NHUtilities.common.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.items.ModsItemsList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NHUCreativeTabs {

    public static final CreativeTabs nhuCreativeTab = new CreativeTabs("nhutilities") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModsItemsList.eternityVial;
        }
    };

    public static final CreativeTabs metaItem01Tab = new CreativeTabs("metaItem01") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ModsItemsList.metaItem01;
        }
    };

    public static final CreativeTabs metaBlock01Tab = new CreativeTabs("metaBlock01") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModsItemsList.metaItemBlock01);
        }
    };
}
