package com.xir.NHUtilities.common.api.enums;

import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_LASER;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_4A;
import static com.github.technus.tectech.thing.metaTileEntity.Textures.OVERLAYS_ENERGY_IN_WIRELESS_MULTI_64A;
import static com.xir.NHUtilities.main.ReferencedInfo.RESOURCE_PATH;
import static gregtech.api.enums.Textures.BlockIcons.CustomIcon;

import java.util.HashMap;
import java.util.Map;

import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.ITexture;
import gregtech.api.render.TextureFactory;

@SuppressWarnings("unused")
public final class TexturesSets {

    public static void init() {}

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

    public static final Map<Integer, ITexture> WirelessTextureMap = new HashMap<>() {

        {
            var args = new short[] { 255, 255, 255, 0 };
            var spaceTime = TextureFactory.of(OVERLAY_WIRELESS_SPACETIME, args);
            put(-1, spaceTime);
            put(4, OVERLAYS_ENERGY_IN_WIRELESS_MULTI_4A[1]);
            put(16, OVERLAYS_ENERGY_IN_WIRELESS_MULTI_16A[1]);
            put(64, OVERLAYS_ENERGY_IN_WIRELESS_MULTI_64A[1]);
            put(256, TextureFactory.of(OVERLAY_WIRELESS_256A, args));
            put(1_024, TextureFactory.of(OVERLAY_WIRELESS_1024A, args));
            put(4_096, TextureFactory.of(OVERLAY_WIRELESS_4096A, args));
            put(16_384, TextureFactory.of(OVERLAY_WIRELESS_16384A, args));
            put(65_536, TextureFactory.of(OVERLAY_WIRELESS_65536A, args));
            put(262_144, TextureFactory.of(OVERLAY_WIRELESS_262144A, args));
            put(1_048_576, TextureFactory.of(OVERLAY_WIRELESS_1048576A, args));
            put(4_194_304, OVERLAYS_ENERGY_IN_WIRELESS_LASER[1]);
            put(16_777_216, spaceTime);
        }

    };

    public static ITexture getWirelessTex(int aAmperes) {
        return WirelessTextureMap.getOrDefault(aAmperes, WirelessTextureMap.get(-1));
    }

    // endregion

}
