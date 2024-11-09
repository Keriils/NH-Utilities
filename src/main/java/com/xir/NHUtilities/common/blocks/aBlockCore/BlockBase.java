package com.xir.NHUtilities.common.blocks.aBlockCore;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.nhuCreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The aim is to simplify some writing as well as others
 */
@SuppressWarnings("unused")
public class BlockBase extends Block {

    protected static final String BLOCK_LANG_KEY_STRING = "block.NHUtilities:";
    protected String name;

    public BlockBase() {
        this("_null_", nhuCreativeTab, Material.iron);
    }

    public BlockBase(String aName) {
        this(aName, nhuCreativeTab, Material.iron);
    }

    public BlockBase(String aName, Material aMaterial) {
        this(aName, nhuCreativeTab, aMaterial);
    }

    public BlockBase(String aName, CreativeTabs aCreativeTabs) {
        this(aName, aCreativeTabs, Material.iron);
    }

    public BlockBase(String aName, CreativeTabs aCreativeTabs, Material aMaterial) {
        super(aMaterial);
        this.setBlockTextureName(this.name = aName);
        this.setCreativeTab(aCreativeTabs);
    }

    @Override
    public Block setBlockTextureName(String textureName) {
        this.textureName = "nhutilities:" + textureName;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName() {
        return this.textureName == null ? "MISSING_ICON_BLOCK_" + getIdFromBlock(this) + "_" + this.name
            : this.textureName;
    }

    @Override
    public String getUnlocalizedName() {
        return BLOCK_LANG_KEY_STRING + this.name;
    }

    @Override
    public Block setBlockName(String name) {
        this.name = name;
        return this;
    }

    public String getBlockName() {
        return this.name;
    }

}
