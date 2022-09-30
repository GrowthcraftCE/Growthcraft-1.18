package growthcraft.apples.item;

import growthcraft.lib.item.GrowthcraftItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AppleSeedsItem extends GrowthcraftItem {

    public AppleSeedsItem() {
        super();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        // TODO: Plant a AppleTreeSapling on use on the ground.

        return super.use(p_41432_, p_41433_, p_41434_);
    }
}
