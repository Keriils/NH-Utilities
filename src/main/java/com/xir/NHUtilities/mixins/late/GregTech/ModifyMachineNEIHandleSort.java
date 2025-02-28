package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.client.NEIAllHatchSort.ALL_SORTED_HATCH_ITEM_STACK;
import static com.xir.NHUtilities.client.NEIAllHatchSort.ALL_SORTED_HATCH_META_ID_SET;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.xir.NHUtilities.client.NEIAllHatchSort;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.GregTechAPI;
import gregtech.common.blocks.BlockMachines;

@SuppressWarnings("UnusedMixin")
@Mixin(value = BlockMachines.class)
public class ModifyMachineNEIHandleSort {

    /**
     * @author Keriils
     * @reason wireless need
     */
    @Overwrite
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs aCreativeTab, List<ItemStack> outputSubBlocks) {
        if (NEIAllHatchSort.isInited) {
            for (int i = 1; i < GregTechAPI.METATILEENTITIES.length; i++) {
                if (GregTechAPI.METATILEENTITIES[i] != null && !ALL_SORTED_HATCH_META_ID_SET.contains(i)) {
                    outputSubBlocks.add(new ItemStack(item, 1, i));
                }
            }
            outputSubBlocks.addAll(ALL_SORTED_HATCH_ITEM_STACK);
        } else {
            for (int i = 1; i < GregTechAPI.METATILEENTITIES.length; i++) {
                if (GregTechAPI.METATILEENTITIES[i] != null) {
                    outputSubBlocks.add(new ItemStack(item, 1, i));
                }
            }

        }
    }

}
