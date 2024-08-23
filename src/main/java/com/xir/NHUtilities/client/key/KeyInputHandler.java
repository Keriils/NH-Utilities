package com.xir.NHUtilities.client.key;

import java.util.Optional;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.brandon3055.draconicevolution.DraconicEvolution;
import com.brandon3055.draconicevolution.client.gui.GuiHandler;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.utills.InventoryUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Registers keyInput event by external method for draconic evolution teleporterMKII.
 * This method can also be used to register other key events for this mod if needed.
 */
public class KeyInputHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.toggleTeleporterMKII.isPressed()) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            World world = player.worldObj;
            Optional<ItemStack> teleporterMKIIOptional = InventoryUtils
                .getItemInPlayerBaublesInventory(player, TeleporterMKII.class);

            if (teleporterMKIIOptional.isPresent()) {
                if (world.isRemote) {
                    FMLNetworkHandler.openGui(
                        player,
                        DraconicEvolution.instance,
                        GuiHandler.GUIID_TELEPORTER,
                        world,
                        (int) player.posX,
                        (int) player.posY,
                        (int) player.posZ);
                }
            }
        }
    }
}
