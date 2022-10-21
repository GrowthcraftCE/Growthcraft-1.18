package growthcraft.cellar.init.client;

import growthcraft.cellar.init.GrowthcraftCellarBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class GrowthcraftCellarBlockRenderers {
    public static void setRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(GrowthcraftCellarBlocks.HOPS_VINE.get(), RenderType.cutout());
    }

    private GrowthcraftCellarBlockRenderers() {
        /* Prevent default public constructor */
    }
}
