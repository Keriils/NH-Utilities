package com.xir.NHUtilities.common.blocks.metaBlockImpl;

import net.minecraft.block.Block;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.blocks.aBlockCore.MetaItemBlockBase;

public class MetaItemBlock01 extends MetaItemBlockBase {

    public MetaItemBlock01(Block block) {
        super(block);
        this.setCreativeTab(NHUCreativeTabs.metaBlock01Tab);
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaBlock01;
    }
}
