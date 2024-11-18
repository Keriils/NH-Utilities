package com.xir.NHUtilities.mixins.late.GregTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.github.technus.tectech.thing.metaTileEntity.multi.GT_MetaTileEntity_EM_research;
import com.github.technus.tectech.thing.metaTileEntity.multi.base.GT_MetaTileEntity_MultiblockBase_EM;
import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;

@Mixin(value = GT_MetaTileEntity_EM_research.class, remap = false)
public abstract class ResearchStationAcceleration_Mixin extends GT_MetaTileEntity_MultiblockBase_EM
    implements ITileEntityTickAcceleration {

    @Shadow(remap = false)
    private long computationRemaining;

    @Override
    public boolean tickAcceleration(int tickAcceleratedRate) {
        if (this.computationRemaining <= 0) return true;
        this.computationRemaining -= tickAcceleratedRate * eAvailableData;
        return true;
    }

    protected ResearchStationAcceleration_Mixin(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }
}
