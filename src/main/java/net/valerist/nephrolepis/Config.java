package net.valerist.nephrolepis;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Nephrolepis.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue GRASSBLADE = BUILDER
            .comment("Should the blade of grass be able to restore dirt to grass block?")
            .define("grass_blade_restores_dirt", true);


    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean grass_blade_restores_dirt;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        grass_blade_restores_dirt = GRASSBLADE.get();
    }
}
