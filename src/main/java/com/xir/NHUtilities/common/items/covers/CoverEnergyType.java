package com.xir.NHUtilities.common.items.covers;

import static gregtech.common.misc.WirelessNetworkManager.addEUToGlobalEnergyMap;
import static gregtech.common.misc.WirelessNetworkManager.ticks_between_energy_addition;
import static java.lang.Long.max;
import static java.lang.Long.min;

import java.util.function.BiConsumer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;

public enum CoverEnergyType {

    DYNAMO {

        @Override
        protected void placed(WirelessEnergyCover cover, EntityPlayer player, ItemStack coverItem) {
            bmtAction(cover, (bmt, mte) -> {
                var euToTransfer = min(mte.getEUVar(), cover.maxEUPerOperation);
                if (euToTransfer <= 0) return;
                pushEnergy(bmt, euToTransfer, () -> bmt.decreaseStoredEnergyUnits(euToTransfer, true));
            });
        }

        @Override
        protected void operate(WirelessEnergyCover cover, long machineTickTimer) {
            bmtAction(cover, (bmt, mte) -> {

                // tick operation
                var euToCache = min(mte.getEUVar(), cover.mEUPower);
                if (euToCache > 0 && (cover.energyEU + euToCache) <= cover.maxEUPerOperation) {
                    cover.energyEU += euToCache;
                    bmt.decreaseStoredEnergyUnits(euToCache, true);
                }

                // wireless sync
                if (cover.coverTimer % ticks_between_energy_addition == 0) {
                    cover.coverTimer = 0;
                    var euToTransfer = min(cover.energyEU, cover.maxEUPerOperation);
                    if (euToTransfer <= 0) return;
                    pushEnergy(bmt, euToTransfer, () -> cover.energyEU = max(cover.energyEU - euToTransfer, 0));
                }
            });
        }

        @Override
        public void onRemoval(WirelessEnergyCover cover) {
            if (cover.coverTile != null) cover.coverTile = null;
            if (cover.energyEU <= 0) return;
            bmtAction(cover, (bmt, mte) -> pushEnergy(bmt, min(cover.energyEU, cover.maxEUPerOperation), () -> {}));
        }
    },

    ENERGY {

        @Override
        protected void placed(WirelessEnergyCover cover, EntityPlayer player, ItemStack coverItem) {
            bmtAction(cover, (bmt, mte) -> pullEnergy(bmt, cover.maxEUPerOperation, () -> {
                cover.energyEU = cover.maxEUPerOperation;
                var euToMachineCache = min(bmt.getEUCapacity() - bmt.getStoredEU(), cover.mEUPower * 20L);
                if (euToMachineCache <= 0) return;
                cover.energyEU -= euToMachineCache;
                bmt.increaseStoredEnergyUnits(euToMachineCache, true);
            }));
        }

        @Override
        protected void operate(WirelessEnergyCover cover, long machineTickTimer) {
            bmtAction(cover, (bmt, mte) -> {

                // tick operation
                var euToMachineCache = min(
                    bmt.getEUCapacity() - bmt.getStoredEU(),
                    min(cover.mEUPower, cover.energyEU));
                if (euToMachineCache > 0) {
                    cover.energyEU -= euToMachineCache;
                    bmt.increaseStoredEnergyUnits(euToMachineCache, true);
                }

                // wireless sync
                if (cover.coverTimer % ticks_between_energy_addition == 0 && cover.energyEU < cover.maxEUPerOperation) {
                    cover.coverTimer = 0;
                    var euToTransfer = cover.maxEUPerOperation - cover.energyEU;
                    if (euToTransfer <= 0) return;
                    pullEnergy(bmt, euToTransfer, () -> cover.energyEU += euToTransfer);
                }
            });
        }

        @Override
        public void onRemoval(WirelessEnergyCover cover) {
            if (cover.coverTile != null) cover.coverTile = null;
            if (cover.energyEU <= 0) return;
            bmtAction(cover, (bmt, mte) -> pushEnergy(bmt, cover.energyEU, () -> {}));
        }
    };

    protected abstract void placed(WirelessEnergyCover cover, EntityPlayer player, ItemStack coverItem);

    protected abstract void operate(WirelessEnergyCover cover, long machineTickTimer);

    protected abstract void onRemoval(WirelessEnergyCover cover);

    protected void baseTEDestroyed(WirelessEnergyCover cover) {
        onRemoval(cover);
    }

    protected static void bmtAction(WirelessEnergyCover cover, BiConsumer<BaseMetaTileEntity, MetaTileEntity> action) {
        if (
            cover.coverTile instanceof BaseMetaTileEntity bmt && bmt.getMetaTileEntity() instanceof MetaTileEntity mte
        ) {
            action.accept(bmt, mte);
        }
    }

    protected static void pushEnergy(BaseMetaTileEntity bmt, long energy, Runnable action) {
        if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), energy)) {
            action.run();
        }
    }

    protected static void pullEnergy(BaseMetaTileEntity bmt, long energy, Runnable action) {
        if (addEUToGlobalEnergyMap(bmt.getOwnerUuid(), -energy)) {
            action.run();
        }
    }

}
