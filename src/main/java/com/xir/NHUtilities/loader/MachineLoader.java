package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_EV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_IV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_LuV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_MAX;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UEV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UHV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UIV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UMV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_UXV;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.EGG_MACHINE_ZPM;
import static com.xir.NHUtilities.common.api.enums.MetaTileEntityID.TC_BLAST_FURNACE;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_EV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_IV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_LuV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UEV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UHV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UIV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UMV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_UXV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Egg_Machine_ZPM;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_Dynamo_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti16_HV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti16_LV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti16_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti16_MV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti4_HV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti4_LV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti4_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti4_MV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti64_HV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti64_LV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti64_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_EnergyMulti64_MV;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.Hatch_Energy_MAX;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.TCBlastFurnace;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.TestMachine;
import static com.xir.NHUtilities.config.Config.enableEggMachine;
import static com.xir.NHUtilities.config.Config.enableWirelessHatchMore;
import static com.xir.NHUtilities.config.Config.wirelessHatchMetaIdOffset;
import static com.xir.NHUtilities.main.ReferencedInfo.isDevEnvironment;
import static com.xir.NHUtilities.utils.CommonUtil.trans;
import static gregtech.api.enums.GTValues.VN;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.enums.HatchType;
import com.xir.NHUtilities.common.api.enums.WirelessHatchMore;
import com.xir.NHUtilities.common.machine.hatch.MTEWirelessHatchDynamoMulti;
import com.xir.NHUtilities.common.machine.hatch.MTEWirelessHatchEnergyMulti;
import com.xir.NHUtilities.common.machine.multi.TCBlastFurnace;
import com.xir.NHUtilities.common.machine.multi.TestMachine;
import com.xir.NHUtilities.common.machine.single.MTEMagicalEggMachine;

import gregtech.api.metatileentity.implementations.MTEHatchDynamo;
import gregtech.api.metatileentity.implementations.MTEHatchEnergy;
import gregtech.api.util.GTUtility;
import tectech.thing.metaTileEntity.hatch.MTEHatchEnergyMulti;

public class MachineLoader {

    public static void initNHUtilitiesMachine() {

        if (isDevEnvironment) TestMachine.set(new TestMachine(24999, "TestMachine", "TestMachine"));
        TCBlastFurnace.set(new TCBlastFurnace(TC_BLAST_FURNACE.ID, trans("nhu.tcebf.machine")));

        if (enableEggMachine) initEggMachine();
        if (enableWirelessHatchMore) initWirelessHatchMore();
    }

    private static void initEggMachine() {
        // spotless:off
        Egg_Machine_EV.set(new MTEMagicalEggMachine(EGG_MACHINE_EV.ID,     trans("nhu.eggMachine.tier.EV"), 4));
        Egg_Machine_IV.set(new MTEMagicalEggMachine(EGG_MACHINE_IV.ID,     trans("nhu.eggMachine.tier.IV"), 5));
        Egg_Machine_LuV.set(new MTEMagicalEggMachine(EGG_MACHINE_LuV.ID,    trans("nhu.eggMachine.tier.LuV"), 6));
        Egg_Machine_ZPM.set(new MTEMagicalEggMachine(EGG_MACHINE_ZPM.ID,    trans("nhu.eggMachine.tier.ZPM"), 7));
        Egg_Machine_UV.set(new MTEMagicalEggMachine(EGG_MACHINE_UV.ID,     trans("nhu.eggMachine.tier.UV"), 8));
        Egg_Machine_UHV.set(new MTEMagicalEggMachine(EGG_MACHINE_UHV.ID,    trans("nhu.eggMachine.tier.UHV"), 9));
        Egg_Machine_UEV.set(new MTEMagicalEggMachine(EGG_MACHINE_UEV.ID,    trans("nhu.eggMachine.tier.UEV"), 10));
        Egg_Machine_UIV.set(new MTEMagicalEggMachine(EGG_MACHINE_UIV.ID,    trans("nhu.eggMachine.tier.UIV"), 11));
        Egg_Machine_UMV.set(new MTEMagicalEggMachine(EGG_MACHINE_UMV.ID,    trans("nhu.eggMachine.tier.UMV"), 12));
        Egg_Machine_UXV.set(new MTEMagicalEggMachine(EGG_MACHINE_UXV.ID,    trans("nhu.eggMachine.tier.UXV"), 13));
        Egg_Machine_MAX.set(new MTEMagicalEggMachine(EGG_MACHINE_MAX.ID,    trans("nhu.eggMachine.tier.MAX"), 14));
        // spotless:on
    }

