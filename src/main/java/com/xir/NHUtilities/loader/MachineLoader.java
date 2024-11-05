package com.xir.NHUtilities.loader;

import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_EV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_IV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_LuV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_MAX;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UEV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UHV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UIV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UMV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_UXV;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.Egg_Machine_ZPM;
import static com.xir.NHUtilities.common.api.enums.CustomItemList.TCBlastFurnace;
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
import static net.minecraft.util.StatCollector.translateToLocal;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.api.enums.CustomItemList;
import com.xir.NHUtilities.common.machine.multi.TCBlastFurnace;
import com.xir.NHUtilities.common.machine.single.MTEMagicalEggMachine;

import gregtech.api.metatileentity.MetaTileEntity;

public class MachineLoader {

    public static void registerMTE(@NotNull CustomItemList item, @NotNull MetaTileEntity mte) {
        item.set(mte.getStackForm(1L));
    }

    public static void registerNHUtilitiesMachine() {

        registerMTE(TCBlastFurnace, new TCBlastFurnace(TC_BLAST_FURNACE.ID, translateToLocal("nhu.tcebf.machine")));
        registerMTE(
            Egg_Machine_EV,
            new MTEMagicalEggMachine(EGG_MACHINE_EV.ID, translateToLocal("nhu.eggMachine.tier.EV"), 4));
        registerMTE(
            Egg_Machine_IV,
            new MTEMagicalEggMachine(EGG_MACHINE_IV.ID, translateToLocal("nhu.eggMachine.tier.IV"), 5));
        registerMTE(
            Egg_Machine_LuV,
            new MTEMagicalEggMachine(EGG_MACHINE_LuV.ID, translateToLocal("nhu.eggMachine.tier.LuV"), 6));
        registerMTE(
            Egg_Machine_ZPM,
            new MTEMagicalEggMachine(EGG_MACHINE_ZPM.ID, translateToLocal("nhu.eggMachine.tier.ZPM"), 7));
        registerMTE(
            Egg_Machine_UV,
            new MTEMagicalEggMachine(EGG_MACHINE_UV.ID, translateToLocal("nhu.eggMachine.tier.UV"), 8));
        registerMTE(
            Egg_Machine_UHV,
            new MTEMagicalEggMachine(EGG_MACHINE_UHV.ID, translateToLocal("nhu.eggMachine.tier.UHV"), 9));
        registerMTE(
            Egg_Machine_UEV,
            new MTEMagicalEggMachine(EGG_MACHINE_UEV.ID, translateToLocal("nhu.eggMachine.tier.UEV"), 10));
        registerMTE(
            Egg_Machine_UIV,
            new MTEMagicalEggMachine(EGG_MACHINE_UIV.ID, translateToLocal("nhu.eggMachine.tier.UIV"), 11));
        registerMTE(
            Egg_Machine_UMV,
            new MTEMagicalEggMachine(EGG_MACHINE_UMV.ID, translateToLocal("nhu.eggMachine.tier.UMV"), 12));
        registerMTE(
            Egg_Machine_UXV,
            new MTEMagicalEggMachine(EGG_MACHINE_UXV.ID, translateToLocal("nhu.eggMachine.tier.UXV"), 13));
        registerMTE(
            Egg_Machine_MAX,
            new MTEMagicalEggMachine(EGG_MACHINE_MAX.ID, translateToLocal("nhu.eggMachine.tier.MAX"), 14));

    }
}
