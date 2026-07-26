package net.valerist.nephrolepis.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.valerist.nephrolepis.Config;
import net.valerist.nephrolepis.item.ModItems;

public class GrassBladeItem extends Item {

    public GrassBladeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        ItemStack item = pContext.getItemInHand();
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockPos);
        Block block = blockstate.getBlock();
        Player player = pContext.getPlayer();

        if(item.is(ModItems.GRASS_BLADE.get()) && blockstate.is(Blocks.DIRT) && (Config.grass_blade_restores_dirt == true)){
            level.setBlockAndUpdate(blockPos, Blocks.GRASS_BLOCK.defaultBlockState());
            item.shrink(1);
            if (player != null){
                level.playSound(player, blockPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1, 1);
                player.swing(pContext.getHand());
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
