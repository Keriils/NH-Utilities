package com.xir.NHUtilities.mixins.late.SpiceOfLife;

import net.minecraft.entity.player.InventoryPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.xir.NHUtilities.container.ContainerFoodContainerPlus;
import com.xir.NHUtilities.gui.GuiFoodContainerPlus;
import com.xir.NHUtilities.inventory.lunchBoxPlus.FoodContainerInventoryPlus;

import squeek.spiceoflife.gui.GuiFoodContainer;
import squeek.spiceoflife.helpers.GuiHelper;
import squeek.spiceoflife.inventory.ContainerFoodContainer;
import squeek.spiceoflife.inventory.FoodContainerInventory;

@SuppressWarnings("UnusedMixin")
@Mixin(value = GuiHelper.class, remap = false)
public class GuiHandler_Mixin {

    @Redirect(
        method = "getSidedGuiElement",
        at = @At(
            value = "NEW",
            target = "(Lnet/minecraft/entity/player/InventoryPlayer;Lsqueek/spiceoflife/inventory/FoodContainerInventory;)Lsqueek/spiceoflife/gui/GuiFoodContainer;"),
        require = 1)
    private squeek.spiceoflife.gui.GuiFoodContainer NHUtilities$redirectGui(InventoryPlayer playerInventory,
        FoodContainerInventory foodContainerInventory) {
        return foodContainerInventory instanceof FoodContainerInventoryPlus
            ? new GuiFoodContainerPlus(playerInventory, foodContainerInventory)
            : new GuiFoodContainer(playerInventory, foodContainerInventory);
    }

    @Redirect(
        method = "getSidedGuiElement",
        at = @At(
            value = "NEW",
            target = "(Lnet/minecraft/entity/player/InventoryPlayer;Lsqueek/spiceoflife/inventory/FoodContainerInventory;)Lsqueek/spiceoflife/inventory/ContainerFoodContainer;"),
        require = 1)
    private ContainerFoodContainer NHUtilities$redirectContainer(InventoryPlayer playerInventory,
        FoodContainerInventory foodContainerInventory) {
        return foodContainerInventory instanceof FoodContainerInventoryPlus
            ? new ContainerFoodContainerPlus(playerInventory, foodContainerInventory)
            : new ContainerFoodContainer(playerInventory, foodContainerInventory);
    }

}
