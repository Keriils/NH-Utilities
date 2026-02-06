package com.xir.NHUtilities.common.machine.multi;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.TC_EBF_ACTIVE;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.TC_EBF_ACTIVE_GLOW;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.TC_EBF_NOT_ACTIVE;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.TC_EBF_NOT_ACTIVE_GLOW;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;
import static gregtech.api.enums.GTValues.VN;
import static gregtech.api.enums.HatchElement.Energy;
import static gregtech.api.enums.HatchElement.InputBus;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.enums.HatchElement.Maintenance;
import static gregtech.api.enums.HatchElement.Muffler;
import static gregtech.api.enums.HatchElement.OutputBus;
import static gregtech.api.enums.HatchElement.OutputHatch;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.casingTexturePages;
import static gregtech.api.util.GTStructureUtility.activeCoils;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofCoil;
import static gregtech.api.util.GTUtility.validMTEList;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.GTMod;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.SoundResource;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEHatchEnergy;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTUtility;
import gregtech.api.util.MultiblockTooltipBuilder;
import gregtech.api.util.OverclockCalculator;
import gregtech.common.misc.GTStructureChannels;
import gregtech.common.tileentities.machines.multi.MTEAbstractMultiFurnace;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.visnet.VisNetHandler;

public class TCBlastFurnace extends MTEAbstractMultiFurnace<TCBlastFurnace> implements ISurvivalConstructable {

