package com.xir.NHUtilities.common.recipes.MassRecipes;

import static gregtech.api.enums.TierEU.RECIPE_EV;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static thaumcraft.common.config.ConfigItems.itemEssence;

import java.util.ArrayList;
import java.util.Map;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.common.recipeMap.recipeResult.NHURecipe;
import com.xir.NHUtilities.common.recipes.TCRecipes.TCRecipeTools;

import gregtech.api.enums.GTValues;
import gregtech.api.interfaces.IRecipeMap;
import gregtech.api.util.GTUtility;
import thaumcraft.common.items.ItemEssence;

public class IndustrialAlchemicalRecipePool {

    public void loadRecipes() {
        TCRecipeTools.getCrucibleCraftingRecipe();
        final IRecipeMap IIA = NHURecipe.IndustrialAlchemicalRecipe;
        for (Map.Entry<String, ArrayList<TCRecipeTools.CrucibleCraftingRecipe>> entry : TCRecipeTools.IAR.entrySet()) {
            ArrayList<TCRecipeTools.CrucibleCraftingRecipe> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                TCRecipeTools.CrucibleCraftingRecipe recipe = value.get(i);
                ItemStack Essence = new ItemStack(itemEssence);
                Essence.setItemDamage(1);
                Essence.setStackDisplayName("nhu.test");
                new ItemEssence().setAspects(Essence, recipe.getInputAspects());
                Object inputItem = recipe.getInputItem();
                Object[] combined = new Object[] { inputItem, GTUtility.getIntegratedCircuit(i + 1) };
                GTValues.RA.stdBuilder()
                    .ignoreCollision()
                    .clearInvalid()
                    .special(Essence)
                    .itemInputs(combined)
                    .itemOutputs(recipe.getOutputItem())
                    .noOptimize()
                    .duration(25 * SECONDS)
                    .eut(RECIPE_EV)
                    .addTo(IIA);

            }
        }
    }
}
