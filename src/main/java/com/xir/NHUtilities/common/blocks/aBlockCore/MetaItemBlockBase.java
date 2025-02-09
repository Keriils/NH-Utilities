package com.xir.NHUtilities.common.blocks.aBlockCore;

import static com.xir.NHUtilities.common.api.NHUCreativeTabs.NHUCreativeTab;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.api.MTOData;
import com.xir.NHUtilities.common.api.interfaces.IMetaObjectProvider;
import com.xir.NHUtilities.common.api.interfaces.IMetaTypeObject;

import gregtech.api.util.GTLanguageManager;

@SuppressWarnings("unused")
public class MetaItemBlockBase extends ItemBlock implements IMetaObjectProvider {

    @SuppressWarnings("SpellCheckingInspection")
    public final String mNoMobsToolTip = GTLanguageManager
        .addStringLocalization("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    @SuppressWarnings("SpellCheckingInspection")
    public final String mNoTileEntityToolTip = GTLanguageManager
        .addStringLocalization("gt.notileentityinthisblock", "This is NOT a TileEntity!");

    protected MTOData<? extends IMetaTypeObject> mtoData;

    protected Supplier<MTOData<? extends IMetaTypeObject>> dataSupplier;

    public MetaItemBlockBase(Block block) {
        super(block);
        if (!(block instanceof MetaBlockBase metaBlockBase)) throw new IllegalArgumentException();
        this.dataSupplier = () -> metaBlockBase.mtoData;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(NHUCreativeTab);
    }

    /**
     * return the MetaTypeManager registered in {@link MTOData}
     */
    @Override
    public MTOData<? extends IMetaTypeObject> getMTOData() {
        if (mtoData == null) {
            if (dataSupplier == null) throw new IllegalStateException();
            mtoData = dataSupplier.get();
        }
        return mtoData;
    }

    @Override
    public int getMetadata(int aMeta) {
        return aMeta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return getMTOData().getName(meta) != null ? (getUnlocalizedName() + "." + meta) : "nhutilities.null";
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> aList, boolean b3h) {
        int meta = itemStack.getItemDamage();
        String[] tooltip = getMTOData().getTooltips(meta);
        if (tooltip != null) aList.addAll(Arrays.asList(tooltip));
        aList.add(this.mNoMobsToolTip);
        aList.add(this.mNoTileEntityToolTip);
    }
}
