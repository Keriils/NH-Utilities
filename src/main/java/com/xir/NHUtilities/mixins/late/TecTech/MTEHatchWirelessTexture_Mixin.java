package com.xir.NHUtilities.mixins.late.TecTech;

import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import gregtech.api.interfaces.ITexture;
import tectech.thing.metaTileEntity.hatch.MTEHatchEnergyMulti;
import tectech.thing.metaTileEntity.hatch.MTEHatchWirelessMulti;

@SuppressWarnings("UnusedMixin")
@Mixin(value = MTEHatchWirelessMulti.class, remap = false)
public abstract class MTEHatchWirelessTexture_Mixin extends MTEHatchEnergyMulti {

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
