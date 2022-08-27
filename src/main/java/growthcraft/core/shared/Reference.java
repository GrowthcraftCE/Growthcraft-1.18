package growthcraft.core.shared;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Reference {
    public static final String MODID = "growthcraft";
    public static final String NAME = "Growthcraft";
    public static final String NAME_SHORT = "core";
    public static final String VERSION = "7.0.0";

    private Reference() { /* Prevent default public constructor */ }

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(Reference.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.TROPICAL_FISH);
        }
    };

    public static class UnlocalizedName {
        public static final String CROWBAR_BLACK = "crowbar_black";
        public static final String CROWBAR_BLUE = "crowbar_blue";
        public static final String CROWBAR_BROWN = "crowbar_brown";
        public static final String CROWBAR_CYAN = "crowbar_cyan";
        public static final String CROWBAR_GRAY = "crowbar_gray";
        public static final String CROWBAR_GREEN = "crowbar_green";
        public static final String CROWBAR_LIGHT_BLUE = "crowbar_light_blue";
        public static final String CROWBAR_LIGHT_GRAY = "crowbar_light_gray";
        public static final String CROWBAR_LIME = "crowbar_lime";
        public static final String CROWBAR_MAGENTA = "crowbar_magenta";
        public static final String CROWBAR_ORANGE = "crowbar_orange";
        public static final String CROWBAR_PINK = "crowbar_pink";
        public static final String CROWBAR_PURPLE = "crowbar_purple";
        public static final String CROWBAR_RED = "crowbar_red";
        public static final String CROWBAR_WHITE = "crowbar_white";
        public static final String CROWBAR_YELLOW = "crowbar_yellow";

        public static final String SALT_ORE = "salt_ore";
        public static final String SALT_BLOCK = "salt_block";
        public static final String SALT_ITEM = "salt";

        public static final String ROPE = "rope";
        public static final String ROPE_LINEN = "rope_linen";

        public static final String TAG_ROPE = "rope";
        public static final String TAG_ROPE_FENCE = "rope_fence";
        public static final String TAG_HEATSOURCES = "heatsources";

        private UnlocalizedName() { /* Disable default public constructor. */ }

    }

}
