package com.xir.NHUtilities.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Initialize with static to provide configuration for this mod and mixin before preInit
 */
public class Config {

    static final Logger ConfigLog = LogManager.getLogger("NHUtilities_Config");

    // region register massItems key !!!
    public static boolean enableGluttonyRingAndHungerRing = true;
    // endregion

    // region TimeVial
    public static boolean enableTimeVial = true;
    public static boolean enableEternityVial = true;
    public static boolean enableEternityVialCosmicRender = true;
    public static boolean enableEternityVialCosmicRenderDeepening = true;
    public static boolean enableBlockMode = true;
    public static int accelerateBlockInterval = 2;
    public static boolean enableLogInfo = false;
    public static boolean limitOneTimeVial = true;
    public static float timeVialDiscountValue = 0.9965F; // e..
    public static float defaultTimeVialVolumeValue = 0.5F;
    public static boolean enableTimeAcceleratorBoost = false;
    public static boolean enableAccelerateGregTechMachine = true;
    public static float accelerateGregTechMachineDiscount = 0.8F;
    public static boolean enableNumberMultiplierTexture = false;
    // endregion

    // region register mixins category key region
    public static boolean enableEnhancedTeleporterMKII = true;
    public static boolean enableModifyEnderIoCapBankIO = true;
    public static boolean enableWEToolWithExuHealingAxe = true;
    public static boolean enableAccelerateEnderIoMachine = true;
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
        .resolve("NHUtilities");
    static final Configuration configuration = new Configuration(
        cfgDirPath.resolve("NHUtilities.cfg")
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
            enableEternityVial = configuration
                .getBoolean("enableEternityVial", CATEGORY_TIME_VIAL, enableEternityVial, "enable Eternity Vial");
            enableBlockMode = configuration
                .getBoolean("enableBlockMode", CATEGORY_TIME_VIAL, enableBlockMode, "enable Block Mode");
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
            accelerateGregTechMachineDiscount = configuration.getFloat(
                "accelerateGregTechMachineDiscount",
                CATEGORY_TIME_VIAL,
                accelerateGregTechMachineDiscount,
                0.0F,
                1.0F,
                "accelerate GregTech Machine Discount");
            enableNumberMultiplierTexture = configuration.getBoolean(
                "enableNumberMultiplierTexture",
                CATEGORY_TIME_VIAL,
                enableNumberMultiplierTexture,
                "enable Number Multiplier Texture");
            accelerateBlockInterval = configuration.getInt(
                "accelerateBlockInterval",
                CATEGORY_TIME_VIAL,
                accelerateBlockInterval,
                2,
                200,
                "accelerate Block Interval");
            enableEternityVialCosmicRender = configuration.getBoolean(
                "enableEternityVialCosmicRender",
                CATEGORY_TIME_VIAL,
                enableEternityVialCosmicRender,
                "enable Eternity Vial Cosmic Render");
            enableEternityVialCosmicRenderDeepening = configuration.getBoolean(
                "enableEternityVialCosmicRenderDeepening",
                CATEGORY_TIME_VIAL,
                enableEternityVialCosmicRenderDeepening,
                "enable Eternity Vial Cosmic Render Deepening");
            enableModifyEnderIoCapBankIO = configuration.getBoolean(
                "enableModifyEnderIoCapBankIO",
                CATEGORY_MIXIN_CONFIG,
                enableModifyEnderIoCapBankIO,
                "enable Modify EnderIo Cap Bank Max IO");
            enableWEToolWithExuHealingAxe = configuration.getBoolean(
                "enableWEToolWithExuHealingAxe",
                CATEGORY_MIXIN_CONFIG,
                enableWEToolWithExuHealingAxe,
                "enable WE Tool With Exu Healing Axe");
            enableAccelerateEnderIoMachine = configuration.getBoolean(
                "enableAccelerateEnderIoMachine",
                CATEGORY_MIXIN_CONFIG,
                enableAccelerateEnderIoMachine,
                "enable Accelerate EnderIO Machine");

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
