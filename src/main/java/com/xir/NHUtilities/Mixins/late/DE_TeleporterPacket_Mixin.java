package com.xir.NHUtilities.Mixins.late;

import java.util.Optional;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.network.TeleporterPacket;
import com.brandon3055.draconicevolution.common.utills.InventoryUtils;

// Before modifying this code, please comment out the annotation below.
@SuppressWarnings("all")
@Mixin(value = TeleporterPacket.Handler.class, remap = true)
public class DE_TeleporterPacket_Mixin {

    @Unique
    private ItemStack getHandOrBaublesTeleporter(EntityPlayerMP instance) {
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
    private ItemStack getTeleporterMKII(EntityPlayerMP instance) {
        return getHandOrBaublesTeleporter(instance);
    }
}
