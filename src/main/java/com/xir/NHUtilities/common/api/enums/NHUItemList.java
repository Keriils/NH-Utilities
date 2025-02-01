package com.xir.NHUtilities.common.api.enums;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.interfaces.IItemContainer;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import gregtech.api.util.GTLog;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public enum NHUItemList implements IItemContainer {

    // region Meta Object
    MetaItem,
    MetaBlock,
    // endregion

    // region Material Mass
    ChaosDraconiumEgg,
    AncientDraconiumEgg,
    TestItem,
    TestItem2,
    MetaDust1,
    MetaDust2,
    MetaDust3,
    MetaDust4,
    PlateCrystal1,
    PlateCrystal2,
    PlateCrystal3,
    PlateCrystal4,
    PlateCrystal5,
    PlateCrystal6,
    PlateCrystal7,
    PlateCrystal8,
    PlateCrystal9,
    PlateCrystal1_Hot,
    PlateCrystal2_Hot,
    PlateCrystal3_Hot,
    PlateCrystal4_Hot,
    PlateCrystal5_Hot,
    PlateCrystal6_Hot,
    PlateCrystal7_Hot,
    PlateCrystal8_Hot,
    PlateCrystal9_Hot,
    // endregion

    // region Material Block
    EggMachineBlock,
    // endregion

    // region Common Item
    TimeVial,
    EternityVial,
    GluttonyRing,
    HungerRing,
    KamiRing,
    LunchBoxPlus,
    FocusTape,
    WarpWardRing,
    // endregion

    // region Fuel Rod
    IchorFuelRod,
    ShadowFuelRod,
    IchorDroplet,
    PrimordialPearlDust,
    // Radiance Uranium
    RodRadianceUranium,
    RodRadianceUranium2,
    RodRadianceUranium4,
    RodRadianceUraniumDepleted,
    RodRadianceUraniumDepleted2,
    RodRadianceUraniumDepleted4,
    // Primordial Pearl Plutonium
    RodPrimordialPearlPlutonium,
    RodPrimordialPearlPlutonium2,
    RodPrimordialPearlPlutonium4,
    RodPrimordialPearlPlutoniumDepleted,
    RodPrimordialPearlPlutoniumDepleted2,
    RodPrimordialPearlPlutoniumDepleted4,
    // endregion

    // region Common Block
    ChaosDragonEgg,
    AncientDragonEgg,
    // endregion

    // region Machines
    TestMachine,
    TCBlastFurnace,
    Egg_Machine_EV,
    Egg_Machine_IV,
    Egg_Machine_LuV,
    Egg_Machine_ZPM,
    Egg_Machine_UV,
    Egg_Machine_UHV,
    Egg_Machine_UEV,
    Egg_Machine_UIV,
    Egg_Machine_UMV,
    Egg_Machine_UXV,
    Egg_Machine_MAX,
    // endregion
    ;

    private ItemStack mStack;
    private boolean mWarned = false;
    private boolean mDeprecated = false;
    private boolean mHasNotBeenSet = true;

    NHUItemList() {}

    NHUItemList(boolean aDeprecated) {
        mDeprecated = aDeprecated;
    }

    @Override
    public Item getItem() {
        sanityCheck();
        if (CommonUtil.isStackInvalid(mStack)) return Item.getItemFromBlock(Blocks.fire);
        return mStack.getItem();
    }

    @Override
    public Block getBlock() {
        sanityCheck();
        return Block.getBlockFromItem(getItem());
    }

    @Override
    public int getMeta() {
        sanityCheck();
        return mStack.getItemDamage();
    }

    @Override
    public ItemStack get(int aAmount) {
        sanityCheck();
        if (CommonUtil.isStackInvalid(mStack)) {
            GTLog.out.println("Object in the ItemList is null at:");
            new NullPointerException().printStackTrace(GTLog.out);
            return new ItemStack(Blocks.fire);
        }
        return CommonUtil.copyAmount(aAmount, mStack);
    }

    @Override
    public IItemContainer set(Block aBlock) {
        return set(Item.getItemFromBlock(aBlock));
    }

    @Override
    public IItemContainer set(Item aItem) {
        mHasNotBeenSet = false;
        if (aItem == null) return this;
        mStack = CommonUtil.copyAmount(1, aItem);
        return this;
    }

    @Override
    public IItemContainer set(ItemStack aItemStack) {
        mHasNotBeenSet = false;
        if (aItemStack == null) return this;
        mStack = CommonUtil.copyAmount(1, aItemStack);
        return this;
    }

    public IItemContainer setAndRegister(IRegisterProvider register) {
        return setAndRegister(register, null, true);
    }

    public IItemContainer setAndRegister(IRegisterProvider register, boolean shouldRegister) {
        return setAndRegister(register, null, shouldRegister);
    }

    /**
     * A lazy register.
     */
    public IItemContainer setAndRegister(Supplier<IRegisterProvider> supplier, boolean shouldRegister) {
        if (shouldRegister) {
            return setAndRegister(supplier.get());
        } else return null;
    }

    @Override
    public IItemContainer setAndRegister(IRegisterProvider register, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        return setAndRegister(register, register.getRegisterName(), aItemClass, shouldRegister);
    }

    @Override
    public IItemContainer setAndRegister(Object aObject, String aRegisterName, Class<? extends ItemBlock> aItemClass,
        boolean shouldRegister) {
        mHasNotBeenSet = false;
        if (aObject instanceof Block aBlock) {
            RegisterUtil.registerBlock(aBlock, aItemClass, aRegisterName, shouldRegister);
            return set(aBlock);
        }
        if (aObject instanceof Item aItem) {
            RegisterUtil.registerItem(aItem, aRegisterName, shouldRegister);
            return set(aItem);
        }
        return this;
    }

    @Override
    public void sanityCheck() {
        if (mHasNotBeenSet)
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        if (mDeprecated && !mWarned) {
            new Exception(this + " is now deprecated").printStackTrace(GTLog.err);
            mWarned = true;
        }
    }

    @Override
    public boolean hasBeenSet() {
        return !mHasNotBeenSet;
    }
}
