package com.xir.NHUtilities.common.api.enums;

import static com.xir.NHUtilities.main.ReferencedInfo.RESOURCE_PATH;
import static gregtech.api.enums.Textures.BlockIcons.CustomIcon;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_ON_WIRELESS;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_ON_WIRELESS_16A;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_ON_WIRELESS_4A;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_ON_WIRELESS_64A;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAYS_ENERGY_ON_WIRELESS_LASER;

import java.util.HashMap;
import java.util.Map;

import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.render.TextureFactory;

@SuppressWarnings("unused")
public final class TexturesSets {

    // Only static constants are allowed
    public static void init() {}

    // for Test Machine or Common TT machine Texture
    public static final IIconContainer ScreenOFF = new CustomIcon("iconsets/EM_CONTROLLER");
    public static final IIconContainer ScreenON = new CustomIcon("iconsets/EM_CONTROLLER_ACTIVE");

    // for Tc EBF Texture
    public static final IIconContainer TC_EBF_ACTIVE = new CustomIcon(
        RESOURCE_PATH + "TcBlastFurnace/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_ACTIVE");
    public static final IIconContainer TC_EBF_ACTIVE_GLOW = new CustomIcon(
        RESOURCE_PATH + "TcBlastFurnace/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_ACTIVE_GLOW");
    public static final IIconContainer TC_EBF_NOT_ACTIVE = new CustomIcon(
        RESOURCE_PATH + "TcBlastFurnace/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE");
    public static final IIconContainer TC_EBF_NOT_ACTIVE_GLOW = new CustomIcon(
        RESOURCE_PATH + "TcBlastFurnace/OVERLAY_FRONT_THAUMIC_ELECTRIC_BLAST_FURNACE_GLOW");

    // region Wireless Tex
    private static final String WIRELESS_DIR = RESOURCE_PATH + "Wireless/";
    public static final IIconContainer OVERLAY_WIRELESS_256A = new CustomIcon(WIRELESS_DIR + "OVERLAY_WIRELESS_256A");
    public static final IIconContainer OVERLAY_WIRELESS_1024A = new CustomIcon(WIRELESS_DIR + "OVERLAY_WIRELESS_1024A");
    public static final IIconContainer OVERLAY_WIRELESS_4096A = new CustomIcon(WIRELESS_DIR + "OVERLAY_WIRELESS_4096A");
    public static final IIconContainer OVERLAY_WIRELESS_16384A = new CustomIcon(
        WIRELESS_DIR + "OVERLAY_WIRELESS_16384A");
    public static final IIconContainer OVERLAY_WIRELESS_65536A = new CustomIcon(
        WIRELESS_DIR + "OVERLAY_WIRELESS_65536A");
    public static final IIconContainer OVERLAY_WIRELESS_262144A = new CustomIcon(
        WIRELESS_DIR + "OVERLAY_WIRELESS_262144A");
    public static final IIconContainer OVERLAY_WIRELESS_1048576A = new CustomIcon(
        WIRELESS_DIR + "OVERLAY_WIRELESS_1048576A");
    public static final IIconContainer OVERLAY_WIRELESS_SPACETIME = new CustomIcon(
        WIRELESS_DIR + "OVERLAY_WIRELESS_SPACETIME");

    public static final Map<Integer, ITexture> WirelessCoverTextureMap = new HashMap<>() {

        {
            var args = new short[] { 255, 255, 255, 0 };
            var spaceTime = TextureFactory.of(OVERLAY_WIRELESS_SPACETIME, args);
            put(-1, spaceTime);
            put(2, OVERLAYS_ENERGY_ON_WIRELESS[0]);
            put(4, OVERLAYS_ENERGY_ON_WIRELESS_4A[0]);
            put(16, OVERLAYS_ENERGY_ON_WIRELESS_16A[0]);
            put(64, OVERLAYS_ENERGY_ON_WIRELESS_64A[0]);
            put(256, TextureFactory.of(OVERLAY_WIRELESS_256A, args));
            put(1_024, TextureFactory.of(OVERLAY_WIRELESS_1024A, args));
            put(4_096, TextureFactory.of(OVERLAY_WIRELESS_4096A, args));
            put(16_384, TextureFactory.of(OVERLAY_WIRELESS_16384A, args));
            put(65_536, TextureFactory.of(OVERLAY_WIRELESS_65536A, args));
            put(262_144, TextureFactory.of(OVERLAY_WIRELESS_262144A, args));
            put(1_048_576, TextureFactory.of(OVERLAY_WIRELESS_1048576A, args));
            put(4_194_304, OVERLAYS_ENERGY_ON_WIRELESS_LASER[0]);
            put(16_777_216, spaceTime);
        }

    };

    public static ITexture getWirelessTex(int aAmperes) {
        return WirelessCoverTextureMap.getOrDefault(aAmperes, WirelessCoverTextureMap.get(-1));
    }
    // endregion

}