    private static void initWirelessHatchMore() {

        int wirelessIdBaseSet = 25100 + 120 + wirelessHatchMetaIdOffset;

        Hatch_Dynamo_MAX.set(new MTEHatchDynamo(11294, "hatch.dynamo.tier.14", trans("hatch.dynamo.tier.14"), 14));
        Hatch_Energy_MAX.set(new MTEHatchEnergy(11304, "hatch.energy.tier.14", trans("hatch.energy.tier.14"), 14));

        // spotless:off
        Hatch_EnergyMulti4_LV.set(new MTEHatchEnergyMulti(      wirelessIdBaseSet + 1,      "hatch.energymulti04.tier.01",      trans("hatch.energymulti04.tier.01"),       1,      4   ));
        Hatch_EnergyMulti16_LV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 2,      "hatch.energymulti16.tier.01",      trans("hatch.energymulti16.tier.01"),       1,      16  ));
        Hatch_EnergyMulti64_LV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 3,      "hatch.energymulti64.tier.01",      trans("hatch.energymulti64.tier.01"),       1,      64  ));
        Hatch_EnergyMulti4_MV.set(new MTEHatchEnergyMulti(      wirelessIdBaseSet + 4,      "hatch.energymulti04.tier.02",      trans("hatch.energymulti04.tier.02"),       2,      4   ));
        Hatch_EnergyMulti16_MV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 5,      "hatch.energymulti16.tier.02",      trans("hatch.energymulti16.tier.02"),       2,      16  ));
        Hatch_EnergyMulti64_MV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 6,      "hatch.energymulti64.tier.02",      trans("hatch.energymulti64.tier.02"),       2,      64  ));
        Hatch_EnergyMulti4_HV.set(new MTEHatchEnergyMulti(      wirelessIdBaseSet + 7,      "hatch.energymulti04.tier.03",      trans("hatch.energymulti04.tier.03"),       3,      4   ));
        Hatch_EnergyMulti16_HV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 8,      "hatch.energymulti16.tier.03",      trans("hatch.energymulti16.tier.03"),       3,      16  ));
        Hatch_EnergyMulti64_HV.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 9,      "hatch.energymulti64.tier.03",      trans("hatch.energymulti64.tier.03"),       3,      64  ));
        Hatch_EnergyMulti4_MAX.set(new MTEHatchEnergyMulti(     wirelessIdBaseSet + 10,     "hatch.energymulti04.tier.14",      trans("hatch.energymulti04.tier.14"),       14,      4   ));
        Hatch_EnergyMulti16_MAX.set(new MTEHatchEnergyMulti(    wirelessIdBaseSet + 11,     "hatch.energymulti16.tier.14",      trans("hatch.energymulti16.tier.14"),       14,      16  ));
        Hatch_EnergyMulti64_MAX.set(new MTEHatchEnergyMulti(    wirelessIdBaseSet + 12,     "hatch.energymulti64.tier.14",      trans("hatch.energymulti64.tier.14"),       14,      64  ));
        // spotless:on

        var energyStr = trans("Hatch.wireless.energy.name");
        var dynamoStr = trans("Hatch.wireless.dynamo.name");
        for (WirelessHatchMore value : WirelessHatchMore.values()) {
            if (
                value.hatchType == HatchType.WirelessEnergyHatch
            ) value.set(
                new MTEWirelessHatchEnergyMulti(
                    value.metaId,
                    value.toString(),
                    getCN(value, energyStr),
                    value.aTier,
                    value.aAmperes));
            else value.set(
                new MTEWirelessHatchDynamoMulti(
                    value.metaId,
                    value.toString(),
                    getCN(value, dynamoStr),
                    value.aTier,
                    value.aAmperes));
        }
    }

    private static @NotNull String getCN(WirelessHatchMore value, String str) {
        var isCN = trans("Lang.helper.local.lang").equals("zh_CN");
        if (isCN) return String.format(str, GTUtility.formatNumbers(value.aAmperes), VN[value.aTier]);
        return String.format(str, VN[value.aTier], GTUtility.formatNumbers(value.aAmperes));
    }
}
