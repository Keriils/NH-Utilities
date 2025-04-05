package com.xir.NHUtilities.mixins.early.MineCraft;

import static com.xir.NHUtilities.mixins.ConstantHelper.GAME_RULE_DO_WEATHER_CYCLE;

import net.minecraft.world.GameRules;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnusedMixin")
@Mixin(value = GameRules.class)
public class WorldGameRule_Mixin {

    @Inject(method = "<init>", at = @At(value = "TAIL"), require = 1)
    private void nhu$weatherCycRuleHandler(CallbackInfo ci) {
        ((GameRules) (Object) this).addGameRule(GAME_RULE_DO_WEATHER_CYCLE, "true");
    }

}
