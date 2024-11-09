package com.xir.NHUtilities.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.xir.NHUtilities.common.blocks.DragonEgg;
import com.xir.NHUtilities.common.blocks.metaBlockImpl.MetaBlock01;
import com.xir.NHUtilities.common.items.aItemCore.ItemBase;
import com.xir.NHUtilities.common.items.baubles.GluttonyRing;
import com.xir.NHUtilities.common.items.baubles.HungerRing;
import com.xir.NHUtilities.common.items.baubles.KamiRing;
import com.xir.NHUtilities.common.items.baubles.WarpWardRing;
import com.xir.NHUtilities.common.items.lunchBoxPlus.LunchBoxPlus;
import com.xir.NHUtilities.common.items.metaItemImpl.MetaItem01;
import com.xir.NHUtilities.common.items.timeVial.EternityVial;
import com.xir.NHUtilities.common.items.timeVial.TimeVial;
import com.xir.NHUtilities.common.items.wand.foci.ItemFocusTape;

public final class ModsItemsList {

    // For Common Item
    public static final ItemBase gluttonyRing = new GluttonyRing();
    public static final ItemBase hungerRing = new HungerRing();
    public static final ItemBase KamiRing = new KamiRing();
    public static final ItemBase timeVial = new TimeVial();
    public static final TimeVial eternityVial = new EternityVial();
    public static final LunchBoxPlus lunchBoxPlus = new LunchBoxPlus();
    public static final ItemFocusTape focusTape = new ItemFocusTape();
    public static final Item warpWardRing = new WarpWardRing();

    // For Common Block
    public static final Block chaosDragonEgg = new DragonEgg("ChaosDragonEgg");
    public static final Block ancientDragonEgg = new DragonEgg("AncientDragonEgg");

    // For Meta Item
    public static final MetaItem01 metaItem01 = new MetaItem01();

    // For Meta Block
    public static final MetaBlock01 metaItemBlock01 = new MetaBlock01();
}
