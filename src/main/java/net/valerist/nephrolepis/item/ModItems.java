package net.valerist.nephrolepis.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Nephrolepis.MODID);

    public static final RegistryObject<Item> FERN_LEAF = ITEMS.register("fern_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETTLE_LEAF = ITEMS.register("nettle_leaf",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
