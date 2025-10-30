package com.xir.NHUtilities.common.api.enums;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableList;
import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.interfaces.IItemContainer;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;
import com.xir.NHUtilities.common.api.interfaces.IRegisterTileProvider;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GTLog;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public enum NHUItemList implements IItemContainer {

    // region Meta Object
    MetaItem,
    MetaBlock,
    WirelessCoverItem,
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
    Chip_EnergyModule,
    // endregion

    // region Wireless Cover Things
    // 2A cover
    Cover_Wireless_Dynamo_2A_LV,
    Cover_Wireless_Dynamo_2A_MV,
    Cover_Wireless_Dynamo_2A_HV,
    Cover_Wireless_Dynamo_2A_EV,
    Cover_Wireless_Dynamo_2A_IV,
    Cover_Wireless_Dynamo_2A_LuV,
    Cover_Wireless_Dynamo_2A_ZPM,
    Cover_Wireless_Dynamo_2A_UV,
    Cover_Wireless_Dynamo_2A_UHV,
    Cover_Wireless_Dynamo_2A_UEV,
    Cover_Wireless_Dynamo_2A_UIV,
    Cover_Wireless_Dynamo_2A_UMV,
    Cover_Wireless_Dynamo_2A_UXV,
    Cover_Wireless_Dynamo_2A_MAX,
    Cover_Wireless_Energy_2A_LV,
    Cover_Wireless_Energy_2A_MV,
    Cover_Wireless_Energy_2A_HV,
    Cover_Wireless_Energy_2A_EV,
    Cover_Wireless_Energy_2A_IV,
    Cover_Wireless_Energy_2A_LuV,
    Cover_Wireless_Energy_2A_ZPM,
    Cover_Wireless_Energy_2A_UV,
    Cover_Wireless_Energy_2A_UHV,
    Cover_Wireless_Energy_2A_UEV,
    Cover_Wireless_Energy_2A_UIV,
    Cover_Wireless_Energy_2A_UMV,
    Cover_Wireless_Energy_2A_UXV,
    Cover_Wireless_Energy_2A_MAX,
    // 4A cover
    Cover_Wireless_Dynamo_Multi_4A_LV,
    Cover_Wireless_Dynamo_Multi_4A_MV,
    Cover_Wireless_Dynamo_Multi_4A_HV,
    Cover_Wireless_Dynamo_Multi_4A_EV,
    Cover_Wireless_Dynamo_Multi_4A_IV,
    Cover_Wireless_Dynamo_Multi_4A_LuV,
    Cover_Wireless_Dynamo_Multi_4A_ZPM,
    Cover_Wireless_Dynamo_Multi_4A_UV,
    Cover_Wireless_Dynamo_Multi_4A_UHV,
    Cover_Wireless_Dynamo_Multi_4A_UEV,
    Cover_Wireless_Dynamo_Multi_4A_UIV,
    Cover_Wireless_Dynamo_Multi_4A_UMV,
    Cover_Wireless_Dynamo_Multi_4A_UXV,
    Cover_Wireless_Dynamo_Multi_4A_MAX,
    Cover_Wireless_Energy_Multi_4A_LV,
    Cover_Wireless_Energy_Multi_4A_MV,
    Cover_Wireless_Energy_Multi_4A_HV,
    Cover_Wireless_Energy_Multi_4A_EV,
    Cover_Wireless_Energy_Multi_4A_IV,
    Cover_Wireless_Energy_Multi_4A_LuV,
    Cover_Wireless_Energy_Multi_4A_ZPM,
    Cover_Wireless_Energy_Multi_4A_UV,
    Cover_Wireless_Energy_Multi_4A_UHV,
    Cover_Wireless_Energy_Multi_4A_UEV,
    Cover_Wireless_Energy_Multi_4A_UIV,
    Cover_Wireless_Energy_Multi_4A_UMV,
    Cover_Wireless_Energy_Multi_4A_UXV,
    Cover_Wireless_Energy_Multi_4A_MAX,
    // 16A cover
    Cover_Wireless_Dynamo_Multi_16A_LV,
    Cover_Wireless_Dynamo_Multi_16A_MV,
    Cover_Wireless_Dynamo_Multi_16A_HV,
    Cover_Wireless_Dynamo_Multi_16A_EV,
    Cover_Wireless_Dynamo_Multi_16A_IV,
    Cover_Wireless_Dynamo_Multi_16A_LuV,
    Cover_Wireless_Dynamo_Multi_16A_ZPM,
    Cover_Wireless_Dynamo_Multi_16A_UV,
    Cover_Wireless_Dynamo_Multi_16A_UHV,
    Cover_Wireless_Dynamo_Multi_16A_UEV,
    Cover_Wireless_Dynamo_Multi_16A_UIV,
    Cover_Wireless_Dynamo_Multi_16A_UMV,
    Cover_Wireless_Dynamo_Multi_16A_UXV,
    Cover_Wireless_Dynamo_Multi_16A_MAX,
    Cover_Wireless_Energy_Multi_16A_LV,
    Cover_Wireless_Energy_Multi_16A_MV,
    Cover_Wireless_Energy_Multi_16A_HV,
    Cover_Wireless_Energy_Multi_16A_EV,
    Cover_Wireless_Energy_Multi_16A_IV,
    Cover_Wireless_Energy_Multi_16A_LuV,
    Cover_Wireless_Energy_Multi_16A_ZPM,
    Cover_Wireless_Energy_Multi_16A_UV,
    Cover_Wireless_Energy_Multi_16A_UHV,
    Cover_Wireless_Energy_Multi_16A_UEV,
    Cover_Wireless_Energy_Multi_16A_UIV,
    Cover_Wireless_Energy_Multi_16A_UMV,
    Cover_Wireless_Energy_Multi_16A_UXV,
    Cover_Wireless_Energy_Multi_16A_MAX,
    // 64A cover
    Cover_Wireless_Dynamo_Multi_64A_LV,
    Cover_Wireless_Dynamo_Multi_64A_MV,
    Cover_Wireless_Dynamo_Multi_64A_HV,
    Cover_Wireless_Dynamo_Multi_64A_EV,
    Cover_Wireless_Dynamo_Multi_64A_IV,
    Cover_Wireless_Dynamo_Multi_64A_LuV,
    Cover_Wireless_Dynamo_Multi_64A_ZPM,
    Cover_Wireless_Dynamo_Multi_64A_UV,
    Cover_Wireless_Dynamo_Multi_64A_UHV,
    Cover_Wireless_Dynamo_Multi_64A_UEV,
    Cover_Wireless_Dynamo_Multi_64A_UIV,
    Cover_Wireless_Dynamo_Multi_64A_UMV,
    Cover_Wireless_Dynamo_Multi_64A_UXV,
    Cover_Wireless_Dynamo_Multi_64A_MAX,
    Cover_Wireless_Energy_Multi_64A_LV,
    Cover_Wireless_Energy_Multi_64A_MV,
    Cover_Wireless_Energy_Multi_64A_HV,
    Cover_Wireless_Energy_Multi_64A_EV,
    Cover_Wireless_Energy_Multi_64A_IV,
    Cover_Wireless_Energy_Multi_64A_LuV,
    Cover_Wireless_Energy_Multi_64A_ZPM,
    Cover_Wireless_Energy_Multi_64A_UV,
    Cover_Wireless_Energy_Multi_64A_UHV,
    Cover_Wireless_Energy_Multi_64A_UEV,
    Cover_Wireless_Energy_Multi_64A_UIV,
    Cover_Wireless_Energy_Multi_64A_UMV,
    Cover_Wireless_Energy_Multi_64A_UXV,
    Cover_Wireless_Energy_Multi_64A_MAX,

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

    // region Common Block
    LunchDispatcher,
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

    // region convenient for wireless & new hatch

    Hatch_EnergyMulti4_LV,
    Hatch_EnergyMulti16_LV,
    Hatch_EnergyMulti64_LV,
    Hatch_EnergyMulti4_MV,
    Hatch_EnergyMulti16_MV,
    Hatch_EnergyMulti64_MV,
    Hatch_EnergyMulti4_HV,
    Hatch_EnergyMulti16_HV,
    Hatch_EnergyMulti64_HV,
    Hatch_EnergyMulti4_MAX,
    Hatch_EnergyMulti16_MAX,
    Hatch_EnergyMulti64_MAX,

    Hatch_Dynamo_MAX,
    Hatch_Energy_MAX,
    // endregion
    ;

    // region helper

    // cover_2_A
    public static final ImmutableList<NHUItemList> WIRELESS_DYNAMO_COVERS_2_A = ImmutableList.of(
        Cover_Wireless_Dynamo_2A_LV,
        Cover_Wireless_Dynamo_2A_MV,
        Cover_Wireless_Dynamo_2A_HV,
        Cover_Wireless_Dynamo_2A_EV,
        Cover_Wireless_Dynamo_2A_IV,
        Cover_Wireless_Dynamo_2A_LuV,
        Cover_Wireless_Dynamo_2A_ZPM,
        Cover_Wireless_Dynamo_2A_UV,
        Cover_Wireless_Dynamo_2A_UHV,
        Cover_Wireless_Dynamo_2A_UEV,
        Cover_Wireless_Dynamo_2A_UIV,
        Cover_Wireless_Dynamo_2A_UMV,
        Cover_Wireless_Dynamo_2A_UXV,
        Cover_Wireless_Dynamo_2A_MAX);

    public static final ImmutableList<NHUItemList> WIRELESS_ENERGY_COVERS_2_A = ImmutableList.of(
        Cover_Wireless_Energy_2A_LV,
        Cover_Wireless_Energy_2A_MV,
        Cover_Wireless_Energy_2A_HV,
        Cover_Wireless_Energy_2A_EV,
        Cover_Wireless_Energy_2A_IV,
        Cover_Wireless_Energy_2A_LuV,
        Cover_Wireless_Energy_2A_ZPM,
        Cover_Wireless_Energy_2A_UV,
        Cover_Wireless_Energy_2A_UHV,
        Cover_Wireless_Energy_2A_UEV,
        Cover_Wireless_Energy_2A_UIV,
        Cover_Wireless_Energy_2A_UMV,
        Cover_Wireless_Energy_2A_UXV,
        Cover_Wireless_Energy_2A_MAX);

    // cover_4_A
    public static final ImmutableList<NHUItemList> WIRELESS_DYNAMO_COVERS_MULTI_4_A = ImmutableList.of(
        Cover_Wireless_Dynamo_Multi_4A_LV,
        Cover_Wireless_Dynamo_Multi_4A_MV,
        Cover_Wireless_Dynamo_Multi_4A_HV,
        Cover_Wireless_Dynamo_Multi_4A_EV,
        Cover_Wireless_Dynamo_Multi_4A_IV,
        Cover_Wireless_Dynamo_Multi_4A_LuV,
        Cover_Wireless_Dynamo_Multi_4A_ZPM,
        Cover_Wireless_Dynamo_Multi_4A_UV,
        Cover_Wireless_Dynamo_Multi_4A_UHV,
        Cover_Wireless_Dynamo_Multi_4A_UEV,
        Cover_Wireless_Dynamo_Multi_4A_UIV,
        Cover_Wireless_Dynamo_Multi_4A_UMV,
        Cover_Wireless_Dynamo_Multi_4A_UXV,
        Cover_Wireless_Dynamo_Multi_4A_MAX);

    public static final ImmutableList<NHUItemList> WIRELESS_ENERGY_COVERS_MULTI_4_A = ImmutableList.of(
        Cover_Wireless_Energy_Multi_4A_LV,
        Cover_Wireless_Energy_Multi_4A_MV,
        Cover_Wireless_Energy_Multi_4A_HV,
        Cover_Wireless_Energy_Multi_4A_EV,
        Cover_Wireless_Energy_Multi_4A_IV,
        Cover_Wireless_Energy_Multi_4A_LuV,
        Cover_Wireless_Energy_Multi_4A_ZPM,
        Cover_Wireless_Energy_Multi_4A_UV,
        Cover_Wireless_Energy_Multi_4A_UHV,
        Cover_Wireless_Energy_Multi_4A_UEV,
        Cover_Wireless_Energy_Multi_4A_UIV,
        Cover_Wireless_Energy_Multi_4A_UMV,
        Cover_Wireless_Energy_Multi_4A_UXV,
        Cover_Wireless_Energy_Multi_4A_MAX);

    // cover_16A
    public static final ImmutableList<NHUItemList> WIRELESS_DYNAMO_COVERS_MULTI_16_A = ImmutableList.of(
        Cover_Wireless_Dynamo_Multi_16A_LV,
        Cover_Wireless_Dynamo_Multi_16A_MV,
        Cover_Wireless_Dynamo_Multi_16A_HV,
        Cover_Wireless_Dynamo_Multi_16A_EV,
        Cover_Wireless_Dynamo_Multi_16A_IV,
        Cover_Wireless_Dynamo_Multi_16A_LuV,
        Cover_Wireless_Dynamo_Multi_16A_ZPM,
        Cover_Wireless_Dynamo_Multi_16A_UV,
        Cover_Wireless_Dynamo_Multi_16A_UHV,
        Cover_Wireless_Dynamo_Multi_16A_UEV,
        Cover_Wireless_Dynamo_Multi_16A_UIV,
        Cover_Wireless_Dynamo_Multi_16A_UMV,
        Cover_Wireless_Dynamo_Multi_16A_UXV,
        Cover_Wireless_Dynamo_Multi_16A_MAX);

    public static final ImmutableList<NHUItemList> WIRELESS_ENERGY_COVERS_MULTI_16_A = ImmutableList.of(
        Cover_Wireless_Energy_Multi_16A_LV,
        Cover_Wireless_Energy_Multi_16A_MV,
        Cover_Wireless_Energy_Multi_16A_HV,
        Cover_Wireless_Energy_Multi_16A_EV,
        Cover_Wireless_Energy_Multi_16A_IV,
        Cover_Wireless_Energy_Multi_16A_LuV,
        Cover_Wireless_Energy_Multi_16A_ZPM,
        Cover_Wireless_Energy_Multi_16A_UV,
        Cover_Wireless_Energy_Multi_16A_UHV,
        Cover_Wireless_Energy_Multi_16A_UEV,
        Cover_Wireless_Energy_Multi_16A_UIV,
        Cover_Wireless_Energy_Multi_16A_UMV,
        Cover_Wireless_Energy_Multi_16A_UXV,
        Cover_Wireless_Energy_Multi_16A_MAX);

    // cover_64A
    public static final ImmutableList<NHUItemList> WIRELESS_DYNAMO_COVERS_MULTI_64_A = ImmutableList.of(
        Cover_Wireless_Dynamo_Multi_64A_LV,
        Cover_Wireless_Dynamo_Multi_64A_MV,
        Cover_Wireless_Dynamo_Multi_64A_HV,
        Cover_Wireless_Dynamo_Multi_64A_EV,
        Cover_Wireless_Dynamo_Multi_64A_IV,
        Cover_Wireless_Dynamo_Multi_64A_LuV,
        Cover_Wireless_Dynamo_Multi_64A_ZPM,
        Cover_Wireless_Dynamo_Multi_64A_UV,
        Cover_Wireless_Dynamo_Multi_64A_UHV,
        Cover_Wireless_Dynamo_Multi_64A_UEV,
        Cover_Wireless_Dynamo_Multi_64A_UIV,
        Cover_Wireless_Dynamo_Multi_64A_UMV,
        Cover_Wireless_Dynamo_Multi_64A_UXV,
        Cover_Wireless_Dynamo_Multi_64A_MAX);

    public static final ImmutableList<NHUItemList> WIRELESS_ENERGY_COVERS_MULTI_64_A = ImmutableList.of(
        Cover_Wireless_Energy_Multi_64A_LV,
        Cover_Wireless_Energy_Multi_64A_MV,
        Cover_Wireless_Energy_Multi_64A_HV,
        Cover_Wireless_Energy_Multi_64A_EV,
        Cover_Wireless_Energy_Multi_64A_IV,
        Cover_Wireless_Energy_Multi_64A_LuV,
        Cover_Wireless_Energy_Multi_64A_ZPM,
        Cover_Wireless_Energy_Multi_64A_UV,
        Cover_Wireless_Energy_Multi_64A_UHV,
        Cover_Wireless_Energy_Multi_64A_UEV,
        Cover_Wireless_Energy_Multi_64A_UIV,
        Cover_Wireless_Energy_Multi_64A_UMV,
        Cover_Wireless_Energy_Multi_64A_UXV,
        Cover_Wireless_Energy_Multi_64A_MAX);

    public static final ImmutableList<ImmutableList<NHUItemList>> DYNAMO_COVERS = ImmutableList.of(
        WIRELESS_DYNAMO_COVERS_2_A,
        WIRELESS_DYNAMO_COVERS_MULTI_4_A,
        WIRELESS_DYNAMO_COVERS_MULTI_16_A,
        WIRELESS_DYNAMO_COVERS_MULTI_64_A);

    public static final ImmutableList<ImmutableList<NHUItemList>> ENERGY_COVERS = ImmutableList.of(
        WIRELESS_ENERGY_COVERS_2_A,
        WIRELESS_ENERGY_COVERS_MULTI_4_A,
        WIRELESS_ENERGY_COVERS_MULTI_16_A,
        WIRELESS_ENERGY_COVERS_MULTI_64_A);

    // endregion

    private ItemStack mStack;
    private boolean mWarned = false;
    private boolean mDeprecated = false;
    private boolean mHasNotBeenSet = true;

    NHUItemList() {}

    NHUItemList(boolean aDeprecated) {
        mDeprecated = aDeprecated;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <I extends Item> I getItem() {
        sanityCheck();
        if (CommonUtil.isStackInvalid(mStack)) return (I) Item.getItemFromBlock(Blocks.fire);
        return (I) mStack.getItem();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <B extends Block> B getBlock() {
        sanityCheck();
        return (B) Block.getBlockFromItem(getItem());
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
            return CommonUtil.aErrorStack();
        }
        return CommonUtil.copyAmount(mStack, aAmount);
    }

    @Override
    public IItemContainer set(ItemStack aItemStack) {
        if (aItemStack == null) return this;
        mHasNotBeenSet = false;
        mStack = CommonUtil.copyAmount(aItemStack, 1);
        if (CommonUtil.isClientSide()) {
            Item item = mStack.getItem();
            if (item == null) return this;
            else if (item.getCreativeTab() == null) {
                NHUCreativeTabs.addToDefaultCreativeTab(mStack.copy());
            }
        }
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
        if (aObject instanceof Block aBlock) {
            RegisterUtil.registerBlock(aBlock, aItemClass, aRegisterName, shouldRegister);
            if (shouldRegister && aBlock instanceof IRegisterTileProvider<?>provider) {
                GameRegistry.registerTileEntity(provider.getTeClass(), aRegisterName);
            }
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
