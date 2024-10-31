package com.xir.NHUtilities.mixins.late.WorldEditGtnh;

import net.minecraft.item.Item;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.extension.platform.PlatformManager;

import cpw.mods.fml.common.registry.GameRegistry;

@Mixin(value = PlatformManager.class, remap = false)
public class ModifyWEWithExU {

    @Unique
    PlatformManager NHUtilities$pManager = (PlatformManager) (Object) this;

    @Redirect(
        method = "handleBlockInteract",
        at = @At(value = "INVOKE", target = "Lcom/sk89q/worldedit/entity/Player;getItemInHand()I", ordinal = 0),
        require = 1)
    private int NHUtilities$modifyLeftClick(Player instance) {
        return NHUtilities$check(instance);
    }

    @Redirect(
        method = "handleBlockInteract",
        at = @At(value = "INVOKE", target = "Lcom/sk89q/worldedit/entity/Player;getItemInHand()I", ordinal = 2),
        require = 1)
    private int NHUtilities$modifyRightClick(Player instance) {
        return NHUtilities$check(instance);
    }

    @Unique
    private int NHUtilities$check(@NotNull Player instance) {
        int itemInHand = instance.getItemInHand();
        return itemInHand == Item.getIdFromItem(GameRegistry.findItem("ExtraUtilities", "defoliageAxe"))
            ? NHUtilities$pManager.getConfiguration().wandItem
            : itemInHand;
    }

}
