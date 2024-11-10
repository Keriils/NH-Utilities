package com.xir.NHUtilities.common.blocks.metaBlockImpl;

import net.minecraft.item.ItemBlock;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.blocks.aBlockCore.MetaBlockBase;

public class MetaBlock extends MetaBlockBase {

    public MetaBlock() {
        super("MetaBlock");
        this.setCreativeTab(NHUCreativeTabs.MetaBlockTab);
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return MetaItemBlock01.class;
    }

    @Override
    public void loadMetaItem() {
        addMetaItem("CreativeTab", 0);
        addMetaItem("test_1", 1);
        addMetaItem("test_2", 2);
    }

    @Override
    public String getRegisterName() {
        return "nhu.MetaBlock";
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaBlock;
    }

    @Override
    public String getIconFolderName() {
        return "MetaBlock";
    }
}
