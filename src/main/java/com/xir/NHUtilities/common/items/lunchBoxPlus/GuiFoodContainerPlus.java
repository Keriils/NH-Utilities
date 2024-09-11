package com.xir.NHUtilities.common.items.lunchBoxPlus;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import squeek.spiceoflife.gui.GuiFoodContainer;
import squeek.spiceoflife.inventory.FoodContainerInventory;

public class GuiFoodContainerPlus extends GuiFoodContainer {

    private static final ResourceLocation guiTextureEXT = new ResourceLocation(
        "nhutilities:textures/gui/food_container_plus.png");

    public GuiFoodContainerPlus(InventoryPlayer playerInventory, FoodContainerInventory foodContainerInventory) {
        super(playerInventory, foodContainerInventory);
        this.inventorySlots = new ContainerFoodContainerPlus(playerInventory, foodContainerInventory);
        this.ySize = 222;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager()
            .bindTexture(guiTextureEXT);
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        this.drawTexturedModalRect(xStart, yStart, 0, 0, 176, 222);
    }
}
