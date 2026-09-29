package net.valerist.nephrolepis.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Nephrolepis.MODID);


    public static final RegistryObject<MobEffect> FREEZE_RESISTANCE_EFFECT = registerEffect("freeze_resistance",
            () -> new FreezeResistanceEffect(MobEffectCategory.BENEFICIAL, 0x6cebe6));
    public static <T extends MobEffect> RegistryObject<T> registerEffect(String name, Supplier<T> effect) {
        return MOB_EFFECTS.register(name, effect);
    }
    public static void register(IEventBus eventBus){MOB_EFFECTS.register(eventBus);}
}
