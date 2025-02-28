package com.xir.NHUtilities.common.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.client.NEIAllHatchSort;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.config.Config;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class NHUCreativeTabs {

    private static final List<ItemStack> defaultMiscStack = new ArrayList<>();

    public static void addToDefaultCreativeTab(ItemStack stack) {
        defaultMiscStack.add(stack);
    }

    public static final CreativeTabs NHUCreativeTab = new CreativeTabs("nhutilities") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.EternityVial.getItem();
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void displayAllReleventItems(List<ItemStack> itemStackList) {
            itemStackList.addAll(defaultMiscStack);
            super.displayAllReleventItems(itemStackList);
        }
    };

    public static final CreativeTabs MetaItemTab = new CreativeTabs("metaItem") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.MetaItem.getItem();
        }
    };

    private static final List<ItemStack> wirelessThings = new ArrayList<>();

    public static void addToWirelessThingsCreativeTab(ItemStack stack) {
        wirelessThings.add(stack);
    }

    public static final CreativeTabs WirelessMisc = new CreativeTabs("wirelessThings") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return NHUItemList.WirelessCoverItem.getItem();
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void displayAllReleventItems(List<ItemStack> itemStackList) {
            super.displayAllReleventItems(itemStackList);
            if (NEIAllHatchSort.isInited) itemStackList.addAll(NEIAllHatchSort.ALL_SORTED_HATCH_ITEM_STACK);
            if (Config.enableOldRecipesOfWirelessHatch) itemStackList.addAll(wirelessThings);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public int func_151243_f() {
            return 14;
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
