package com.xir.NHUtilities.utils;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.xir.NHUtilities.common.api.MetaTypeManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaObjectUtil {

    public static ItemStack addMetaItemUtil(MetaTypeManager manager, Item item, String aName, int aMeta,
        String aExtraFolder, String[] tooltips) {
        mapUtil(manager, aName, aMeta, aExtraFolder, tooltips);
        return new ItemStack(item, 1, aMeta);
    }

    public static ItemStack addMetaItemUtil(MetaTypeManager manager, Block block, String aName, int aMeta,
        String aExtraFolder, String[] tooltips) {
        mapUtil(manager, aName, aMeta, aExtraFolder, tooltips);
        return new ItemStack(block, 1, aMeta);
    }

    private static void mapUtil(MetaTypeManager manager, String aName, int aMeta, String aExtraFolder,
        String[] tooltips) {
        manager.getNameMap()
            .put(aMeta, aName);
        if (aExtraFolder != null) manager.getGroupFoldersMap()
            .put(aMeta, aExtraFolder);
        if (tooltips != null && tooltips.length >= 1) manager.getTooltipsMap()
            .put(aMeta, tooltips);
    }

    @SideOnly(Side.CLIENT)
    public static void registerIconUtil(MetaTypeManager manager, String iconPathName, IIconRegister register) {
        Map<Integer, IIcon> iconMap = manager.getIconMap();
        Map<Integer, String> nameMap = manager.getNameMap();
        Map<Integer, String> groupFoldersMap = manager.getGroupFoldersMap();

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
