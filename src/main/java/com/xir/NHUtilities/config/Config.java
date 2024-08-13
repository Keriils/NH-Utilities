package com.xir.NHUtilities.config;

import java.io.IOException;
import java.nio.file.Path;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.xir.NHUtilities.main.NHUtilities;

/**
 * Initialize with static to provide configuration for this mod and mixin before preInit
 */
public class Config {

    static final Logger ConfigLog = LogManager.getLogger(NHUtilities.MODID + "_Config");

    // region register massItems key !!!
    public static boolean enableGluttonyRingAndHungerRing = true;
    // endregion

    // region register mixinModule key region
    public static boolean enableEnhancedTeleporterMKII = true;
    public static String[] listeningMods = new String[] { "NHUtilities", "TwistSpaceTechnology", "boxplusplus",
        "programmablehatches" };
    // endregion

    // region category
    private static final String CATEGORY_MIXIN_CONFIG = "Mixin_Config";
    private static final String CATEGORY_Manager = "Lang_Manger";
    private static final String CATEGORY_MASS = "Mass_Config";
    // endregion

    // region cfgFile
    static final Path cfgDirPath = Launch.minecraftHome.toPath()
        .resolve("config")
        .resolve(NHUtilities.MODID);
    static final Configuration configuration = new Configuration(
        cfgDirPath.resolve(NHUtilities.MODID + ".cfg")
            .toFile(),
        true);
    // endregion

    static {
        categoryInit();
        {
            enableEnhancedTeleporterMKII = configuration.getBoolean(
                "enableEnhancedTeleporterMKII",
                CATEGORY_MIXIN_CONFIG,
                enableEnhancedTeleporterMKII,
                "enable Enhanced TeleporterMKII");
            listeningMods = configuration.getStringList(
                "listeningMods",
                CATEGORY_Manager,
                listeningMods,
                "List the mod IDs here to manage your GTNH language files");
            enableGluttonyRingAndHungerRing = configuration.getBoolean(
                "enableGluttonyRingAndHungerRing",
                CATEGORY_MASS,
                enableGluttonyRingAndHungerRing,
                "enable GluttonyRing & AndHungerRing");
        }

        try {
            ConfigLog.info("Start to ResetLangManager init");
            ResetLangManager.checkInit(listeningMods);
        } catch (IOException e) {
            ConfigLog.warn("ResetLangManager occurred an error while init!!!");
        }

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    private static void categoryInit() {
        configuration.addCustomCategoryComment(CATEGORY_MIXIN_CONFIG, "Control the corresponding functions of Mixin");
        configuration.addCustomCategoryComment(
            CATEGORY_Manager,
            "List the mod IDs here to manage your GTNH language files.\nIf you don't know the mod ID, please write a different name instead.");
        configuration.addCustomCategoryComment(CATEGORY_MASS, "A config region to Mass!./I need!!");
    }
}
