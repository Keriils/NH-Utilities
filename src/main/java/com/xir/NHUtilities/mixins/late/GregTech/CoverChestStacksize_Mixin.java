package com.xir.NHUtilities.mixins.late.GregTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "gregtech.common.covers.CoverChest$LimitingItemStackHandler")
public abstract class CoverChestStacksize_Mixin {
    /**
     * @author ChromaPIE
     * @reason Unleash the stacksize of items in Item Holders from ONE
     */
    @Overwrite(remap = false)
    public int getSlotLimit(int slot) {
        return 64;
    }
}
