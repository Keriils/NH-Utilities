package com.xir.NHUtilities.mixins.late.SpiceOfLife;

import net.minecraft.entity.player.InventoryPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.xir.NHUtilities.common.items.LunchBoxPlus.GuiFoodContainerPlus;
import com.xir.NHUtilities.common.items.LunchBoxPlus.LunchBoxPlus;

import squeek.spiceoflife.gui.GuiFoodContainer;
import squeek.spiceoflife.helpers.GuiHelper;
import squeek.spiceoflife.inventory.FoodContainerInventory;

@Mixin(value = GuiHelper.class, remap = false)
public class GuiHandler_Client_Mixin {

    @Redirect(
        method = "getSidedGuiElement",
        at = @At(
            value = "NEW",
            target = "(Lnet/minecraft/entity/player/InventoryPlayer;Lsqueek/spiceoflife/inventory/FoodContainerInventory;)Lsqueek/spiceoflife/gui/GuiFoodContainer;"),
        require = 1)
    private GuiFoodContainer NHUtilities$redirectGui(InventoryPlayer playerInventory,
        FoodContainerInventory foodContainerInventory) {
        boolean isLunchBoxPlus = playerInventory.getCurrentItem()
            .getItem() instanceof LunchBoxPlus;

        return isLunchBoxPlus ? new GuiFoodContainerPlus(playerInventory, foodContainerInventory)
            : new GuiFoodContainer(playerInventory, foodContainerInventory);
    }
}
