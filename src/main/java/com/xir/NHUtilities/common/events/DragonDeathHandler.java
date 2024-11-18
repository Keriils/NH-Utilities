package com.xir.NHUtilities.common.events;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import org.jetbrains.annotations.NotNull;

import com.brandon3055.draconicevolution.common.entity.EntityChaosGuardian;
import com.brandon3055.draconicevolution.common.entity.EntityCustomDragon;
import com.kuba6000.mobsinfo.api.IMobExtraInfoProvider;
import com.kuba6000.mobsinfo.api.MobDrop;
import com.kuba6000.mobsinfo.api.MobRecipe;
import com.xir.NHUtilities.common.api.enums.NHUItemList;
import com.xir.NHUtilities.utils.MathUtil;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
@Optional.Interface(iface = "com.kuba6000.mobsinfo.api.IMobExtraInfoProvider", modid = "mobsinfo")
public class DragonDeathHandler implements IMobExtraInfoProvider {

    @SubscribeEvent
    public void onDragonDeathDrop(LivingDropsEvent event) {
        if (event == null || event.entityLiving == null) return;
        EntityLivingBase entityLiving = event.entityLiving;
        if (entityLiving instanceof EntityChaosGuardian) {
            if (MathUtil.randInt(0, 10) < 3) return; // 60%
            entityLiving.entityDropItem(NHUItemList.ChaosDragonEgg.get(1), MathUtil.randFloat());
        } else if (entityLiving instanceof EntityCustomDragon) {
            if (MathUtil.randInt(0, 10) < 5) return; // 40%
            entityLiving.entityDropItem(NHUItemList.AncientDragonEgg.get(1), MathUtil.randFloat());
        }
    }

    @Override
    @Optional.Method(modid = "mobsinfo")
    public void provideExtraDropsInformation(@NotNull String entityString, @NotNull ArrayList<MobDrop> drops,
        @NotNull MobRecipe recipe) {
        if (recipe.entity instanceof EntityChaosGuardian) {
            MobDrop drop = MobDrop.create(NHUItemList.ChaosDragonEgg.get(1))
                .withType(MobDrop.DropType.Normal)
                .withChance(0.6d);
            drop.clampChance();
            drops.add(drop);
        } else if (recipe.entity instanceof EntityCustomDragon) {
            MobDrop drop = MobDrop.create(NHUItemList.AncientDragonEgg.get(1))
                .withType(MobDrop.DropType.Normal)
                .withChance(0.4d);
            drop.clampChance();
            drops.add(drop);
        }
    }
}
