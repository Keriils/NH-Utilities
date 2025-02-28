package com.xir.NHUtilities.common.api.UtilHelper;

@FunctionalInterface
public interface ParamSupplier<P, T> {

    T get(P amount);

}
