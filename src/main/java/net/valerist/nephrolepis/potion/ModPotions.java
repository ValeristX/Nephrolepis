package net.valerist.nephrolepis.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.effect.FreezeResistanceEffect;
import net.valerist.nephrolepis.effect.ModEffects;

import java.util.function.Supplier;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, Nephrolepis.MODID);

    public static final RegistryObject<Potion> FREEZE_RESISTANCE_POTION = registerPotion("freeze_resistance",
            () -> new Potion(new MobEffectInstance(ModEffects.FREEZE_RESISTANCE_EFFECT.get(), 3600, 0)));
    public static final RegistryObject<Potion> FREEZE_RESISTANCE_POTION2 = registerPotion("long_freeze_resistance",
            () -> new Potion(new MobEffectInstance(ModEffects.FREEZE_RESISTANCE_EFFECT.get(), 9600, 0)));

    public static <T extends Potion> RegistryObject<T> registerPotion(String name, Supplier<T> potion) {
        return POTIONS.register(name, potion);
    }

    public static void register(IEventBus eventBus){POTIONS.register(eventBus);}
}
