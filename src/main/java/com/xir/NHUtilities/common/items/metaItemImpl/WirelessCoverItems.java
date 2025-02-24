package com.xir.NHUtilities.common.items.metaItemImpl;

import static com.xir.NHUtilities.common.api.enums.NHUItemList.DYNAMO_COVERS;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.ENERGY_COVERS;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;
import static gregtech.api.util.GTUtility.formatNumbers;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.items.aItemCore.MetaItemBase;
import com.xir.NHUtilities.common.items.covers.WirelessCovers;
import com.xir.NHUtilities.utils.CommonUtil;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.interfaces.ITexture;

public class WirelessCoverItems extends MetaItemBase implements ILoadMetaItem {

    public WirelessCoverItems() {
        super("WirelessCoverItem");
        setCreativeTab(NHUCreativeTabs.WirelessMisc);
    }

    @Override
    public void loadMetaItem() {

        // meta id 1 -> 14 for wireless dynamo cover
        // reversed id [0] for wireless cover things
        // addMetaItem("WirelessCoverTest", 0);

        NHUItemList dynamoValue, energyValue;
        var ac = new int[] { 0, 1, 3, 5 };
        var tex = new ITexture[] { getWirelessTex(2), getWirelessTex(4), getWirelessTex(16), getWirelessTex(64), };
        var amp = new String[] { "Ampere_2A", "Ampere_4A", "Ampere_16A", "Ampere_64A" };
        var dynamoIconString = new String[] { "Cover_Wireless_Dynamo_LV", "Cover_Wireless_Dynamo_MV",
            "Cover_Wireless_Dynamo_HV", "Cover_Wireless_Dynamo_EV", "Cover_Wireless_Dynamo_IV",
            "Cover_Wireless_Dynamo_LuV", "Cover_Wireless_Dynamo_ZPM", "Cover_Wireless_Dynamo_UV",
            "Cover_Wireless_Dynamo_UHV", "Cover_Wireless_Dynamo_UEV", "Cover_Wireless_Dynamo_UIV",
            "Cover_Wireless_Dynamo_UMV", "Cover_Wireless_Dynamo_UXV", "Cover_Wireless_Dynamo_MAX" };
        var energyIconString = new String[] { "Cover_Wireless_Energy_LV", "Cover_Wireless_Energy_MV",
            "Cover_Wireless_Energy_HV", "Cover_Wireless_Energy_EV", "Cover_Wireless_Energy_IV",
            "Cover_Wireless_Energy_LuV", "Cover_Wireless_Energy_ZPM", "Cover_Wireless_Energy_UV",
            "Cover_Wireless_Energy_UHV", "Cover_Wireless_Energy_UEV", "Cover_Wireless_Energy_UIV",
            "Cover_Wireless_Energy_UMV", "Cover_Wireless_Energy_UXV", "Cover_Wireless_Energy_MAX" };
        var meta = 1;
        for (int i = 0; i < 4; i++) {
            for (int j1 = 0; j1 < DYNAMO_COVERS[i].length; j1++) {
                dynamoValue = DYNAMO_COVERS[i][j1];
                dynamoValue.set(
                    addMetaItem(
                        dynamoIconString[j1],
                        meta++,
                        amp[i],
                        new String[] {
                            CommonUtil.trans("tooltip.amp.info") + " " + formatNumbers(2 << ac[i]) + " A" }));
                GregTechAPI.registerCover(
                    dynamoValue.get(1),
                    tex[i],
                    new WirelessCovers.CoverWirelessDynamo((int) GTValues.V[j1 + 1], 2 << ac[i]));
            }
            for (int j2 = 0; j2 < ENERGY_COVERS[i].length; j2++) {
                energyValue = ENERGY_COVERS[i][j2];
                energyValue.set(
                    addMetaItem(
                        energyIconString[j2],
                        meta++,
                        amp[i],
                        new String[] {
                            CommonUtil.trans("tooltip.amp.info") + " " + formatNumbers(2 << ac[i]) + " A" }));
                GregTechAPI.registerCover(
                    energyValue.get(1),
                    tex[i],
                    new WirelessCovers.CoverWirelessEnergy((int) GTValues.V[j2 + 1], 2 << ac[i]));
            }
        }

    }
}
