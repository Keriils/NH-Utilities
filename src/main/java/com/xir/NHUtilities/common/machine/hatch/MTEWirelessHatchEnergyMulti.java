package com.xir.NHUtilities.common.machine.hatch;

import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;
import static gregtech.api.enums.GT_Values.V;
import static gregtech.api.util.GT_Utility.formatNumbers;

import net.minecraft.util.EnumChatFormatting;

import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_WirelessMulti;
import com.xir.NHUtilities.utils.CommonUtil;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;

public class MTEWirelessHatchEnergyMulti extends GT_MetaTileEntity_Hatch_WirelessMulti {

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
        return new String[] { EnumChatFormatting.GRAY + CommonUtil.trans("Hatch.InfoData.desc.wireless.1"),
            EnumChatFormatting.GRAY + CommonUtil.trans("Hatch.InfoData.desc.wireless.2"),
            CommonUtil.trans("nhu.logotype.gt.logo"),
            EnumChatFormatting.GRAY + CommonUtil.trans("Hatch.InfoData.desc.wireless.3")
                + EnumChatFormatting.YELLOW
                + formatNumbers(Amperes * V[mTier])
                + EnumChatFormatting.RESET
                + " EU/t" };
    }
}
