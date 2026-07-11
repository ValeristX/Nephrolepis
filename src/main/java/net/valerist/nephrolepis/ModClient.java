package net.valerist.nephrolepis;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.valerist.nephrolepis.block.ModBlocks;

@Mod.EventBusSubscriber(modid = Nephrolepis.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClient {
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex == 0 && level != null && pos != null) {
                return BiomeColors.getAverageGrassColor(level, pos);
            }
            return 0xFFFFFF;
            },
                ModBlocks.TINY_GRASS.get(),
                ModBlocks.TINY_GRASS_EDGE.get());
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register(
                (stack, tintIndex) -> 0x3a7d35, // Replace with a static hex color or custom logic if preferred
                ModBlocks.TINY_GRASS.get(),
                ModBlocks.TINY_GRASS_EDGE.get()
        );
    }
}
