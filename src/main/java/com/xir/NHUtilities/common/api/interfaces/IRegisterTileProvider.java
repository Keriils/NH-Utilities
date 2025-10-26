package com.xir.NHUtilities.common.api.interfaces;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;

public interface IRegisterTileProvider<T extends TileEntity> extends ITileEntityProvider {

    Class<T> getTeClass();

}
