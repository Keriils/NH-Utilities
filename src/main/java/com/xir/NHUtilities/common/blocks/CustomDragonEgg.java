package com.xir.NHUtilities.common.blocks;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.NHUCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;

public class CustomDragonEgg extends BlockDragonEgg implements IRegisterProvider {

    private final String registerName;

    public CustomDragonEgg(String name) {
        this.registerName = name;
        this.setHardness(100.0F);
        this.setResistance(9999999.9F);
        this.setStepSound(Block.soundTypePiston);
        this.setCreativeTab(NHUCreativeTab);
        this.setBlockName(name);
        this.setBlockTextureName("nhutilities:" + name);
    }

    @Override
    public String getUnlocalizedName() {
        return "block." + this.registerName;
    }

    @Override
    public void onBlockClicked(World worldIn, int x, int y, int z, EntityPlayer player) {}

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
        float subY, float subZ) {
        return true;
    }

    @Override
    public String getRegisterName() {
        return registerName;
    }
}
