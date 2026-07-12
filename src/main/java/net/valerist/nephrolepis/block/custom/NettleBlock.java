package net.valerist.nephrolepis.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.valerist.nephrolepis.tag.ModTags;

public class NettleBlock extends LargePlantBlock{

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
}
