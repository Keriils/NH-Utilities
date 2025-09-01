package com.xir.NHUtilities.common.items.metaItemImpl;

import static com.xir.NHUtilities.common.api.enums.NHUItemList.DYNAMO_COVERS;
import static com.xir.NHUtilities.common.api.enums.NHUItemList.ENERGY_COVERS;
import static com.xir.NHUtilities.common.api.enums.TexturesSets.getWirelessTex;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.items.aItemCore.MetaItemBase;
import com.xir.NHUtilities.common.items.covers.CoverEnergyType;
import com.xir.NHUtilities.common.items.covers.WirelessEnergyCover;
import com.xir.NHUtilities.utils.CommonUtil;

import gregtech.api.covers.CoverRegistry;
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
        final var ac_index = new int[] { 0, 1, 3, 5 };
        final var textures = new ITexture[] { getWirelessTex(2), getWirelessTex(4), getWirelessTex(16),
            getWirelessTex(64), };
        final var amp = new String[] { "2 A", "4 A", "16 A", "64 A" };
        final var key_amp = "Ampere_";
        AtomicInteger meta = new AtomicInteger(1);
        IntStream.range(0, 4)
            .forEach(turns -> {
                var dynamoList = DYNAMO_COVERS.get(turns);
                var tooltips = new String[] { CommonUtil.trans("tooltip.amp.info") + " " + amp[turns] };
                IntStream.range(0, dynamoList.size())
                    .forEach(index -> {
                        var value = dynamoList.get(index);
                        value.set(
                            addMetaItem(
                                "Cover_Wireless_Dynamo_" + GTValues.VN[index + 1],
                                meta.getAndIncrement(),
                                (key_amp + amp[turns]).replace(" ", ""),
                                tooltips));
                        CoverRegistry.registerCover(
                            value.get(1),
                            textures[turns],
                            context -> new WirelessEnergyCover(
                                (int) GTValues.V[index + 1],
                                2 << ac_index[turns],
                                CoverEnergyType.DYNAMO,
                                context,
                                textures[turns]));
                    });
                var energyList = ENERGY_COVERS.get(turns);
                IntStream.range(0, energyList.size())
                    .forEach(index -> {
                        var value = energyList.get(index);
                        value.set(
                            addMetaItem(
                                "Cover_Wireless_Energy_" + GTValues.VN[index + 1],
                                meta.getAndIncrement(),
                                (key_amp + amp[turns]).replace(" ", ""),
                                tooltips));
                        CoverRegistry.registerCover(
                            value.get(1),
                            textures[turns],
                            context -> new WirelessEnergyCover(
                                (int) GTValues.V[index + 1],
                                2 << ac_index[turns],
                                CoverEnergyType.ENERGY,
                                context,
                                textures[turns]));
                    });
            });
    }

}
