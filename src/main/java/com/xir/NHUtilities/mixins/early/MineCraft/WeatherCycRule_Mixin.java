package com.xir.NHUtilities.mixins.early.MineCraft;

import static com.xir.NHUtilities.mixins.ConstantHelper.GAME_RULE_DO_WEATHER_CYCLE;

import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnusedMixin")
@Mixin(value = { World.class, WorldServer.class })
public class WeatherCycRule_Mixin {

    @Inject(method = "updateWeather", at = @At(value = "HEAD"), require = 1, cancellable = true)
    private void nhu$processWeatherCycRule(CallbackInfo ci) {
        GameRules rule = ((World) (Object) this).provider.worldObj.getGameRules();
        if (!rule.hasRule(GAME_RULE_DO_WEATHER_CYCLE))
            throw new IllegalStateException("Wtf???, this exception shouldn't be occur.");
        if (!rule.getGameRuleBooleanValue(GAME_RULE_DO_WEATHER_CYCLE)) ci.cancel();
    }

}
