package com.xir.NHUtilities.common.items.metaItemImpl;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.items.aItemCore.MetaItemBase;

public class MetaItem01 extends MetaItemBase {

    public MetaItem01() {
        super("MetaItem01");
        this.setCreativeTab(NHUCreativeTabs.metaItem01Tab);
    }

    @Override
    public void loadMetaItem() {
        addMetaItem("s1", 1);
        addMetaItem("s2", 2);
        addMetaItem("s3", 3);
    }

    @Override
    public String getItemName() {
        return "nhu.MetaItem.01";
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaItem01;
    }

    @Override
    public String getIconFolderName() {
        return "MetaItem_01";
    }
}
