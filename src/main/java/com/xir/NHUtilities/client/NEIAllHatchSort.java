package com.xir.NHUtilities.client;

import java.util.Comparator;
import java.util.HashSet;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.UtilHelper.HatchesBoxed;
import com.xir.NHUtilities.common.api.enums.HatchType;
import com.xir.NHUtilities.common.api.interfaces.LazyHatchHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class NEIAllHatchSort {

    public static HashSet<Integer> ALL_SORTED_HATCH_META_ID_SET = new HashSet<>();

    public static ImmutableList<ItemStack> ALL_SORTED_HATCH_ITEM_STACK;

    public static boolean isInited = false;

    public static void init() {

        isInited = true;

        Comparator<HatchesBoxed> hatchesBoxedComparator = Comparator
            .<HatchesBoxed>comparingInt(v -> v.hatchAmperes.ordinal())
            .thenComparingInt(v -> HatchType.hatchSort(v.hatchType))
            .thenComparingInt(v -> v.voltageTier.ordinal());

        ALL_SORTED_HATCH_ITEM_STACK = ImmutableList.<ItemStack>builder()
            .add(
                LazyHatchHelper.allCommonHatch.get()
                    .stream()
                    .sorted(hatchesBoxedComparator)
                    .map(v -> v.hatchStack.copy())
                    .toArray(ItemStack[]::new))
            .add(
                LazyHatchHelper.allWirelessHatch.get()
                    .stream()
                    .sorted(hatchesBoxedComparator)
                    .map(v -> v.hatchStack.copy())
                    .toArray(ItemStack[]::new))
            .build();

        ALL_SORTED_HATCH_ITEM_STACK.forEach(v -> ALL_SORTED_HATCH_META_ID_SET.add(Items.feather.getDamage(v)));

    }

}
