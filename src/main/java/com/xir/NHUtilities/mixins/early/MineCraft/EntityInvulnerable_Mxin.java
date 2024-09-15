package com.xir.NHUtilities.mixins.early.MineCraft;

import net.minecraft.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.IEntityInvulnerable;

@Mixin(Entity.class)
public class EntityInvulnerable_Mxin implements IEntityInvulnerable {

    @Shadow
    private boolean invulnerable;

    @Override
    public void setEntityInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }
}
