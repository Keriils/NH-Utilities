package com.xir.NHUtilities.mixins;

import static com.xir.NHUtilities.config.Config.disableDollyDebuff;
import static com.xir.NHUtilities.config.Config.disableSuperChestOrTankDebuff;
import static com.xir.NHUtilities.config.Config.enableAccelerateEnderIoMachine;
import static com.xir.NHUtilities.config.Config.enableAccelerateGregTechMachine;
import static com.xir.NHUtilities.config.Config.enableEnhancedTeleporterMKII;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableModifyEnderIoCapBankIO;
import static com.xir.NHUtilities.config.Config.enableModifyWirelessHatchTexture;
import static com.xir.NHUtilities.config.Config.enableWEToolWithExuHealingAxe;
import static com.xir.NHUtilities.config.Config.enableWirelessHatchMore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

@SuppressWarnings("unused")
public enum Mixins {

    DE_EnhanceTeleporterMKII_I_Mixin(Category.TeleporterMKII, Side.BOTH, Phase.LATE,
        "DraconicEvolution.TeleporterMKII_Mixin", TargetMod.DraconicEvolution, TargetMod.Baubles),
    DE_EnhanceTeleporterMKII_II_Mixin(Category.TeleporterMKII, Side.CLIENT, Phase.LATE,
        "DraconicEvolution.GUITeleporter_Mixin", TargetMod.DraconicEvolution),
    DE_EnhanceTeleporterMKII_III_Mixin(Category.TeleporterMKII, Side.BOTH, Phase.LATE,
        "DraconicEvolution.TeleporterPacket_Mixin", TargetMod.DraconicEvolution),
    GT_BaseMetaTileEntity_Acceleration_Mixin(Category.BaseMetaTileEntityAcceleration, Side.BOTH, Phase.LATE,
        "GregTech.BaseMetaTileEntityAcceleration_Mixin", TargetMod.GregTech),
    GT_ResearchStationAcceleration_Mixin(Category.BaseMetaTileEntityAcceleration, Side.BOTH, Phase.LATE,
        "GregTech.ResearchStationAcceleration_Mixin", TargetMod.GregTech),
    EndrIO_Modify_CapBankMaxIO_Mixin(Category.ModifyCapBankMaxIO, Side.BOTH, Phase.LATE,
        "EnderIO.Modify_CapBankMaxIO_Mixin", TargetMod.EnderIO),
    WE_ModifyWithExuHealingAxe_Mixin(Category.WEToolWithExuHealingAxe, Side.BOTH, Phase.LATE,
        "WorldEditGtnh.ModifyWEWithExU", TargetMod.WorldEdit, TargetMod.ExtraUtilities),
    EnderIO_AccelerateTileEntity_Mixin(Category.ToAccelerateEnderIoMachine, Side.BOTH, Phase.LATE,
        "EnderIO.AccelerateTileEntity_Mixin", TargetMod.EnderIO),
    EnderIO_AccelerateEnergyRecive_Mixin(Category.ToAccelerateEnderIoMachine, Side.BOTH, Phase.LATE,
        "EnderIO.AccelerateEnergyRecive_Mixin", TargetMod.EnderIO),
    SpiceOfLife_LunchBoxGuiHandlerServer(Category.LunchBoxPlus, Side.SERVER, Phase.LATE,
        "SpiceOfLife.GuiHandler_Server_Mixin", TargetMod.SpiceOfLife),
    SpiceOfLife_LunchBoxGuiHandlerClient(Category.LunchBoxPlus, Side.CLIENT, Phase.LATE,
        "SpiceOfLife.GuiHandler_Client_Mixin", TargetMod.SpiceOfLife),
    DisableDebuff_Mixin(Category.DisableSuperTankOrChestDebuff, Side.BOTH, Phase.LATE, "GregTech.DisableDebuff_Mixin",
        TargetMod.GregTech),
    DisableDollyDebuff_Mixin(Category.DisableDollyDebuff, Side.BOTH, Phase.LATE, "JABBA.DisableDollyDebuff_Mixin",
        TargetMod.JABBA),
    ModifyWirelessHatchTextureMixin(Category.ModifyWirelessHatchTexture, Side.BOTH, Phase.LATE,
        "GregTech.MTEHatchWirelessTexture_Mixin", TargetMod.GregTech),

    ;

    private enum Category {

        TeleporterMKII(enableEnhancedTeleporterMKII),
        BaseMetaTileEntityAcceleration(enableAccelerateGregTechMachine),
        ModifyCapBankMaxIO(enableModifyEnderIoCapBankIO),
        WEToolWithExuHealingAxe(enableWEToolWithExuHealingAxe),
        ToAccelerateEnderIoMachine(enableAccelerateEnderIoMachine),
        LunchBoxPlus(enableLunchBoxPlus),
        DisableSuperTankOrChestDebuff(disableSuperChestOrTankDebuff),
        DisableDollyDebuff(disableDollyDebuff),
        ModifyWirelessHatchTexture(enableModifyWirelessHatchTexture && enableWirelessHatchMore),

        ;

        public final boolean isEnable;

        Category(boolean isEnable) {
            this.isEnable = isEnable;
        }
    }

    private final Side side;
    private final Phase phase;
    private final String mixin;
    private final Category category;

    private final TargetMod[] targetMod;

    Mixins(Category category, Side side, Phase phase, String mixin, TargetMod... targetMod) {
        this.side = side;
        this.phase = phase;
        this.mixin = mixin;
        this.category = category;
        this.targetMod = targetMod;
    }

    public static @NotNull List<String> getLateMixins(Set<String> loadedMods) {
        return filterMixins(Phase.LATE, loadedMods);
    }

    public static @NotNull List<String> getEarlyMixins(Set<String> loadedMods) {
        return filterMixins(Phase.EARLY, loadedMods);
    }

    private static @NotNull List<String> filterMixins(Phase phase, Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        for (Mixins value : Mixins.values()) {
            if (value.category.isEnable && shouldApply(value.side)
                && value.phase == phase
                && loadedMods.containsAll(
                    Arrays.stream(value.targetMod)
                        .map(TargetMod::getModId)
                        .collect(Collectors.toSet()))) {
                mixins.add(value.mixin);
            }
        }
        return mixins;
    }

    private static boolean shouldApply(Side side) {
        return side == Side.BOTH || (side == Side.CLIENT && FMLLaunchHandler.side()
            .isClient())
            || (side == Side.SERVER && FMLLaunchHandler.side()
                .isServer());
    }

    private enum Phase {
        EARLY,
        LATE

    }

    private enum Side {
        BOTH,
        SERVER,
        CLIENT

    }
}
