package net.valerist.nephrolepis;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.valerist.nephrolepis.block.ModBlocks;
import net.valerist.nephrolepis.effect.ModEffects;
import net.valerist.nephrolepis.item.ModCreativeModTabs;
import net.valerist.nephrolepis.item.ModItems;
import net.valerist.nephrolepis.potion.BetterBrewingRecipe;
import net.valerist.nephrolepis.potion.ModPotions;
import org.slf4j.Logger;

@Mod(Nephrolepis.MODID)
public class Nephrolepis
{
    public static final String MODID = "nephrolepis";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Nephrolepis(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        ModEffects.register(modEventBus); // effects
        ModCreativeModTabs.register(modEventBus); // our creative mode tab
        ModItems.register(modEventBus); // items
        ModBlocks.register(modEventBus); // blocks
        ModPotions.register(modEventBus); // potions
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FERN.getId(), ModBlocks.POTTED_FERN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CRAWLING_PETALS.getId(), ModBlocks.POTTED_CRAWLING_PETALS);
        });
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, ModBlocks.SNOWDROP.get().asItem(), ModPotions.FREEZE_RESISTANCE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.FREEZE_RESISTANCE_POTION.get(), Items.REDSTONE, ModPotions.FREEZE_RESISTANCE_POTION2.get()));
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
