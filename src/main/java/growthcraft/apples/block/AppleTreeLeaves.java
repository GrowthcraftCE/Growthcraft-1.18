package growthcraft.apples.block;

import growthcraft.core.utils.BlockPropertiesUtils;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class AppleTreeLeaves extends LeavesBlock {

    public AppleTreeLeaves() {
        this(getInitProperties());
    }

    public AppleTreeLeaves(Properties p_54422_) {
        super(p_54422_);
    }

    private static Properties getInitProperties() {
        Properties properties = Properties.of(Material.LEAVES);
        properties.strength(0.2F);
        properties.randomTicks();
        properties.sound(SoundType.GRASS);
        properties.noOcclusion();
        properties.isViewBlocking(BlockPropertiesUtils::never);
        return properties;
    }
}
