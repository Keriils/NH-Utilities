package com.xir.NHUtilities.common.items.metaItemImpl;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.items.aItemCore.MetaItemBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.render.ICosmicRenderItem;

public class MetaItem extends MetaItemBase implements ICosmicRenderItem {

    private IIcon cosmicCys;

    public MetaItem() {
        super("MetaItem");
        this.setCreativeTab(NHUCreativeTabs.MetaItemTab);
    }

    @Override
    public void loadMetaItem() {

        NHUItemList.IchorFuelRod.set(addMetaItem("IchorFuelRod", 0));
        NHUItemList.ShadowFuelRod.set(addMetaItem("ShadowFuelRod", 1));
        NHUItemList.IchorDroplet.set(addMetaItem("IchorDroplet", 2));
        NHUItemList.PrimordialPearlDust.set(addMetaItem("PrimordialPearlDust", 3));
        NHUItemList.ChaosDraconiumEgg.set(addMetaItem("ChaosDraconiumEgg", 4));
        NHUItemList.AncientDraconiumEgg.set(addMetaItem("AncientDraconiumEgg", 5));
        NHUItemList.TestItem.set(addMetaItem("TestItem", 6));
        NHUItemList.TestItem2.set(addMetaItem("TestItem2", 7));
        NHUItemList.MetaDust1.set(addMetaItem("MetaDust", 101));
        NHUItemList.MetaDust2.set(addMetaItem("MetaDust2", 102));
        NHUItemList.MetaDust2.set(addMetaItem("MetaDust2", 102));
        NHUItemList.MetaDust3.set(addMetaItem("MetaDust3", 103));
        NHUItemList.MetaDust4.set(addMetaItem("MetaDust4", 104));
        NHUItemList.PlateCrystal1.set(addMetaItem("PlateCrystal1", 113));
        NHUItemList.PlateCrystal2.set(addMetaItem("PlateCrystal2", 114));
        NHUItemList.PlateCrystal3.set(addMetaItem("PlateCrystal3", 115));
        NHUItemList.PlateCrystal4.set(addMetaItem("PlateCrystal4", 116));
        NHUItemList.PlateCrystal5.set(addMetaItem("PlateCrystal5", 117));
        NHUItemList.PlateCrystal6.set(addMetaItem("PlateCrystal6", 118));
        NHUItemList.PlateCrystal7.set(addMetaItem("PlateCrystal7", 119));
        NHUItemList.PlateCrystal8.set(addMetaItem("PlateCrystal8", 120));
        NHUItemList.PlateCrystal9.set(addMetaItem("PlateCrystal9", 121));
        NHUItemList.PlateCrystal1_Hot.set(addMetaItem("PlateCrystal1_Hot", 123));
        NHUItemList.PlateCrystal2_Hot.set(addMetaItem("PlateCrystal2_Hot", 124));
        NHUItemList.PlateCrystal3_Hot.set(addMetaItem("PlateCrystal3_Hot", 125));
        NHUItemList.PlateCrystal4_Hot.set(addMetaItem("PlateCrystal4_Hot", 126));
        NHUItemList.PlateCrystal5_Hot.set(addMetaItem("PlateCrystal5_Hot", 127));
        NHUItemList.PlateCrystal6_Hot.set(addMetaItem("PlateCrystal6_Hot", 128));
        NHUItemList.PlateCrystal7_Hot.set(addMetaItem("PlateCrystal7_Hot", 129));
        NHUItemList.PlateCrystal8_Hot.set(addMetaItem("PlateCrystal8_Hot", 130));
        NHUItemList.PlateCrystal9_Hot.set(addMetaItem("PlateCrystal9_Hot", 131));

    }

    @Override
    public String getRegisterName() {
        return "MetaItem";
    }

    @Override
    public MetaTypeManager getMTManager() {
        return MetaTypeManager.MetaItem;
    }

    @Override
    public String getIconFolderName() {
        return "MetaItem";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        super.registerIcons(register);
        this.cosmicCys = register.registerIcon("nhutilities:MetaResources/MetaItem/PlateCrystal9_mask");
    }

    @Override
    public IIcon getMaskTexture(ItemStack stack, EntityPlayer player) {
        return this.cosmicCys;
    }

    @Override
    public float getMaskMultiplier(ItemStack stack, EntityPlayer player) {
        return 0.3F;
    }
}
