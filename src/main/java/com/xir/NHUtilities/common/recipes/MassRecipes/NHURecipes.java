package com.xir.NHUtilities.common.recipes.MassRecipes;

import static com.brandon3055.draconicevolution.common.ModBlocks.draconiumBlock;
import static com.brandon3055.draconicevolution.common.ModBlocks.infusedObsidian;
import static com.github.technus.tectech.thing.CustomItemList.hatch_CreativeMaintenance;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaForgeRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeConstants.COIL_HEAT;
import static gregtech.api.util.GT_RecipeConstants.UniversalChemical;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import com.xir.NHUtilities.common.api.enums.NHUItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import goodgenerator.items.MyMaterial;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import singulariteam.eternalsingularity.item.EternalSingularityItem;
import thaumic.tinkerer.common.ThaumicTinkerer;
import thaumic.tinkerer.common.item.kami.ItemKamiResource;

public class NHURecipes {

    public static void initNHURecipeCrossMod() {

        initFuelRodRecipe();
        initEggMachineRecipe();
        initEternityTimeVialRecipe();
        WirelessHatchMoreRecipe.initWirelessHatchMore();

        // for adding debug maintenance recipe
        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Hull_EV.get(1), ItemList.Duct_Tape.get(1), GT_Utility.getIntegratedCircuit(16))
            .itemOutputs(hatch_CreativeMaintenance.get(1))
            .duration(25 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);
    }

    private static void initFuelRodRecipe() {

        // ichor fuel rod
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ichorium, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Ichorium, 2),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1))
            .duration(50 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium2.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium.get(4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Ichorium, 6),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodPrimordialPearlPlutonium2.get(2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Ichorium, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodPrimordialPearlPlutonium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // radiance fuel rod
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 2),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.ShadowFuelRod.get(1))
            .duration(50 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(NHUItemList.RodRadianceUranium2.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium.get(4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Shadow, 6),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.RodRadianceUranium2.get(2),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(NHUItemList.RodRadianceUranium4.get(1))
            .duration(10 * SECONDS)
            .noOptimize()
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        // centrifuge
        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(1), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(1000))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted2.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(2), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 1500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(2000))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodPrimordialPearlPlutoniumDepleted4.get(1))
            .itemOutputs(NHUItemList.IchorFuelRod.get(4), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .outputChances(10000, 3500)
            .fluidOutputs(MyMaterial.plutoniumBasedLiquidFuelDepleted.getFluidOrGas(4000))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(1),
                Materials.Uranium.getDust(16),
                Materials.Plutonium.getDust(4),
                Materials.Graphite.getDust(16),
                Materials.Uranium235.getDust(2),
                Materials.Plutonium241.getDust(2))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(64))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted2.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(2),
                Materials.Uranium.getDust(32),
                Materials.Plutonium.getDust(8),
                Materials.Graphite.getDust(32),
                Materials.Uranium235.getDust(4),
                Materials.Plutonium241.getDust(4))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(128))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.RodRadianceUraniumDepleted4.get(1))
            .itemOutputs(
                NHUItemList.ShadowFuelRod.get(4),
                Materials.Uranium.getDust(64),
                Materials.Plutonium.getDust(16),
                Materials.Graphite.getDust(64),
                Materials.Uranium235.getDust(8),
                Materials.Plutonium241.getDust(8))
            .outputChances(10000, 10000, 10000, 9000, 5000, 3000)
            .fluidOutputs(WerkstoffLoader.Neon.getFluidOrGas(256))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(centrifugeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3))
            .itemOutputs(NHUItemList.PrimordialPearlDust.get(4))
            .duration(100 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(maceratorRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(ThaumicTinkerer.registry.getFirstItemFromClass(ItemKamiResource.class), 1, 0))
            .itemOutputs(NHUItemList.IchorDroplet.get(3))
            .duration(100 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(extractorRecipes);
    }

    private static void initEggMachineRecipe() {

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.ChaosDragonEgg.get(1))
            .fluidInputs(Materials.Radon.getGas(16384))
            .itemOutputs(NHUItemList.ChaosDraconiumEgg.get(2))
            .duration(127 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .metadata(COIL_HEAT, 6400)
            .addTo(blastFurnaceRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.ChaosDraconiumEgg.get(1))
            .fluidInputs(Materials.Draconium.getMolten(1008L))
            .itemOutputs(NHUItemList.ChaosDragonEgg.get(1))
            .duration(3600 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(UniversalChemical);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.AncientDragonEgg.get(1))
            .fluidInputs(Materials.Radon.getPlasma(16384))
            .itemOutputs(NHUItemList.AncientDraconiumEgg.get(2))
            .duration(127 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .metadata(COIL_HEAT, 8001)
            .addTo(blastFurnaceRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.AncientDraconiumEgg.get(1))
            .fluidInputs(Materials.DraconiumAwakened.getMolten(1008L))
            .itemOutputs(NHUItemList.AncientDragonEgg.get(1))
            .duration(3600 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(UniversalChemical);

        NHUItemList[] eggMachineList = new NHUItemList[] { NHUItemList.Egg_Machine_EV, NHUItemList.Egg_Machine_IV,
            NHUItemList.Egg_Machine_LuV, NHUItemList.Egg_Machine_ZPM, NHUItemList.Egg_Machine_UV,
            NHUItemList.Egg_Machine_UHV, NHUItemList.Egg_Machine_UEV, NHUItemList.Egg_Machine_UIV,
            NHUItemList.Egg_Machine_UMV, NHUItemList.Egg_Machine_UXV, NHUItemList.Egg_Machine_MAX };

        for (int i = 0; i < eggMachineList.length - 1; i++) {
            GT_Values.RA.stdBuilder()
                .itemInputs(eggMachineList[i].get(3), new ItemStack(Item.getItemFromBlock(Blocks.dragon_egg), 1))
                .itemOutputs(eggMachineList[i + 1].get(1))
                .fluidInputs(Materials.Radon.getGas(4000 << i))
                .duration((20 << i) * SECONDS)
                .eut(GT_Values.VP[i])
                .addTo(assemblerRecipes);
        }

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(Items.egg, 64),
                GregtechItemList.Transformer_HA_EV_HV.get(1),
                ItemList.Field_Generator_HV.get(3),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(32),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 16))
            .fluidInputs(Materials.Radon.getGas(16000))
            .itemOutputs(NHUItemList.Egg_Machine_EV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.MagicEnergyAbsorber_EV.get(1),
                GregtechItemList.Transformer_HA_EV_HV.get(1),
                ItemList.Field_Generator_HV.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(32),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 4))
            .fluidInputs(Materials.Radon.getGas(4000))
            .itemOutputs(NHUItemList.Egg_Machine_EV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_EV.get(1),
                GregtechItemList.Transformer_HA_IV_EV.get(1),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 64))
            .fluidInputs(Materials.HSSG.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_IV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_IV.get(1),
                GregtechItemList.Transformer_HA_LuV_IV.get(1),
                ItemList.Energy_LapotronicOrb.get(4),
                ItemList.Emitter_LuV.get(4))
            .fluidInputs(Materials.HSSS.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_LuV.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                NHUItemList.Egg_Machine_LuV.get(1),
                GregtechItemList.Transformer_HA_ZPM_LuV.get(1),
                ItemList.Energy_LapotronicOrb2.get(4),
                ItemList.Emitter_ZPM.get(4))
            .fluidInputs(Materials.Trinium.getMolten(1152))
            .itemOutputs(NHUItemList.Egg_Machine_ZPM.get(1))
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(assemblerRecipes);

        ExtremeCraftingManager.getInstance()
            .addRecipe(
                NHUItemList.Egg_Machine_UV.get(1),
                "         ",
                " AAAAAAA ",
                " ABBBBBA ",
                " ABCCCBA ",
                " ABCZCBA ",
                " ABCCCBA ",
                " ABBBBBA ",
                " AAAAAAA ",
                'A',
                new ItemStack(infusedObsidian, 1),
                'B',
                new ItemStack(draconiumBlock, 1, 2),
                'C',
                GregtechItemList.Transformer_HA_UV_ZPM.get(1),
                'Z',
                NHUItemList.Egg_Machine_ZPM.get(1));
    }

    private static void initEternityTimeVialRecipe() {
        GT_Values.RA.stdBuilder()
            .itemInputs(NHUItemList.TimeVial.get(0), new ItemStack(EternalSingularityItem.instance, 64))
            .fluidInputs(MaterialsKevlar.Kevlar.getMolten(1440L))
            .itemOutputs(NHUItemList.EternityVial.get(1))
            .outputChances(500)
            .metadata(COIL_HEAT, 13500)
            .duration(60 * SECONDS)
            .eut(TierEU.RECIPE_UMV)
            .addTo(plasmaForgeRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Timepiece.get(1))
            .fluidInputs(MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(1145))
            .itemOutputs(NHUItemList.EternityVial.get(1))
            .metadata(COIL_HEAT, 13500)
            .duration(3 * MINUTES)
            .eut(TierEU.RECIPE_UXV)
            .addTo(plasmaForgeRecipes);
    }
}
