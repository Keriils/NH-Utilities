package com.xir.NHUtilities.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

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

    // region TimeVial
    public static boolean enableTimeVial = true;
    public static boolean enableLogInfo = false;
    public static boolean limitOneTimeVial = true;
    public static float timeVialDiscountValue = 0.9965F; // e..
    public static float defaultTimeVialVolumeValue = 0.5F;
    public static boolean enableTimeAcceleratorBoost = false;
    public static boolean enableAccelerateGregTechMachine = true;
    public static boolean enableNumberMultiplierTexture = false;
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
    private static final String CATEGORY_TIME_VIAL = "Time_Vial";
    // endregion

    // region cfgFile
    static final Path cfgDirPath = minecraftHome().toPath()
        .resolve("config")
        .resolve(NHUtilities.MODID);
    static final Configuration configuration = new Configuration(
        cfgDirPath.resolve(NHUtilities.MODID + ".cfg")
            .toFile(),
        true);
    // endregion

    static File minecraftHome() {
        return new File(System.getProperty("user.dir"));
    }

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
            enableTimeVial = configuration
                .getBoolean("enableTimeVial", CATEGORY_TIME_VIAL, enableTimeVial, "enable Time Vial");
            enableLogInfo = configuration
                .getBoolean("enableLogInfo", CATEGORY_TIME_VIAL, enableLogInfo, "enable log info debug");
            limitOneTimeVial = configuration
                .getBoolean("limitOneTimeVial", CATEGORY_TIME_VIAL, limitOneTimeVial, "limit One TimeVial");
            defaultTimeVialVolumeValue = configuration.getFloat(
                "defaultTimeVialVolume",
                CATEGORY_TIME_VIAL,
                defaultTimeVialVolumeValue,
                0.0F,
                5.0F,
                "set time vial volume");
            timeVialDiscountValue = configuration.getFloat(
                "timeVialDiscountValue",
                CATEGORY_TIME_VIAL,
                timeVialDiscountValue,
                0.0F,
                1.0F,
                "set time vial discount value");
            enableTimeAcceleratorBoost = configuration.getBoolean(
                "enableTimeAcceleratorBoost",
                CATEGORY_TIME_VIAL,
                enableTimeAcceleratorBoost,
                "enable Time Accelerator Boost, boost to 256X");
            enableAccelerateGregTechMachine = configuration.getBoolean(
                "enableAccelerateGregTechMachine",
                CATEGORY_TIME_VIAL,
                enableAccelerateGregTechMachine,
                "enable Accelerate GregTech Machine");
            enableNumberMultiplierTexture = configuration.getBoolean(
                "enableNumberMultiplierTexture",
                CATEGORY_TIME_VIAL,
                enableNumberMultiplierTexture,
                "enable Number Multiplier Texture");

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
        configuration.addCustomCategoryComment(CATEGORY_TIME_VIAL, "The TimeVial config setting");
    }
}
