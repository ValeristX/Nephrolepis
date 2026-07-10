package net.valerist.nephrolepis.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.block.custom.LargePlantBlock;
import net.valerist.nephrolepis.block.custom.RotationalBlock;
import net.valerist.nephrolepis.block.custom.TinyPlantBlock;
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
           () -> new LargePlantBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));

    public static final RegistryObject<Block> TINY_GRASS = registerBlock("tiny_grass",
            () -> new TinyPlantBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));
    public static final RegistryObject<Block> CRAWLING_PETALS = registerBlock("crawling_petals",
            () -> new TinyPlantBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).noCollission().noOcclusion()));




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
