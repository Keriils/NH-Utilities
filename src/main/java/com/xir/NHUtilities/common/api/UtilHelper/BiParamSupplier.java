package com.xir.NHUtilities.common.api.UtilHelper;

@FunctionalInterface
public interface BiParamSupplier<P, P2, T> {

    T get(P defaultAmount, P2 function);

}
