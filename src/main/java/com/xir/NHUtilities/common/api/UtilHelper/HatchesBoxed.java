package com.xir.NHUtilities.common.api.UtilHelper;

import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.enums.HatchAmperes;
import com.xir.NHUtilities.common.api.enums.HatchType;
import com.xir.NHUtilities.common.api.enums.VoltageTier;

public class HatchesBoxed {

    public final VoltageTier voltageTier;

    public final ItemStack hatchStack;

    public final HatchType hatchType;

    public final HatchAmperes hatchAmperes;

    HatchesBoxed(VoltageTier voltageTier, ItemStack hatchStack, HatchAmperes hatchAmperes, HatchType hatchType) {
        this.voltageTier = voltageTier;
        this.hatchStack = hatchStack;
        this.hatchAmperes = hatchAmperes;
        this.hatchType = hatchType;
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull HatchesBoxed buildHatchBoxed(VoltageTier voltageTier, ItemStack hatchStack,
        HatchAmperes hatchAmperes, HatchType hatchType) {
        return new HatchesBoxed(voltageTier, hatchStack, hatchAmperes, hatchType);
    }

}
