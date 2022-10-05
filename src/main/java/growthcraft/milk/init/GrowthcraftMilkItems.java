package growthcraft.milk.init;

import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.utils.FluidUtils;
import growthcraft.milk.item.MilkingBucketItem;
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

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_BUTTER_MILK = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BUTTER_MILK).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.BUTTER_MILK_FLUID_STILL,
                    Reference.FluidColor.BUTTER_MILK_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_CHEESE_BASE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.CHEESE_BASE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.CHEESE_BASE_FLUID_STILL,
                    Reference.FluidColor.CHEESE_BASE_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_CONDENSED_MILK = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.CONDENSED_MILK).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.CONDENSED_MILK_FLUID_STILL,
                    Reference.FluidColor.CONDENSED_MILK_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_CREAM = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.CREAM).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.CREAM_FLUID_STILL,
                    Reference.FluidColor.CREAM_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_CULTURED_MILK = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.CULTURED_MILK).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.CULTURED_MILK_FLUID_STILL,
                    Reference.FluidColor.CULTURED_MILK_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_KUMIS = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.KUMIS).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.KUMIS_FLUID_STILL,
                    Reference.FluidColor.KUMIS_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_MILK = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.MILK).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.MILK_FLUID_STILL,
                    Reference.FluidColor.MILK_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_RENNET = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.RENNET).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.RENNET_FLUID_STILL,
                    Reference.FluidColor.RENNET_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_SKIM_MILK = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.SKIM_MILK).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.SKIM_MILK_FLUID_STILL,
                    Reference.FluidColor.SKIM_MILK_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_WHEY = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.WHEY).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftMilkFluids.WHEY_FLUID_STILL,
                    Reference.FluidColor.WHEY_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<MilkingBucketItem> MILKING_BUCKET_IRON = ITEMS.register(
            Reference.UnlocalizedName.MILKING_BUCKET_IRON,
            MilkingBucketItem::new
    );

    public static final List<RegistryObject<? extends Item>> BUCKETS = List.of(
            BUCKET_BUTTER_MILK, BUCKET_CHEESE_BASE, BUCKET_CONDENSED_MILK, BUCKET_CREAM,
            BUCKET_CULTURED_MILK, BUCKET_KUMIS, BUCKET_MILK, BUCKET_RENNET, BUCKET_SKIM_MILK,
            BUCKET_WHEY
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
