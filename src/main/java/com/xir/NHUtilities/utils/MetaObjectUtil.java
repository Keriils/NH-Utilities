package com.xir.NHUtilities.utils;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.MTOData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class MetaObjectUtil {

    private MetaObjectUtil() {}

    @Contract("_, _, _, _, _, _ -> new")
    public static @NotNull ItemStack addMetaItemUtil(MTOData<?> manager, Item item, String aName, int aMeta,
        String aExtraFolder, String[] tooltips) {
        mapUtil(manager, aName, aMeta, aExtraFolder, tooltips);
        return new ItemStack(item, 1, aMeta);
    }

    @Contract("_, _, _, _, _, _ -> new")
    public static @NotNull ItemStack addMetaItemUtil(MTOData<?> manager, Block block, String aName, int aMeta,
        String aExtraFolder, String[] tooltips) {
        mapUtil(manager, aName, aMeta, aExtraFolder, tooltips);
        return new ItemStack(block, 1, aMeta);
    }

    private static void mapUtil(@NotNull MTOData<?> manager, String aName, int aMeta, String aExtraFolder,
        String[] tooltips) {
        var nameMap = manager.NAME_MAP;
        if (nameMap.containsKey(aMeta))
            throw new IllegalArgumentException("This meta value has benn set to " + nameMap.get(aMeta));
        nameMap.put(aMeta, aName);
        if (aExtraFolder != null) manager.GROUP_FOLDERS_MAP.put(aMeta, aExtraFolder);
        if (tooltips != null && tooltips.length >= 1) manager.TOOLTIPS_MAP.put(aMeta, tooltips);
    }

    @SideOnly(Side.CLIENT)
    public static void registerIconUtil(@NotNull MTOData<?> manager, String iconPathName, IIconRegister register) {
        Map<Integer, IIcon> iconMap = manager.ICON_MAP;
        Map<Integer, String> nameMap = manager.NAME_MAP;
        Map<Integer, String> groupFoldersMap = manager.GROUP_FOLDERS_MAP;

        for (Map.Entry<Integer, String> entry : nameMap.entrySet()) {
            int meta = entry.getKey();
            String baseIconPath = entry.getValue();
            String groupFolder = groupFoldersMap.get(meta);

            String fullIconPath = groupFolder != null ? iconPathName + "/" + groupFolder + "/" + baseIconPath
                : iconPathName + baseIconPath;

            iconMap.put(meta, register.registerIcon(fullIconPath));
        }
    }

}
