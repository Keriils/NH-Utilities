package com.xir.NHUtilities.mixins.late.TecTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import tectech.loader.recipe.ResearchStationAssemblyLine;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ResearchStationAssemblyLine.class, remap = false)
public class BanOriginalWirelessRecipes_Mixin {

    /**
     * @author Keriils
     * @reason wireless hatch more!
     */
    @Overwrite
    private void addWirelessEnergyRecipes() {}

}
