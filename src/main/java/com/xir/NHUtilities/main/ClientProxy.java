package com.xir.NHUtilities.main;

import static com.xir.NHUtilities.config.Config.enableEnhancedTeleporterMKII;
import static com.xir.NHUtilities.config.Config.enableEternityVialCosmicRender;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import net.minecraftforge.client.MinecraftForgeClient;

import com.xir.NHUtilities.client.key.KeyBindings;
import com.xir.NHUtilities.client.key.KeyInputHandler;
import com.xir.NHUtilities.client.render.MetaAbleCosmicItemRenderer;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.loader.RenderLoader;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import fox.spiteful.avaritia.render.CosmicItemRenderer;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {

        super.init(event);

        if (enableEnhancedTeleporterMKII) {
            FMLCommonHandler.instance()
                .bus()
                .register(new KeyInputHandler());
            KeyBindings.init();
        }

        CosmicItemRenderer cosmic = new MetaAbleCosmicItemRenderer();
        if (enableEternityVialCosmicRender) {
            MinecraftForgeClient.registerItemRenderer(NHUItemList.EternityVial.getItem(), cosmic);
        }
        MinecraftForgeClient.registerItemRenderer(NHUItemList.MetaItem.getItem(), cosmic);

        if (enableTimeVial) {
            RenderLoader.registerNHUtilitiesEntityRendering();
        }

    }
}
