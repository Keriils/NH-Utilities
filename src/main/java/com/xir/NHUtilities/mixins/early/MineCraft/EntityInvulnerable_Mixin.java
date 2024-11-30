package com.xir.NHUtilities.mixins.early.MineCraft;

import net.minecraft.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.xir.NHUtilities.common.api.interfaces.IEntityInvulnerable;

@Mixin(Entity.class)
@SuppressWarnings("UnusedMixin")
public class EntityInvulnerable_Mixin implements IEntityInvulnerable {

    @Shadow
    private boolean invulnerable;

    @Override
    @SuppressWarnings("AddedMixinMembersNamePattern")
    public void setEntityInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }
}
