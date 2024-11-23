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
import static com.xir.NHUtilities.common.api.enums.NHUItemList.TCBlastFurnace;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.TestMachine;
import static com.xir.NHUtilities.main.ReferencedInfo.isDevEnvironment;
import static com.xir.NHUtilities.utils.CommonUtil.trans;
import static gregtech.api.enums.GT_Values.VN;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.enums.WirelessHatchMore;
import com.xir.NHUtilities.common.api.interfaces.IItemContainer;
import com.xir.NHUtilities.common.machine.hatch.MTEWirelessHatchDynamoMulti;
import com.xir.NHUtilities.common.machine.hatch.MTEWirelessHatchEnergyMulti;
import com.xir.NHUtilities.common.machine.multi.TCBlastFurnace;
import com.xir.NHUtilities.common.machine.multi.TestMachine;
import com.xir.NHUtilities.common.machine.single.MTEMagicalEggMachine;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GT_Utility;

public class MachineLoader {

    private static void registerMTE(@NotNull IItemContainer container, @NotNull MetaTileEntity mte) {
        container.set(mte.getStackForm(1L));
    }

    public static void initNHUtilitiesMachine() {

        if (isDevEnvironment) registerMTE(TestMachine, new TestMachine(24999, "TestMachine", "TestMachine"));
        registerMTE(TCBlastFurnace, new TCBlastFurnace(TC_BLAST_FURNACE.ID, trans("nhu.tcebf.machine")));

        initEggMachine();
        initWirelessHatchMore();
    }

    private static void initEggMachine() {
        // spotless:off
        registerMTE(Egg_Machine_EV,     new MTEMagicalEggMachine(EGG_MACHINE_EV.ID,     trans("nhu.eggMachine.tier.EV"), 4));
        registerMTE(Egg_Machine_IV,     new MTEMagicalEggMachine(EGG_MACHINE_IV.ID,     trans("nhu.eggMachine.tier.IV"), 5));
        registerMTE(Egg_Machine_LuV,    new MTEMagicalEggMachine(EGG_MACHINE_LuV.ID,    trans("nhu.eggMachine.tier.LuV"), 6));
        registerMTE(Egg_Machine_ZPM,    new MTEMagicalEggMachine(EGG_MACHINE_ZPM.ID,    trans("nhu.eggMachine.tier.ZPM"), 7));
        registerMTE(Egg_Machine_UV,     new MTEMagicalEggMachine(EGG_MACHINE_UV.ID,     trans("nhu.eggMachine.tier.UV"), 8));
        registerMTE(Egg_Machine_UHV,    new MTEMagicalEggMachine(EGG_MACHINE_UHV.ID,    trans("nhu.eggMachine.tier.UHV"), 9));
        registerMTE(Egg_Machine_UEV,    new MTEMagicalEggMachine(EGG_MACHINE_UEV.ID,    trans("nhu.eggMachine.tier.UEV"), 10));
        registerMTE(Egg_Machine_UIV,    new MTEMagicalEggMachine(EGG_MACHINE_UIV.ID,    trans("nhu.eggMachine.tier.UIV"), 11));
        registerMTE(Egg_Machine_UMV,    new MTEMagicalEggMachine(EGG_MACHINE_UMV.ID,    trans("nhu.eggMachine.tier.UMV"), 12));
        registerMTE(Egg_Machine_UXV,    new MTEMagicalEggMachine(EGG_MACHINE_UXV.ID,    trans("nhu.eggMachine.tier.UXV"), 13));
        registerMTE(Egg_Machine_MAX,    new MTEMagicalEggMachine(EGG_MACHINE_MAX.ID,    trans("nhu.eggMachine.tier.MAX"), 14));
        // spotless:on
    }

    private static void initWirelessHatchMore() {
        var energyStr = trans("Hatch.wireless.energy.name");
        var dynamoStr = trans("Hatch.wireless.dynamo.name");
        for (WirelessHatchMore value : WirelessHatchMore.values()) {
            if (value.hatchType == WirelessHatchMore.HatchType.EnergyHatch) registerMTE(
                value,
                new MTEWirelessHatchEnergyMulti(
                    value.metaId,
                    value.toString(),
                    getCN(value, energyStr),
                    value.aTier,
                    value.aAmperes));
            else registerMTE(
                value,
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
        if (isCN) return String.format(str, GT_Utility.formatNumbers(value.aAmperes), VN[value.aTier]);
        return String.format(str, VN[value.aTier], GT_Utility.formatNumbers(value.aAmperes));
    }
}
