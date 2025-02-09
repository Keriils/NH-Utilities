package com.xir.NHUtilities.common.api.interfaces;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.MTOData;
import com.xir.NHUtilities.utils.MetaObjectUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public interface IMetaTypeObject extends IMetaObjectProvider {

    <T extends IMetaTypeObject> IMetaTypeObject setMtoData(MTOData<T> mtoData);

    default ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder, String[] tooltips) {
        if (this instanceof Item item) {
            return MetaObjectUtil.addMetaItemUtil(getMTOData(), item, aName, aMeta, aExtraFolder, tooltips);
        } else if (this instanceof Block block) {
            return MetaObjectUtil.addMetaItemUtil(getMTOData(), block, aName, aMeta, aExtraFolder, tooltips);
        } else throw new IllegalArgumentException("Wrong Registration Args.");
    }

    default ItemStack addMetaItem(String aName, int aMeta) {
        return addMetaItem(aName, aMeta, null, null);
    }

    default ItemStack addMetaItem(String aName, int aMeta, String[] tooltips) {
        return addMetaItem(aName, aMeta, null, tooltips);
    }

    default ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder) {
        return addMetaItem(aName, aMeta, aExtraFolder, null);
    }

    /**
     * Returns the icon folder path for this meta type.
     * Each meta type has its specific icon location.
     */
    @SideOnly(Side.CLIENT)
    String getIconFolderName();

}
