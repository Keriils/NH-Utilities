package com.xir.NHUtilities.common.machine.multi;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;
import static gregtech.api.enums.GT_HatchElement.Energy;
import static gregtech.api.enums.GT_HatchElement.InputBus;
import static gregtech.api.enums.GT_HatchElement.InputHatch;
import static gregtech.api.enums.GT_HatchElement.Maintenance;
import static gregtech.api.enums.GT_HatchElement.Muffler;
import static gregtech.api.enums.GT_HatchElement.OutputBus;
import static gregtech.api.enums.GT_HatchElement.OutputHatch;
import static gregtech.api.enums.GT_Values.VN;
import static gregtech.api.enums.Textures.BlockIcons.casingTexturePages;
import static gregtech.api.util.GT_StructureUtility.buildHatchAdder;
import static gregtech.api.util.GT_StructureUtility.ofCoil;
import static gregtech.api.util.GT_Utility.filterValidMTEs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.fluid.IFluidStore;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Energy;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Muffler;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Output;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_OverclockCalculator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_AbstractMultiFurnace;

public class NHUtilities_TC_ElectricBlastFurnace extends
    GT_MetaTileEntity_AbstractMultiFurnace<NHUtilities_TC_ElectricBlastFurnace> implements ISurvivalConstructable {

    private int mHeatingCapacity = 0;
    protected final ArrayList<GT_MetaTileEntity_Hatch_Output> mPollutionOutputHatches = new ArrayList<>();
    protected final FluidStack[] pollutionFluidStacks = { Materials.CarbonDioxide.getGas(1000),
        Materials.CarbonMonoxide.getGas(1000), Materials.SulfurDioxide.getGas(1000) };
    protected static final int CASING_INDEX = 11;
    protected static final String STRUCTURE_PIECE_MAIN = "main";
    private static final IIconContainer Active = new Textures.BlockIcons.CustomIcon(
        "iconsets/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_ACTIVE");
    private static final IIconContainer Active_Glow = new Textures.BlockIcons.CustomIcon(
        "iconsets/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_ACTIVE_GLOW");
    private static final IIconContainer Not_Active = new Textures.BlockIcons.CustomIcon(
        "iconsets/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE");
    private static final IIconContainer Not_Active_Glow = new Textures.BlockIcons.CustomIcon(
        "iconsets/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_GLOW");
    private static final IStructureDefinition<NHUtilities_TC_ElectricBlastFurnace> STRUCTURE_DEFINITION = StructureDefinition
        .<NHUtilities_TC_ElectricBlastFurnace>builder()
        .addShape(
            STRUCTURE_PIECE_MAIN,
            transpose(
                new String[][] { { "ttt", "tmt", "ttt" }, { "CCC", "C-C", "CCC" }, { "CCC", "C-C", "CCC" },
                    { "b~b", "bbb", "bbb" } }))
        .addElement(
            't',
            buildHatchAdder(NHUtilities_TC_ElectricBlastFurnace.class)
                .atLeast(
                    OutputHatch.withAdder(NHUtilities_TC_ElectricBlastFurnace::addOutputHatchToTopList)
                        .withCount(t -> t.mPollutionOutputHatches.size()))
                .casingIndex(CASING_INDEX)
                .dot(1)
                .buildAndChain(GregTech_API.sBlockCasings1, CASING_INDEX))
        .addElement('m', Muffler.newAny(CASING_INDEX, 2))
        .addElement(
            'C',
            ofCoil(
                NHUtilities_TC_ElectricBlastFurnace::setCoilLevel,
                NHUtilities_TC_ElectricBlastFurnace::getCoilLevel))
        .addElement(
            'b',
            buildHatchAdder(NHUtilities_TC_ElectricBlastFurnace.class)
                .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy)
                .casingIndex(CASING_INDEX)
                .dot(1)
                .buildAndChain(GregTech_API.sBlockCasings1, CASING_INDEX))
        .build();

    public boolean addOutputHatchToTopList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        if (aTileEntity == null) return false;
        IMetaTileEntity aMetaTileEntity = aTileEntity.getMetaTileEntity();
        if (aMetaTileEntity == null) return false;
        if (aMetaTileEntity instanceof GT_MetaTileEntity_Hatch_Output) {
            ((GT_MetaTileEntity_Hatch) aMetaTileEntity).updateTexture(aBaseCasingIndex);
            return mPollutionOutputHatches.add((GT_MetaTileEntity_Hatch_Output) aMetaTileEntity);
        }
        return false;
    }

    public NHUtilities_TC_ElectricBlastFurnace(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public NHUtilities_TC_ElectricBlastFurnace(String aName) {
        super(aName);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        this.mHeatingCapacity = 0;
        setCoilLevel(HeatingCoilLevel.None);
        mPollutionOutputHatches.clear();
        if (!checkPiece(STRUCTURE_PIECE_MAIN, 1, 3, 0)) return false;
        if (getCoilLevel() == HeatingCoilLevel.None) return false;
        if (mMaintenanceHatches.size() != 1) return false;
        this.mHeatingCapacity = (int) getCoilLevel().getHeat() + 100 * (GT_Utility.getTier(getMaxInputVoltage()) - 2);
        return true;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, 1, 3, 0);
    }

    @Override
    public IStructureDefinition<NHUtilities_TC_ElectricBlastFurnace> getStructureDefinition() {
        return STRUCTURE_DEFINITION;
    }

    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType(StatCollector.translateToLocal("nhu.tcebf.machine.type"))
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_1"))
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_2"))
            .addPollutionAmount(getPollutionPerSecond(null))
            .addSeparator()
            .beginStructureBlock(3, 4, 3, true)
            .addController(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_1"))
            .addCasingInfoRange(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_2"), 0, 15, false)
            .addOtherStructurePart(
                StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_3.1"),
                StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_3.2"))
            .addEnergyHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_4"), 3)
            .addMaintenanceHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_5"), 3)
            .addMufflerHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_6"), 2)
            .addInputBus(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_7"), 3)
            .addInputHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_8"), 3)
            .addOutputBus(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_9"), 3)
            .addOutputHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_10"))
            .addOutputHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_11"), 1)
            .addStructureInfo(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_12"))
            .toolTipFinisher(MOD_NAME);
        return tt;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new NHUtilities_TC_ElectricBlastFurnace(this.mName);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) return new ITexture[] { casingTexturePages[0][CASING_INDEX], TextureFactory.builder()
                .addIcon(Active)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(Active_Glow)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { casingTexturePages[0][CASING_INDEX], TextureFactory.builder()
                .addIcon(Not_Active)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(Not_Active_Glow)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { casingTexturePages[0][CASING_INDEX] };
    }

    @Override
    public int getPollutionPerSecond(ItemStack aStack) {
        return GT_Mod.gregtechproxy.mPollutionEBFPerSecond;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.blastFurnaceRecipes;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        int maxParallel = 4;
        return new ProcessingLogic() {

            @Nonnull
            @Override
            protected GT_OverclockCalculator createOverclockCalculator(@Nonnull GT_Recipe recipe) {
                return super.createOverclockCalculator(recipe).setRecipeHeat(recipe.mSpecialValue)
                    .setMachineHeat(mHeatingCapacity)
                    .setHeatOC(true)
                    .setHeatDiscount(true);
            }

            @Override
            protected @Nonnull CheckRecipeResult validateRecipe(@Nonnull GT_Recipe recipe) {
                return recipe.mSpecialValue <= mHeatingCapacity ? CheckRecipeResultRegistry.SUCCESSFUL
                    : CheckRecipeResultRegistry.insufficientHeat(recipe.mSpecialValue);
            }
        }.setSpeedBonus(0.50F)
            .setEuModifier(0.80F)
            .setMaxParallel(maxParallel);
    }

    @Override
    public boolean addOutput(FluidStack aLiquid) {
        if (aLiquid == null) return false;
        FluidStack tLiquid = aLiquid.copy();
        ArrayList<GT_MetaTileEntity_Hatch_Output> tOutputHatches;
        if (isPollutionFluid(tLiquid)) {
            tOutputHatches = this.mPollutionOutputHatches;
            multiplyPollutionFluidAmount(tLiquid);
        } else {
            tOutputHatches = this.mOutputHatches;
        }
        return dumpFluid(tOutputHatches, tLiquid, true) || dumpFluid(tOutputHatches, tLiquid, false);
    }

    protected boolean isPollutionFluid(@Nullable FluidStack fluidStack) {
        if (fluidStack == null) return false;
        for (FluidStack pollutionFluidStack : pollutionFluidStacks) {
            if (!fluidStack.isFluidEqual(pollutionFluidStack)) continue;
            return true;
        }
        return false;
    }

    @Override
    public List<? extends IFluidStore> getFluidOutputSlots(FluidStack[] toOutput) {
        if (Arrays.stream(toOutput)
            .anyMatch(this::isPollutionFluid)) {
            return filterValidMTEs(mPollutionOutputHatches);
        }
        return filterValidMTEs(mOutputHatches);
    }

    public int getPollutionReduction() {
        int reduction = 100;
        for (GT_MetaTileEntity_Hatch_Muffler tHatch : filterValidMTEs(mMufflerHatches)) {
            reduction = Math.min(tHatch.calculatePollutionReduction(100), reduction);
        }
        return reduction;
    }

    protected void multiplyPollutionFluidAmount(@Nonnull FluidStack fluid) {
        fluid.amount = fluid.amount * Math.min(100 - getPollutionReduction(), 100) / 100;
    }

    @Override
    public String[] getInfoData() {
        int mPollutionReduction = getPollutionReduction();
        long storedEnergy = 0;
        long maxEnergy = 0;
        for (GT_MetaTileEntity_Hatch_Energy tHatch : filterValidMTEs(mEnergyHatches)) {
            storedEnergy += tHatch.getBaseMetaTileEntity()
                .getStoredEU();
            maxEnergy += tHatch.getBaseMetaTileEntity()
                .getEUCapacity();
        }

        return new String[] {
            StatCollector.translateToLocal("GT5U.multiblock.Progress") + ": "
                + EnumChatFormatting.GREEN
                + GT_Utility.formatNumbers(mProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s / "
                + EnumChatFormatting.YELLOW
                + GT_Utility.formatNumbers(mMaxProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s",
            StatCollector.translateToLocal("GT5U.multiblock.energy") + ": "
                + EnumChatFormatting.GREEN
                + GT_Utility.formatNumbers(storedEnergy)
                + EnumChatFormatting.RESET
                + " EU / "
                + EnumChatFormatting.YELLOW
                + GT_Utility.formatNumbers(maxEnergy)
                + EnumChatFormatting.RESET
                + " EU",
            StatCollector.translateToLocal("GT5U.multiblock.usage") + ": "
                + EnumChatFormatting.RED
                + GT_Utility.formatNumbers(-mEUt)
                + EnumChatFormatting.RESET
                + " EU/t",
            StatCollector.translateToLocal("GT5U.multiblock.mei") + ": "
                + EnumChatFormatting.YELLOW
                + GT_Utility.formatNumbers(getMaxInputVoltage())
                + EnumChatFormatting.RESET
                + " EU/t(*2A) "
                + StatCollector.translateToLocal("GT5U.machines.tier")
                + ": "
                + EnumChatFormatting.YELLOW
                + VN[GT_Utility.getTier(getMaxInputVoltage())]
                + EnumChatFormatting.RESET,
            StatCollector.translateToLocal("GT5U.multiblock.problems") + ": "
                + EnumChatFormatting.RED
                + (getIdealStatus() - getRepairStatus())
                + EnumChatFormatting.RESET
                + " "
                + StatCollector.translateToLocal("GT5U.multiblock.efficiency")
                + ": "
                + EnumChatFormatting.YELLOW
                + mEfficiency / 100.0F
                + EnumChatFormatting.RESET
                + " %",
            StatCollector.translateToLocal("GT5U.EBF.heat") + ": "
                + EnumChatFormatting.GREEN
                + GT_Utility.formatNumbers(mHeatingCapacity)
                + EnumChatFormatting.RESET
                + " K",
            StatCollector.translateToLocal("GT5U.multiblock.pollution") + ": "
                + EnumChatFormatting.GREEN
                + mPollutionReduction
                + EnumChatFormatting.RESET
                + " %" };
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(STRUCTURE_PIECE_MAIN, stackSize, 1, 3, 0, elementBudget, env, false, true);
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ) {
        inputSeparation = !inputSeparation;
        GT_Utility.sendChatToPlayer(
            aPlayer,
            StatCollector.translateToLocal("GT5U.machines.separatebus") + " " + inputSeparation);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        if (aNBT.hasKey("isBussesSeparate")) {
            // backward compatibility
            inputSeparation = aNBT.getBoolean("isBussesSeparate");
        }
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
    public boolean supportsBatchMode() {
        return true;
    }
}
