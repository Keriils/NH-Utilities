package com.xir.NHUtilities.common.machine.multi;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.xir.NHUtilities.common.machine.multi.MTEcore.NHU_MTEBase;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.MultiblockTooltipBuilder;

public class TestMachine extends NHU_MTEBase<TestMachine> {

    protected TestMachine(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    protected TestMachine(String aName) {
        super(aName);
    }

    @Override
    public boolean requiresMaintenance() {
        return false;
    }

    @Override
    public boolean enableExplosion() {
        return false;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {

    }

    @Override
    public IStructureDefinition<TestMachine> getStructureDefinition() {
        return null;
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        return null;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return false;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return null;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
        int colorIndex, boolean active, boolean redstoneLevel) {
        return new ITexture[0];
    }
}
