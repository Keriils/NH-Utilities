package com.xir.NHUtilities.mixins.late.TecTech;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;

import tectech.loader.recipe.ResearchStationAssemblyLine;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ResearchStationAssemblyLine.class, remap = false)
public class BanOriginalWirelessRecipes_Mixin {

    @WrapWithCondition(
        method = "addWirelessEnergyRecipes",
        at = { @At(
            value = "INVOKE",
            target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
            ordinal = 0),
            @At(
                value = "INVOKE",
                target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
                ordinal = 1),
            @At(
                value = "INVOKE",
                target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
                ordinal = 2),
            @At(
                value = "INVOKE",
                target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
                ordinal = 3),
            @At(
                value = "INVOKE",
                target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
                ordinal = 4),
            @At(
                value = "INVOKE",
                target = "Ltectech/recipe/TTRecipeAdder;addResearchableAssemblylineRecipe(Lnet/minecraft/item/ItemStack;IIII[Ljava/lang/Object;[Lnet/minecraftforge/fluids/FluidStack;Lnet/minecraft/item/ItemStack;II)Z",
                ordinal = 11) },
        require = 1)
    private boolean nhu$banOriginalRecipes(ItemStack aResearchItem, int totalComputationRequired,
        int computationRequiredPerSec, int researchEUt, int researchAmperage, Object[] aInputs,
        FluidStack[] aFluidInputs, ItemStack aOutput, int assDuration, int assEUt) {
        return false;
    }

}
