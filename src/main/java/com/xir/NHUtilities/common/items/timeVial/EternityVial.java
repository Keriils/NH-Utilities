package com.xir.NHUtilities.common.items.timeVial;

import static com.xir.NHUtilities.config.Config.enableEternityVialCosmicRenderDeepening;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.main.ReferencedInfo;
import com.xir.NHUtilities.utils.TooltipsChroma;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.items.LudicrousItems;
import fox.spiteful.avaritia.render.ICosmicRenderItem;

public class EternityVial extends TimeVial implements ICosmicRenderItem {

    private IIcon cosmicMask;

    public EternityVial() {
        setMaxStackSize(1);
        setUnlocalizedName("EternityVial");
        setTextureName("TimeVial/EternityVial");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        super.registerIcons(register);
        this.cosmicMask = register.registerIcon(
            enableEternityVialCosmicRenderDeepening ? "nhutilities:TimeVial/EternityVial_mask"
                : "nhutilities:TimeVial/EternityVial_mask2");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return LudicrousItems.cosmic;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void getInfoFromNBT(@NotNull ItemStack stack, @NotNull List<String> list) {
        list.add(TooltipsChroma.applyChromaEffect(StatCollector.translateToLocal("text.EternityVial.details_0")));
    }

    @Override
    protected void mergeSameVialTime(@NotNull EntityPlayer player, ItemStack stack) {}

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity playerIn, int slot, boolean isHeld) {}

    @Override
    protected boolean consumeTimeData(@NotNull ItemStack stack, int consumedTick) {
        return true;
    }

    @Override
    public IIcon getMaskTexture(ItemStack stack, EntityPlayer player) {
        return this.cosmicMask;
    }

    @Override
    public float getMaskMultiplier(ItemStack stack, EntityPlayer player) {
        return 1.0F;
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    public String getItemStackDisplayName(ItemStack stack) {
        if (ReferencedInfo.IS_CLIENT_SIDE) {
            return I18n.format(this.getUnlocalizedNameInefficiently(stack) + ".name")
                + I18n.format("text.EternityVial.tips")
                + I18n.format(
                    TooltipsChroma.applyChromaEffect(StatCollector.translateToLocal("text.EternityVial.details_0")))
                + "§r";
        } else {
            return super.getItemStackDisplayName(stack);
        }
    }
}
