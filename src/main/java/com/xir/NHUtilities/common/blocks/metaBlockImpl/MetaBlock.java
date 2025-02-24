package com.xir.NHUtilities.common.blocks.metaBlockImpl;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.blocks.aBlockCore.MetaBlockBase;
import com.xir.NHUtilities.common.items.metaItemImpl.ILoadMetaItem;

public class MetaBlock extends MetaBlockBase implements ILoadMetaItem {

    public MetaBlock() {
        super("MetaBlock");
        this.setCreativeTab(NHUCreativeTabs.MetaBlockTab);
    }

    @Override
    public void loadMetaItem() {
        NHUItemList.EggMachineBlock.set(addMetaItem("EggMachineBlock", 0));
    }

}
