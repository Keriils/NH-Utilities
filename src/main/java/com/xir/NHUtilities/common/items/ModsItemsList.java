package com.xir.NHUtilities.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.blocks.ChaosDragonEgg;
import com.xir.NHUtilities.common.items.aItemCore.ItemBasic;
import com.xir.NHUtilities.common.items.baubles.GluttonyRing;
import com.xir.NHUtilities.common.items.baubles.HungerRing;
import com.xir.NHUtilities.common.items.baubles.KamiRing;
import com.xir.NHUtilities.common.items.baubles.WarpWardRing;
import com.xir.NHUtilities.common.items.lunchBoxPlus.LunchBoxPlus;
import com.xir.NHUtilities.common.items.timeVial.EternityVial;
import com.xir.NHUtilities.common.items.timeVial.TimeVial;
import com.xir.NHUtilities.common.items.wand.foci.ItemFocusTape;

public final class ModsItemsList {

    // For Common Item
    public static final ItemBasic gluttonyRing = new GluttonyRing();
    public static final ItemBasic hungerRing = new HungerRing();
    public static final ItemBasic KamiRing = new KamiRing();
    public static final ItemBasic timeVial = new TimeVial();
    public static final TimeVial eternityVial = new EternityVial();
    public static final LunchBoxPlus lunchBoxPlus = new LunchBoxPlus();
    public static final ItemFocusTape focusTape = new ItemFocusTape();
    public static final Item warpWardRing = new WarpWardRing();
    public static final Block chaosDragonEgg = new ChaosDragonEgg("ChaosDragonEgg");
    public static final Block ancientDragonEgg = new ChaosDragonEgg("AncientDragonEgg");
}
