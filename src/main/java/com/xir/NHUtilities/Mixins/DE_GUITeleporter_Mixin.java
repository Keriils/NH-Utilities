package com.xir.NHUtilities.Mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.brandon3055.brandonscore.common.utills.Teleporter;
import com.brandon3055.draconicevolution.client.gui.GUITeleporter;
import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.utills.InventoryUtils;

// Before modifying this code, please comment out the annotation below.
@SuppressWarnings("all")
@Mixin(value = GUITeleporter.class, remap = false)
public abstract class DE_GUITeleporter_Mixin {

    @Shadow
    private ItemStack teleporterItem;

    @Shadow
    private EntityPlayer player;

    @Shadow
    protected List<Teleporter.TeleportLocation> locations = new ArrayList<Teleporter.TeleportLocation>(0);

    @Shadow
    private int tick = 0;

    @Shadow
    private int selected = 0;

    @Shadow
    private int selectionOffset = 0;

    @Shadow
    private boolean showFuelLight = true;

    private GUITeleporter theGUITeleporter = (GUITeleporter) ((Object) this);

    private boolean isBaubles = false;

    @Shadow
    protected abstract void readDataFromItem(ItemStack teleporter);

    private Teleporter.TeleportLocation getLocationSafely(int index) {
        if (index < locations.size() && index >= 0) return locations.get(index);
        return new Teleporter.TeleportLocation(0, 0, 0, 0, 0, 0, EnumChatFormatting.DARK_RED + "[Index Error]");
    }

    @Inject(method = "<init>", at = @At("TAIL"), cancellable = false)
    private void setBaubles(EntityPlayer player, CallbackInfo ci) {
        Optional<ItemStack> playerBaublesInventory = InventoryUtils
            .getItemInPlayerBaublesInventory(player, TeleporterMKII.class);
        if (player.getHeldItem() != null && player.getHeldItem()
            .getItem() == ModItems.teleporterMKII) {
            isBaubles = false;
        } else if (playerBaublesInventory.isPresent()) {
            teleporterItem = playerBaublesInventory.get();
            readDataFromItem(playerBaublesInventory.get());
            isBaubles = true;
        }
    }

    /**
     * @author Keriils
     * @reason the simpler method
     */
    @Overwrite(remap = false)
    public void updateScreen() {
        if (handOrBaubles()) {
            theGUITeleporter.mc.displayGuiScreen(null);
            theGUITeleporter.mc.setIngameFocus();
        }

        if (tick % 5 == 0 && locations.size() > 0
            && getLocationSafely(selected + selectionOffset).getDimensionName()
                .equals("")
            && banHand()) {
            if (isBaubles) {
                readDataFromItem(
                    InventoryUtils.getItemInPlayerBaublesInventory(player, TeleporterMKII.class)
                        .get());
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

    private boolean handOrBaubles() {
        if (player.isDead) return true;
        if (!isBaubles) {
            return player.getCurrentEquippedItem() == null || !player.getCurrentEquippedItem()
                .isItemEqual(new ItemStack(ModItems.teleporterMKII));
        }
        return false;
    }

    private boolean banHand() {
        if (isBaubles) return true;
        return player.getHeldItem() != null && player.getHeldItem()
            .getItem() == ModItems.teleporterMKII;
    }

}
