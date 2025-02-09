package com.xir.NHUtilities.common.blocks.metaBlockImpl;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.blocks.aBlockCore.MetaBlockBase;

public class MetaBlock extends MetaBlockBase {

    public MetaBlock() {
        super("MetaBlock");
        this.setCreativeTab(NHUCreativeTabs.MetaBlockTab);
    }

    public void loadMetaItem() {
        NHUItemList.EggMachineBlock.set(addMetaItem("EggMachineBlock", 0));
    }

}
