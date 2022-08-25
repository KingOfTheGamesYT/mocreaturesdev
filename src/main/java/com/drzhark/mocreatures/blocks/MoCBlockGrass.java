package com.drzhark.mocreatures.blocks;

import com.drzhark.mocreatures.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MoCBlockGrass extends Block {

    public MoCBlockGrass() {
        super (Properties.create(Material.EARTH)
                .tickRandomly()
                .hardnessAndResistance(0.5F)
                .hardnessAndResistance(0.6F)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
                .sound(SoundType.PLANT));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }
}
