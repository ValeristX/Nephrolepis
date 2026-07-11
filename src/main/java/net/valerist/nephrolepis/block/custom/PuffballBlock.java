package net.valerist.nephrolepis.block.custom;

import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.eventbus.api.Event;


public class PuffballBlock extends RotationalBlock {
    public PuffballBlock(Properties pProperties) {
        super(pProperties);
    }
    // placement rule

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState stateBelow = level.getBlockState(below);

        return stateBelow.isSolidRender(level, below);
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
}
