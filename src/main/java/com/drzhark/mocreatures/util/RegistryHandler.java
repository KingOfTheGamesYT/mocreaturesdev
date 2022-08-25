package com.drzhark.mocreatures.util;



import com.drzhark.mocreatures.MoCreatures;
import com.drzhark.mocreatures.blocks.BlockItemBase;
import com.drzhark.mocreatures.blocks.MoCBlockDirt;
import com.drzhark.mocreatures.blocks.MoCBlockGrass;
import com.drzhark.mocreatures.blocks.MoCBlockTallGrass;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoCreatures.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoCreatures.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    //Blocks
    public static final RegistryObject<Block> WYVERN_TALLGRASS = BLOCKS.register("wyvern_tallgrass", MoCBlockTallGrass::new);
    public static final RegistryObject<Block> WYVERN_GRASS = BLOCKS.register("wyvern_grass", MoCBlockGrass::new);
    public static final RegistryObject<Block> WYVERN_DIRT = BLOCKS.register("wyvern_dirt", MoCBlockDirt::new);



    //Block Items
    public static final RegistryObject<Item> WYVERN_TALLGRASS_ITEM = ITEMS.register("wyvern_tallgrass", () -> new BlockItemBase(WYVERN_TALLGRASS.get()));
    public static final RegistryObject<Item> WYVERN_GRASS_ITEM = ITEMS.register("wyvern_grass", () -> new BlockItemBase(WYVERN_GRASS.get()));
    public static final RegistryObject<Item> WYVERN_DIRT_ITEM = ITEMS.register("wyvern_dirt", () -> new BlockItemBase(WYVERN_DIRT.get()));



}