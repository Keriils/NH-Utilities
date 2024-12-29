package com.xir.NHUtilities.mixins.late.DraconicEvolution;

import static com.xir.NHUtilities.utils.InventoryUtils.getItemInPlayerBaublesInventory;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.items.tools.TeleporterMKII;
import com.brandon3055.draconicevolution.common.network.TeleporterPacket;

@SuppressWarnings("UnusedMixin")
@Mixin(value = TeleporterPacket.Handler.class)
public class TeleporterPacket_Mixin {

    @Redirect(
        method = "onMessage(Lcom/brandon3055/draconicevolution/common/network/TeleporterPacket;Lcpw/mods/fml/common/network/simpleimpl/MessageContext;)Lcpw/mods/fml/common/network/simpleimpl/IMessage;",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/player/EntityPlayerMP;getHeldItem()Lnet/minecraft/item/ItemStack;"),
        require = 1)
    private ItemStack NHUtilities$getTeleporterMKII(EntityPlayerMP instance) {
        if (instance.inventory.getCurrentItem() != null && instance.inventory.getCurrentItem()
            .getItem() == ModItems.teleporterMKII) {
            return instance.inventory.getCurrentItem();
        } else {
            var playerBaublesInventory = getItemInPlayerBaublesInventory(instance, TeleporterMKII.class);
            if (playerBaublesInventory.isPresent()) {
                return playerBaublesInventory.get();
            }
        }
        return null;
    }
}
