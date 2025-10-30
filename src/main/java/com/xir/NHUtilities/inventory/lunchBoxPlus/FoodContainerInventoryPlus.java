package com.xir.NHUtilities.inventory.lunchBoxPlus;

import static com.xir.NHUtilities.utils.CommonUtil.setItemStackSize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.UtilHelper.StackMapper;
import com.xir.NHUtilities.common.items.lunchBoxPlus.LunchBoxPlus;
import com.xir.NHUtilities.main.NHUtilities;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.ItemStackKey;

import appeng.api.storage.data.IAEItemStack;
import appeng.util.item.AEItemStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.NonNull;
import squeek.spiceoflife.inventory.FoodContainerInventory;

@SuppressWarnings("unused")
public class FoodContainerInventoryPlus extends FoodContainerInventory {

    public static final StackMapper<ItemStack> TOKEN_ITEM_STACK = is -> is;
    public static final StackMapper<IAEItemStack> TOKEN_AE_STACK = AEItemStack::create;

    public FoodContainerInventoryPlus(LunchBoxPlus itemFoodContainer, ItemStack itemStackFoodContainer) {
        super(itemFoodContainer, itemStackFoodContainer);
    }

    public ItemStack[] getInventoryItems() {
        return this.inventoryItems;
    }

    public <T> ImmutableList<T> getAvailableFoods(@NonNull StackMapper<T> mapper) {
        return getAvailableFoods(mapper, null);
    }

    public <T> ImmutableList<T> getAvailableFoods(@NonNull StackMapper<T> mapper,
        @Nullable Predicate<ItemStack> filter) {
        var builder = ImmutableList.<T>builder();
        for (ItemStack food : inventoryItems) {
            if (food == null || food.stackSize <= 0) continue;
            if (filter == null || filter.test(food)) {
                builder.add(mapper.apply(food));
            }
        }
        return builder.build();
    }

    public ImmutableList<Integer> getEmptySlotIndexes() {
        var builder = ImmutableList.<Integer>builder();
        for (int i = 0; i < inventoryItems.length; i++) {
            var is = inventoryItems[i];
            if (is == null || is.stackSize <= 0) builder.add(i);

            // Clean up empty items (items with stackSize <= 0)
            if (is != null && is.stackSize <= 0) inventoryItems[i] = null;
        }
        return builder.build();
    }

    public void setSlotContent(int index, ItemStack itemStack) {
        inventoryItems[index] = itemStack;
    }

    public FoodContainerInventoryPlus sortItem() {
        return sortItemBy(null);
    }

    public FoodContainerInventoryPlus sortItemBy(@Nullable Comparator<ItemStack> comparator) {
        var time = System.nanoTime();
        var group = new Object2ObjectOpenHashMap<ItemStackKey, List<ItemStack>>();
        for (int i = 0; i < inventoryItems.length; i++) {
            var food = inventoryItems[i];
            if (food != null && food.stackSize > 0) {
                group.computeIfAbsent(new ItemStackKey(food), k -> new ArrayList<>())
                    .add(food);
            }
            inventoryItems[i] = null;
        }

        var retList = new ArrayList<ItemStack>();
        for (List<ItemStack> value : group.values()) {
            // spotless:off
            var maxSize = Math.min(value.get(0).getMaxStackSize(), 64);
            // spotless:on

            var totalCount = 0;
            for (ItemStack stack : value) {
                // 一些非法操作使得itemstack超过限制
                if (stack.stackSize > maxSize) {
                    retList.add(CommonUtil.setItemStackSize(stack.stackSize, stack.copy()));
                    continue;
                }
                totalCount += stack.stackSize;
            }

            var idx = 0;
            while (totalCount > 0) {
                var is = value.get(idx++);
                var transferAmount = Math.min(totalCount, maxSize);
                totalCount -= transferAmount;
                retList.add(setItemStackSize(transferAmount, is));
            }
        }

        if (comparator != null) retList.sort(comparator);
        for (int i = 0; i < retList.size(); i++) inventoryItems[i] = retList.get(i);

        time = System.nanoTime() - time;
        NHUtilities.LOG.info("Time Sort ==> ms: {},  ns: {}", (double) time / 1_000_000, time);
        return this;
    }
}
