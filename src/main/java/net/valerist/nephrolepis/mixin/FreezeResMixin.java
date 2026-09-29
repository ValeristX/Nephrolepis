package net.valerist.nephrolepis.mixin;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.valerist.nephrolepis.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class FreezeResMixin {
    @Shadow public abstract boolean hasEffect(MobEffect pEffect);

    @Inject(method = "canFreeze", at = @At("HEAD"), cancellable = true)
    private void onCanFreeze(CallbackInfoReturnable<Boolean> cir) {
        if(this.hasEffect(ModEffects.FREEZE_RESISTANCE_EFFECT.get())){
            cir.setReturnValue(false);
        }
    }
}
