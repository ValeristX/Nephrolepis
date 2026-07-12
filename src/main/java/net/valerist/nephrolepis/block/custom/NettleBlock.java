package net.valerist.nephrolepis.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.valerist.nephrolepis.item.ModItems;
import net.valerist.nephrolepis.tag.ModTags;

public class NettleBlock extends LargePlantBlock implements BonemealableBlock {

    public NettleBlock(Properties pProperties) {
        super(pProperties);
    }
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        boolean boots_on = false;
        boolean leggings_on = false;
        boolean damage = true;
        Iterable<ItemStack> armorlist = pEntity.getArmorSlots();
        for (ItemStack armor : armorlist) {
            if (armor.is(ModTags.Items.BYPASSES_NETTLE_DAMAGE_BOOTS)){
                boots_on = true;
            }
            if (armor.is(ModTags.Items.BYPASSES_NETTLE_DAMAGE_LEGGINGS)){
                leggings_on = true;
            }
        }
        if(boots_on && leggings_on){
            damage = false;
        }
        if(damage){
            pEntity.hurt(pLevel.damageSources().cactus(), 0.5F);
        }
    }

    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean value) {
        return levelReader.getBlockState(blockPos.above()).isAir();
    }
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        level.addFreshEntity(new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.NETTLE_LEAF.get())));
    }
}
