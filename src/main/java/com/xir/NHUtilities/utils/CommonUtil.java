package com.xir.NHUtilities.utils;

import cpw.mods.fml.common.FMLCommonHandler;

@SuppressWarnings("unused")
public class CommonUtil {

    private CommonUtil() {}

    public static boolean isClientSide() {
        return FMLCommonHandler.instance()
            .getSide()
            .isClient();
    }

    public static boolean isServerSide() {
        return FMLCommonHandler.instance()
            .getSide()
            .isServer();
    }

}
