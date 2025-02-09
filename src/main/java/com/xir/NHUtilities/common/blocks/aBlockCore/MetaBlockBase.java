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

import com.xir.NHUtilities.common.api.MTOData;
import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.MetaObjectUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public class MetaBlockBase extends BlockBase implements IMetaTypeObject {

    @SideOnly(Side.CLIENT)
    private String iconPathName;

    protected final String unlocalizedName;

    protected MTOData<? extends IMetaTypeObject> mtoData;

    // default class
    protected Class<? extends ItemBlock> itemBlockClass = MetaItemBlockBase.class;

    public MetaBlockBase(String aUnlocalizedName) {
        this.name = aUnlocalizedName;
        this.unlocalizedName = "block." + this.name;
        if (CommonUtil.isClientSide()) this.iconPathName = "nhutilities:MetaResources/" + getIconFolderName() + "/";
        RegisterUtil.registerBlock(this, this.getItemBlockClass(), this.getRegisterName());
    }

    public Class<? extends ItemBlock> getItemBlockClass() {
        return this.itemBlockClass;
    }

    public void setItemBlockClass(Class<? extends MetaItemBlockBase> itemBlockClass) {
        this.itemBlockClass = itemBlockClass;
    }

    @Override
    public <T extends IMetaTypeObject> IMetaTypeObject setMtoData(MTOData<T> mtoData) {
        if (this.mtoData != null) throw new IllegalStateException();
        this.mtoData = mtoData;
        return this;
    }

    @Override
    public MTOData<?> getMTOData() {
        return this.mtoData;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getIconFolderName() {
        return this.name;
    }

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
        return mtoData.getIcon(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        MetaObjectUtil.registerIconUtil(mtoData, iconPathName, register);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> itemStackList) {
        mtoData.NAME_MAP.forEach((meta, name) -> itemStackList.add(new ItemStack(this, 1, meta)));
    }
}
