package com.xir.NHUtilities.common.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.api.enums.NHUItemList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NHUCreativeTabs {

    public static final CreativeTabs NHUCreativeTab = new CreativeTabs("nhutilities") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.EternityVial.getItem();
        }
    };

    public static final CreativeTabs MetaItemTab = new CreativeTabs("metaItem") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.MetaItem.getItem();
        }
    };

    public static final CreativeTabs MetaBlockTab = new CreativeTabs("metaBlock") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.MetaBlock.getItem();
        }
    };
}
