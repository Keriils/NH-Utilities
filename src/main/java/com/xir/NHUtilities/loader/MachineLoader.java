package com.xir.NHUtilities.loader;

import com.xir.NHUtilities.common.enumPackages.CustomItemList;
import com.xir.NHUtilities.common.enumPackages.MetaTileEntityID;
import com.xir.NHUtilities.common.tileEntity.GT_TileEntity_TCElectricBlastFurnace;

public class MachineLoader implements Runnable {

    @Override
    public void run() {
        CustomItemList.Machine_Multi_TCBlastFurnace.set(
            new GT_TileEntity_TCElectricBlastFurnace(
                MetaTileEntityID.TCEBF_CONTROLLER.ID,
                "multimachine.tcblastfurnace",
                "Thaumic Electric Blast Furnace").getStackForm(1L));
    }
}
