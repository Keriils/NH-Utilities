package com.xir.NHUtilities.mixins.late.NewHorizonsCoreMod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.dreammaster.gthandler.recipes.AssemblingLineRecipes;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;

@SuppressWarnings("UnusedMixin")
@Mixin(value = AssemblingLineRecipes.class, remap = false)
public class BanOriginalWirelessDataOrComputationHatchRecipes_Mixin {

    @WrapWithCondition(
        method = "run",
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
                ordinal = 3) },
        require = 1)
    private boolean nhu$banRecipes(ItemStack tAlt, int aStacks, int uStack, int tStack, int tAmount, Object[] uList,
        FluidStack[] t, ItemStack tList, int duration, int eut) {
        return false;
    }

}
