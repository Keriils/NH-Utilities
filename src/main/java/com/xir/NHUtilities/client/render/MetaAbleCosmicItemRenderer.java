package com.xir.NHUtilities.client.render;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.metaItemImpl.MetaItem;

import fox.spiteful.avaritia.render.CosmicItemRenderer;

public class MetaAbleCosmicItemRenderer extends CosmicItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
        if (itemStack.getItem() instanceof MetaItem) {
            int itemDamage = itemStack.getItemDamage();
            return itemDamage == 121 || itemDamage == 131;
        }
        return true;
    }
}
