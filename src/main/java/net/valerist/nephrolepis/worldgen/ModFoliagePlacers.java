package net.valerist.nephrolepis.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.worldgen.tree.SnowdriftFoliagePlacer;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Nephrolepis.MODID);

    public static final RegistryObject<FoliagePlacerType<SnowdriftFoliagePlacer>> SNOWDRIFT_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("snowdrift_foliage_placer", () -> new FoliagePlacerType<>(SnowdriftFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}