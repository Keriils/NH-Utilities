package com.xir.NHUtilities.mixins.late.DraconicEvolution;

import static com.xir.NHUtilities.utils.InventoryUtils.getItemInPlayerBaublesInventory;

import java.util.List;
import java.util.Optional;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.brandon3055.brandonscore.common.utills.Teleporter;
import com.brandon3055.draconicevolution.client.gui.GUITeleporter;
import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.utills.InventoryUtils;

@Mixin(value = GUITeleporter.class)
@SuppressWarnings("UnusedMixin")
public abstract class GUITeleporter_Mixin extends GuiScreen {

    @Shadow(remap = false)
    private ItemStack teleporterItem;

    @Shadow(remap = false)
    private EntityPlayer player;

    @Shadow(remap = false)
    protected List<Teleporter.TeleportLocation> locations;

    @Shadow(remap = false)
    private int tick;

    @Shadow(remap = false)
    private int selected;

    @Shadow(remap = false)
    private int selectionOffset;

    @Shadow(remap = false)
    private boolean showFuelLight;

    @Unique
    private boolean NHUtilities$isBaubles = false;

    @Shadow(remap = false)
    protected abstract void readDataFromItem(ItemStack teleporter);

    @Shadow(remap = false)
    protected abstract Teleporter.TeleportLocation getLocationSafely(int index);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void NHUtilities$setBaubles(EntityPlayer player, CallbackInfo ci) {
        ItemStack heldItem = player.getHeldItem();
        if (heldItem != null && heldItem.getItem() == ModItems.teleporterMKII) return;
        var playerBaublesInventory = getItemInPlayerBaublesInventory(player, TeleporterMKII.class);
        if (playerBaublesInventory.isPresent()) {
            teleporterItem = playerBaublesInventory.get();
            readDataFromItem(playerBaublesInventory.get());
            NHUtilities$isBaubles = true;
        }

    }

    /**
     * @author Keriils -> wo shi zhu bi
     * @reason the simpler method
     */
    @Overwrite
    public void updateScreen() {
        if (NHUtilities$handOrBaubles()) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }

        if (tick % 5 == 0 && !locations.isEmpty()
            && getLocationSafely(selected + selectionOffset).getDimensionName()
                .isEmpty()
            && NHUtilities$banHand()) {
            if (NHUtilities$isBaubles) {
                Optional<ItemStack> playerBaublesInventory = InventoryUtils
                    .getItemInPlayerBaublesInventory(player, TeleporterMKII.class);
                playerBaublesInventory.ifPresent(this::readDataFromItem);
            } else {
                readDataFromItem(player.getHeldItem());
            }
        }

        tick++;
        if (tick >= 10) {
            tick = 0;
            showFuelLight = !showFuelLight;
        }
    }

    @Unique
    private boolean NHUtilities$handOrBaubles() {
        if (player.isDead) return true;
        if (!NHUtilities$isBaubles) {
            return player.getCurrentEquippedItem() == null || !player.getCurrentEquippedItem()
                .isItemEqual(new ItemStack(ModItems.teleporterMKII));
        }
        return false;
    }

    @Unique
    private boolean NHUtilities$banHand() {
        if (NHUtilities$isBaubles) return true;
        return player.getHeldItem() != null && player.getHeldItem()
            .getItem() == ModItems.teleporterMKII;
    }

}
