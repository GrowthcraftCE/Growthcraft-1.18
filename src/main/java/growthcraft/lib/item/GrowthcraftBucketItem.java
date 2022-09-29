package growthcraft.lib.item;

import growthcraft.core.shared.Reference;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;

import java.awt.*;
import java.util.function.Supplier;

public class GrowthcraftBucketItem extends BucketItem {
    private final int color;

    public GrowthcraftBucketItem(Supplier<? extends Fluid> supplier, Color color) {
        super(supplier, new Item.Properties().tab(Reference.CREATIVE_TAB).stacksTo(1));
        this.color = color.getRGB();
    }

    public boolean hasColor(ItemStack stack) {
        return true;
    }

    public int getColor(ItemStack stack) {
        return this.color;
    }

    public int getColor(int i) {
        return i == 0 ? this.color : 0xFFFFFF;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.BUCKET);
    }
}
