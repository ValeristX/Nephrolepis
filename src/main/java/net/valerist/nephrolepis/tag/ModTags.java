package net.valerist.nephrolepis.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.valerist.nephrolepis.Nephrolepis;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> SUBSTRATE = tag("substrate");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Nephrolepis.MODID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> CRAFTABLE_INTO_PLANT_MATTER = tag("craftable_into_plant_matter");
        public static final TagKey<Item> BYPASSES_NETTLE_DAMAGE_BOOTS = tag("bypasses_nettle_damage_boots");
        public static final TagKey<Item> BYPASSES_NETTLE_DAMAGE_LEGGINGS = tag("bypasses_nettle_damage_leggings");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Nephrolepis.MODID, name));
        }
    }
}
