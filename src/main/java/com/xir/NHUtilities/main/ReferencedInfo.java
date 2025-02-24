package com.xir.NHUtilities.main;

import net.minecraft.launchwrapper.Launch;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;

@SuppressWarnings("unused")
public final class ReferencedInfo {

    private ReferencedInfo() {}

    // For Dev
    public static final boolean isDevEnvironment = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

    // For Mod Main Info
    public static final String MOD_ID = "NHUtilities";

    public static final String MOD_NAME = "NH Utilities";

    public static final String MOD_ID_UPPER = "NHUTILITIES";

    public static final String MOD_ID_LOWER = "nhutilities";

    public static final String MOD_NAME_UPPER = "NH UTILITIES";

    public static final String MOD_NAME_LOWER = "nh utilities";

    public static final String RESOURCE_PATH = MOD_ID_LOWER + ":";

    public static final boolean IS_CLIENT_SIDE = FMLCommonHandler.instance()
        .getSide()
        .isClient();

    public static final boolean IS_SERVER_SIDE = FMLCommonHandler.instance()
        .getSide()
        .isServer();

    // For Mod dependencies
    public static final String DEPENDENCIES = " after:gregtech;" + " after:Avaritia;"
        + " after:DraconicEvolution;"
        + " after:Baubles";

    // For Sided Proxy
    public static final String CLIENT_SIDE = "com.xir.NHUtilities.main.ClientProxy";

    public static final String SERVER_SIDE = "com.xir.NHUtilities.main.CommonProxy";

    // For Interaction With Other Mod
    public static final boolean BAUBLES_MOD_IS_LOADED = Loader.isModLoaded("Baubles");

    public static final boolean OTH_MOD_IS_LOADED = Loader.isModLoaded("123Technology");
}