    private boolean isNewTexture = true;
    private double tcSpeedBonus = 0.8;
    private double tcEuModifier = 0.95;
    private int mHeatingCapacity = 0;
    protected static final int CASING_INDEX = 11;
    protected static final String STRUCTURE_PIECE_MAIN = "main";
    private static final IStructureDefinition<TCBlastFurnace> STRUCTURE_DEFINITION = StructureDefinition
        .<TCBlastFurnace>builder()
        .addShape(
            STRUCTURE_PIECE_MAIN,
            transpose(
                new String[][] { { "fff", "fmf", "fff" }, { "CCC", "C-C", "CCC" }, { "CCC", "C-C", "CCC" },
                    { "b~b", "bbb", "bbb" } }))
        .addElement(
            'f',
            buildHatchAdder(TCBlastFurnace.class).atLeast(OutputHatch)
                .casingIndex(CASING_INDEX)
                .dot(3)
                .buildAndChain(GregTechAPI.sBlockCasings1, CASING_INDEX))
        .addElement('m', Muffler.newAny(CASING_INDEX, 2))
        .addElement('C', activeCoils(ofCoil(TCBlastFurnace::setCoilLevel, TCBlastFurnace::getCoilLevel)))
        .addElement(
            'b',
            buildHatchAdder(TCBlastFurnace.class)
                .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy)
                .casingIndex(CASING_INDEX)
                .dot(1)
                .buildAndChain(GregTechAPI.sBlockCasings1, CASING_INDEX))
        .build();

    public TCBlastFurnace(int aID, String aNameRegional) {
        super(aID, "multimachine.tcblastfurnace", aNameRegional);
    }

    public TCBlastFurnace(String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new TCBlastFurnace(this.mName);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(StatCollector.translateToLocal("nhu.tcebf.machine.type"))
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_1"))
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_2"))
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_3"))
            .addInfo(
                StatCollector.translateToLocal("nhu.tcebf.machine.info_4") + ":"
                    + EnumChatFormatting.AQUA
                    + "⌊80-30*fire(cv)*entropy(cv)/(fire(cv)*entropy(cv)+13.5)⌋/100")
            .addInfo(
                StatCollector.translateToLocal("nhu.tcebf.machine.info_5") + ":"
                    + EnumChatFormatting.AQUA
                    + "⌊95-15*fire(cv)*order(cv)/(fire(cv)*order(cv)+13.5)⌋/100")
            .addInfo(StatCollector.translateToLocal("nhu.tcebf.machine.info_6"))
            .addInfo(
                "" + EnumChatFormatting.ITALIC
                    + EnumChatFormatting.DARK_PURPLE
                    + StatCollector.translateToLocal("nhu.tcebf.machine.info_7"))
            .addPollutionAmount(getPollutionPerSecond(null))
            .beginStructureBlock(3, 4, 3, true)
            .addController(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_1"))
            .addCasingInfoRange(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_2"), 0, 15, false)
            .addCasingInfoExactly(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_3"), 16, true)
            .addEnergyHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_4"), 3)
            .addMaintenanceHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_5"), 3)
            .addMufflerHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_6"), 2)
            .addInputBus(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_7"), 1)
            .addInputHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_8"), 1)
            .addOutputBus(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_9"), 1)
            .addOutputHatch(StatCollector.translateToLocal("nhu.tcebf.machine.build.helper_10"), 3)
            .addSubChannelUsage(GTStructureChannels.HEATING_COIL)
            .toolTipFinisher(MOD_NAME);
        return tt;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) return new ITexture[] { casingTexturePages[0][CASING_INDEX], TextureFactory.builder()
                .addIcon(isNewTexture ? TC_EBF_ACTIVE : OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_ACTIVE)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(isNewTexture ? TC_EBF_ACTIVE_GLOW : OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { casingTexturePages[0][CASING_INDEX], TextureFactory.builder()
                .addIcon(isNewTexture ? TC_EBF_NOT_ACTIVE : OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(isNewTexture ? TC_EBF_NOT_ACTIVE_GLOW : OVERLAY_FRONT_ELECTRIC_BLAST_FURNACE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { casingTexturePages[0][CASING_INDEX] };
    }

    @Override
    public int getPollutionPerSecond(ItemStack aStack) {
        return GTMod.proxy.mPollutionEBFPerSecond;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.blastFurnaceRecipes;
    }

    @Override
    public IStructureDefinition<TCBlastFurnace> getStructureDefinition() {
        return STRUCTURE_DEFINITION;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        int maxParallel = 4;
        return new ProcessingLogic() {

            @Nonnull
            @Override
            protected OverclockCalculator createOverclockCalculator(@Nonnull GTRecipe recipe) {
                return super.createOverclockCalculator(recipe).setRecipeHeat(recipe.mSpecialValue)
                    .setMachineHeat(mHeatingCapacity)
                    .setHeatOC(true)
                    .setHeatDiscount(true);
            }

            @Override
            protected @Nonnull CheckRecipeResult validateRecipe(@Nonnull GTRecipe recipe) {
                return recipe.mSpecialValue <= mHeatingCapacity ? CheckRecipeResultRegistry.SUCCESSFUL
                    : CheckRecipeResultRegistry.insufficientHeat(recipe.mSpecialValue);
            }
        }.setMaxParallel(maxParallel);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        this.mHeatingCapacity = 0;
        this.tcSpeedBonus = 1.0 / 1.25;
        this.tcEuModifier = 1.0 / 1.05;
        setCoilLevel(HeatingCoilLevel.None);
        // mPollutionOutputHatches.clear();
        if (!checkPiece(STRUCTURE_PIECE_MAIN, 1, 3, 0)) return false;
        if (getCoilLevel() == HeatingCoilLevel.None) return false;
        if (mMaintenanceHatches.size() != 1) return false;
        this.mHeatingCapacity = (int) getCoilLevel().getHeat() + 100 * (GTUtility.getTier(getMaxInputVoltage()) - 2);
        return true;
    }

    @Override
    public String[] getInfoData() {
        long storedEnergy = 0;
        long maxEnergy = 0;
        for (MTEHatchEnergy tHatch : validMTEList(mEnergyHatches)) {
            storedEnergy += tHatch.getBaseMetaTileEntity()
                .getStoredEU();
            maxEnergy += tHatch.getBaseMetaTileEntity()
                .getEUCapacity();
        }

        return new String[] {
            StatCollector.translateToLocal("GT5U.multiblock.Progress") + ": "
                + EnumChatFormatting.GREEN
                + GTUtility.formatNumbers(mProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s / "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(mMaxProgresstime / 20)
                + EnumChatFormatting.RESET
                + " s",
            StatCollector.translateToLocal("GT5U.multiblock.energy") + ": "
                + EnumChatFormatting.GREEN
                + GTUtility.formatNumbers(storedEnergy)
                + EnumChatFormatting.RESET
                + " EU / "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(maxEnergy)
                + EnumChatFormatting.RESET
                + " EU",
            StatCollector.translateToLocal("GT5U.multiblock.usage") + ": "
                + EnumChatFormatting.RED
                + GTUtility.formatNumbers(-lEUt)
                + EnumChatFormatting.RESET
                + " EU/t",
            StatCollector.translateToLocal("GT5U.multiblock.mei") + ": "
                + EnumChatFormatting.YELLOW
                + GTUtility.formatNumbers(getMaxInputVoltage())
                + EnumChatFormatting.RESET
                + " EU/t(*2A) "
                + StatCollector.translateToLocal("GT5U.machines.tier")
                + ": "
                + EnumChatFormatting.YELLOW
                + VN[GTUtility.getTier(getMaxInputVoltage())]
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
                + GTUtility.formatNumbers(mHeatingCapacity)
                + EnumChatFormatting.RESET
                + " K",
            StatCollector.translateToLocal("GT5U.multiblock.pollution") + ": "
                + EnumChatFormatting.GREEN
                + getAveragePollutionPercentage()
                + EnumChatFormatting.RESET
                + " %" };
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, 1, 3, 0);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivalBuildPiece(STRUCTURE_PIECE_MAIN, stackSize, 1, 3, 0, elementBudget, env, false, true);
    }

    @Override
    public void onScrewdriverRightClick(ForgeDirection side, EntityPlayer aPlayer, float aX, float aY, float aZ,
        ItemStack aTool) {
        if (aPlayer.isSneaking()) {
            isNewTexture = !isNewTexture;
            GTUtility.sendChatToPlayer(
                aPlayer,
                StatCollector.translateToLocal("GT5U.machines.isnewtexture") + " " + isNewTexture);
        } else {
            inputSeparation = !inputSeparation;
            GTUtility.sendChatToPlayer(
                aPlayer,
                StatCollector.translateToLocal("GT5U.machines.separatebus") + " " + inputSeparation);
        }
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setDouble("tcSpeedBonus", tcSpeedBonus);
        aNBT.setDouble("tcEuModifier", tcEuModifier);
        aNBT.setBoolean("isNewTexture", isNewTexture);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        if (aNBT.hasKey("isBussesSeparate")) {
            // backward compatibility
            inputSeparation = aNBT.getBoolean("isBussesSeparate");
        }
        if (aNBT.hasKey("tcSpeedBonus")) {
            tcSpeedBonus = aNBT.getDouble("tcSpeedBonus");
        }
        if (aNBT.hasKey("tcEuModifier")) {
            tcEuModifier = aNBT.getDouble("tcEuModifier");
        }
        if (aNBT.hasKey("isNewTexture")) {
            isNewTexture = aNBT.getBoolean("isNewTexture");
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

    @SideOnly(Side.CLIENT)
    @Override
    protected SoundResource getActivitySoundLoop() {
        return SoundResource.GT_MACHINES_EBF_LOOP;
    }

    @Override
    public void onValueUpdate(byte aValue) {
        super.onValueUpdate(aValue);
        boolean oIsNewTexture = isNewTexture;
        isNewTexture = (aValue & 1) == 1;
        if (oIsNewTexture != isNewTexture) getBaseMetaTileEntity().issueTextureUpdate();
    }

    @Override
    public byte getUpdateData() {
        return (byte) (isNewTexture ? 1 : 0);
    }

    @Override
    protected void setProcessingLogicPower(ProcessingLogic logic) {
        super.setProcessingLogicPower(logic);
        logic.setSpeedBonus(tcSpeedBonus);
        logic.setEuModifier(tcEuModifier);
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (aTick % 10 == 0 && this.mMachine) {
            final World world = this.getBaseMetaTileEntity()
                .getWorld();
            int x = this.getBaseMetaTileEntity()
                .getXCoord();
            int y = this.getBaseMetaTileEntity()
                .getYCoord();
            int z = this.getBaseMetaTileEntity()
                .getZCoord();
            getNode(world, x, y, z);
        }
    }

    private void getNode(World world, int x, int y, int z) {
        double fire = VisNetHandler.drainVis(world, x, y, z, Aspect.FIRE, 999);
        double entropy = VisNetHandler.drainVis(world, x, y, z, Aspect.ENTROPY, 999);
        double order = VisNetHandler.drainVis(world, x, y, z, Aspect.ORDER, 999);
        if (fire == 0 || entropy == 0) {
            tcSpeedBonus = 0.8F;
        } else {
            tcSpeedBonus = Math.floor(80.0 - 30.0 * fire * entropy / (fire * entropy + 13.5)) / 100.0;
        }
        if (fire == 0 || order == 0) {
            tcEuModifier = 0.95F;
        } else {
            tcEuModifier = Math.floor(95.0 - 15.0 * fire * order / (fire * order + 13.5)) / 100.0;
        }
    }
}
