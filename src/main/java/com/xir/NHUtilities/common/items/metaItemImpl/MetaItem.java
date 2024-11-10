package com.xir.NHUtilities.common.items.metaItemImpl;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.items.aItemCore.MetaItemBase;

public class MetaItem extends MetaItemBase {

    public MetaItem() {
        super("MetaItem");
        this.setCreativeTab(NHUCreativeTabs.MetaItemTab);
    }

    @Override
    public void loadMetaItem() {
        // addMetaItem("CreativeTab", 0);

        NHUItemList.IchorFuelRod.set(addMetaItem("IchorFuelRod", 0));
        NHUItemList.ShadowFuelRod.set(addMetaItem("ShadowFuelRod", 1));
        NHUItemList.IchorDroplet.set(addMetaItem("IchorDroplet", 2));
        NHUItemList.PrimordialPearlDust.set(addMetaItem("PrimordialPearlDust", 3));

    }

    @Override
    public String getRegisterName() {
        return "nhu.MetaItem";
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaItem;
    }

    @Override
    public String getIconFolderName() {
        return "MetaItem";
    }
}
