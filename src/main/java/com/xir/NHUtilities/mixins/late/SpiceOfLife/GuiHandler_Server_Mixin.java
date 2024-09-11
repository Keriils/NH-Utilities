package com.xir.NHUtilities.mixins.late.SpiceOfLife;

import net.minecraft.entity.player.InventoryPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.xir.NHUtilities.common.items.LunchBoxPlus.ContainerFoodContainerPlus;
import com.xir.NHUtilities.common.items.LunchBoxPlus.LunchBoxPlus;

import squeek.spiceoflife.helpers.GuiHelper;
import squeek.spiceoflife.inventory.ContainerFoodContainer;
import squeek.spiceoflife.inventory.FoodContainerInventory;

@Mixin(value = GuiHelper.class, remap = false)
public class GuiHandler_Server_Mixin {

    @Redirect(
        method = "getSidedGuiElement",
        at = @At(
            value = "NEW",
            target = "(Lnet/minecraft/entity/player/InventoryPlayer;Lsqueek/spiceoflife/inventory/FoodContainerInventory;)Lsqueek/spiceoflife/inventory/ContainerFoodContainer;"),
        require = 1)
    private ContainerFoodContainer NHUtilities$redirectContainer(InventoryPlayer playerInventory,
        FoodContainerInventory foodContainerInventory) {
        boolean isLunchBoxPlus = playerInventory.getCurrentItem()
            .getItem() instanceof LunchBoxPlus;

        return isLunchBoxPlus ? new ContainerFoodContainerPlus(playerInventory, foodContainerInventory)
            : new ContainerFoodContainer(playerInventory, foodContainerInventory);
    }
}
