package com.xir.NHUtilities.container;

import static appeng.container.slot.SlotRestrictedInput.PlacableItemType.BIOMETRIC_CARD;

import net.minecraft.entity.player.InventoryPlayer;

import com.xir.NHUtilities.common.tiles.TileLunchDispatcher;

import appeng.container.AEBaseContainer;
import appeng.container.slot.SlotRestrictedInput;

public class ContainerLunchDispatcher extends AEBaseContainer {

    public ContainerLunchDispatcher(InventoryPlayer invPlayer, TileLunchDispatcher teLunchDispatcher) {
        super(invPlayer, teLunchDispatcher, null);

        for (int column = 0; column < TileLunchDispatcher.COLUMN_SIZE; column++) {
            for (int row = 0; row < TileLunchDispatcher.ROW_SIZE; row++) {
                this.addSlotToContainer(
                    new SlotRestrictedInput(
                        BIOMETRIC_CARD,
                        teLunchDispatcher,
                        row + TileLunchDispatcher.ROW_SIZE * column,
                        44 + row * 18,
                        19 + column * 18,
                        invPlayer));
            }
        }

        this.bindPlayerInventory(invPlayer, 0, 166 - 82);
    }

}
