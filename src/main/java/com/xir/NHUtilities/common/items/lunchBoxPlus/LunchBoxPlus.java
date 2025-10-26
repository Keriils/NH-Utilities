package com.xir.NHUtilities.common.items.lunchBoxPlus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;
import com.xir.NHUtilities.inventory.lunchBoxPlus.FoodContainerInventoryPlus;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import squeek.spiceoflife.inventory.NBTInventory;
import squeek.spiceoflife.items.ItemFoodContainer;

public class LunchBoxPlus extends ItemFoodContainer implements IRegisterProvider {

    private static final String LUNCH_BOX_PLUS = "LunchBoxPlus";
    private static final int LUNCH_BOX_PLUS_SLOT_NUM = 54;

    public LunchBoxPlus() {
        super(LUNCH_BOX_PLUS, LUNCH_BOX_PLUS_SLOT_NUM);

        setTextureName("nhutilities:" + this.itemName);
        setUnlocalizedName(this.itemName);

        setCreativeTab(NHUCreativeTabs.NHUCreativeTab);

    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ) {
        // 本身就很大容量了 没必要和其他容器交互
        return false;
    }

    @Override
    public int getInventoryStackLimit(NBTInventory inventory) {
        return 64;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return pass == 0;
    }

    @Override
    public String getRegisterName() {
        return LUNCH_BOX_PLUS;
    }

    @Override
    public FoodContainerInventoryPlus getInventory(ItemStack itemStack) {
        return new FoodContainerInventoryPlus(this, itemStack);
    }
}
