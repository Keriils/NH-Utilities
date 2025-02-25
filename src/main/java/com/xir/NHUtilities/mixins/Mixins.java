package com.xir.NHUtilities.mixins;

import static com.xir.NHUtilities.config.Config.disableDollyDebuff;
import static com.xir.NHUtilities.config.Config.disableSuperChestOrTankDebuff;
import static com.xir.NHUtilities.config.Config.enableAccelerateEnderIoMachine;
import static com.xir.NHUtilities.config.Config.enableAccelerateGregTechMachine;
import static com.xir.NHUtilities.config.Config.enableBanOriginalWirelessRecipes;
import static com.xir.NHUtilities.config.Config.enableEnhancedTeleporterMKII;
import static com.xir.NHUtilities.config.Config.enableLunchBoxPlus;
import static com.xir.NHUtilities.config.Config.enableModifyEnderIoCapBankIO;
import static com.xir.NHUtilities.config.Config.enableModifyWirelessHatchTexture;
import static com.xir.NHUtilities.config.Config.enableWEToolWithExuHealingAxe;
import static com.xir.NHUtilities.config.Config.enableWirelessHatchMore;
import static com.xir.NHUtilities.main.ReferencedInfo.IS_CLIENT_SIDE;
import static com.xir.NHUtilities.main.ReferencedInfo.IS_SERVER_SIDE;
import static com.xir.NHUtilities.mixins.Mixins.MixinClass.ERROR;
import static com.xir.NHUtilities.mixins.Mixins.MixinClass.newMixinClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public enum Mixins {

    // spotless:off
    DraconicEvolution_EnhanceTeleporterMKII(

        newMixinClass("TeleporterMKII_Cross_With_Baubles")
            .setClass("TeleporterMKII_Mixin")
            .setPackagePath(PackagePath.DraconicEvolution)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.Baubles)
            .addTargetMod(TargetMod.DraconicEvolution)
            .addCondition(enableEnhancedTeleporterMKII),
        newMixinClass("Modify_TeleporterMKII_GUI")
            .setClass("GUITeleporter_Mixin")
            .setPackagePath(PackagePath.DraconicEvolution)
            .setPhase(Phase.LATE)
            .setSide(Side.CLIENT)
            .addTargetMod(TargetMod.DraconicEvolution)
            .addCondition(enableEnhancedTeleporterMKII),
        newMixinClass("Modify_Teleporter_Future")
            .setClass("TeleporterPacket_Mixin")
            .setPackagePath(PackagePath.DraconicEvolution)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.DraconicEvolution)
            .addCondition(enableEnhancedTeleporterMKII)

    ),

    GregTech_Accelerations(

        newMixinClass("Modify_BaseMTE_With_Acceleration")
            .setClass("BaseMetaTileEntityAcceleration_Mixin")
            .setPackagePath(PackagePath.GregTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(enableAccelerateGregTechMachine),
        newMixinClass("Modify_ResearchStation_Acceleration")
            .setClass("ResearchStationAcceleration_Mixin")
            .setPackagePath(PackagePath.TecTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.TecTech)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(enableAccelerateGregTechMachine),
        newMixinClass("Modify_AdvAssLine_Acceleration")
            .setClass("MTEAdvAssLineAcceleration_Mixin")
            .setPackagePath(PackagePath.GregTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.GregTech)
            .addTargetMod(TargetMod.GigaGramFab)
            .addCondition(enableAccelerateGregTechMachine)

    ),

    GregTech_Wireless_Things(

        newMixinClass("Modify_BaseMTE_WirelessCover_Feature")
            .setClass("BaseMetaTileEntityWirelessCover_Mixin")
            .setPackagePath(PackagePath.GregTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(enableWirelessHatchMore),
        newMixinClass("Ban_Original_Wireless_Recipes")
            .setClass("BanOriginalWirelessRecipes_Mixin")
            .setPackagePath(PackagePath.TecTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.TecTech)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(enableWirelessHatchMore)
            .addCondition(enableBanOriginalWirelessRecipes),
        newMixinClass("Modify_Wireless_Hatch_Textures")
            .setClass("MTEHatchWirelessTexture_Mixin")
            .setPackagePath(PackagePath.TecTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.TecTech)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(enableModifyWirelessHatchTexture)
            .addCondition(enableWirelessHatchMore)

    ),

    GregTech_Modifications(

        newMixinClass("Disable_SuperChestOrTank_Debuff")
            .setClass("DisableDebuff_Mixin")
            .setPackagePath(PackagePath.GregTech)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.GregTech)
            .addCondition(disableSuperChestOrTankDebuff)

    ),

    EnderIO_Modifications(

        newMixinClass("Modify_CapBankMaxIO")
            .setClass("Modify_CapBankMaxIO_Mixin")
            .setPackagePath(PackagePath.EnderIO)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.EnderIO)
            .addCondition(enableModifyEnderIoCapBankIO),
        newMixinClass("To_Accelerate_EnderIO_Machine")
            .setClass("AccelerateTileEntity_Mixin")
            .setPackagePath(PackagePath.EnderIO)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.EnderIO)
            .addCondition(enableAccelerateEnderIoMachine),
        newMixinClass("Modify_Acceleration_Energy_Receive")
            .setClass("AccelerateEnergyReceive_Mixin")
            .setPackagePath(PackagePath.EnderIO)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.EnderIO)
            .addCondition(enableAccelerateEnderIoMachine)

    ),

    JABBA_Modifications(

        newMixinClass("Disable_Dolly_Debuff")
            .setClass("DisableDollyDebuff_Mixin")
            .setPackagePath(PackagePath.JABBA)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.JABBA)
            .addCondition(disableDollyDebuff)

    ),

    WorldEdit_Modifications(

        newMixinClass("Modify_With_Exu_HealingAxe")
            .setClass("ModifyWEWithExU")
            .setPackagePath(PackagePath.WorldEditGtnh)
            .setPhase(Phase.LATE)
            .addTargetMod(TargetMod.WorldEdit)
            .addTargetMod(TargetMod.ExtraUtilities)
            .addCondition(enableWEToolWithExuHealingAxe)

    ),

    SpiceOfLife_Modifications(

        newMixinClass("Modify_ServerSide_GuiHandler")
            .setClass("GuiHandler_Server_Mixin")
            .setPackagePath(PackagePath.SpiceOfLife)
            .setPhase(Phase.LATE)
            .setSide(Side.SERVER)
            .addTargetMod(TargetMod.SpiceOfLife)
            .addCondition(enableLunchBoxPlus),
        newMixinClass("Modify_ClientSide_GuiHandler")
            .setClass("GuiHandler_Client_Mixin")
            .setPackagePath(PackagePath.SpiceOfLife)
            .setPhase(Phase.LATE)
            .setSide(Side.CLIENT)
            .addTargetMod(TargetMod.SpiceOfLife)
            .addCondition(enableLunchBoxPlus)

    ),

    ;
    // spotless:on

    private final MixinClass[] MIXIN_CLASS;
    private final Supplier<Boolean> shouldApplyThisMixinGroup;

    Mixins(MixinClass... MIXIN_CLASS) {
        this(() -> true, MIXIN_CLASS);
    }

    Mixins(Supplier<Boolean> shouldApplyThisMixinGroup, MixinClass... MIXIN_CLASS) {
        this.MIXIN_CLASS = MIXIN_CLASS;
        this.shouldApplyThisMixinGroup = shouldApplyThisMixinGroup;
    }

    public static @NotNull List<String> getLateMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        for (Mixins value : Mixins.values()) {
            if (!value.shouldApplyThisMixinGroup.get()) continue;
            for (MixinClass mixinClass : value.MIXIN_CLASS) {
                if (mixinClass.mClass.equals(ERROR)) continue;
                if (!mixinClass.phase.equals(Phase.LATE)) continue;
                if (!shouldApply(mixinClass.side)) continue;
                if (!mixinClass.classPredicate.test(mixinClass)) continue;
                if (!loadedMods.containsAll(
                    mixinClass.targetMods.stream()
                        .map(TargetMod::getModId)
                        .collect(Collectors.toSet())))
                    continue;
                mixins.add(mixinClass.getMixinClassPath());
            }
        }
        return mixins;
    }

    private static boolean shouldApply(Side side) {
        return side == Side.BOTH || (side == Side.CLIENT && IS_CLIENT_SIDE) || (side == Side.SERVER && IS_SERVER_SIDE);
    }

    enum PackagePath {

        Forge,
        JABBA,
        EnderIO,
        TecTech,
        GregTech,
        MineCraft,
        SpiceOfLife,
        WorldEditGtnh,
        DraconicEvolution,

        ;

        private final String path;

        PackagePath() {
            this.path = this.toString();
        }
    }

    static class MixinClass {

        static final String ERROR = "NHU_MIXIN_ERROR";

        final String id;

        String mClass = ERROR;

        String packagePath;

        Side side = Side.BOTH;

        Phase phase = Phase.ERROR_PHASE;

        List<TargetMod> targetMods = new ArrayList<>();

        Predicate<MixinClass> classPredicate = mixinClass -> true;

        public MixinClass(String id) {
            this.id = id;
        }

        @Contract("_ -> new")
        static @NotNull MixinClass newMixinClass(String aIdentifier) {
            return new MixinClass(aIdentifier);
        }

        MixinClass setClass(String mClass) {
            this.mClass = mClass;
            return this;
        }

        public MixinClass setSide(Side side) {
            this.side = side;
            return this;
        }

        public MixinClass setPhase(Phase phase) {
            this.phase = phase;
            return this;
        }

        public String getMixinClassPath() {
            if (this.packagePath == null) return this.mClass;
            return this.packagePath + this.mClass;
        }

        public MixinClass setPackagePath(PackagePath... packagePath) {
            if (packagePath == null || packagePath.length == 0) return this;
            this.packagePath = Arrays.stream(packagePath)
                .map(p -> p.path)
                .collect(Collectors.joining(".", "", "."));
            return this;
        }

        MixinClass addTargetMod(TargetMod targetMod) {
            targetMods.add(targetMod);
            return this;
        }

        MixinClass addTargetMod(TargetMod... targetMod) {
            targetMods.addAll(Arrays.asList(targetMod));
            return this;
        }

        MixinClass addCondition(boolean condition) {
            classPredicate = classPredicate.and(mixinClass -> condition);
            return this;
        }

        MixinClass addCondition(@NotNull Function<Predicate<MixinClass>, Predicate<MixinClass>> condition) {
            classPredicate = condition.apply(classPredicate);
            return this;
        }

    }

    enum Phase {
        LATE,
        EARLY,
        ERROR_PHASE
    }

    enum Side {
        BOTH,
        SERVER,
        CLIENT

    }
}
