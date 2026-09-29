package net.valerist.nephrolepis.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;

public class SnowdriftFoliagePlacer extends FoliagePlacer {
    public static final Codec<SnowdriftFoliagePlacer> CODEC = RecordCodecBuilder.create(snowdriftFoliagePlacerInstance
            -> foliagePlacerParts(snowdriftFoliagePlacerInstance).and(Codec.intRange(0,16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(snowdriftFoliagePlacerInstance, SnowdriftFoliagePlacer::new));

    private final int height;
    public SnowdriftFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return null;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliageAttachment foliageAttachment, int i1, int i2, int i3) {
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos().above(0), 2, 2, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos().above(1), 2, 2, foliageAttachment.doubleTrunk());
        this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos().above(2), 2, 2, foliageAttachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
