package com.xir.NHUtilities.common.machine.hatch;

import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;
import static com.xir.NHUtilities.utils.CommonUtil.trans;
import static gregtech.api.enums.GTValues.V;
import static gregtech.api.util.GTUtility.formatNumbers;

import net.minecraft.util.EnumChatFormatting;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import tectech.thing.metaTileEntity.hatch.MTEHatchWirelessMulti;

public class MTEWirelessHatchEnergyMulti extends MTEHatchWirelessMulti {

    public MTEWirelessHatchEnergyMulti(int aID, String aName, String aNameRegional, int aTier, int aAmp) {
        super(aID, aName, aNameRegional, aTier, aAmp);
    }

    protected MTEWirelessHatchEnergyMulti(String aName, int aTier, int aAmp, String[] aDescription,
        ITexture[][][] aTextures) {
        super(aName, aTier, aAmp, aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEWirelessHatchEnergyMulti(mName, mTier, Amperes, new String[0], mTextures);
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }

    @Override
    public String[] getDescription() {
        return new String[] { EnumChatFormatting.GRAY + trans("Hatch.InfoData.desc.wireless.1"),
            EnumChatFormatting.GRAY + trans("Hatch.InfoData.desc.wireless.2"), trans("nhu.logotype.gt.logo"),
            EnumChatFormatting.GRAY + trans("Hatch.InfoData.desc.wireless.3")
                + EnumChatFormatting.YELLOW
                + formatNumbers(Amperes * V[mTier])
                + EnumChatFormatting.RESET
                + " EU/t" };
    }
}
