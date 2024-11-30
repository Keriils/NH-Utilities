package com.xir.NHUtilities.mixins.late.DraconicEvolution;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.network.TeleporterPacket;
import com.brandon3055.draconicevolution.common.utills.InventoryUtils;

@SuppressWarnings("UnusedMixin")
@Mixin(value = TeleporterPacket.Handler.class)
public class TeleporterPacket_Mixin {

    @Unique
    @Nullable
    private ItemStack NHUtilities$getHandOrBaublesTeleporter(EntityPlayerMP instance) {
        Optional<ItemStack> playerBaublesInventory = InventoryUtils
            .getItemInPlayerBaublesInventory(instance, TeleporterMKII.class);
        if (instance.inventory.getCurrentItem() != null && instance.inventory.getCurrentItem()
            .getItem() == ModItems.teleporterMKII) {
            return instance.inventory.getCurrentItem();
        } else if (playerBaublesInventory.isPresent()) {
            return playerBaublesInventory.get();
        }
        return null;
    }

    @Redirect(
        method = "onMessage(Lcom/brandon3055/draconicevolution/common/network/TeleporterPacket;Lcpw/mods/fml/common/network/simpleimpl/MessageContext;)Lcpw/mods/fml/common/network/simpleimpl/IMessage;",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/EntityPlayerMP;getHeldItem()Lnet/minecraft/item/ItemStack;"),
        require = 1)
    private ItemStack NHUtilities$getTeleporterMKII(EntityPlayerMP instance) {
        return NHUtilities$getHandOrBaublesTeleporter(instance);
    }
}
