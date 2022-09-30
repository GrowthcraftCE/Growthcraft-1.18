package growthcraft.apples.init;

import com.google.common.collect.ImmutableList;
import growthcraft.apples.shared.Reference;
import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GrowthcraftApplesItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, Reference.MODID
    );

    public static final RegistryObject<GrowthcraftBucketItem> BUCKET_APPLE_JUICE = ITEMS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_JUICE).get(FluidUtils.BUCKET),
            () -> new GrowthcraftBucketItem(
                    GrowthcraftApplesFluids.APPLE_JUICE_FLUID_STILL,
                    Reference.FluidColor.APPLE_JUICE_FLUID_COLOR.getColor()
            )
    );

    public static final List<RegistryObject<? extends Item>> BUCKETS = ImmutableList.of(
            BUCKET_APPLE_JUICE
    );

    private GrowthcraftApplesItems() {
        /* Prevent default public constructor */
    }
}
