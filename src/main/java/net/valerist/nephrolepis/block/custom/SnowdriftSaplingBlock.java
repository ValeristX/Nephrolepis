package net.valerist.nephrolepis.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.valerist.nephrolepis.tag.ModTags;

public class SnowdriftSaplingBlock extends SaplingBlock {
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState stateBelow = level.getBlockState(below);

        return stateBelow.is(ModTags.Blocks.SUBSTRATE_SNOW);
    }
    public SnowdriftSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties) {
        super(pTreeGrower, pProperties);
    }
}
