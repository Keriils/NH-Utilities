package com.xir.NHUtilities.common.api.enums;

import net.minecraft.util.EnumChatFormatting;

import com.xir.NHUtilities.utils.CommonUtil;

@SuppressWarnings("unused")
public enum NHUTextEnum {

    Author_Keriils(EnumChatFormatting.RED + "K"
        + EnumChatFormatting.GOLD
        + "e"
        + EnumChatFormatting.YELLOW
        + "r"
        + EnumChatFormatting.GREEN
        + "i"
        + EnumChatFormatting.AQUA
        + "i"
        + EnumChatFormatting.BLUE
        + "l"
        + EnumChatFormatting.LIGHT_PURPLE
        + "s"
        + EnumChatFormatting.DARK_RED
        + "_", false),
    Author_Tc_traveler(EnumChatFormatting.LIGHT_PURPLE + "Tc_traveler", false);

    private String aText;
    private String aKey;

    NHUTextEnum(String aKey) {
        this.aKey = aKey;
    }

    NHUTextEnum(String authorName, boolean hasKey) {
        var ap = CommonUtil.trans("nhu.author.prefix");
        if (hasKey) this.aText = ap + " " + CommonUtil.trans(authorName);
        else this.aText = ap + " " + authorName;
    }

    public String getText() {
        if (this.aKey != null) return CommonUtil.trans(this.aKey);
        return this.aText;
    }

}
