package com.xir.NHUtilities.utils;

import java.util.List;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

/**
 * referenced draconic evolution
 */
@SuppressWarnings("unused")
public final class InformationHelper {

    private InformationHelper() {}

    public static final String dividingLine = "=====================";

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isCtrlKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean holdShiftForDetails(List list) {
        if (!isShiftKeyDown()) {
            list.add(
                StatCollector.translateToLocal("infohelper.NHUtilities.txt_0") + " "
                    + EnumChatFormatting.ITALIC
                    + StatCollector.translateToLocal("infohelper.NHUtilities.key_shift")
                    + EnumChatFormatting.RESET
                    + " "
                    + StatCollector.translateToLocal("infohelper.NHUtilities.txt_1"));
            return false;
        }
        return true;
    }

    public static boolean holdCtrlForDetails(List list) {
        if (!isShiftKeyDown()) {
            list.add(
                StatCollector.translateToLocal("infohelper.NHUtilities.txt_0") + " "
                    + EnumChatFormatting.ITALIC
                    + StatCollector.translateToLocal("infohelper.NHUtilities.key_ctrl")
                    + EnumChatFormatting.RESET
                    + " "
                    + StatCollector.translateToLocal("infohelper.NHUtilities.txt_1"));
            return false;
        }
        return true;
    }

}
