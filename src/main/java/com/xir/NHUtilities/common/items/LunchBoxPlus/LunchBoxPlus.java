package com.xir.NHUtilities.common.items.LunchBoxPlus;

import net.minecraft.creativetab.CreativeTabs;

import squeek.spiceoflife.inventory.NBTInventory;
import squeek.spiceoflife.items.ItemFoodContainer;

public class LunchBoxPlus extends ItemFoodContainer {

    private static final String LUNCH_BOX_PLUS = "LunchBoxPlus";
    private static final int LUNCH_BOX_PLUS_SLOT_NUM = 54;

    public LunchBoxPlus() {
        super(LUNCH_BOX_PLUS, LUNCH_BOX_PLUS_SLOT_NUM);

        setTextureName("nhutilities:" + this.itemName);
        setUnlocalizedName("NHUtilities:" + this.itemName);

        setCreativeTab(CreativeTabs.tabMisc);

    }

    @Override
    public int getInventoryStackLimit(NBTInventory inventory) {
        return 64;
    }
}
