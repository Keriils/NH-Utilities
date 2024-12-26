package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;

public class TCRecipeTools {

    public static HashMap<String, ArrayList<CrucibleCraftingRecipe>> IAR = new HashMap<>();

    public static void getCrucibleCraftingRecipe() {
        for (Object o : ThaumcraftApi.getCraftingRecipes()) {
            if (!(o instanceof CrucibleRecipe)) {
                continue;
            }
            if (((CrucibleRecipe) o).getRecipeOutput() instanceof ItemStack
                && ((CrucibleRecipe) o).getRecipeOutput() != null) {
                Object input = ((CrucibleRecipe) o).catalyst;
                String inputItem = input.toString();
                CrucibleCraftingRecipe p = new CrucibleCraftingRecipe(
                    input,
                    ((CrucibleRecipe) o).getRecipeOutput(),
                    ((CrucibleRecipe) o).aspects,
                    ((CrucibleRecipe) o).key);
                if (IAR.get(inputItem) == null) {
                    ArrayList<CrucibleCraftingRecipe> arrayList = new ArrayList<>();
                    arrayList.add(p);
                    IAR.put(inputItem, arrayList);
                } else {
                    ArrayList<CrucibleCraftingRecipe> old = IAR.get(inputItem);
                    old.add(p);
                    IAR.replace(inputItem, old);
                }
            }
        }
    }

    public static class CrucibleCraftingRecipe {

        private final Object InputItem;
        private final ItemStack OutputItem;
        private final AspectList InputAspects;
        private final String Research;

        public CrucibleCraftingRecipe(Object inputItem, ItemStack outputItem, AspectList inputAspects,
            String research) {
            InputItem = inputItem;
            OutputItem = outputItem;
            InputAspects = inputAspects;
            Research = research;
        }

        public Object getInputItem() {
            return InputItem;
        }

        public ItemStack getOutputItem() {
            return OutputItem;
        }

        public AspectList getInputAspects() {
            return InputAspects;
        }

        public String getResearch() {
            return Research;
        }

        public int getAspectAmount(Aspect aspect) {
            return this.InputAspects.getAmount(aspect);
        }

        public int getAspectAmount() {
            int i = 0;
            for (Aspect aspect : this.InputAspects.getAspects()) {
                i += this.InputAspects.getAmount(aspect);
            }
            return i;
        }
    }
}
