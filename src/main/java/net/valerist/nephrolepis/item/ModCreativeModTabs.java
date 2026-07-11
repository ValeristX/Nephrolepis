package net.valerist.nephrolepis.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.valerist.nephrolepis.Nephrolepis;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.valerist.nephrolepis.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Nephrolepis.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FERN_LEAF.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SEED_BENCH.get());
                        pOutput.accept(ModBlocks.PLANT_MATTER_BLOCK.get());
                        pOutput.accept(ModBlocks.FERN.get());
                        pOutput.accept(ModBlocks.CRAWLING_PETALS.get());
                        pOutput.accept(ModBlocks.TINY_GRASS.get());

                        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }
                        //pOutput.accept(Items.DIAMOND);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}