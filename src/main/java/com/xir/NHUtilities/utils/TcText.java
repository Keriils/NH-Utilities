package com.xir.NHUtilities.utils;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class TcText {

    // universal
    public static final String researchPrefixInLang = "nhu.research.";
    public static final String prefixOfResearchInThaumonomicon = "tc.research_";// use only in GTApiResearch.java
    // research & recipe key
    // please use upper in research and lower in recipe
    public static final String thaumicEBF = "thaumicebf";
    public static final String focusTape = "focustape";
    public static final String warpWardRing = "warpwardring";
    public static final String shadowMetalFuelRod = "shadowmetalfuelrod";
    public static final String ichoriumFuelRod = "ichoriumfuelrod";
    // research aspect(这是研究时需要的要素)
    public static final AspectList resThaumicEBF = new AspectList().add(Aspect.ENERGY, 4)
        .add(Aspect.MECHANISM, 4)
        .add(Aspect.FIRE, 4);
    public static final AspectList resFocusTape = new AspectList().add(Aspect.ORDER, 10)
        .add(Aspect.ENTROPY, 10)
        .add(Aspect.TOOL,10);
    public static final AspectList resWarpWardRing = new AspectList().add(Aspect.ORDER, 4)
        .add(Aspect.FIRE, 4)
        .add(Aspect.WATER, 4)
        .add(Aspect.EARTH, 4)
        .add(Aspect.AIR, 4)
        .add(Aspect.ENTROPY, 4);
    // recipe aspect(这是制作配方时候消耗的要素)
    public static final AspectList aThaumicEbf = new AspectList().add(Aspect.FIRE, 64)
        .add(Aspect.ORDER, 64)
        .add(Aspect.ENTROPY, 64)
        .add(Aspect.WATER, 64)
        .add(Aspect.AIR, 64)
        .add(Aspect.EARTH, 64);
    public static final AspectList aFocusTape = new AspectList().add(Aspect.ORDER, 20)
        .add(Aspect.ENTROPY, 20)
        .add(Aspect.TOOL, 40);
    public static final AspectList aWarpWardRing = new AspectList().add(Aspect.ORDER, 512)
        .add(Aspect.FIRE, 512)
        .add(Aspect.WATER, 512)
        .add(Aspect.EARTH, 512)
        .add(Aspect.AIR, 512)
        .add(Aspect.ENTROPY, 512)
        .add(Aspect.WEATHER, 16);
    // 因为一些原因通过gtApi注册的研究的字段不会放入这里
}
