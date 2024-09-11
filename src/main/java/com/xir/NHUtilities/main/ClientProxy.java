package com.xir.NHUtilities.main;

import static com.xir.NHUtilities.config.Config.enableEnhancedTeleporterMKII;
import static com.xir.NHUtilities.config.Config.enableEternityVialCosmicRender;
import static com.xir.NHUtilities.config.Config.enableTimeVial;

import net.minecraftforge.client.MinecraftForgeClient;

import com.xir.NHUtilities.client.key.KeyBindings;
import com.xir.NHUtilities.client.key.KeyInputHandler;
import com.xir.NHUtilities.common.items.ModsItemsList;
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

        if (enableEternityVialCosmicRender) {
            CosmicItemRenderer cosmic = new CosmicItemRenderer();
            MinecraftForgeClient.registerItemRenderer(ModsItemsList.eternityVial, cosmic);
        }

        if (enableTimeVial) {
            RenderLoader.registerNHUtilitiesEntityRendering();
        }

    }
}
