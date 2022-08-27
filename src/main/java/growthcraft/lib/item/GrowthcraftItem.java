package growthcraft.lib.item;

import growthcraft.core.shared.Reference;
import net.minecraft.world.item.Item;

public class GrowthcraftItem extends Item {
    public GrowthcraftItem() {
        super(getInitProperties(64));
    }

    public GrowthcraftItem(int maxStackSize) {
        super(getInitProperties(maxStackSize));
    }

    private static Properties getInitProperties(int maxStackSize) {
        Properties properties = new Properties();
        properties.tab(Reference.CREATIVE_TAB);
        properties.stacksTo(maxStackSize);
        return properties;
    }
}
