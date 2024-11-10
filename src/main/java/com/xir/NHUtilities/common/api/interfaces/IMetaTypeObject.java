package com.xir.NHUtilities.common.api.interfaces;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Interface for managing items or blocks with metadata.
 */
public interface IMetaTypeObject extends IMetaObjectProvider {

    /**
     * Initializes and registers the meta type object.
     * This method must be called in the {@link com.xir.NHUtilities.loader.ItemsLoader} and should internally call
     * {@link IMetaTypeObject#loadMetaItem()}
     */
    void initializeMetaTypeObject();

    /**
     * Loads the meta items or blocks.
     * This method is called within {@link IMetaTypeObject#initializeMetaTypeObject()}
     */
    void loadMetaItem();

    /**
     * This method should be called within {@link IMetaTypeObject#loadMetaItem()}
     *
     * @param aExtraFolder extra group folder for a series of items or blocks of the same type
     */
    ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder, String[] tooltips);

    /**
     * Returns the icon folder path for this meta type.
     * Each meta type has its specific icon location.
     */
    @SideOnly(Side.CLIENT)
    String getIconFolderName();

}
