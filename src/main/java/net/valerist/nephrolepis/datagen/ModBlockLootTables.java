package net.valerist.nephrolepis.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.block.ModBlocks;
import net.valerist.nephrolepis.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PLANT_MATTER_BLOCK.get());
        this.dropSelf(ModBlocks.SEED_BENCH.get());
        this.dropOther(ModBlocks.TINY_GRASS.get(),ModItems.GRASS_BLADE.get());
        this.dropOther(ModBlocks.TINY_GRASS_EDGE.get(), ModItems.GRASS_BLADE.get());
        this.dropSelf(ModBlocks.CRAWLING_PETALS.get());
        this.dropOther(ModBlocks.FERN.get(), ModItems.FERN_LEAF.get());
        this.add(ModBlocks.POTTED_FERN.get(), createPotFlowerItemTable(ModBlocks.FERN.get()));
        this.add(ModBlocks.POTTED_CRAWLING_PETALS.get(), createPotFlowerItemTable(ModBlocks.CRAWLING_PETALS.get()));
        this.dropSelf(ModBlocks.GIANT_PUFFBALL.get());
        this.dropOther(ModBlocks.STINGING_NETTLE.get(), ModItems.NETTLE_LEAF.get());

        this.dropSelf(ModBlocks.SNOWDRIFT_LOG.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SNOWDRIFT_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SNOWDRIFT_WOOD.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_PLANKS.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_STAIRS.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_FENCE.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_DOOR.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SNOWDRIFT_BUTTON.get());

        this.add(ModBlocks.SNOWDRIFT_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.SNOWDRIFT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}