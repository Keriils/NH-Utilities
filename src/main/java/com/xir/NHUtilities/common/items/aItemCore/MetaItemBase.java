package com.xir.NHUtilities.common.items.aItemCore;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.xir.NHUtilities.common.api.MTOData;
import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.MetaObjectUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public class MetaItemBase extends ItemBase implements IMetaTypeObject {

    @SideOnly(Side.CLIENT)
    private String iconPathName;

    protected MTOData<? extends IMetaTypeObject> mtoData;

    protected final String unlocalizedName;

    public MetaItemBase(String aUnlocalizedName) {
        this.name = aUnlocalizedName;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.unlocalizedName = "item." + this.name;
        if (CommonUtil.isClientSide()) this.iconPathName = "nhutilities:MetaResources/" + getIconFolderName() + "/";
        RegisterUtil.registerItem(this);
    }

    @Override
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return mtoData.getName(meta) != null ? (getUnlocalizedName() + "." + meta) : "nhutilities.null";
    }

    @Override
    public MTOData<?> getMTOData() {
        return this.mtoData;
    }

    @Override
    public <T extends IMetaTypeObject> IMetaTypeObject setMtoData(MTOData<T> mtoData) {
        if (this.mtoData != null) throw new IllegalStateException();
        this.mtoData = mtoData;
        return this;
    }

    /**
     * Returns the icon folder path for this meta type.
     * Each meta type has its specific icon location.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public String getIconFolderName() {
        return this.name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return mtoData.getIcon(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        MetaObjectUtil.registerIconUtil(mtoData, iconPathName, register);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> itemStackList) {
        mtoData.NAME_MAP.forEach((meta, name) -> itemStackList.add(new ItemStack(this, 1, meta)));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> aList, boolean b3h) {
        int meta = itemStack.getItemDamage();
        String[] tooltip = mtoData.getTooltips(meta);
        if (tooltip != null) aList.addAll(Arrays.asList(tooltip));
    }
}
