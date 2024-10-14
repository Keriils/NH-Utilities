package com.xir.NHUtilities.common.items.aCreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.items.ModsItemsList;

public class NHUCreativeTab extends CreativeTabs {

    public NHUCreativeTab() {
        super("nhutilities");
    }

    @Override
    public Item getTabIconItem() {
        return ModsItemsList.eternityVial;
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}
