package com.xir.NHUtilities.common.blocks.metaBlockImpl;

import net.minecraft.item.ItemBlock;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.blocks.aBlockCore.MetaBlockBase;

public class MetaBlock01 extends MetaBlockBase {

    public MetaBlock01() {
        super("MetaBlock01");
        this.setCreativeTab(NHUCreativeTabs.metaBlock01Tab);
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return MetaItemBlock01.class;
    }

    @Override
    public void loadMetaItem() {
        addMetaItem("test_1", 1);
        addMetaItem("test_2", 2);
    }

    @Override
    public String getBlockName() {
        return "nhu.MetaBlock.01";
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaBlock01;
    }

    @Override
    public String getIconFolderName() {
        return "MetaBlock_01";
    }
}
