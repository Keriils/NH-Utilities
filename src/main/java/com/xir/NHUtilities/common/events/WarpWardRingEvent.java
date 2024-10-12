package com.xir.NHUtilities.common.events;

import static shukaro.warptheory.handlers.WarpHandler.Knowledge;

import java.util.Optional;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.xir.NHUtilities.common.items.baubles.WarpWardRing;
import com.xir.NHUtilities.utils.InventoryUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import shukaro.warptheory.util.ChatHelper;
import shukaro.warptheory.util.FormatCodes;

public class WarpWardRingEvent {

    @SubscribeEvent
    public void onWarpWardRingPlacingGTBlocks(BlockEvent.PlaceEvent event) {
        int x = event.x, y = event.y, z = event.z;
        EntityPlayer player = event.player;
        World world = event.world;
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null) return;
        Optional<ItemStack> baublesItem = InventoryUtils.getItemInPlayerBaublesInventory(player, WarpWardRing.class);
        if (!baublesItem.isPresent()) return;
        if (tileEntity instanceof BaseMetaTileEntity) {
            Random random = new Random();
            int number = random.nextInt(100) + 1;
            if (number <= 3) {
                String name = player.getCommandSenderName();
                int warpPerm = Knowledge.getWarpPerm(name);
                int warpSticky = Knowledge.getWarpSticky(name);
                int warpTemp = Knowledge.getWarpTemp(name);
                int warpCounter = Knowledge.getWarpCounter(name);
                if (warpCounter == 0) {
                    ChatHelper.sendToPlayer(
                        player,
                        FormatCodes.Purple.code + FormatCodes.Italic.code
                            + StatCollector.translateToLocal("chat.nhutilities.1"));
                    return;
                } else {
                    int amount = random.nextInt(10) + 1;
                    if (warpCounter <= amount) {
                        Knowledge.setWarpTemp(name, 0);
                        Knowledge.setWarpSticky(name, 0);
                        Knowledge.setWarpPerm(name, 0);
                        Knowledge.setWarpCounter(name, 0);
                        ChatHelper.sendToPlayer(
                            player,
                            FormatCodes.Purple.code + FormatCodes.Italic.code
                                + StatCollector.translateToLocal("chat.nhutilities.2"));
                    } else {
                        Knowledge.setWarpCounter(name, warpCounter - amount);
                        if (warpTemp <= amount) {
                            Knowledge.setWarpTemp(name, 0);
                            amount -= warpTemp;
                            if (warpSticky <= amount) {
                                Knowledge.setWarpSticky(name, 0);
                                amount -= warpSticky;
                                if (warpPerm <= amount) {
                                    Knowledge.setWarpPerm(name, 0);
                                } else {
                                    Knowledge.setWarpPerm(name, warpPerm - amount);
                                }
                            } else {
                                Knowledge.setWarpSticky(name, warpSticky - amount);
                            }
                        } else {
                            Knowledge.setWarpTemp(name, warpTemp - amount);
                        }
                    }
                    ChatHelper.sendToPlayer(
                        player,
                        FormatCodes.Purple.code + FormatCodes.Italic.code
                            + StatCollector.translateToLocal("chat.nhutilities.3"));
                }
            }
        } else {
            return;
        }
    }
}
