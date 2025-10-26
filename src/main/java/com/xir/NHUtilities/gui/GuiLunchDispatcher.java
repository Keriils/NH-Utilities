package com.xir.NHUtilities.gui;

import static appeng.core.localization.GuiColors.ChestInventory;
import static appeng.core.localization.GuiText.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.xir.NHUtilities.common.tiles.TileLunchDispatcher;
import com.xir.NHUtilities.container.ContainerLunchDispatcher;
import com.xir.NHUtilities.main.ReferencedInfo;

import appeng.client.gui.AEBaseGui;

public class GuiLunchDispatcher extends AEBaseGui {

    public GuiLunchDispatcher(InventoryPlayer invPlayer, TileLunchDispatcher tileEntity) {
        super(new ContainerLunchDispatcher(invPlayer, tileEntity));
    }

    @Override
    public void drawFG(int offsetX, int offsetY, int mouseX, int mouseY) {
        this.fontRendererObj.drawString("Gui Lunch Dispatcher", 8, 6, 0x404040);
        this.fontRendererObj.drawString(inventory.getLocal(), 8, this.ySize - 96 + 3, ChestInventory.getColor());
    }

    public void bindNhuTexture(String file) {
        // spotless:off
        ResourceLocation loc = new ResourceLocation(ReferencedInfo.MOD_ID_LOWER, "textures/" + file);
        this.mc.getTextureManager().bindTexture(loc);
        // spotless:on
    }

    @Override
    public void drawBG(int offsetX, int offsetY, int mouseX, int mouseY) {
        this.bindNhuTexture("gui/lunch_dispatcher.png");
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }
}
