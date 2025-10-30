package com.xir.NHUtilities.common.tiles.utils;

import static com.xir.NHUtilities.common.api.UtilHelper.WarpBox.newWarpBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.xir.NHUtilities.common.api.UtilHelper.WarpBox;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.common.items.lunchBoxPlus.LunchBoxPlus;
import com.xir.NHUtilities.container.ContainerFoodContainerPlus;
import com.xir.NHUtilities.inventory.lunchBoxPlus.FoodContainerInventoryPlus;
import com.xir.NHUtilities.utils.InventoryUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DispatchUnit {

    @NotNull
    @Getter
    private final EntityPlayer player;
    @Nullable
    private ItemStack lunchBoxPlus;
    @Nullable
    private FoodContainerInventoryPlus inventoryPlus;

    static final WarpBox<LunchBoxPlus> boxApi = newWarpBox(NHUItemList.LunchBoxPlus::getItem);

    public ItemStack getLunchBoxPlus() {
        if (lunchBoxPlus != null) return lunchBoxPlus;
        return lunchBoxPlus = InventoryUtils.getItemInPlayerInventory(player, LunchBoxPlus.class)
            .orElse(lunchBoxPlus);
    }

    public FoodContainerInventoryPlus getInventoryPlus() {
        if (inventoryPlus != null) return inventoryPlus;
        return getLunchBoxPlus() == null ? inventoryPlus
            : (inventoryPlus = boxApi.get()
                .getInventory(lunchBoxPlus));
    }

    public boolean isValid() {
        return getLunchBoxPlus() != null && getInventoryPlus() != null;
    }

    // gui同步稍微复杂了些,当玩家打开gui时有同步问题
    // 同时从逻辑上看 午餐盒打开着才能分发过去 不是吗....
    public boolean canProcess() {
        return !player.isEating() && isLunchBoxOpened() && !isPlayerInteractWithContainer() && hasEmptySlot();
    }

    public boolean hasEmptySlot() {
        if (getInventoryPlus() != null) for (ItemStack itemStack : getInventoryPlus().getInventoryItems())
            if (itemStack == null || itemStack.stackSize <= 0) return true;
        return false;
    }

    public boolean isLunchBoxOpened() {
        return getLunchBoxPlus() != null && boxApi.get()
            .isOpen(getLunchBoxPlus());
    }

    public boolean isPlayerInteractWithContainer() {
        var isHoldingLunchBox = player.getHeldItem() == getLunchBoxPlus();
        var isOpeningLunchBox = player.openContainer instanceof ContainerFoodContainerPlus;
        return isHoldingLunchBox && isOpeningLunchBox;
    }

    public void markDirty() {
        getInventoryPlus().markDirty();
    }
}
