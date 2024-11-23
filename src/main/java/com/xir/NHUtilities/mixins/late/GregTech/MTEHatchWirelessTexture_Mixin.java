package com.xir.NHUtilities.mixins.late.GregTech;

import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_EnergyMulti;
import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_WirelessMulti;

import gregtech.api.interfaces.ITexture;

@Mixin(value = GT_MetaTileEntity_Hatch_WirelessMulti.class, remap = false)
public abstract class MTEHatchWirelessTexture_Mixin extends GT_MetaTileEntity_Hatch_EnergyMulti {

    // no use
    public MTEHatchWirelessTexture_Mixin(int aID, String aName, String aNameRegional, int aTier, int aAmp) {
        super(aID, aName, aNameRegional, aTier, aAmp);
    }

    /**
     * @author Keriils_
     * @reason modify to new texture
     */
    @Overwrite
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }

    /**
     * @author Keriils_
     * @reason modify to new texture
     */
    @Overwrite
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }
}
