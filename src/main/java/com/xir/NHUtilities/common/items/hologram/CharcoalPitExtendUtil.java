package com.xir.NHUtilities.common.items.hologram;

import static net.minecraft.init.Items.feather;
import static net.minecraftforge.oredict.OreDictionary.getOreName;

import java.util.ArrayList;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;

import com.gtnewhorizon.structurelib.structure.IItemSource;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.util.GTUtility;

public final class CharcoalPitExtendUtil {

    private CharcoalPitExtendUtil() {}

    private static final Predicate<ItemStack> PREDICATE_LOGWOOD = stack -> {
        for (var id : OreDictionary.getOreIDs(stack)) {
            if (getOreName(id).equals("logWood")) return true;
        }
        if (stack.getItem() instanceof ItemBlock item) {
            var log = Block.getBlockFromItem(item);
            var meta = feather.getDamage(stack);
            String tTool = log.getHarvestTool(meta);
            return OrePrefixes.log.contains(stack) && ("axe".equals(tTool)) && (log.getMaterial() == Material.wood);
        }
        return false;
    };

    public static void handle(EntityPlayerMP playerMP, World world, BaseMetaTileEntity baseMetaTileEntity) {
        var ori = baseMetaTileEntity.getBlockOffset(0, -1, 0);
        if (ori == Blocks.air) {
            ArrayList<ChunkPosition> toPlace = new ArrayList<>();
            ArrayList<ChunkPosition> itrRecursive = new ArrayList<>();
            itrRecursive.add(newPos(0, -1, 0));
            while (!itrRecursive.isEmpty()) {
                var pos = itrRecursive.remove(0);
                toPlace.add(pos);
                if (
                    !checkAllSide(
                        baseMetaTileEntity,
                        pos.chunkPosX,
                        pos.chunkPosY,
                        pos.chunkPosZ,
                        toPlace,
                        itrRecursive)
                ) {
                    GTUtility.sendChatToPlayer(
                        playerMP,
                        "Make sure your Charcoal Pit structure is sealed and contains only air inside...");
                    return;
                }
            }

            IItemSource source = IItemSource.fromPlayer(playerMP);
            if (!source.takeAll(PREDICATE_LOGWOOD, true, toPlace.size())) {
                GTUtility.sendChatToPlayer(playerMP, "Make sure you have enough inventory...");
                return;
            }

            ItemStack logWood;
            for (var position : toPlace) {
                logWood = source.takeOne(PREDICATE_LOGWOOD, false);
                if (logWood == null) {
                    for (int i = 0; i < 3; i++) {
                        GTUtility.sendChatToPlayer(
                            playerMP,
                            "An unexpected exception occurs, please save your save immediately and report this bug....");
                    }
                    return;
                }
                logWood.copy()
                    .tryPlaceItemIntoWorld(
                        playerMP,
                        world,
                        baseMetaTileEntity.xCoord + position.chunkPosX,
                        baseMetaTileEntity.yCoord + position.chunkPosY,
                        baseMetaTileEntity.zCoord + position.chunkPosZ,
                        ForgeDirection.UP.ordinal(),
                        0.5f,
                        0.5f,
                        0.5f);
            }
        }
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean checkAllSide(BaseMetaTileEntity baseMetaTile, int x, int y, int z,
        ArrayList<? super ChunkPosition> toPlace, ArrayList<? super ChunkPosition> itrRecursive) {

        ChunkPosition c;

        var blockXPos = baseMetaTile.getBlockOffset(x + 1, y, z);
        if (x + 1 < 6 && blockXPos == Blocks.air) {
            c = newPos(x + 1, y, z);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (!(blockXPos == Blocks.dirt || blockXPos == Blocks.grass)) {
            return false;
        }

        var blockXNeg = baseMetaTile.getBlockOffset(x - 1, y, z);
        if (x - 1 > -6 && blockXNeg == Blocks.air) {
            c = newPos(x - 1, y, z);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (!(blockXNeg == Blocks.dirt || blockXNeg == Blocks.grass)) {
            return false;
        }

        var blockYPos = baseMetaTile.getBlockOffset(x, y + 1, z);
        if (y + 1 < 1 && blockYPos == Blocks.air) {
            c = newPos(x, y + 1, z);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (
            !(blockYPos == Blocks.dirt || blockYPos == Blocks.grass
                || (x == 0 && y == -1 && z == 0 && blockYPos == GregTechAPI.sBlockMachines))
        ) {
            return false;
        }

        var blockYNeg = baseMetaTile.getBlockOffset(x, y - 1, z);
        if (y - 1 > -6 && blockYNeg == Blocks.air) {
            c = newPos(x, y - 1, z);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (blockYNeg != Blocks.brick_block) {
            return false;
        }

        var blockZPos = baseMetaTile.getBlockOffset(x, y, z + 1);
        if (z + 1 < 6 && blockZPos == Blocks.air) {
            c = newPos(x, y, z + 1);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (!(blockZPos == Blocks.dirt || blockZPos == Blocks.grass)) {
            return false;
        }

        var blockZNeg = baseMetaTile.getBlockOffset(x, y, z - 1);
        if (z - 1 > -6 && blockZNeg == Blocks.air) {
            c = newPos(x, y, z - 1);
            if (!toPlace.contains(c) && !itrRecursive.contains(c)) itrRecursive.add(c);
        } else if (!(blockZNeg == Blocks.dirt || blockZNeg == Blocks.grass)) {
            return false;
        }
        return true;
    }

    private static ChunkPosition newPos(int x, int y, int z) {
        return new ChunkPosition(x, y, z);
    }

}
