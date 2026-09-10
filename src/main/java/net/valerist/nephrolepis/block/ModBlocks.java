package net.valerist.nephrolepis.block;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.block.custom.*;
import net.valerist.nephrolepis.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Nephrolepis.MODID);

    public static final RegistryObject<Block> SEED_BENCH = registerBlock("seed_bench",
            () -> new RotationalBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> PLANT_MATTER_BLOCK = registerFuelBlock("plant_matter_block",
            () -> new RotationalBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK)));
    public static final RegistryObject<Block> FERN = registerBlock("fern",
           () -> new FernBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_FERN = BLOCKS.register("potted_fern",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.FERN,
            BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> TINY_GRASS = registerBlock("tiny_grass",
            () -> new TinyPlantBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> TINY_GRASS_EDGE = registerBlock("tiny_grass_edge",
            () -> new TinyPlantBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> CRAWLING_PETALS = registerBlock("crawling_petals",
            () -> new CrawlingPetalsBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));
    public static final RegistryObject<Block> GIANT_PUFFBALL = registerBlock("giant_puffball",
            () -> new PuffballBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).noOcclusion()));
    public static final RegistryObject<Block> STINGING_NETTLE = registerBlock("stinging_nettle",
            () -> new NettleBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));

    public static final RegistryObject<Block> NEST_SMALL = registerBlock("nest_small",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> NEST_SIDE = registerBlock("nest_side",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));

    public static final RegistryObject<Block> NEST_CORNER = registerBlock("nest_corner",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> NEST_MIDDLE = registerBlock("nest_middle",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));

    public static final RegistryObject<Block> NEST_SMALL_MOSS = registerBlock("nest_small_moss",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> NEST_SIDE_MOSS = registerBlock("nest_side_moss",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));

    public static final RegistryObject<Block> NEST_CORNER_MOSS = registerBlock("nest_corner_moss",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> NEST_MIDDLE_MOSS = registerBlock("nest_middle_moss",
            () -> new NestBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noOcclusion().instabreak().mapColor(MapColor.PLANT)));

    public static final RegistryObject<Block> SNOWDRIFT_LOG = registerBlock("snowdrift_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> SNOWDRIFT_WOOD = registerBlock("snowdrift_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> SNOWDRIFT_PLANKS = registerBlock("snowdrift_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }
    public static <T extends Block> RegistryObject<T> registerFuelBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new ModFuelBlocks(toReturn.get(), new Item.Properties(), 400));
        return toReturn;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
