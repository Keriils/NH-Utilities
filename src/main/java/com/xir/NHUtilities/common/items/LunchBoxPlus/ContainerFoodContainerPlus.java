package com.xir.NHUtilities.common.items.LunchBoxPlus;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import squeek.spiceoflife.inventory.ContainerFoodContainer;
import squeek.spiceoflife.inventory.FoodContainerInventory;
import squeek.spiceoflife.inventory.SlotFiltered;

public class ContainerFoodContainerPlus extends ContainerFoodContainer {

    public ContainerFoodContainerPlus(InventoryPlayer playerInventory, FoodContainerInventory foodContainerInventory) {
        super(playerInventory, foodContainerInventory);
    }

    @Override
    protected void addSlotsOfType(Class<? extends Slot> slotClass, IInventory inventory, int xStart, int yStart) {
        this.addSlotsOfType(SlotFiltered.class, inventory, 8, slotsY, 6);
    }

    @Override
    protected void addPlayerInventorySlots(InventoryPlayer playerInventory, int yStart) {
        this.addPlayerInventorySlots(playerInventory, 8, 141);
    }
}
