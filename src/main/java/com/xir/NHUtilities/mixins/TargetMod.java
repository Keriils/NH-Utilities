package com.xir.NHUtilities.mixins;

@SuppressWarnings("unused")
public enum TargetMod {

    DraconicEvolution("Draconic Evolution", "DraconicEvolution"),
    Baubles("Baubles", "Baubles"),
    GregTech("GregTech", "gregtech"),
    EnderIO("Ender IO", "EnderIO"),
    WorldEdit("WorldEdit", "worldedit"),
    ExtraUtilities("Extra Utilities", "ExtraUtilities"),;

    public final String modName;
    public final String modId;

    TargetMod(String modName, String modId) {
        this.modName = modName;
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public String getModId() {
        return modId;
    }
}
