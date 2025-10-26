package com.xir.NHUtilities.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.tiles.TileLunchDispatcher;
import com.xir.NHUtilities.container.ContainerLunchDispatcher;
import com.xir.NHUtilities.gui.GuiLunchDispatcher;
import com.xir.NHUtilities.main.NHUtilities;
import com.xir.NHUtilities.utils.CommonUtil;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public final class NHUGuiHandler implements IGuiHandler {

    public static final int lunchDispatcherGuid = 0;

    public static void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(NHUtilities.instance, new NHUGuiHandler());
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == lunchDispatcherGuid) {
            var te = CommonUtil.<TileLunchDispatcher>getWorldTE(world, x, y, z);
            if (te != null) {
                return new ContainerLunchDispatcher(player.inventory, te);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == lunchDispatcherGuid) {
            var te = CommonUtil.<TileLunchDispatcher>getWorldTE(world, x, y, z);
            if (te != null) {
                return new GuiLunchDispatcher(player.inventory, te);
            }
        }
        return null;
    }
}
