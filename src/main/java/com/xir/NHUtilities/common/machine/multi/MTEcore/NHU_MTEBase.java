package com.xir.NHUtilities.common.machine.multi.MTEcore;

import java.util.Collection;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.xir.NHUtilities.utils.CommonUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_ExtendedPowerMultiBlockBase;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;

public abstract class NHU_MTEBase<T extends NHU_MTEBase<T>> extends GT_MetaTileEntity_ExtendedPowerMultiBlockBase<T>
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
        return new ProcessingLogic().setOverclock(isEnablePerfectOverclock() ? 4 : 2, 4)
            .setSpeedBonus(getSpeedBonus())
            .setEuModifier(getEuModifier())
            .setMaxParallelSupplier(this::getMaxParallel);
    }

    @NotNull
    @Override
    public CheckRecipeResult checkProcessing() {
        return super.checkProcessing();
    }

    @NotNull
    @Override
    protected CheckRecipeResult doCheckRecipe() {
        return super.doCheckRecipe();
    }

    @Override
    protected void setupProcessingLogic(ProcessingLogic logic) {
        super.setupProcessingLogic(logic);
        logic.setEuModifier(getEuModifier());
        logic.setSpeedBonus(getSpeedBonus());
    }

    @ApiStatus.OverrideOnly
    protected abstract boolean isEnablePerfectOverclock();

    /**
     * This method is called on each recipe process, to get the eu modifier dynamically.
     */
    @ApiStatus.OverrideOnly
    protected abstract float getEuModifier();

    /**
     * This method is called on each recipe process, to get the speed bonus dynamically.
     */
    @ApiStatus.OverrideOnly
    protected abstract float getSpeedBonus();

    /**
     * This method is called to get the max parallel dynamically.
     */
    @ApiStatus.OverrideOnly
    protected abstract int getMaxParallel();

    @Override
    @ApiStatus.OverrideOnly
    public RecipeMap<?> getRecipeMap() {
        return null;
    }

    @NotNull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return super.getAvailableRecipeMaps();
    }

    @Override
    public int getRecipeCatalystPriority() {
        return super.getRecipeCatalystPriority();
    }

    @Override
    protected void setProcessingLogicPower(ProcessingLogic logic) {
        super.setProcessingLogicPower(logic);
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

    @Override
    public boolean addToMachineList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return super.addToMachineList(aTileEntity, aBaseCasingIndex);
    }

    public boolean addToMachineListWithExoticEnergy(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return this.addToMachineList(aTileEntity, aBaseCasingIndex)
            || addExoticEnergyInputToMachineList(aTileEntity, aBaseCasingIndex);
    }
    // endregion

    // region Common Setting
    @Override
    protected boolean canUseControllerSlotForRecipe() {
        return super.canUseControllerSlotForRecipe();
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

    @Override
    public String[] getInfoData() {

        var euModify = String.format("%.3f", this.getEuModifier() * 100) + "%";
        var speedBonus = String.format("%.3f", this.getSpeedBonus() * 100) + "%";

        String[] rawInfo = super.getInfoData();
        String[] reInfo = new String[rawInfo.length + 3];
        System.arraycopy(rawInfo, 0, reInfo, 0, rawInfo.length);

        reInfo[rawInfo.length + 2] = EnumChatFormatting.AQUA + CommonUtil.trans("Machine.InfoData.EuModifier")
            + ": "
            + EnumChatFormatting.GOLD
            + euModify;
        reInfo[rawInfo.length + 1] = EnumChatFormatting.AQUA + CommonUtil.trans("Machine.InfoData.SpeedMultiplier")
            + ": "
            + EnumChatFormatting.GOLD
            + speedBonus;
        reInfo[rawInfo.length] = EnumChatFormatting.AQUA + CommonUtil.trans("Machine.InfoData.Parallel")
            + ": "
            + EnumChatFormatting.GOLD
            + getMaxParallel();
        return reInfo;

    }

    @Override
    public abstract void construct(ItemStack stackSize, boolean hintsOnly);

    @Override
    public abstract int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env);
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

    // for Custom Texture in different condition
    @Override
    public void onValueUpdate(byte aValue) {
        super.onValueUpdate(aValue);
    }

    @Override
    public byte getUpdateData() {
        return super.getUpdateData();
    }
    // endregion
}
