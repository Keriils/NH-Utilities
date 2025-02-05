package com.xir.NHUtilities.common.machine.multi.MTEcore;

import static com.xir.NHUtilities.utils.CommonUtil.trans;

import java.util.Collection;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizons.modularui.api.drawable.UITexture;
import com.gtnewhorizons.modularui.api.math.Pos2d;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEExtendedPowerMultiBlockBase;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.util.MultiblockTooltipBuilder;

public abstract class NHU_MTEBase<T extends NHU_MTEBase<T>> extends MTEExtendedPowerMultiBlockBase<T>
    implements IConstructable, ISurvivalConstructable {

    // region Constructor
    public NHU_MTEBase(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    protected NHU_MTEBase(String aName) {
        super(aName);
    }

    @Override
    public abstract IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity);
    // endregion

    // region ProcessLogic
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
    @ApiStatus.OverrideOnly
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic();
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
        this.customProcessLogicPres(logic);
    }

    protected void customProcessLogicPres(@NotNull ProcessingLogic logic) {
        logic.setEuModifier(getEuModifier());
        logic.setSpeedBonus(getSpeedBonus());
        logic.setMaxParallelSupplier(this::getMaxParallel);
        logic.setOverclock(isEnablePerfectOverclock() ? 4.0d : 2.0d, 4.0d);
    }

    @ApiStatus.OverrideOnly
    protected abstract boolean isEnablePerfectOverclock();

    /**
     * <p>
     * This method is called on each recipe process, to get the eu modifier dynamically.
     * <p>
     * Sets an EUtDiscount. 0.9 is 10% less energy. 1.1 is 10% more energy.
     */
    @ApiStatus.OverrideOnly
    protected abstract double getEuModifier();

    /**
     * <p>
     * This method is called on each recipe process, to get the speed bonus dynamically.
     * <p>
     * Sets a Speed Boost for the multiBlock. 0.9 is 10% faster. 1.1 is 10% slower.
     */
    @ApiStatus.OverrideOnly
    protected abstract double getSpeedBonus();

    /**
     * <p>
     * This method is called to get the max parallel dynamically.
     * <p>
     * Sets the MaxParallel a multi can handle.s
     */
    @ApiStatus.OverrideOnly
    protected abstract int getMaxParallel();

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
    // endregion

    // region Adder
    @Override
    public boolean addToMachineList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return super.addToMachineList(aTileEntity, aBaseCasingIndex);
    }

    public boolean addToMachineListWithExoticEnergy(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return this.addToMachineList(aTileEntity, aBaseCasingIndex)
            || addExoticEnergyInputToMachineList(aTileEntity, aBaseCasingIndex);
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

        reInfo[rawInfo.length + 2] = EnumChatFormatting.AQUA + trans("Machine.InfoData.EuModifier")
            + ": "
            + EnumChatFormatting.GOLD
            + euModify;
        reInfo[rawInfo.length + 1] = EnumChatFormatting.AQUA + trans("Machine.InfoData.SpeedMultiplier")
            + ": "
            + EnumChatFormatting.GOLD
            + speedBonus;
        reInfo[rawInfo.length] = EnumChatFormatting.AQUA + trans("Machine.InfoData.Parallel")
            + ": "
            + EnumChatFormatting.GOLD
            + getMaxParallel();
        return reInfo;

    }

    @Override
    protected abstract MultiblockTooltipBuilder createTooltip();
    // endregion

    // region Machine maintenance setting
    /**
     * Determines whether maintenance is required.
     *
     * @return true if maintenance is required, false otherwise.
     */
    @Override
    public abstract boolean getDefaultHasMaintenanceChecks();

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

    // region Texture
    // for Custom Texture in different condition
    @Override
    public abstract ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side,
        ForgeDirection facing, int aColorIndex, boolean aActive, boolean aRedStoneLevel);

    @Override
    public void onValueUpdate(byte aValue) {
        super.onValueUpdate(aValue);
    }

    @Override
    public byte getUpdateData() {
        return super.getUpdateData();
    }
    // endregion

    // region Structure
    // Just normalize the de-rewrite and lookup methods
    @Override
    public abstract IStructureDefinition<T> getStructureDefinition();

    @Override
    public abstract boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack);

    @Override
    public abstract void construct(ItemStack stackSize, boolean hintsOnly);

    @Override
    public abstract int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env);
    // endregion

}
