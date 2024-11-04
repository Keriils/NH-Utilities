package com.xir.NHUtilities.common.blocks;

import static com.xir.NHUtilities.loader.CreativeTabsLoader.nhuCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ChaosDragonEgg extends BlockDragonEgg {

    public ChaosDragonEgg(String name) {
        String localName = "nhutilities:" + name;
        this.setHardness(100.0F);
        this.setResistance(9999999.9F);
        this.setStepSound(Block.soundTypePiston);
        this.setCreativeTab(nhuCreativeTab);
        this.setBlockName(localName);
        this.setBlockTextureName(localName);
    }

    @Override
    public void onBlockClicked(World worldIn, int x, int y, int z, EntityPlayer player) {}

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        return true;
    }
}
