package com.xir.NHUtilities.common.api.interfaces;

import com.xir.NHUtilities.common.api.MetaTypeManager;

public interface IMetaObjectProvider {

    /**
     * return the MetaTypeManager registered in {@link MetaTypeManager}
     */
    MetaTypeManager getMTManager();

}
