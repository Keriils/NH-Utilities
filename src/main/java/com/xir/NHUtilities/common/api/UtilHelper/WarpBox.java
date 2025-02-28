package com.xir.NHUtilities.common.api.UtilHelper;

import java.util.function.Supplier;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class WarpBox<T> {

    T t;

    boolean isInited;

    Supplier<T> Supplier;

    @Contract(value = "_ -> new", pure = true)
    public static <T> @NotNull WarpBox<T> newWarpBox(Supplier<T> Supplier) {
        return new WarpBox<>(Supplier);
    }

    WarpBox(Supplier<T> Supplier) {
        this.Supplier = Supplier;
    }

    public T get() {
        if (t == null) {
            if (isInited) throw new IllegalStateException();
            initT();
        }
        return this.t;
    }

    void initT() {
        this.t = Supplier.get();
        this.Supplier = null;
        this.isInited = true;
    }
}
