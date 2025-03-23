package com.xir.NHUtilities.common.items.covers;

import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static gregtech.common.misc.WirelessNetworkManager.ticks_between_energy_addition;
import static java.lang.Long.min;

import net.minecraftforge.fluids.Fluid;

import com.xir.NHUtilities.common.api.interfaces.mixinHelper.IWirelessCoverEnergyProvider;

import gregtech.api.covers.CoverContext;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.common.covers.CoverLegacyData;

@SuppressWarnings("unused")
public class WirelessCovers {

    private WirelessCovers() {}

    // region Wireless Dynamo
    public static class CoverWirelessDynamo extends AbstractWirelessCover {

        public CoverWirelessDynamo(CoverContext context, int voltage, int ampere) {
            super(context, voltage, ampere);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt) {
                var isEnergyProvider = bmt instanceof IWirelessCoverEnergyProvider provider;
                var currentEU = isEnergyProvider ? ((IWirelessCoverEnergyProvider) bmt).getEnergyToTransfer()
                    : bmt.getStoredEUuncapped();
                if (currentEU <= 0) return; // nothing to transfer
                var euToTransfer = min(currentEU, transferred_energy_per_operation);
                if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), euToTransfer)) {
                    if (isEnergyProvider) {
                        ((IWirelessCoverEnergyProvider) bmt).setEnergyCache(currentEU - euToTransfer);
                    } else {
                        bmt.decreaseStoredEnergyUnits(euToTransfer, true);
                    }
                }
            }
        }
    }
    // endregion

    // region Wireless Energy
    public static class CoverWirelessEnergy extends AbstractWirelessCover {

        public CoverWirelessEnergy(CoverContext context, int voltage, int ampere) {
            super(context, voltage, ampere);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt) {
                var currentEU = bmt.getStoredEUuncapped();
                var euToTransfer = min(transferred_energy_per_operation - currentEU, transferred_energy_per_operation);
                if (euToTransfer <= 0) return; // nothing to transfer
                if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), -euToTransfer)) {
                    bmt.increaseStoredEnergyUnits(euToTransfer, true);
                }
            }
        }
    }
    // endregion

    // region AbstractWirelessCover
    public static abstract class AbstractWirelessCover extends CoverLegacyData {

        protected final long transferred_energy_per_operation;

        public AbstractWirelessCover(CoverContext context, int voltage, int ampere) {
            super(context);
            this.transferred_energy_per_operation = ticks_between_energy_addition * (long) ampere * (long) voltage;
        }

        @Override
        public void doCoverThings(byte aInputRedStone, long aTimer) {
            if (coverData == 0 || aTimer % ticks_between_energy_addition == 0) {
                tryOperate(coveredTile.get());
            }
        }

        @Override
        public void onBaseTEDestroyed() {
            tryOperate(coveredTile.get());
            super.onBaseTEDestroyed();
        }

        @Override
        public void onCoverRemoval() {
            tryOperate(coveredTile.get());
            super.onCoverRemoval();
        }

        protected abstract void tryOperate(ICoverable tileEntity);

        @Override
        public int getMinimumTickRate() {
            return 20;
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
        public boolean isRedstoneSensitive(long aTimer) {
            return false;
        }

        @Override
        public boolean alwaysLookConnected() {
            return true;
        }

        @Override
        public boolean letsEnergyIn() {
            return true;
        }

        @Override
        public boolean letsEnergyOut() {
            return true;
        }

        @Override
        public boolean letsFluidIn(Fluid fluid) {
            return true;
        }

        @Override
        public boolean letsFluidOut(Fluid fluid) {
            return true;
        }

        @Override
        public boolean letsItemsIn(int slot) {
            return true;
        }

        @Override
        public boolean letsItemsOut(int slot) {
            return true;
        }
    }
    // endregion
}
