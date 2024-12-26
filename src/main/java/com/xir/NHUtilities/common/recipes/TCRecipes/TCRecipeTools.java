package com.xir.NHUtilities.common.recipes.TCRecipes;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;

import com.xir.NHUtilities.utils.CommonUtil;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;

public class TCRecipeTools {

    public static HashMap<String, ArrayList<CrucibleCraftingRecipe>> IAR = new HashMap<>();

    public static void getCrucibleCraftingRecipe() {
        for (var o : ThaumcraftApi.getCraftingRecipes()) {
            if (!(o instanceof CrucibleRecipe o1)) continue;
            if (CommonUtil.isStackValid(o1.getRecipeOutput())) {
                Object input;
                Object cat = o1.catalyst;
                if (cat instanceof ArrayList<?>catalyst1) {
                    var warped = new ItemStack[catalyst1.size()];
                    for (int i = 0; i < warped.length; i++) {
                        warped[i] = CommonUtil.copyAmount(1, (ItemStack) catalyst1.get(i));
                    }
                    input = warped;
                } else if (cat instanceof ItemStack itemStack) {
                    input = CommonUtil.copyAmount(1,itemStack);
                } else continue;
                String inputKey = cat.toString();
                CrucibleCraftingRecipe p = new CrucibleCraftingRecipe(
                    input,
                    CommonUtil.copy(o1.getRecipeOutput()),
                    o1.aspects,
                    o1.key);
                if (IAR.get(inputKey) == null) {
                    var arrayList = new ArrayList<CrucibleCraftingRecipe>();
                    arrayList.add(p);
                    IAR.put(inputKey, arrayList);
                } else {
                    var old = IAR.get(inputKey);
                    old.add(p);
                    IAR.replace(inputKey, old);
                }
            }
        }
    }

    @SuppressWarnings("unused")
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
