package com.xir.NHUtilities.common.api.enums;

import static com.xir.NHUtilities.config.Config.wirelessHatchMetaIdOffset;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.NHUCreativeTabs;
import com.xir.NHUtilities.common.api.interfaces.IItemContainer;
import com.xir.NHUtilities.common.api.interfaces.IRegisterProvider;
import com.xir.NHUtilities.utils.CommonUtil;
import com.xir.NHUtilities.utils.RegisterUtil;

import gregtech.api.util.GTLog;

@SuppressWarnings({ "unused", "UnusedReturnValue" })
public enum WirelessHatchMore implements IItemContainer {

    // region Enum
    // spotless:off
    dynamoMulti_EV_4            (   1,      4,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_EV_16           (   2,      4,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_EV_64           (   3,      4,      64,         HatchType.WirelessDynamoHatch),

    energyMulti_IV_256          (   4,      5,      256,        HatchType.WirelessEnergyHatch),
    dynamoMulti_IV_4            (   5,      5,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_IV_16           (   6,      5,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_IV_64           (   7,      5,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_IV_256          (   8,      5,      256,        HatchType.WirelessDynamoHatch),

    energyMulti_LuV_256         (   9 ,     6,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_LuV_1024        (   10,     6,      1024,       HatchType.WirelessEnergyHatch),
    dynamoMulti_LuV_4           (   11,     6,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_LuV_16          (   12,     6,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_LuV_64          (   13,     6,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_LuV_256         (   14,     6,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_LuV_1024        (   15,     6,      1024,       HatchType.WirelessDynamoHatch),

    energyMulti_ZPM_256         (   16,     7,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_ZPM_1024        (   17,     7,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_ZPM_4096        (   18,     7,      4096,       HatchType.WirelessEnergyHatch),
    dynamoMulti_ZPM_4           (   19,     7,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_ZPM_16          (   20,     7,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_ZPM_64          (   21,     7,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_ZPM_256         (   22,     7,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_ZPM_1024        (   23,     7,      1024,       HatchType.WirelessDynamoHatch),
    dynamoMulti_ZPM_4096        (   24,     7,      4096,       HatchType.WirelessDynamoHatch),

    energyMulti_UV_256          (   25,     8,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_UV_1024         (   26,     8,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_UV_4096         (   27,     8,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_UV_16384        (   28,     8,      16384,      HatchType.WirelessEnergyHatch),
    dynamoMulti_UV_4            (   29,     8,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_16           (   30,     8,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_64           (   31,     8,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_256          (   32,     8,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_1024         (   33,     8,      1024,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_4096         (   34,     8,      4096,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UV_16384        (   35,     8,      16384,      HatchType.WirelessDynamoHatch),

    energyMulti_UHV_256         (   36,     9,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_UHV_1024        (   37,     9,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_UHV_4096        (   38,     9,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_UHV_16384       (   39,     9,      16384,      HatchType.WirelessEnergyHatch),
    energyMulti_UHV_65536       (   40,     9,      65536,      HatchType.WirelessEnergyHatch),
    dynamoMulti_UHV_4           (   41,     9,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_16          (   42,     9,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_64          (   43,     9,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_256         (   44,     9,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_1024        (   45,     9,      1024,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_4096        (   46,     9,      4096,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_16384       (   47,     9,      16384,      HatchType.WirelessDynamoHatch),
    dynamoMulti_UHV_65536       (   48,     9,      65536,      HatchType.WirelessDynamoHatch),

    energyMulti_UEV_256         (   49,    10,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_UEV_1024        (   50,    10,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_UEV_4096        (   51,    10,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_UEV_16384       (   52,    10,      16384,      HatchType.WirelessEnergyHatch),
    energyMulti_UEV_65536       (   53,    10,      65536,      HatchType.WirelessEnergyHatch),
    energyMulti_UEV_262144      (   54,    10,      262144,     HatchType.WirelessEnergyHatch),
    dynamoMulti_UEV_4           (   55,    10,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_16          (   56,    10,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_64          (   57,    10,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_256         (   58,    10,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_1024        (   59,    10,      1024,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_4096        (   60,    10,      4096,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_16384       (   61,    10,      16384,      HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_65536       (   62,    10,      65536,      HatchType.WirelessDynamoHatch),
    dynamoMulti_UEV_262144      (   63,    10,      262144,     HatchType.WirelessDynamoHatch),

    energyMulti_UIV_256         (   64,    11,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_UIV_1024        (   65,    11,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_UIV_4096        (   66,    11,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_UIV_16384       (   67,    11,      16384,      HatchType.WirelessEnergyHatch),
    energyMulti_UIV_65536       (   68,    11,      65536,      HatchType.WirelessEnergyHatch),
    energyMulti_UIV_262144      (   69,    11,      262144,     HatchType.WirelessEnergyHatch),
    energyMulti_UIV_1048576     (   70,    11,      1048576,    HatchType.WirelessEnergyHatch),
    dynamoMulti_UIV_4           (   71,    11,      4,          HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_16          (   72,    11,      16,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_64          (   73,    11,      64,         HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_256         (   74,    11,      256,        HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_1024        (   75,    11,      1024,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_4096        (   76,    11,      4096,       HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_16384       (   77,    11,      16384,      HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_65536       (   78,    11,      65536,      HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_262144      (   79,    11,      262144,     HatchType.WirelessDynamoHatch),
    dynamoMulti_UIV_1048576     (   80,    11,      1048576,    HatchType.WirelessDynamoHatch),

    energyMulti_UMV_256         (   81,    12,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_UMV_1024        (   82,    12,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_UMV_4096        (   83,    12,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_UMV_16384       (   84,    12,      16384,      HatchType.WirelessEnergyHatch),
    energyMulti_UMV_65536       (   85,    12,      65536,      HatchType.WirelessEnergyHatch),
    energyMulti_UMV_262144      (   86,    12,      262144,     HatchType.WirelessEnergyHatch),
    energyMulti_UMV_1048576     (   87,    12,      1048576,    HatchType.WirelessEnergyHatch),
    energyMulti_UMV_4194304     (   88,    12,      4194304,    HatchType.WirelessEnergyHatch),

    energyMulti_MAX_256         (   89,    14,      256,        HatchType.WirelessEnergyHatch),
    energyMulti_MAX_1024        (   90,    14,      1024,       HatchType.WirelessEnergyHatch),
    energyMulti_MAX_4096        (   91,    14,      4096,       HatchType.WirelessEnergyHatch),
    energyMulti_MAX_16384       (   92,    14,      16384,      HatchType.WirelessEnergyHatch),
    energyMulti_MAX_65536       (   93,    14,      65536,      HatchType.WirelessEnergyHatch),
    energyMulti_MAX_262144      (   94,    14,      262144,     HatchType.WirelessEnergyHatch),
    energyMulti_MAX_1048576     (   95,    14,      1048576,    HatchType.WirelessEnergyHatch),
    energyMulti_MAX_4194304     (   96,    14,      4194304,    HatchType.WirelessEnergyHatch),
    energyMulti_MAX_16777216    (   97,    14,      16777216,   HatchType.WirelessEnergyHatch),
    energyMulti_MAX_67108864    (   98,    14,      67108864,   HatchType.WirelessEnergyHatch),

    energyMulti_LV_4            (   100,    1,      4,          HatchType.WirelessEnergyHatch),
    energyMulti_LV_16           (   101,    1,      16,         HatchType.WirelessEnergyHatch),
    energyMulti_LV_64           (   102,    1,      64,         HatchType.WirelessEnergyHatch),

    energyMulti_MV_4            (   103,    2,      4,          HatchType.WirelessEnergyHatch),
    energyMulti_MV_16           (   104,    2,      16,         HatchType.WirelessEnergyHatch),
    energyMulti_MV_64           (   105,    2,      64,         HatchType.WirelessEnergyHatch),

    energyMulti_HV_4            (   106,    3,      4,          HatchType.WirelessEnergyHatch),
    energyMulti_HV_16           (   107,    3,      16,         HatchType.WirelessEnergyHatch),
    energyMulti_HV_64           (   108,    3,      64,         HatchType.WirelessEnergyHatch),

    // spotless:on
    // endregion
    ;

    // region Misc
    private ItemStack mStack;
    private boolean mWarned = false;
    private boolean mDeprecated = false;
    private boolean mHasNotBeenSet = true;
    public final int metaId;
    public final int aTier;
    public final int aAmperes;
    public final HatchType hatchType;

    WirelessHatchMore(int aID, int aTier, int aAmperes, HatchType hatchType) {
        this.metaId = 25100 + aID + wirelessHatchMetaIdOffset;
        this.aTier = aTier;
        this.aAmperes = aAmperes;
        this.hatchType = hatchType;
    }

    WirelessHatchMore(int aID, int aTier, int aAmperes, boolean aDeprecated, HatchType hatchType) {
        this(aID, aTier, aAmperes, hatchType);
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
