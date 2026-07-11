package net.valerist.nephrolepis.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        this.dropSelf(ModBlocks.TINY_GRASS.get());
        this.dropSelf(ModBlocks.CRAWLING_PETALS.get());
        this.dropOther(ModBlocks.FERN.get(), ModItems.FERN_LEAF.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}