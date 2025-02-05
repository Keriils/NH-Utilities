package com.xir.NHUtilities.common.api.interfaces;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.utils.MetaObjectUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Interface for managing items or blocks with metadata.
 */
@SuppressWarnings("unused")
public interface IMetaTypeObject extends IMetaObjectProvider {

    /**
     * Initializes and registers the meta type object.
     * This method must be called in the {@link com.xir.NHUtilities.loader.ItemsLoader} and should internally call
     * {@link IMetaTypeObject#loadMetaItem()}
     */
    default void initializeMetaTypeObject() {
        this.getMTManager()
            .setMetaObject(this);
        this.loadMetaItem();
    }

    /**
     * Loads the meta items or blocks.
     * This method is called within {@link IMetaTypeObject#initializeMetaTypeObject()}
     */
    void loadMetaItem();

    /**
     * This method should be called within {@link IMetaTypeObject#loadMetaItem()}.
     * Of course, there are additional ways to add them
     * {@link com.xir.NHUtilities.common.api.MetaTypeManager#addMetaItem(String, int, String, String[])}.
     * 
     * @param aExtraFolder extra group folder for a series of items or blocks of the same type.
     */
    default ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder, String[] tooltips) {
        if (this instanceof Item item) {
            return MetaObjectUtil.addMetaItemUtil(getMTManager(), item, aName, aMeta, aExtraFolder, tooltips);
        } else if (this instanceof Block block) {
            return MetaObjectUtil.addMetaItemUtil(getMTManager(), block, aName, aMeta, aExtraFolder, tooltips);
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
