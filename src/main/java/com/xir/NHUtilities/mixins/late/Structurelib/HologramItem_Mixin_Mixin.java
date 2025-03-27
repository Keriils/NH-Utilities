package com.xir.NHUtilities.mixins.late.Structurelib;

import static com.xir.NHUtilities.utils.CommonUtil.trans;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.brandon3055.brandonscore.common.utills.InfoHelper;
import com.gtnewhorizon.structurelib.alignment.constructable.ChannelDataAccessor;
import com.gtnewhorizon.structurelib.alignment.constructable.ConstructableUtility;
import com.gtnewhorizon.structurelib.item.ItemConstructableTrigger;

@SuppressWarnings("UnusedMixin")
@Mixin(value = ItemConstructableTrigger.class)
public class HologramItem_Mixin_Mixin {

    @Unique
    private static final String CHANNEL_BUILD_SIZE = "nhu_build_size";

    @Redirect(
        method = "onItemUseFirst",
        at = @At(
            value = "INVOKE",
            target = "Lcom/gtnewhorizon/structurelib/alignment/constructable/ConstructableUtility;handle(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;IIII)Z"),
        require = 1,
        remap = false)
    private boolean nhu$enhanceHologramItem(ItemStack stack, EntityPlayer player, World world, int x, int y, int z,
        int aSide) {
        if (ChannelDataAccessor.hasSubChannel(stack, CHANNEL_BUILD_SIZE)) {
            ItemStack cache = stack.copy();
            cache.stackSize = ChannelDataAccessor.getChannelData(stack, CHANNEL_BUILD_SIZE);
            return ConstructableUtility.handle(cache, player, world, x, y, z, aSide);
        }
        return ConstructableUtility.handle(stack, player, world, x, y, z, aSide);
    }

    @Inject(method = "addInformation", at = @At("TAIL"), require = 1)
    private void nhu$addInfo(ItemStack aStack, EntityPlayer ep, List<String> aList, boolean boo, CallbackInfo ci) {
        if (!InfoHelper.isShiftKeyDown()) {
            aList.add(trans("tooltip.nhu.line"));
            aList.add(trans("tooltip.nhu.buildSizeChannel.Info.1"));
            aList.add(trans("tooltip.nhu.line"));
        }
    }
}
