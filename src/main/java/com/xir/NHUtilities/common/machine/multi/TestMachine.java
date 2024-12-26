package com.xir.NHUtilities.common.machine.multi;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.xir.NHUtilities.main.ReferencedInfo.MOD_NAME;
import static gregtech.api.enums.HatchElement.Energy;
import static gregtech.api.enums.HatchElement.ExoticEnergy;
import static gregtech.api.enums.HatchElement.InputBus;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.enums.HatchElement.OutputBus;
import static gregtech.api.enums.HatchElement.OutputHatch;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static tectech.thing.casing.TTCasingsContainer.sBlockCasingsTT;

import java.util.Arrays;
import java.util.Collection;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.xir.NHUtilities.common.api.enums.NHUTextEnum;
import com.xir.NHUtilities.common.machine.multi.MTEcore.NHU_MTEBase;
import com.xir.NHUtilities.common.recipeMap.recipeResult.NHURecipe;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.MultiblockTooltipBuilder;
import tectech.thing.casing.BlockGTCasingsTT;
import tectech.thing.metaTileEntity.multi.base.render.TTRenderedExtendedFacingTexture;

@SuppressWarnings("unused")
public class TestMachine extends NHU_MTEBase<TestMachine> {

    public static final IIconContainer ScreenOFF = new Textures.BlockIcons.CustomIcon("iconsets/EM_CONTROLLER");
    public static final IIconContainer ScreenON = new Textures.BlockIcons.CustomIcon("iconsets/EM_CONTROLLER_ACTIVE");

    // region Constructor
    protected TestMachine(String aName) {
        super(aName);
    }

    public TestMachine(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new TestMachine(mName);
    }
    // endregion

    // region Logic
    @Override
    protected ProcessingLogic createProcessingLogic() {
        return super.createProcessingLogic();
    }

    @Override
    protected boolean isEnablePerfectOverclock() {
        return true;
    }

    @Override
    protected double getEuModifier() {
        return 1.0D;
    }

    @Override
    protected double getSpeedBonus() {
        return 1.0D;
    }

    @Override
    protected int getMaxParallel() {
        return 114514;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.assemblerRecipes;
    }

    @Override
    public @NotNull Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(RecipeMaps.assemblerRecipes, NHURecipe.IndustrialAlchemicalRecipe);
    }
    // endregion

    // region Common Setting
    @Override
    public boolean requiresMaintenance() {
        return false;
    }

    @Override
    public boolean enableExplosion() {
        return false;
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        return new MultiblockTooltipBuilder().addMachineType("Test")
            .addInfo(NHUTextEnum.Author_Keriils.getText())
            .toolTipFinisher(MOD_NAME);
    }
    // endregion

    // region Texture
    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
        int aColorIndex, boolean aActive, boolean aRedStoneLevel) {
        if (side == facing) {
            return new ITexture[] { Textures.BlockIcons.casingTexturePages[BlockGTCasingsTT.texturePage][3],
                new TTRenderedExtendedFacingTexture(aActive ? ScreenON : ScreenOFF) };
        }
        return new ITexture[] { Textures.BlockIcons.casingTexturePages[BlockGTCasingsTT.texturePage][3] };
    }
    // endregion

    // region Structure
    @Override
    public IStructureDefinition<TestMachine> getStructureDefinition() {
        return StructureDefinition.<TestMachine>builder()
            .addShape(STRUCTURE_PIECE_MAIN, shape)
            .addElement(
                'A',
                buildHatchAdder(TestMachine.class)
                    .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Energy.or(ExoticEnergy))
                    .adder(TestMachine::addToMachineListWithExoticEnergy)
                    .dot(1)
                    .casingIndex(BlockGTCasingsTT.textureOffset + 1)
                    .buildAndChain(ofBlock(sBlockCasingsTT, 1)))
            .addElement('B', ofBlock(sBlockCasingsTT, 2))
            .addElement('C', ofBlock(sBlockCasingsTT, 3))
            .build();
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            horizontalOffSet,
            verticalOffSet,
            depthOffSet,
            elementBudget,
            env,
            false,
            true);
    }

    private static final String STRUCTURE_PIECE_MAIN = "main";
    private static final int horizontalOffSet = 2;
    private static final int verticalOffSet = 2;
    private static final int depthOffSet = 0;
    private final String[][] shape = new String[][] { { "BBBBB", "BAAAB", "BA~AB", "BAAAB", "BBBBB" },
        { "BAAAB", "ACCCA", "ACCCA", "ACCCA", "BAAAB" }, { "BAAAB", "ACCCA", "ACCCA", "ACCCA", "BAAAB" },
        { "BAAAB", "ACCCA", "ACCCA", "ACCCA", "BAAAB" }, { "BBBBB", "BAAAB", "BAAAB", "BAAAB", "BBBBB" } };
    // endregion

    // Structure:
    // Blocks:
    // A -> ofBlock...(gt.blockcasingsTT, 1, ...);
    // B -> ofBlock...(gt.blockcasingsTT, 2, ...);
    // C -> ofBlock...(gt.blockcasingsTT, 3, ...);
}
