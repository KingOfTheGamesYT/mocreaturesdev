package com.drzhark.mocreatures.blocks;





import java.util.Collections;
import java.util.List;
import java.util.Random;


import com.drzhark.mocreatures.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.IShearable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class MoCBlockTallGrass extends BushBlock implements IShearable {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);

    public MoCBlockTallGrass() {
        super(Properties.create(Material.TALL_PLANTS)
                .sound(SoundType.PLANT)
                .setLightLevel((f) -> {return 11;})
                .notSolid()
                .doesNotBlockMovement()
                .zeroHardnessAndResistance()
                .harvestLevel(0));

    }


    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(RegistryHandler.WYVERN_GRASS.get()) || state.isIn(RegistryHandler.WYVERN_DIRT.get()) || state.isIn(RegistryHandler.OGRE_GRASS.get()) || state.isIn(RegistryHandler.OGRE_DIRT.get());
    }


    public AxisAlignedBB getBoundingBox(BlockState state, IBlockReader source, BlockPos pos) {
        return AABB;
    }


    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }


    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }


    public void grow(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {

    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XYZ;
    }


//extends MoCBlockBush

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return null;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
     * (inclusive).
     */

    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return 1 + par2Random.nextInt(par1 * 2 + 1);
    }

@Override
    public boolean isShearable() {
        return true;
    }


    public List<ItemStack> onSheared(ItemStack item, IBlockReader world, BlockPos pos, int fortune) {
        return new java.util.ArrayList<ItemStack>(java.util.Arrays.asList(new ItemStack(RegistryHandler.WYVERN_TALLGRASS.get())));
    }

    @Override
    public void shear(SoundCategory category) {

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }
}
