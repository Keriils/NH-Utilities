package com.xir.NHUtilities.common.items.covers;

import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static java.lang.Long.min;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IWirelessEnergyHatchInformation;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.CoverBehavior;
import gregtech.api.util.ISerializableObject;

@SuppressWarnings("unused")
public class WirelessCovers {

    private WirelessCovers() {}

    // region Wireless Dynamo
    public static class CoverWirelessDynamo extends AbstractWirelessCover {

        public CoverWirelessDynamo(int voltage) {
            super(voltage);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt && bmt.getMetaTileEntity() instanceof MetaTileEntity mte) {
                var currentEU = mte.getEUVar();
                if (currentEU <= 0) return; // nothing to transfer
                var euToTransfer = min(currentEU, transferred_energy_per_operation);
                if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), euToTransfer)) {
                    bmt.decreaseStoredEnergyUnits(euToTransfer, true);
                }
            }
        }
    }
    // endregion

    // region Wireless Energy
    public static class CoverWirelessEnergy extends AbstractWirelessCover {

        public CoverWirelessEnergy(int voltage) {
            super(voltage);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt && bmt.getMetaTileEntity() instanceof MetaTileEntity mte) {
                var currentEU = mte.getEUVar();
                long euToTransfer = min(transferred_energy_per_operation - currentEU, transferred_energy_per_operation);
                if (euToTransfer <= 0) return; // nothing to transfer
                if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), -euToTransfer)) {
                    bmt.increaseStoredEnergyUnits(euToTransfer, true);
                }
            }
        }
    }
    // endregion

    // region AbstractWirelessCover
    public static abstract class AbstractWirelessCover extends CoverBehavior
        implements IWirelessEnergyHatchInformation {

        protected final long transferred_energy_per_operation;

        public AbstractWirelessCover(int voltage) {
            this.transferred_energy_per_operation = 2 * voltage * ticks_between_energy_addition;
        }

        @Override
        public int doCoverThings(ForgeDirection side, byte aInputRedStone, int aCoverID, int aCoverVariable,
            ICoverable aTileEntity, long aTimer) {
            if (aCoverVariable == 0 || aTimer % ticks_between_energy_addition == 0) {
                tryOperate(aTileEntity);
            }
            return 1;
        }

        protected abstract void tryOperate(ICoverable tileEntity);

        @Override
        public int getTickRate(ForgeDirection side, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
            return 10;
        }

        @Override
        public boolean allowsCopyPasteTool() {
            return false;
        }

        @Override
        public boolean allowsTickRateAddition() {
            return false;
        }

        @Override
        public boolean isRedstoneSensitive(ForgeDirection side, int aCoverID, int aCoverVariable,
            ICoverable aTileEntity, long aTimer) {
            return false;
        }

        @Override
        protected boolean onCoverRightClickImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity, EntityPlayer aPlayer, float aX,
            float aY, float aZ) {
            return false;
        }

        @Override
        public boolean alwaysLookConnected(ForgeDirection side, int aCoverID, int aCoverVariable,
            ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean isGUIClickableImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity) {
            return true;
        }
    }
    // endregion
}
