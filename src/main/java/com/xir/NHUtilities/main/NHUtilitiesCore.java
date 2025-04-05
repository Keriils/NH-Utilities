package com.xir.NHUtilities.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@SuppressWarnings("unused")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class NHUtilitiesCore implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.NHUtilities.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        ArrayList<String> mixins = new ArrayList<>();
        mixins.add("MineCraft.EntityInvulnerable_Mixin");
        mixins.add("MineCraft.WorldGameRule_Mixin");
        mixins.add("MineCraft.WeatherCycRule_Mixin");
        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
