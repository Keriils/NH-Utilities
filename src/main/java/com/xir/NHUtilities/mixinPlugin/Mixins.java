package com.xir.NHUtilities.mixinPlugin;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

public enum Mixins {

    DE_TeleporterMKII_Mixin("TeleporterMKII_Mixin", TargetMods.DraconicEvolution, TargetMods.Baubles),
    DE_GUITeleporter_Mixin("GUITeleporter_Mixin", TargetMods.DraconicEvolution),
    DE_TeleporterPacket_Mixin("TeleporterPacket_Mixin", TargetMods.DraconicEvolution),
    GT_MTEAcclerator_Mixin("BaseMetaTileEntity_Mixin", TargetMods.GregTech);

    private final String mixinClass;
    private final List<String> targetMod = new ArrayList<>();

    Mixins(String mixinClass, TargetMods @NotNull... targetMods) {
        this.mixinClass = mixinClass;
        for (TargetMods mod : targetMods) {
            this.targetMod.add(mod.modId);
        }
    }

    public List<String> getTargetMod() {
        return targetMod;
    }

    public String getMixinClass() {
        return mixinClass;
    }
}
