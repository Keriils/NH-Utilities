package com.xir.NHUtilities.Mixins.late;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

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

// Before modifying this code, please comment out the annotation below.
@SuppressWarnings("all")
@Mixin(value = GUITeleporter.class, remap = true)
public abstract class DE_GUITeleporter_Mixin {

    @Shadow(remap = false)
    private ItemStack teleporterItem;

    @Shadow(remap = false)
    private EntityPlayer player;

    @Shadow(remap = false)
    protected List<Teleporter.TeleportLocation> locations = new ArrayList<Teleporter.TeleportLocation>(0);

    @Shadow(remap = false)
    private int tick = 0;

    @Shadow(remap = false)
    private int selected = 0;

    @Shadow(remap = false)
    private int selectionOffset = 0;

    @Shadow(remap = false)
    private boolean showFuelLight = true;

    @Unique
    private final GUITeleporter theGUITeleporter = (GUITeleporter) ((Object) this);

    @Unique
    private boolean isBaubles = false;

    @Shadow(remap = false)
    protected abstract void readDataFromItem(ItemStack teleporter);

    @Unique
    private Teleporter.TeleportLocation getLocationSafely(int index) {
        if (index < locations.size() && index >= 0) return locations.get(index);
        return new Teleporter.TeleportLocation(0, 0, 0, 0, 0, 0, EnumChatFormatting.DARK_RED + "[Index Error]");
    }

    @Inject(method = "<init>", at = @At("TAIL"))
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
     * @author Keriils -> wo shi zhu bi
     * @reason the simpler method
     */
    @Overwrite(remap = true)
    public void updateScreen() {
        if (handOrBaubles()) {
            theGUITeleporter.mc.displayGuiScreen(null);
            theGUITeleporter.mc.setIngameFocus();
        }

        if (tick % 5 == 0 && !locations.isEmpty()
            && getLocationSafely(selected + selectionOffset).getDimensionName()
                .isEmpty()
            && banHand()) {
            if (isBaubles) {
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
    private boolean handOrBaubles() {
        if (player.isDead) return true;
        if (!isBaubles) {
            return player.getCurrentEquippedItem() == null || !player.getCurrentEquippedItem()
                .isItemEqual(new ItemStack(ModItems.teleporterMKII));
        }
        return false;
    }

    @Unique
    private boolean banHand() {
        if (isBaubles) return true;
        return player.getHeldItem() != null && player.getHeldItem()
            .getItem() == ModItems.teleporterMKII;
    }

}
