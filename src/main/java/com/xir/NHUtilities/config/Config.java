package com.xir.NHUtilities.config;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

import com.xir.NHUtilities.main.NHUtilities;

/**
 * Initialize with static to provide configuration for this mod and mixin before preInit
 */
public class Config {

    // region register mixinModule key region
    public static Boolean enableEnhancedTeleporterMKII = true;
    // endregion

    // region category
    public static final String CATEGORY_MIXIN_CONFIG = "mixin_config";
    // endregion

    static {
        Configuration configuration = new Configuration(
            Launch.minecraftHome.toPath()
                .resolve("config")
                .resolve(NHUtilities.MODID + ".cfg")
                .toFile());

        {
            enableEnhancedTeleporterMKII = configuration.getBoolean(
                "enableEnhancedTeleporterMKII",
                CATEGORY_MIXIN_CONFIG,
                enableEnhancedTeleporterMKII,
                "enable Enhanced TeleporterMKII");
        }

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
