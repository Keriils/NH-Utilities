package com.xir.NHUtilities.common.items.wand.foci;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatchMaintenance;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemFocusTape extends ItemFocusBasic implements IRegisterProvider {

    private final String name = "FocusTape";
    private static final AspectList cost = new AspectList().add(Aspect.ORDER, 500);

    public ItemFocusTape() {
        setMaxDamage(0);
        setMaxStackSize(1);
        setNoRepair();
        setCreativeTab(NHUCreativeTabs.NHUCreativeTab);
        setUnlocalizedName(name);
    }

    @Override
    public AspectList getVisCost(ItemStack focus) {
        return cost;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        icon = iconRegister.registerIcon("nhutilities:" + name);
    }

    @Override
    public String getSortingHelper(final ItemStack itemStack) {
        return "TAPE" + super.getSortingHelper(itemStack);
    }

    @Override
    public boolean isVisCostPerTick(ItemStack focusstack) {
        return false;
    }

    @Override
    public WandFocusAnimation getAnimation(ItemStack focusstack) {
        return WandFocusAnimation.CHARGE;
    }

    @Override
    public int getFocusColor(ItemStack focusstack) {
        return 0x404040;
    }

    @Override
    public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player,
        MovingObjectPosition movingobjectposition) {
        if (world.isRemote || movingobjectposition == null) {
            return wandstack;
        }
        ItemWandCasting wandCasting = (ItemWandCasting) wandstack.getItem();
        int x = movingobjectposition.blockX;
        int y = movingobjectposition.blockY;
        int z = movingobjectposition.blockZ;
        TileEntity mTileEntity = world.getTileEntity(x, y, z);
        if (!(mTileEntity instanceof BaseMetaTileEntity mBaseMetaTileEntity)) {
            return wandstack;
        }
        if (wandCasting != null
            && (mBaseMetaTileEntity.getMetaTileEntity() instanceof MTEHatchMaintenance hatchMaintenance)
            && (!hatchMaintenance.mWrench || !hatchMaintenance.mSolderingTool
                || !hatchMaintenance.mSoftMallet
                || !hatchMaintenance.mHardHammer
                || !hatchMaintenance.mScrewdriver
                || !hatchMaintenance.mCrowbar
                || hatchMaintenance.getBaseMetaTileEntity()
                    .isActive())) {
            if (wandCasting.consumeAllVis(wandstack, player, this.getVisCost(wandstack), true, false)) {
                hatchMaintenance.mHardHammer = true;
                hatchMaintenance.mCrowbar = true;
                hatchMaintenance.mScrewdriver = true;
                hatchMaintenance.mSoftMallet = true;
                hatchMaintenance.mSolderingTool = true;
                hatchMaintenance.mWrench = true;
                hatchMaintenance.getBaseMetaTileEntity()
                    .setActive(false);
                world.playSoundEffect(x, y, z, "thaumcraft:wand", 1.0F, 1.0F);
            }
        }
        return wandstack;
    }

    @Override
    public int getActivationCooldown(ItemStack stack) {
        return 10;
    }

    @Override
    public String getRegisterName() {
        return this.name;
    }
}
