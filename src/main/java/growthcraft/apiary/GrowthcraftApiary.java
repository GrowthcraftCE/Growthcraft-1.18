package growthcraft.apiary;

import growthcraft.apiary.init.GrowthcraftApiaryBlocks;
import growthcraft.apiary.init.GrowthcraftApiaryFluids;
import growthcraft.apiary.init.GrowthcraftApiaryItems;
import growthcraft.apiary.shared.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.MODID)
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftApiary {

    public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);

    public GrowthcraftApiary() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetupEvent);

        // GrowthcraftApiaryConfig.loadConfig()

        GrowthcraftApiaryBlocks.BLOCKS.register(modEventBus);
        GrowthcraftApiaryItems.ITEMS.register(modEventBus);
        GrowthcraftApiaryFluids.FLUIDS.register(modEventBus);
        // GrowthcraftApiaryBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        // GrowthcraftApiaryContainers.CONTAINERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void clientSetupEvent(final FMLClientSetupEvent event) {
        // Do nothing for now ...
    }

    private void setup(final FMLCommonSetupEvent event) {
        //event.enqueueWork( () -> {
        //   GrowthcraftOreGeneration.registerConfiguredFeatures();
        //});
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Growthcraft Apiary starting up ...");
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> itemRegistry = event.getRegistry();
        final Item.Properties properties = new Item.Properties().tab(growthcraft.core.shared.Reference.CREATIVE_TAB);
        //GrowthcraftApiaryBlocks.registerBlockItems(itemRegistry, properties);
    }
}
