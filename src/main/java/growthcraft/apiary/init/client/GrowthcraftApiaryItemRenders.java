package growthcraft.apiary.init.client;

import growthcraft.apiary.init.GrowthcraftApiaryFluids;
import growthcraft.apiary.shared.Reference;
import growthcraft.lib.client.ItemRendererUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrowthcraftApiaryItemRenders {

    @SubscribeEvent
    public static void registerItemRenders(ColorHandlerEvent.Item event) {
       ItemRendererUtils.registerItem(event, Reference.FluidColor.HONEY.toItemColor(), GrowthcraftApiaryFluids.HONEY_FLUID.get().getBucket());
       ItemRendererUtils.registerItem(event, Reference.FluidColor.HONEY_MEAD.toItemColor(), GrowthcraftApiaryFluids.HONEY_MEAD_FLUID.get().getBucket()); 
       ItemRendererUtils.registerItem(event, Reference.FluidColor.HONEY_MEAD_MUST.toItemColor(), GrowthcraftApiaryFluids.HONEY_MEAD_MUST_FLUID.get().getBucket());
    }

}
