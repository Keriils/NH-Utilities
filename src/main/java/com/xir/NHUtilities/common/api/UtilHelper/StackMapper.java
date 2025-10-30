package com.xir.NHUtilities.common.api.UtilHelper;

import java.util.function.Function;

import net.minecraft.item.ItemStack;

public interface StackMapper<T> extends Function<ItemStack, T> {

}
