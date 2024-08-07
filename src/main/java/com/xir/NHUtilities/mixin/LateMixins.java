package com.xir.NHUtilities.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.NHUtilities.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        ArrayList<String> Mixins = new ArrayList<>();
        if (loadedMods.contains("DraconicEvolution")) {
            Mixins.add("DE_TeleporterMKII_Mixin");
            Mixins.add("DE_GUITeleporter_Mixin");
            Mixins.add("DE_TeleporterPacket_Mixin");
        }
        return Mixins;
    }
}
