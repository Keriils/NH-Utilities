package com.xir.NHUtilities.mixinPlugin;

public enum TargetMods {

    DraconicEvolution("Draconic Evolution", "DraconicEvolution"),
    Baubles("Baubles", "Baubles"),
    GregTech("GregTech", "gregtech"),
    EnderIO("Ender IO", "EnderIO");

    public final String modName;
    public final String modId;

    TargetMods(String modName, String modId) {
        this.modName = modName;
        this.modId = modId;
    }
}
