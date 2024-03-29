package growthcraft.apples.init;

import java.util.ArrayList;

import growthcraft.apples.item.AppleSeedsItem;
import growthcraft.apples.shared.Reference;
import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftApplesItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, Reference.MODID
    );

    public static final RegistryObject<Item> APPLE_SEEDS = ITEMS.register(
            Reference.UnlocalizedName.APPLE_SEEDS,
            AppleSeedsItem::new
    );
    
    public static final RegistryObject<GrowthcraftBucketItem> APPLE_CIDER_BUCKET = ITEMS.register(
    		FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_CIDER).get(FluidUtils.BUCKET),
    		() -> new GrowthcraftBucketItem(GrowthcraftApplesFluids.APPLE_CIDER_FLUID, Reference.FluidColor.APPLE_CIDER_FLUID_COLOR.getColor()));
    
    public static final RegistryObject<GrowthcraftBucketItem> APPLE_JUICE_BUCKET = ITEMS.register(
    		FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_JUICE).get(FluidUtils.BUCKET),
    		() -> new GrowthcraftBucketItem(GrowthcraftApplesFluids.APPLE_JUICE_FLUID, Reference.FluidColor.APPLE_JUICE_FLUID_COLOR.getColor()));

    public static void registerCompostables() {
        float f = 0.3F;
        float f1 = 0.5F;
        float f2 = 0.65F;
        float f3 = 0.85F;
        float f4 = 1.0F;

        ComposterBlock.COMPOSTABLES.put(GrowthcraftApplesItems.APPLE_SEEDS.get(), f1);
    }

    public static boolean excludeItemRegistry(ResourceLocation registryName) {
        ArrayList<String> excludeItems = new ArrayList<>();
        //excludeBlocks.add(Reference.MODID + ":" + Reference.UnlocalizedName.APPLE_TREE_FRUIT);
        return excludeItems.contains(registryName.toString());
    }

    private GrowthcraftApplesItems() {
        /* Prevent default public constructor */
    }
}
