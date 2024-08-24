package com.xir.NHUtilities.utils;

import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import org.jetbrains.annotations.NotNull;

/**
 * referenced Avaritia mod
 */
@SuppressWarnings("unused")
public final class TooltipsChroma {

    private TooltipsChroma() {}

    private static final EnumChatFormatting[] CHROMA_FORMATTINGS = new EnumChatFormatting[] { RED, GOLD, YELLOW, GREEN,
        AQUA, BLUE, LIGHT_PURPLE };

    public static @NotNull String applyChromaEffect(@NotNull String input) {
        return formatWithChroma(input, CHROMA_FORMATTINGS, 80.0, 1, 1);
    }

    public static @NotNull String formatWithChroma(@NotNull String input, EnumChatFormatting[] colors, double delay,
        int step, int posStep) {
        StringBuilder formattedText = new StringBuilder(input.length() * 3);

        if (delay <= 0) {
            delay = 0.001;
        }

        int offset = (int) Math.floor(Minecraft.getSystemTime() / delay) % colors.length;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            int colorIndex = ((i * posStep) + colors.length - offset) % colors.length;

            formattedText.append(colors[colorIndex].toString());
            formattedText.append(character);
        }

        return formattedText.toString();
    }
}
