package com.xir.NHUtilities.utils;

import static net.minecraft.init.Items.feather;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.xir.NHUtilities.main.ReferencedInfo;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public class CommonUtil {

    private CommonUtil() {}

    public static String trans(String langKey) {
        return StatCollector.translateToLocal(langKey);
    }

    public static boolean simpleMetaEqual(ItemStack is1, ItemStack is2) {
        if (is1 == null || is2 == null) return false;
        if (is1.getItem() != is2.getItem()) return false;
        int is1_meta = feather.getDamage(is1);
        int is2_meta = feather.getDamage(is2);
        if (is1_meta == is2_meta) return true;
        return is1_meta == WILDCARD_VALUE || is2_meta == WILDCARD_VALUE;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ItemStack newItemStack(Item aItem) {
        return new ItemStack(aItem, 1, 0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ItemStack newItemStack(Block aBlock) {
        return new ItemStack(aBlock, 1, 0);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull ItemStack newItemStack(Item aItem, int aMeta) {
        return new ItemStack(aItem, 1, aMeta);
    }

    @Contract("_, _ -> new")
    public static @NotNull ItemStack newItemStack(Block aBlock, int aMeta) {
        return new ItemStack(aBlock, 1, aMeta);
    }

    public static @NotNull ItemStack aErrorStack() {
        return newItemStack(Blocks.fire).setStackDisplayName(EnumChatFormatting.DARK_RED + "ERROR_STACK!!!");
    }

    public static ItemStack copyAmount(int aAmount, Item aItem) {
        return copyAmount(aAmount, new ItemStack(aItem, 1, 0));
    }

    public static ItemStack copyAmount(int aAmount, ItemStack aItemStack) {
        ItemStack rStack = copy(aItemStack);
        if (rStack == null)
            return aErrorStack().setStackDisplayName(EnumChatFormatting.YELLOW + "ERROR_STACK_DURING_COPY_STACK!!!");
        if (aAmount > 64 || aAmount < 0) aAmount = 111;
        return setItemStackSize(aAmount, rStack);
    }

    @Contract("_, _ -> param2")
    public static @NotNull ItemStack setItemStackSize(int aAmount, @NotNull ItemStack aItemStack) {
        aItemStack.stackSize = (byte) aAmount;
        return aItemStack;
    }

    public static @Nullable ItemStack copy(ItemStack aItemStack) {
        if (isStackValid(aItemStack)) return aItemStack.copy();
        return null;
    }

    public static boolean isStackValid(ItemStack aItemStack) {
        return (aItemStack != null) && aItemStack.getItem() != null && aItemStack.stackSize >= 0;
    }

    public static boolean isStackInvalid(ItemStack aItemStack) {
        return aItemStack == null || aItemStack.getItem() == null || aItemStack.stackSize < 0;
    }

    public static boolean isClientSide() {
        return ReferencedInfo.IS_CLIENT_SIDE;
    }

    public static boolean isServerSide() {
        return ReferencedInfo.IS_SERVER_SIDE;
    }

    @Contract(value = "_ -> new", pure = true)
    public static <T> StructureDefinition.@NotNull Builder<T> StructureDefinitionBuilder(Class<T> typeToken) {
        return StructureDefinition.builder();
    }

}
