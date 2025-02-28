package com.xir.NHUtilities.common.api.UtilHelper;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);

}
