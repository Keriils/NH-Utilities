package com.xir.NHUtilities.common.machine.hatch;

import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;
import static gregtech.api.enums.GT_Values.V;
import static gregtech.api.util.GT_Utility.formatNumbers;
import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static gregtech.common.misc.WirelessNetworkManager.strongCheckOrAddUser;

import java.util.UUID;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;

import com.github.technus.tectech.thing.metaTileEntity.hatch.GT_MetaTileEntity_Hatch_DynamoMulti;
import com.xir.NHUtilities.utils.CommonUtil;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.interfaces.tileentity.IWirelessEnergyHatchInformation;
import gregtech.api.metatileentity.MetaTileEntity;

public class MTEWirelessHatchDynamoMulti extends GT_MetaTileEntity_Hatch_DynamoMulti
    implements IWirelessEnergyHatchInformation {

    // region Constructor
    public MTEWirelessHatchDynamoMulti(int aID, String aName, String aNameRegional, int aTier, int aAmp) {
        super(aID, aName, aNameRegional, aTier, aAmp);
    }

    protected MTEWirelessHatchDynamoMulti(String aName, int aTier, int aAmp, ITexture[][][] aTextures) {
        super(aName, aTier, aAmp, new String[0], aTextures);
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

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEWirelessHatchDynamoMulti(mName, mTier, Amperes, mTextures);
    }
    // endregion

    // region Logic
    @Override
    public boolean isEnetOutput() {
        return false;
    }

    @Override
    public boolean isOutputFacing(ForgeDirection side) {
        return false;
    }

    @Override
    public long getMinimumStoredEU() {
        return 2 * V[mTier];
    }

    @Override
    public long maxEUStore() {
        return totalStorage(V[mTier]) * Amperes / 2;
    }

    @Override
    public ConnectionType getConnectionType() {
        return ConnectionType.WIRELESS;
    }

    private UUID owner_uuid;

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPreTick(aBaseMetaTileEntity, aTick);

        if (aBaseMetaTileEntity.isServerSide()) {

            // On first tick find the player name and attempt to add them to the map.
            if (aTick == 1) {

                // UUID and username of the owner.
                owner_uuid = aBaseMetaTileEntity.getOwnerUuid();

                strongCheckOrAddUser(owner_uuid);
            }

            // Every ticks_between_energy_addition ticks change the energy content of the machine.
            if (aTick % ticks_between_energy_addition == 0L) {
                addEUToGlobalEnergyMap(owner_uuid, getEUVar());
                setEUVar(0L);
            }
        }
    }
    // endregion

    // region Texture
    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[] { aBaseTexture, getWirelessTex(Amperes) };
    }
    // endregion
}
