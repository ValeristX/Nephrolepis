package net.valerist.nephrolepis.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.valerist.nephrolepis.block.ModBlocks;
import net.valerist.nephrolepis.tag.ModTags;


public class PuffballBlock extends RotationalBlock implements BonemealableBlock{
    public PuffballBlock(Properties pProperties) {
        super(pProperties);
    }
    // placement rule

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState stateBelow = level.getBlockState(below);
        boolean dirt = stateBelow.is(ModTags.Blocks.SUBSTRATE);

        return dirt;
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(2,0,2,14,8,14);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);
        pLevel.destroyBlock(pPos, false, pEntity, 0);
        pLevel.playSound(pEntity, pPos, SoundEvents.SHROOMLIGHT_STEP, SoundSource.BLOCKS, 1, 1);
        ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, true, false, true));
        for (double i = 0; i <= 5; i++) {
            pLevel.addParticle(ParticleTypes.CLOUD, pPos.getX()+i/10, pPos.getY(), pPos.getZ()+i/10, 0.0, 0.9, 0.0);
        }
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean value) {
        return levelReader.getBlockState(blockPos.above()).isAir();
    }
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModBlocks.GIANT_PUFFBALL.get())));
    }
}
