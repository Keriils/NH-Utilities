package com.xir.NHUtilities.mixins.late.GregTech;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.xir.NHUtilities.common.api.interfaces.mixinHelper.IWirelessCoverEnergyProvider;
import com.xir.NHUtilities.common.items.covers.WirelessCovers;

import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.CommonMetaTileEntity;

@Mixin(value = BaseMetaTileEntity.class, remap = false)
@SuppressWarnings({ "UnusedMixin", "DiscouragedShift" })
public abstract class BaseMetaTileEntityWirelessCover_Mixin extends CommonMetaTileEntity
    implements IWirelessCoverEnergyProvider {

    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    public long getEnergyToTransfer() {
        return NHUtilities$wirelessEnergyCache;
    }

    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    public void setEnergyCache(long value) {
        if (value <= 0) value = 0;
        this.NHUtilities$wirelessEnergyCache = value;
    }

    @Accessor("mStoredEnergy")
    public abstract long getFieldStoredEnergy();

    @Accessor("mStoredEnergy")
    public abstract void setFieldStoredEnergy(long value);

    @Unique
    private long NHUtilities$wirelessEnergyCache = 0;

    @Inject(
        method = "updateEntity",
        at = @At(
            value = "INVOKE",
            target = "Lgregtech/api/metatileentity/MetaTileEntity;onPreTick(Lgregtech/api/interfaces/tileentity/IGregTechTileEntity;J)V",
            shift = At.Shift.BEFORE),
        require = 1)
    private void NHUtilities$wirelessCover(CallbackInfo ci) {
        for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
            if (getCoverInfoAtSide(side).getCoverBehavior() instanceof WirelessCovers.CoverWirelessDynamo) {
                NHUtilities$dumpEnergyToWirelessCache();
                break;
            }
        }
    }

    @Unique
    private void NHUtilities$dumpEnergyToWirelessCache() {
        long energy = this.getFieldStoredEnergy();
        if (energy <= 0) return;
        NHUtilities$wirelessEnergyCache += energy;
        this.setFieldStoredEnergy(0);
    }

    @Inject(
        method = "writeToNBT",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/nbt/NBTTagCompound;setLong(Ljava/lang/String;J)V",
            ordinal = 1,
            shift = At.Shift.BEFORE),
        require = 1,
        remap = true)
    private void NHUtilities$saveNBT(NBTTagCompound nbt, CallbackInfo ci) {
        nbt.setLong("wirelessEnergyCache", NHUtilities$wirelessEnergyCache);
    }

    @Inject(
        method = "setInitialValuesAsNBT",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/nbt/NBTTagCompound;getLong(Ljava/lang/String;)J",
            ordinal = 1,
            shift = At.Shift.BEFORE),
        require = 1,
        remap = true)
    private void NHUtilities$readNBT(NBTTagCompound aNBT, short aID, CallbackInfo ci) {
        NHUtilities$wirelessEnergyCache = aNBT.getLong("wirelessEnergyCache");
    }

}
