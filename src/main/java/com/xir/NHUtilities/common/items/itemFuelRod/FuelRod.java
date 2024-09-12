package com.xir.NHUtilities.common.items.itemFuelRod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

import org.jetbrains.annotations.NotNull;

import com.xir.NHUtilities.common.items.aItemCore.RadioactiveItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.util.GT_Utility;
import ic2.api.item.IBoxable;
import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;

public class FuelRod extends RadioactiveItem implements IReactorComponent, IBoxable {

    // region Fields
    private final int Heat;
    private final float Power;
    private final int Duration;
    private final int numberOfCells;
    private final ItemStack depletedResult;
    private final float HeatBonus; // for mox cell
    // endregion

    // region Constructor
    public FuelRod(String aName, int aCells, int aEUt, int aHeat, int aRads, int aDuration, float aHeatBonus,
        ItemStack aDepletedResult) {
        super(aName, aRads);
        this.setMaxStackSize(64);
        this.numberOfCells = aCells;
        this.Power = aEUt / 25.0F;
        this.Duration = aDuration;
        this.Heat = aHeat;
        this.HeatBonus = aHeatBonus;
        this.depletedResult = aDepletedResult;
    }
    // endregion

    // region ChamberProcess
    @Override
    @SuppressWarnings("ConstantConditions")
    public void processChamber(IReactor reactor, ItemStack stack, int x, int y, boolean heatRun) {
        if (reactor.produceEnergy()) {
            for (int iteration = 0; iteration < this.numberOfCells; ++iteration) {
                int pulses = 1 + this.numberOfCells / 2;
                int heat;
                if (!heatRun) {
                    for (heat = 0; heat < pulses; ++heat) {
                        this.acceptUraniumPulse(reactor, stack, stack, x, y, x, y, false);
                    }
                    checkPulseAble(reactor, x - 1, y, stack, x, y, false);
                    checkPulseAble(reactor, x + 1, y, stack, x, y, false);
                    checkPulseAble(reactor, x, y - 1, stack, x, y, false);
                    checkPulseAble(reactor, x, y + 1, stack, x, y, false);
                } else {
                    pulses += checkPulseAble(reactor, x - 1, y, stack, x, y, true)
                        + checkPulseAble(reactor, x + 1, y, stack, x, y, true)
                        + checkPulseAble(reactor, x, y - 1, stack, x, y, true)
                        + checkPulseAble(reactor, x, y + 1, stack, x, y, true);
                    heat = sumUp(pulses) * this.Heat;
                    ArrayList<FuelRod.ItemStackCoord> heatAcceptors = new ArrayList<>();
                    this.checkHeatAcceptor(reactor, x - 1, y, heatAcceptors);
                    this.checkHeatAcceptor(reactor, x + 1, y, heatAcceptors);
                    this.checkHeatAcceptor(reactor, x, y - 1, heatAcceptors);
                    this.checkHeatAcceptor(reactor, x, y + 1, heatAcceptors);

                    while (!heatAcceptors.isEmpty() && heat > 0) {
                        int dheat = heat / heatAcceptors.size();
                        heat -= dheat;
                        dheat = ((IReactorComponent) heatAcceptors.get(0).stack.getItem()).alterHeat(
                            reactor,
                            heatAcceptors.get(0).stack,
                            heatAcceptors.get(0).x,
                            heatAcceptors.get(0).y,
                            dheat);
                        heat += dheat;
                        heatAcceptors.remove(0);
                    }

                    if (heat > 0) {
                        reactor.addHeat(heat);
                    }
                }
            }
            if (this.getCustomDamage(stack) >= this.getMaxCustomDamage(stack) - 1) {
                reactor.setItemAt(x, y, GT_Utility.copyAmount(1, depletedResult));
            } else if (heatRun) {
                this.setCustomDamage(stack, this.getCustomDamage(stack) + 1);
            }
        }
    }

    private static int checkPulseAble(@NotNull IReactor reactor, int x, int y, ItemStack me, int mex, int mey,
        boolean heatRun) {
        ItemStack other = reactor.getItemAt(x, y);
        return other != null && other.getItem() instanceof IReactorComponent
            && ((IReactorComponent) other.getItem()).acceptUraniumPulse(reactor, other, me, x, y, mex, mey, heatRun) ? 1
                : 0;
    }

    private static int sumUp(int x) {
        return (x * x + x) / 2;
    }

    private void checkHeatAcceptor(@NotNull IReactor reactor, int x, int y,
        ArrayList<FuelRod.ItemStackCoord> heatAcceptors) {
        ItemStack thing = reactor.getItemAt(x, y);
        if (thing != null && thing.getItem() instanceof IReactorComponent
            && ((IReactorComponent) thing.getItem()).canStoreHeat(reactor, thing, x, y)) {
            heatAcceptors.add(new ItemStackCoord(thing, x, y));
        }
    }

    @Override
    public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY,
        int pulseX, int pulseY, boolean heatRun) {
        if (!heatRun) {
            reactor.addOutput(Power * (1 + HeatBonus * ((float) reactor.getHeat() / (float) reactor.getMaxHeat())));
        }
        return true;
    }

    private static class ItemStackCoord {

        public ItemStack stack;
        public int x;
        public int y;

        public ItemStackCoord(ItemStack stack1, int x1, int y1) {
            this.stack = stack1;
            this.x = x1;
            this.y = y1;
        }
    }

    public int getCustomDamage(ItemStack stack) {
        NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
        return nbt.getInteger("advDmg");
    }

    public int getMaxCustomDamage(ItemStack stack) {
        return this.Duration;
    }

    public void setCustomDamage(ItemStack stack, int damage) {
        NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
        nbt.setInteger("advDmg", damage);
        int maxStackDamage = stack.getMaxDamage();
        if (maxStackDamage > 2) {
            stack.setItemDamage(1 + (int) Util.map(damage, this.Duration, maxStackDamage - 2));
        }
    }
    // endregion

    // region Override
    @Override
    public boolean canBeStoredInToolbox(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
        return false;
    }

    @Override
    public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
        return 0;
    }

    @Override
    public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
        return 0;
    }

    @Override
    public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
        return heat;
    }

    @Override
    public float influenceExplosion(IReactor iReactor, ItemStack itemStack) {
        return this.numberOfCells * (HeatBonus + 2.7F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean extraInformation) {
        list.add(
            String.format(
                StatCollector.translateToLocal("text.NHUtilities.fuelRod.tooltip.0"),
                getMaxCustomDamage(stack) - getCustomDamage(stack),
                getMaxCustomDamage(stack)));
        if (this.HeatBonus > 0F) StatCollector.translateToLocal("text.NHUtilities.fuelRod.tooltip.1");
        list.add(String.format(StatCollector.translateToLocal("text.NHUtilities.fuelRod.tooltip.2"), this.Heat));
        list.add(String.format(StatCollector.translateToLocal("text.NHUtilities.fuelRod.tooltip.3"), this.Power));
    }
    // endregion

}
