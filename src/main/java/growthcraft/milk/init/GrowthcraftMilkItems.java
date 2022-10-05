package growthcraft.milk.init;

import growthcraft.milk.shared.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GrowthcraftMilkItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, Reference.MODID
    );


    /*
        public static final RegistryObject<GrowthcraftBucketItem> BUCKET_RICE_WATER = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.RICE_WATER).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftRiceFluids.RICE_WATER_FLUID_STILL,
                    Reference.FluidColor.RICE_WATER_FLUID_COLOR.getColor()
            )
    );
     */

    public static final List<RegistryObject<? extends Item>> BUCKETS = List.of(
            // TODO: Add bucket items
    );

    public static void registerCompostables() {
        float f = 0.3F;
        float f1 = 0.5F;
        float f2 = 0.65F;
        float f3 = 0.85F;
        float f4 = 1.0F;

        // ComposterBlock.COMPOSTABLES.put(GrowthcraftRiceItems.RICE.get(), f2);

    }

    private GrowthcraftMilkItems() {
        /* Prevent default public constructor */
    }
}
