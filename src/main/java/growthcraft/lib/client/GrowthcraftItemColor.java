package growthcraft.lib.client;

import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.item.GrowthcraftItem;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class GrowthcraftItemColor implements ItemColor {

    @Override
    public int getColor(ItemStack itemStack, int layer) {
        if(itemStack.getItem() instanceof GrowthcraftBucketItem) {
            GrowthcraftBucketItem bucket = (GrowthcraftBucketItem) itemStack.getItem();
            return bucket.getColor(layer);
        }
        if(itemStack.getItem() instanceof GrowthcraftItem) {
            GrowthcraftItem growthcraftItem = (GrowthcraftItem) itemStack.getItem();
            return growthcraftItem.getColor(layer);
        }
        return 0;
    }
}
