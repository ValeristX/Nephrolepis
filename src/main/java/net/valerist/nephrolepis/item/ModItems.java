package net.valerist.nephrolepis.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.item.custom.GrassBladeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Nephrolepis.MODID);

    public static final RegistryObject<Item> FERN_LEAF = ITEMS.register("fern_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETTLE_LEAF = ITEMS.register("nettle_leaf",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_BLADE = ITEMS.register("grass_blade",
            () -> new GrassBladeItem(new Item.Properties()));

    public static final RegistryObject<Item> CHANTERELLE_FLESH = ITEMS.register("chanterelle_flesh",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GHILLIE_SUIT_HELMET = ITEMS.register("ghillie_suit_helmet",
            () -> new ArmorItem(ModArmor.GHILLIE_SUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GHILLIE_SUIT_CHESTPLATE = ITEMS.register("ghillie_suit_chestplate",
            () -> new ArmorItem(ModArmor.GHILLIE_SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
