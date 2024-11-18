package com.xir.NHUtilities.common.items.lunchBoxPlus;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;

import squeek.spiceoflife.inventory.NBTInventory;
import squeek.spiceoflife.items.ItemFoodContainer;

public class LunchBoxPlus extends ItemFoodContainer implements IRegisterProvider {

    private static final String LUNCH_BOX_PLUS = "LunchBoxPlus";
    private static final int LUNCH_BOX_PLUS_SLOT_NUM = 54;

    public LunchBoxPlus() {
        super(LUNCH_BOX_PLUS, LUNCH_BOX_PLUS_SLOT_NUM);

        setTextureName("nhutilities:" + this.itemName);
        setUnlocalizedName(this.itemName);

        setCreativeTab(NHUCreativeTabs.NHUCreativeTab);

    }

    @Override
    public int getInventoryStackLimit(NBTInventory inventory) {
        return 64;
    }

    @Override
    public String getRegisterName() {
        return LUNCH_BOX_PLUS;
    }
}
