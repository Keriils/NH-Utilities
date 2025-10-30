package com.xir.NHUtilities.common.items.lunchBoxPlus;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.NHUCreativeTab;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.utils.CommonUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLunchDispatcher extends ItemBlock {

    public ItemLunchDispatcher(Block block) {
        super(block);
        this.setCreativeTab(NHUCreativeTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean extraInformation) {
        super.addInformation(itemStack, player, list, extraInformation);
        list.add(CommonUtil.trans("text.lunchDispatcher.details_0"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_1"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_2"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_3"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_4"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_5"));
        list.add(CommonUtil.trans("text.lunchDispatcher.details_6"));

    }
}
