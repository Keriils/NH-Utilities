package com.xir.NHUtilities.common.machine.multi.MTEcore;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.ApiStatus;

import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizons.modularui.api.drawable.UITexture;
import com.gtnewhorizons.modularui.api.math.Pos2d;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEExtendedPowerMultiBlockBase;
import gregtech.api.recipe.RecipeMap;

public abstract class NHU_MTEBase<T extends NHU_MTEBase<T>> extends MTEExtendedPowerMultiBlockBase<T>
    implements IConstructable, ISurvivalConstructable {

    // region Constructor
    protected NHU_MTEBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    protected NHU_MTEBase(String aName) {
        super(aName);
    }
    // endregion

    // region ProcessLogic
    @Override
    @ApiStatus.OverrideOnly
    protected ProcessingLogic createProcessingLogic() {
        return null;
    }

    @Override
    @ApiStatus.OverrideOnly
    public RecipeMap<?> getRecipeMap() {
        return null;
    }

    @Override
    protected void setProcessingLogicPower(ProcessingLogic logic) {
        super.setProcessingLogicPower(logic);
    }

    @Override
    protected void setEnergyUsage(ProcessingLogic processingLogic) {
        super.setEnergyUsage(processingLogic);
    }

    @Override
    protected void setupProcessingLogic(ProcessingLogic logic) {
        super.setupProcessingLogic(logic);
    }

    @Override
    public void onFirstTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onFirstTick(aBaseMetaTileEntity);
    }

    @Override
    public void onPreTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPreTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public boolean onRunningTick(ItemStack aStack) {
        return super.onRunningTick(aStack);
    }

    @Override
    public void onTickFail(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onTickFail(aBaseMetaTileEntity, aTick);
    }

    @Override
    protected void runMachine(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.runMachine(aBaseMetaTileEntity, aTick);
    }
    // endregion

    // region Common Setting

    @Override
    protected boolean canUseControllerSlotForRecipe() {
        return false;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public boolean supportsBatchMode() {
        return true;
    }

    @Override
    public boolean supportsVoidProtection() {
        return true;
    }

    @Override
    public boolean supportsInputSeparation() {
        return true;
    }

    @Override
    public boolean supportsSingleRecipeLocking() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister aBlockIconRegister) {}

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
    }
    // endregion

    // region Standardize the setting of machine mode
    @Override
    public boolean supportsMachineModeSwitch() {
        return super.supportsMachineModeSwitch();
    }

    @Override
    public void setMachineMode(int index) {
        super.setMachineMode(index);
    }

    @Override
    public int nextMachineMode() {
        return super.nextMachineMode();
    }

    @Override
    public int getMachineMode() {
        return super.getMachineMode();
    }

    @Override
    public void setMachineModeIcons() {
        super.setMachineModeIcons();
    }

    @Override
    public UITexture getMachineModeIcon(int index) {
        return super.getMachineModeIcon(index);
    }

    @Override
    public Pos2d getMachineModeSwitchButtonPos() {
        return super.getMachineModeSwitchButtonPos();
    }

    @Override
    public String getMachineModeName() {
        return super.getMachineModeName();
    }
    // endregion

    // region Machine maintenance setting
    /**
     * Determines whether maintenance is required.
     *
     * @return true if maintenance is required, false otherwise.
     */
    public abstract boolean requiresMaintenance();

    @Override // Don't override
    public boolean shouldCheckMaintenance() {
        return super.shouldCheckMaintenance();
    }

    @Override // Don't override
    public boolean getDefaultHasMaintenanceChecks() {
        return requiresMaintenance();
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }
    // endregion

    // region Machine Explosion
    /**
     * Determines whether Explosion is enabled.
     *
     * @return true if explosion is enabled, false otherwise.
     */
    public abstract boolean enableExplosion();

    @Override
    public void doExplosion(long aExplosionPower) {
        if (enableExplosion()) super.doExplosion(aExplosionPower);
    }

    @Override // bie bie.. jpg
    public float getExplosionResistance(ForgeDirection side) {
        return super.getExplosionResistance(side);
    }

    @Override
    public boolean willExplodeInRain() {
        return enableExplosion();
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return enableExplosion();
    }
    // endregion

    // region Using Tool Right Click
    // easier to find method.....
    @Override
    public boolean onSolderingToolRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer aPlayer,
        float aX, float aY, float aZ, ItemStack aTool) {
        return super.onSolderingToolRightClick(side, wrenchingSide, aPlayer, aX, aY, aZ, aTool);
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ,
        ItemStack aTool) {
        super.onScrewdriverRightClick(side, aPlayer, aX, aY, aZ, aTool);
    }

    @Override
    public boolean onWrenchRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer entityPlayer,
        float aX, float aY, float aZ, ItemStack aTool) {
        return super.onWrenchRightClick(side, wrenchingSide, entityPlayer, aX, aY, aZ, aTool);
    }

    @Override
    public boolean onWireCutterRightClick(ForgeDirection side, ForgeDirection wrenchingSide, EntityPlayer aPlayer,
        float aX, float aY, float aZ, ItemStack aTool) {
        return super.onWireCutterRightClick(side, wrenchingSide, aPlayer, aX, aY, aZ, aTool);
    }
    // endregion

    // region Special optional setting
    @Override
    public void setItemNBT(NBTTagCompound aNBT) {}

    @Override
    protected boolean supportsCraftingMEBuffer() {
        return super.supportsCraftingMEBuffer();
    }

    @Override
    public void onBlockDestroyed() {
        super.onBlockDestroyed();
    }

    @Override
    public void onRandomDisplayTick(IGregTechTileEntity aBaseMetaTileEntity) {
        super.onRandomDisplayTick(aBaseMetaTileEntity);
    }
    // endregion
}
