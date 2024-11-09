package com.xir.NHUtilities.common.blocks.aBlockCore;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.nhuCreativeTab;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.interfaces.IMetaObjectProvider;

import gregtech.api.util.GTLanguageManager;

public abstract class MetaItemBlockBase extends ItemBlock implements IMetaObjectProvider {

    public final String mNoMobsToolTip = GTLanguageManager
        .addStringLocalization("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    public final String mNoTileEntityToolTip = GTLanguageManager
        .addStringLocalization("gt.notileentityinthisblock", "This is NOT a TileEntity!");

    public MetaItemBlockBase(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(nhuCreativeTab);
    }

    /**
     * return the MetaTypeManager registered in {@link MetaTypeManager}
     */
    @Override
    public abstract MetaTypeManager getMTManager();

    @Override
    public int getMetadata(int aMeta) {
        return aMeta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        Map<Integer, String> metaNameMap = getMTManager().getNameMap();
        return getUnlocalizedName() + (metaNameMap.containsKey(meta) ? meta : "NULL");
    }

    @Override
    public ItemBlock setUnlocalizedName(String p_77655_1_) {
        return super.setUnlocalizedName(p_77655_1_);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> aList, boolean b3h) {
        int meta = itemStack.getItemDamage();
        String[] tooltip = getMTManager().getTooltipsMap()
            .get(meta);
        if (tooltip != null) aList.addAll(Arrays.asList(tooltip));
        aList.add(this.mNoMobsToolTip);
        aList.add(this.mNoTileEntityToolTip);
    }
}
