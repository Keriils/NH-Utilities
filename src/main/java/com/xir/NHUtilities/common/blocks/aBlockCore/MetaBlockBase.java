package com.xir.NHUtilities.common.blocks.aBlockCore;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.xir.NHUtilities.common.api.MetaTypeManager;
import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.MetaObjectUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public abstract class MetaBlockBase extends BlockBase implements IMetaTypeObject {

    @SideOnly(Side.CLIENT)
    private String iconPathName;

    protected final String unlocalizedName;

    public MetaBlockBase(String aUnlocalizedName) {
        this.name = aUnlocalizedName;
        this.unlocalizedName = "block." + this.name;
        if (CommonUtil.isClientSide()) this.iconPathName = "nhutilities:MetaResources/" + getIconFolderName() + "/";
        RegisterUtil.registerBlock(this, this.getItemBlockClass(), this.getRegisterName());
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

    public abstract Class<? extends ItemBlock> getItemBlockClass();

    /**
     * Loads the meta items or blocks.
     * This method is called within {@link IMetaTypeObject#initializeMetaTypeObject()}
     */
    @Override
    public abstract void loadMetaItem();

    /**
     * return the block registered name
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
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public int getDamageValue(World aWorld, int aX, int aY, int aZ) {
        return aWorld.getBlockMetadata(aX, aY, aZ);
    }

    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return getMTManager().getIcon(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        MetaObjectUtil.registerIconUtil(getMTManager(), iconPathName, register);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> itemStackList) {
        getMTManager().getNameMap()
            .forEach((meta, name) -> itemStackList.add(new ItemStack(this, 1, meta)));
    }
}
