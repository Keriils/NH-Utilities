package com.xir.NHUtilities.mixins.late.GregTech;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.interfaces.ITileEntityTickAcceleration;

import tectech.thing.metaTileEntity.multi.MTEResearchStation;
import tectech.thing.metaTileEntity.multi.base.TTMultiblockBase;

@SuppressWarnings("UnusedMixin")
@Mixin(value = MTEResearchStation.class, remap = false)
public abstract class ResearchStationAcceleration_Mixin extends TTMultiblockBase
    implements ITileEntityTickAcceleration {

    @Shadow(remap = false)
    private long computationRemaining;

    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    public boolean tickAcceleration(int tickAcceleratedRate) {
        if (this.computationRemaining <= 0) return true;
        this.computationRemaining -= tickAcceleratedRate * eAvailableData;
        return true;
    }

    protected ResearchStationAcceleration_Mixin(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }
}
