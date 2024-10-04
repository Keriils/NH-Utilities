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

import com.xir.NHUtilities.common.items.baubles.WarpRing;
import com.xir.NHUtilities.utils.InventoryUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import shukaro.warptheory.util.ChatHelper;
import thaumcraft.common.Thaumcraft;

public class WarpWardRingEvent {

    @SubscribeEvent
    public void onWarpWardRingPlacingGTBlocks(BlockEvent.PlaceEvent event) {
        int x = event.x, y = event.y, z = event.z;
        EntityPlayer player = event.player;
        World world = event.world;
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null) return;
        Optional<ItemStack> baublesItem = InventoryUtils.getItemInPlayerBaublesInventory(player, WarpRing.class);
        if (!baublesItem.isPresent()) return;
        if (tileEntity instanceof BaseMetaTileEntity) {
            Random random = new Random();
            int number = random.nextInt(1000) + 1;
            if (number <= 1000) {
                String name = player.getCommandSenderName();
                int wp = Knowledge.getWarpPerm(name);
                int wn = Knowledge.getWarpSticky(name);
                int wt = Knowledge.getWarpTemp(name);
                int wc = Knowledge.getWarpCounter(name);
                if (wc == 0) {
                    return;
                } else {
                    if (number <= 500) {
                        if (wt >= 1) {
                            int newWt = wt-2;
                            Knowledge.warpTemp.replace(name,wt,newWt);
                            Knowledge.setWarpCounter(name,wc-1);
                            ChatHelper.sendToPlayer(player, StatCollector.translateToLocal("chat.nhutilities.1"));
                            return;
                        }
                    } else if (number <= 900) {
                        if (wn >= 1) {
                            Knowledge.setWarpSticky(name, wn - 1);
                            Knowledge.setWarpTemp(name, wt + 1);
                            ChatHelper.sendToPlayer(player, StatCollector.translateToLocal("chat.nhutilities.2"));
                            return;
                        }
                    } else {
                        if (wp >= 1) {
                            Knowledge.setWarpPerm(name, wp - 1);
                            Knowledge.setWarpSticky(name, wn + 1);
                            ChatHelper.sendToPlayer(player, StatCollector.translateToLocal("chat.nhutilities.3"));
                            return;
                        }
                    }
                }
            }
        }
    }
}
