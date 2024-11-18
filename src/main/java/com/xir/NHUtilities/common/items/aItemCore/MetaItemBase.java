package com.xir.NHUtilities.common.items.aItemCore;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.MetaObjectUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public abstract class MetaItemBase extends ItemBase implements IMetaTypeObject {

    @SideOnly(Side.CLIENT)
    private String iconPathName;

    protected final String unlocalizedName;

    public MetaItemBase(String aUnlocalizedName) {
        this.name = aUnlocalizedName;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.unlocalizedName = "item." + this.name;
        if (CommonUtil.isClientSide()) this.iconPathName = "nhutilities:MetaResources/" + getIconFolderName() + "/";
        RegisterUtil.registerItem(this);
    }

    public ItemStack addMetaItem(String aName, int aMeta) {
        return addMetaItem(aName, aMeta, null, null);
    }

    public ItemStack addMetaItem(String aName, int aMeta, String[] tooltips) {
        return addMetaItem(aName, aMeta, null, tooltips);
    }

    public ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder) {
        return addMetaItem(aName, aMeta, aExtraFolder, null);
    }

    @Override
    public ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder, String[] tooltips) {
        return MetaObjectUtil.addMetaItemUtil(getMTManager(), this, aName, aMeta, aExtraFolder, tooltips);
    }

    @Override
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return getMTManager().getName(meta) != null ? (getUnlocalizedName() + "." + meta) : "nhutilities.null";
    }

    /**
     * Loads the meta items or blocks.
     * This method is called within {@link IMetaTypeObject#initializeMetaTypeObject()}
     */
    @Override
    public abstract void loadMetaItem();

    /**
     * return the item registered name
     */
    @Override
    public abstract String getRegisterName();

    /**
     * return the MetaTypeManager registered in {@link MetaTypeManager}
     */
    @Override
    public abstract MetaTypeManager getMTManager();

    /**
     * Returns the icon folder path for this meta type.
     * Each meta type has its specific icon location.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public abstract String getIconFolderName();

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return getMTManager().getIcon(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        MetaObjectUtil.registerIconUtil(getMTManager(), iconPathName, register);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> itemStackList) {
        getMTManager().getNameMap()
            .forEach((meta, name) -> itemStackList.add(new ItemStack(this, 1, meta)));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> aList, boolean b3h) {
        int meta = itemStack.getItemDamage();
        String[] tooltip = getMTManager().getTooltipsMap()
            .get(meta);
        if (tooltip != null) aList.addAll(Arrays.asList(tooltip));
    }
}
