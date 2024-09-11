package com.xir.NHUtilities.common.items.itemFuelRod;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.items.aItemCore.RadioactiveItem;

import ic2.api.item.IBoxable;
import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;

public class ItemFuelRod extends RadioactiveItem implements IReactorComponent, IBoxable {

    public ItemFuelRod(String name, int mRadio) {
        super(name, mRadio);
    }

    @Override
    public boolean canBeStoredInToolbox(ItemStack itemStack) {
        return false;
    }

    @Override
    public void processChamber(IReactor iReactor, ItemStack itemStack, int i, int i1, boolean b) {

    }

    @Override
    public boolean acceptUraniumPulse(IReactor iReactor, ItemStack itemStack, ItemStack itemStack1, int i, int i1,
        int i2, int i3, boolean b) {
        return false;
    }

    @Override
    public boolean canStoreHeat(IReactor iReactor, ItemStack itemStack, int i, int i1) {
        return false;
    }

    @Override
    public int getMaxHeat(IReactor iReactor, ItemStack itemStack, int i, int i1) {
        return 0;
    }

    @Override
    public int getCurrentHeat(IReactor iReactor, ItemStack itemStack, int i, int i1) {
        return 0;
    }

    @Override
    public int alterHeat(IReactor iReactor, ItemStack itemStack, int i, int i1, int i2) {
        return 0;
    }

    @Override
    public float influenceExplosion(IReactor iReactor, ItemStack itemStack) {
        return 0;
    }
}
