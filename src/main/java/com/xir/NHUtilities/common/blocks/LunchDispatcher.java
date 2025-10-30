package com.xir.NHUtilities.common.blocks;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.api.interfaces.IRegisterTileProvider;
import com.xir.NHUtilities.common.blocks.aBlockCore.BlockBase;
import com.xir.NHUtilities.common.tiles.TileLunchDispatcher;
import com.xir.NHUtilities.handler.NHUGuiHandler;
import com.xir.NHUtilities.main.NHUtilities;
import com.xir.NHUtilities.utils.CommonUtil;

public class LunchDispatcher extends BlockBase implements IRegisterTileProvider<TileLunchDispatcher> {

    public LunchDispatcher() {
        super("LunchDispatcher");
        this.setHardness(7.0f);
        this.setResistance(150.0f);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        var ret = new ArrayList<ItemStack>();
        ret.add(NHUItemList.LunchDispatcher.get(1));
        if (world.getTileEntity(x, y, z) instanceof TileLunchDispatcher lunchDispatcher) {
            for (ItemStack is : lunchDispatcher.getIdCardInv()) {
                if (CommonUtil.isStackValid(is)) ret.add(is);
            }
        }
        return ret;
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        if (worldIn.isRemote) return true;

        var te = CommonUtil.<TileLunchDispatcher>getWorldTE(worldIn, x, y, z);
        if (te != null) {
            player.openGui(NHUtilities.instance, NHUGuiHandler.lunchDispatcherGuid, worldIn, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, int x, int y, int z, EntityLivingBase placer, ItemStack itemIn) {
        super.onBlockPlacedBy(worldIn, x, y, z, placer, itemIn);
        if (!worldIn.isRemote && placer instanceof EntityPlayerMP player) {
            TileLunchDispatcher te = (TileLunchDispatcher) worldIn.getTileEntity(x, y, z);
            te.setOwnerUUid(player.getUniqueID());
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileLunchDispatcher();
    }

    @Override
    public Class<TileLunchDispatcher> getTeClass() {
        return TileLunchDispatcher.class;
    }
}
