package growthcraft.cellar.init;

import growthcraft.cellar.block.HopsCropBlock;
import growthcraft.cellar.shared.Reference;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class GrowthcraftCellarBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, Reference.MODID
    );

    // TODO: BREW_KETTLE

    // TODO: CULTURE_JAR

    // TODO: FERMENT_BARREL_OAK

    // TODO: FRUIT_PRESS
    // TODO: FRUIT_PRESS_PISTON

    // TODO: GRAPE_VINE
    // TODO: GRAPE_VINE_CROP
    // TODO: GRAPE_VINE_LEAVES

    public static final RegistryObject<HopsCropBlock> HOPS_VINE = BLOCKS.register(
            Reference.UnlocalizedName.HOPS_VINE, HopsCropBlock::new
    );

    // TODO: ROASTER

    public static void registerBlockItems(IForgeRegistry<Item> itemRegistry, Item.Properties properties) {
        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            if (block.getRegistryName() != null && !excludeBlockItemRegistry(block.getRegistryName())) {
                final BlockItem blockItem = new BlockItem(block, properties);
                blockItem.setRegistryName(block.getRegistryName());
                itemRegistry.register(blockItem);
            }
        });
    }

    private static boolean excludeBlockItemRegistry(ResourceLocation registryName) {
        ArrayList<String> excludeBlocks = new ArrayList<>();
        // Exclude any blocks that do not need to be accessible via the Creative tab
        //excludeBlocks.add(Reference.MODID + ":" + Reference.UnlocalizedName.APPLE_TREE_FRUIT);
        // Exclude Fluid Blocks
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_AMBER_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_COPPER_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.GOLDEN_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.HOPPED_GOLDEN_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.IPA_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.OLD_PORT_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PALE_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PALE_GOLDEN_WORT).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PALE_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PILSNER_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PURPLE_GRAPE_JUICE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.PURPLE_GRAPE_WINE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.RED_GRAPE_JUICE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.RED_GRAPE_WINE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.STOUT_ALE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.VIENNA_LAGER).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.WHITE_GRAPE_JUICE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.WHITE_GRAPE_WINE).get(FluidUtils.BLOCK));
        excludeBlocks.add(Reference.MODID + ":" + FluidUtils.getFluidNames(Reference.UnlocalizedName.WORT).get(FluidUtils.BLOCK));

        return excludeBlocks.contains(registryName.toString());
    }

    private GrowthcraftCellarBlocks() {
        /* Disable default public constructor */
    }


}
