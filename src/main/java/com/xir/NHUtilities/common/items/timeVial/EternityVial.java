package com.xir.NHUtilities.common.items.timeVial;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.utils.TooltipsChroma;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.items.LudicrousItems;

// @Optional.Interface(iface = "fox.spiteful.avaritia.render.ICosmicRenderItem",modid = "Avaritia")
public class EternityVial extends TimeVial /* implements ICosmicRenderItem */ {

    // private IIcon cosmicMask; // to do ...
    // private IIcon GTNH;

    public EternityVial() {
        setMaxStackSize(1);
        setUnlocalizedName("EternityVial");
        setTextureName("EternityVial");
    }

    // @Override
    // @SideOnly(Side.CLIENT)
    // public void registerIcons(IIconRegister register) {
    // super.registerIcons(register);
    // this.cosmicMask = register.registerIcon(NHUtilities.MODID + ":" + "EternityVial_mask3");
    // this.GTNH = register.registerIcon(NHUtilities.MODID + ":" + "icon_GTNH");
    // }
    //
    // @Override
    // public IIcon getIcon(ItemStack stack, int pass) {
    // if (pass == 1) {
    // return this.GTNH;
    // }
    //
    // return super.getIcon(stack, pass);
    // }

    @Override
    @Optional.Method(modid = "Avaritia")
    public EnumRarity getRarity(ItemStack stack) {
        return LudicrousItems.cosmic;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void getInfoFromNBT(@NotNull ItemStack stack, List<String> list) {
        list.add(
            TooltipsChroma
                .applyChromaEffect(StatCollector.translateToLocal("text.NHUtilities.EternityVial.details_0")));
    }

    @Override
    protected void mergeSameVialTime(@NotNull EntityPlayer player, ItemStack stack) {}

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity playerIn, int slot, boolean isHeld) {}

    @Override
    protected boolean shouldAndConsumeTimeData(@NotNull ItemStack stack, int consumedTick) {
        return true;
    }

    // @Override
    // public IIcon getMaskTexture(ItemStack stack, EntityPlayer player) {
    // return this.cosmicMask;
    // }
    //
    // @Override
    // public float getMaskMultiplier(ItemStack stack, EntityPlayer player) {
    // return 1.0F;
    // }
}
