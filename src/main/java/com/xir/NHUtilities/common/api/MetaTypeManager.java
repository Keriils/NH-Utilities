package com.xir.NHUtilities.common.api;

import java.util.HashMap;
import java.util.Map;

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
    public static final MetaTypeManager MetaItem01 = create();
    // endregion

    // region Meta Block
    public static final MetaTypeManager MetaBlock01 = create();
    // endregion

    // region Manager
    private IMetaTypeObject metaObject;
    /**
     * IconMap only called in Client side.
     */
    private final Map<Integer, IIcon> iconMap = CommonUtil.isClientSide() ? new HashMap<>() : null;
    /**
     * <li>Called on the client side to set up groups for items or blocks.
     * <li>Used to manage extra group folders for a series of items or blocks of the same type.
     */
    private final Map<Integer, String> groupFoldersMap = CommonUtil.isClientSide() ? new HashMap<>() : null;
    private final Map<Integer, String> nameMap = new HashMap<>();
    private final Map<Integer, String[]> tooltipsMap = new HashMap<>();

    private MetaTypeManager() {}

    @Contract(" -> new")
    private static @NotNull MetaTypeManager create() {
        return new MetaTypeManager();
    }

    /**
     * Gets the icon map.
     *
     * @return the icon map
     */
    @Contract(pure = true)
    public Map<Integer, IIcon> getIconMap() {
        return this.iconMap;
    }

    /**
     * Gets the icon for a meta value.
     *
     * @return the icon
     */
    public IIcon getIcon(int aMeta) {
        return this.getIconMap()
            .get(aMeta);
    }

    /**
     * Gets the extra group folders map
     *
     * @return the group folders map
     */
    @Contract(pure = true)
    public Map<Integer, String> getGroupFoldersMap() {
        return this.groupFoldersMap;
    }

    /**
     * Gets the folder name for a meta value.
     *
     * @return the extra group folder for a series of items or blocks of the same type
     */
    public String getFolderName(int aMeta) {
        return this.getGroupFoldersMap()
            .get(aMeta);
    }

    /**
     * Gets the name map.
     *
     * @return the name map
     */
    @Contract(pure = true)
    public Map<Integer, String> getNameMap() {
        return this.nameMap;
    }

    /**
     * Gets the name for a meta value.
     *
     * @return the item or block name
     */
    public String getName(int aMeta) {
        return this.getNameMap()
            .get(aMeta);
    }

    /**
     * Gets the tooltips map.
     *
     * @return the tooltips map
     */
    @Contract(pure = true)
    public Map<Integer, String[]> getTooltipsMap() {
        return this.tooltipsMap;
    }

    /**
     * Gets the tooltips for a meta value.
     *
     * @return the tooltips
     */
    public String[] getTooltips(int aMeta) {
        return this.getTooltipsMap()
            .get(aMeta);
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

    /**
     * Sets the meta object of item or block which implements {@link IMetaTypeObject}.
     */
    public void setMetaObject(IMetaTypeObject object) {
        this.metaObject = object;
    }
    // endregion
}
