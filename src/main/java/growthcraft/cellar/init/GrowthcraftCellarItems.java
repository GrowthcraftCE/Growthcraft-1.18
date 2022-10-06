package growthcraft.cellar.init;

import growthcraft.cellar.shared.Reference;
import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GrowthcraftCellarItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, Reference.MODID
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_AMBER_ALE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_ALE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.AMBER_ALE_FLUID_STILL,
                    Reference.FluidColor.AMBER_ALE_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_AMBER_LAGER = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_LAGER).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.AMBER_LAGER_FLUID_STILL,
                    Reference.FluidColor.AMBER_LAGER_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_AMBER_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.AMBER_WORT_FLUID_STILL,
                    Reference.FluidColor.AMBER_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_BROWN_ALE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_ALE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.BROWN_ALE_FLUID_STILL,
                    Reference.FluidColor.BROWN_ALE_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_BROWN_LAGER = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_LAGER).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.BROWN_LAGER_FLUID_STILL,
                    Reference.FluidColor.BROWN_LAGER_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_BROWN_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.BROWN_WORT_FLUID_STILL,
                    Reference.FluidColor.BROWN_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_COPPER_ALE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_ALE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.COPPER_ALE_FLUID_STILL,
                    Reference.FluidColor.COPPER_ALE_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_COPPER_LAGER = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_LAGER).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.COPPER_LAGER_FLUID_STILL,
                    Reference.FluidColor.COPPER_LAGER_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_COPPER_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.COPPER_WORT_FLUID_STILL,
                    Reference.FluidColor.COPPER_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_DARK_LAGER = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_LAGER).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.DARK_LAGER_FLUID_STILL,
                    Reference.FluidColor.DARK_LAGER_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_DARK_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.DARK_WORT_FLUID_STILL,
                    Reference.FluidColor.DARK_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_DEEP_AMBER_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_AMBER_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.DEEP_AMBER_WORT_FLUID_STILL,
                    Reference.FluidColor.DEEP_AMBER_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_DEEP_COPPER_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_COPPER_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.DEEP_COPPER_WORT_FLUID_STILL,
                    Reference.FluidColor.DEEP_COPPER_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_GOLDEN_WORT = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.GOLDEN_WORT).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.GOLDEN_WORT_FLUID_STILL,
                    Reference.FluidColor.GOLDEN_WORT_FLUID_COLOR.getColor()
            )
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_IPA_ALE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.IPA_ALE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftCellarFluids.IPA_ALE_FLUID_STILL,
                    Reference.FluidColor.IPA_ALE_FLUID_COLOR.getColor()
            )
    );

    public static final List<RegistryObject<? extends Item>> BUCKETS = List.of(
            BUCKET_AMBER_ALE, BUCKET_AMBER_LAGER, BUCKET_AMBER_WORT,
            BUCKET_BROWN_ALE, BUCKET_BROWN_LAGER, BUCKET_BROWN_WORT,
            BUCKET_BROWN_ALE, BUCKET_COPPER_LAGER, BUCKET_COPPER_WORT,
            BUCKET_DARK_LAGER, BUCKET_DARK_WORT, BUCKET_DEEP_AMBER_WORT,
            BUCKET_DEEP_COPPER_WORT, BUCKET_GOLDEN_WORT, BUCKET_IPA_ALE
    );

    public static void registerCompostables() {
        float f = 0.3F;
        float f1 = 0.5F;
        float f2 = 0.65F;
        float f3 = 0.85F;
        float f4 = 1.0F;

        // ComposterBlock.COMPOSTABLES.put(GrowthcraftRiceItems.RICE.get(), f2);

    }

    private GrowthcraftCellarItems() {
        /* Prevent default public constructor */
    }
}
