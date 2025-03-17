package com.xir.NHUtilities.common.items.covers;

import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static java.lang.Long.min;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;

import com.xir.NHUtilities.common.api.interfaces.mixinHelper.IWirelessCoverEnergyProvider;

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

        public CoverWirelessDynamo(int voltage, int ampere) {
            super(voltage, ampere);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt && bmt.getMetaTileEntity() instanceof MetaTileEntity mte) {
                var isEnergyProvider = bmt instanceof IWirelessCoverEnergyProvider provider;
                var currentEU = isEnergyProvider ? ((IWirelessCoverEnergyProvider) bmt).getEnergyToTransfer()
                    : mte.getEUVar();
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

        public CoverWirelessEnergy(int voltage, int ampere) {
            super(voltage, ampere);
        }

        @Override
        protected void tryOperate(ICoverable tileEntity) {
            if (tileEntity instanceof BaseMetaTileEntity bmt && bmt.getMetaTileEntity() instanceof MetaTileEntity mte) {
                var currentEU = mte.getEUVar();
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
    public static abstract class AbstractWirelessCover extends CoverBehavior
        implements IWirelessEnergyHatchInformation {

        protected final long transferred_energy_per_operation;

        public AbstractWirelessCover(int voltage, int ampere) {
            this.transferred_energy_per_operation = ticks_between_energy_addition * (long) ampere * (long) voltage;
        }

        @Override
        public int doCoverThings(ForgeDirection side, byte aInputRedStone, int aCoverID, int aCoverVariable,
            ICoverable aTileEntity, long aTimer) {
            if (aCoverVariable == 0 || aTimer % ticks_between_energy_addition == 0) {
                tryOperate(aTileEntity);
            }
            return 1;
        }

        @Override
        protected void onBaseTEDestroyedImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity) {
            tryOperate(aTileEntity);
        }

        @Override
        protected boolean onCoverRemovalImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity, boolean aForced) {
            tryOperate(aTileEntity);
            return super.onCoverRemovalImpl(side, aCoverID, aCoverVariable, aTileEntity, aForced);
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

        @Override
        protected boolean letsEnergyOutImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean letsEnergyInImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean letsItemsInImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, int aSlot, ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean letsItemsOutImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, int aSlot, ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean letsFluidInImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, Fluid aFluid, ICoverable aTileEntity) {
            return true;
        }

        @Override
        protected boolean letsFluidOutImpl(ForgeDirection side, int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable, Fluid aFluid, ICoverable aTileEntity) {
            return true;
        }
    }
    // endregion
}
