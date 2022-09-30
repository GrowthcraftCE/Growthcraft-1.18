package growthcraft.apiary.init;

import growthcraft.apiary.shared.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class GrowthcraftApiaryBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
            ForgeRegistries.BLOCKS, Reference.MODID
    );

    // TODO: Add Vanilla Plank Bee Boxes
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
        //excludeBlocks.add(growthcraft.core.shared.Reference.MODID + ":" + growthcraft.core.shared.Reference.UnlocalizedName.ROPE_LINEN);

        return excludeBlocks.contains(registryName.toString());
    }

}
