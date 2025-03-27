package com.xir.NHUtilities.mixins;

@SuppressWarnings({ "unused", "SpellCheckingInspection" })
public enum TargetMod {

    DraconicEvolution("Draconic Evolution", "DraconicEvolution"),
    Baubles("Baubles", "Baubles"),
    GregTech("GregTech", "gregtech"),
    TecTech("TecTech - Tec Technology!", "tectech"),
    EnderIO("Ender IO", "EnderIO"),
    WorldEdit("WorldEdit", "worldedit"),
    ExtraUtilities("Extra Utilities", "ExtraUtilities"),
    SpiceOfLife("SpiceOfLife", "SpiceOfLife"),
    JABBA("JABBA", "JABBA"),
    GigaGramFab("GigaGramFab", "ggfab"),
    NewHorizonsCoreMod("GT: New Horizons", "dreamcraft"),
    StructureLib("StructureLib", "structurelib"),

    ;

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
