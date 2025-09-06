package com.xir.NHUtilities.common.items.covers;

import static gregtech.common.misc.WirelessNetworkManager.ticks_between_energy_addition;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;

import org.jetbrains.annotations.NotNull;

import com.google.common.io.ByteArrayDataInput;
import com.xir.NHUtilities.utils.CommonUtil;

import cpw.mods.fml.relauncher.Side;
import gregtech.api.covers.CoverContext;
import gregtech.api.interfaces.ITexture;
import gregtech.common.covers.Cover;
import io.netty.buffer.ByteBuf;

public class WirelessEnergyCover extends Cover {

    protected long energyEU = 0;
    protected final long mEUPower;
    protected final long maxEUPerOperation;
    protected final CoverEnergyType energyType;
    protected static final String KEY_ENERGY_EU = "energyEU";

    public WirelessEnergyCover(int voltage, int ampere, @NotNull CoverEnergyType energyType,
        @NotNull CoverContext context, @NotNull ITexture coverFGTexture) {
        super(context, coverFGTexture);
        this.energyType = energyType;
        this.mEUPower = (long) ampere * (long) voltage;
        this.maxEUPerOperation = ticks_between_energy_addition * mEUPower;
    }

    // region Data
    @Override
    protected void readDataFromNbt(NBTBase nbt) {
        NBTTagCompound tag = (NBTTagCompound) nbt;
        energyEU = tag.getLong(KEY_ENERGY_EU);
    }

    @Override
    protected void readDataFromPacket(ByteArrayDataInput byteData) {
        energyEU = byteData.readLong();
    }

    @Override
    protected @NotNull NBTBase saveDataToNbt() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setLong(KEY_ENERGY_EU, energyEU);
        return tag;
    }

    @Override
    protected void writeDataToByteBuf(ByteBuf byteBuf) {
        byteBuf.writeLong(energyEU);
    }
    // endregion

    // region Ticking-logic
    @Override
    public void doCoverThings(byte aRedStone, long aTickTimer) {
        energyType.operate(this, aTickTimer);
    }

    @Override
    public void onPlayerAttach(EntityPlayer player, ItemStack coverItem) {
        energyType.placed(this, player, coverItem);
    }

    @Override
    public void onBaseTEDestroyed() {
        CommonUtil.sideApply(Side.SERVER, () -> energyType.baseTEDestroyed(this));
    }

    @Override
    public void onCoverRemoval() {
        CommonUtil.sideApply(Side.SERVER, () -> energyType.onRemoval(this));
    }

    @Override
    public boolean allowsTickRateAddition() {
        return false;
    }

    @Override
    public int getMinimumTickRate() {
        return 1;
    }
    // endregion

    // region Misc
    @Override
    public boolean allowsCopyPasteTool() {
        return false;
    }

    @Override
    public boolean alwaysLookConnected() {
        return true;
    }

    @Override
    public boolean letsRedstoneGoIn() {
        return true;
    }

    @Override
    public boolean letsRedstoneGoOut() {
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
    // endregion
}
