package com.xir.NHUtilities.common.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;
import com.xir.NHUtilities.utils.CommonUtil;

/**
 * <li>Manages meta-able objects and registers all meta items or blocks.
 * <li>This class is designed to handle the registration and management of meta items or blocks,
 * including their icons, metaData, and tooltips.
 */
@SuppressWarnings("unused")
public class MetaTypeManager {

    // region Meta Item
    public static final MetaTypeManager MetaItem = create();
    // endregion

    // region Meta Block
    public static final MetaTypeManager MetaBlock = create();
    // endregion

    // region Manager
    private IMetaTypeObject metaObject;
    /**
     * The name map which is the name of the meta item.
     */
    public final Map<Integer, String> NAME_MAP = new LinkedHashMap<>();
    /**
     * The tooltips map.
     */
    public final Map<Integer, String[]> TOOLTIPS_MAP = new HashMap<>();
    /**
     * IconMap only called in Client side.
     */
    public final Map<Integer, IIcon> ICON_MAP = CommonUtil.isClientSide() ? new HashMap<>() : null;
    /**
     * <li>The extra group folders map, but in server side should be null.
     * <li>Called on the client side to set up groups for items or blocks.
     * <li>Used to manage extra group folders for a series of items or blocks of the same type.
     */
    public final Map<Integer, String> GROUP_FOLDERS_MAP = CommonUtil.isClientSide() ? new HashMap<>() : null;

    private MetaTypeManager() {}

    @Contract(" -> new")
    private static @NotNull MetaTypeManager create() {
        return new MetaTypeManager();
    }

    /**
     * An additional method to add meta item, but should after the metaObject is initialized or
     * {@link IMetaTypeObject#initializeMetaTypeObject()}.
     */
    public ItemStack addMetaItem(String aName, int aMeta, String aExtraFolder, String[] tooltips) {
        if (metaObject == null) throw new IllegalStateException("MetaObject has been set in this time.");
        return metaObject.addMetaItem(aName, aMeta, aExtraFolder, tooltips);
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

    // region Getter
    /**
     * Gets the icon for a meta value.
     *
     * @return the icon
     */
    public IIcon getIcon(int aMeta) {
        return this.ICON_MAP.get(aMeta);
    }

    /**
     * Gets the folder name for a meta value.
     *
     * @return the extra group folder for a series of items or blocks of the same type
     */
    public String getFolderName(int aMeta) {
        return this.GROUP_FOLDERS_MAP.get(aMeta);
    }

    /**
     * Gets the name for a meta value.
     *
     * @return the item or block name
     */
    public String getName(int aMeta) {
        return this.NAME_MAP.get(aMeta);
    }

    /**
     * Gets the tooltips for a meta value.
     *
     * @return the tooltips
     */
    public String[] getTooltips(int aMeta) {
        return this.TOOLTIPS_MAP.get(aMeta);
    }

    /**
     * Gets the meta object.
     *
     * @return the meta object of item or block
     */
    @Contract(pure = true)
    public IMetaTypeObject getMetaObject() {
        return this.metaObject;
    }
    // endregion

    /**
     * Sets the meta object of item or block which implements {@link IMetaTypeObject}.
     */
    public void setMetaObject(IMetaTypeObject object) {
        if (metaObject != null) throw new IllegalStateException("MetaObject has been set.");
        this.metaObject = object;
    }
    // endregion
}
