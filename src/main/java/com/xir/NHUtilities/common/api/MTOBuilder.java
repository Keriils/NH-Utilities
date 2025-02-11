package com.xir.NHUtilities.common.api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.interfaces.MTO.IMetaTypeObject;

@SuppressWarnings("unused")
public class MTOBuilder<T extends IMetaTypeObject> {

    private final T mtoObj;

    private MTOData<T> mtoData;

    private final List<Consumer<T>> action = new ArrayList<>();

    public MTOBuilder(T mtoObj) {
        if (mtoObj == null) throw new IllegalArgumentException();
        this.mtoObj = mtoObj;
    }

    @Contract(value = "_ -> new", pure = true)
    public static <T extends IMetaTypeObject> @NotNull MTOBuilder<T> newBuilder(T t) {
        return new MTOBuilder<>(t);
    }

    public MTOBuilder<T> setMtoData(MTOData<T> mtoData) {
        if (mtoData == null) throw new IllegalArgumentException();
        if (this.mtoData != null) throw new IllegalStateException();
        this.mtoData = mtoData;
        return this;
    }

    public MTOBuilder<T> addRegisterAction(Consumer<T> action) {
        if (action == null) throw new IllegalArgumentException();
        this.action.add(action);
        return this;
    }

    public IMetaTypeObject build() {
        if (mtoData == null) this.mtoData = new MTOData<>();
        this.mtoObj.setMtoData(mtoData);
        this.mtoData.setMetaObject(mtoObj);
        for (Consumer<T> tConsumer : action) tConsumer.accept(mtoObj);
        return mtoObj;
    }
}
