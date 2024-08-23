package com.xir.NHUtilities.client.key;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.brandon3055.draconicevolution.common.lib.References;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class KeyBindings {

    private KeyBindings() {}

    public static final KeyBinding toggleTeleporterMKII;

    static {
        toggleTeleporterMKII = new KeyBinding("key.toggleTeleporterMKII", Keyboard.KEY_NONE, References.MODNAME);
    }

    public static void init() {
        ClientRegistry.registerKeyBinding(toggleTeleporterMKII);
    }
}
