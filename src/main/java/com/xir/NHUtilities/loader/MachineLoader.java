package com.xir.NHUtilities.loader;

import net.minecraft.util.StatCollector;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.common.api.enums.MetaTileEntityID;
import com.xir.NHUtilities.common.machine.multi.NHUtilities_TC_ElectricBlastFurnace;
import com.xir.NHUtilities.common.machine.single.MTEMagicalEggMachine;

public class MachineLoader {

    public static void registerNHUtilitiesMachine() {
        CustomItemList.Machine_Multi_TCBlastFurnace.set(
            new NHUtilities_TC_ElectricBlastFurnace(
                MetaTileEntityID.TCEBF_CONTROLLER.ID,
                "multimachine.tcblastfurnace",
                StatCollector.translateToLocal("nhu.tcebf.machine")).getStackForm(1L));
        CustomItemList.EggMachineLuv
            .set(new MTEMagicalEggMachine(25123, "egg machine", "A test egg machine", 10).getStackForm(1L));

    }
}
