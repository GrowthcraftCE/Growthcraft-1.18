package growthcraft.core.item;

import growthcraft.core.block.RopeBlock;
import growthcraft.core.block.entity.RopeBlockEntity;
import growthcraft.lib.item.GrowthcraftItem;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class RopeItem extends GrowthcraftItem {

    private final RopeBlock block;

    public RopeItem(RopeBlock block) {
        this.block = block;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if(blockState.is(BlockTags.FENCES)) {
            level.setBlock(blockPos, this.block.defaultBlockState(), 11);
            RopeBlockEntity ropeBlockEntity = (RopeBlockEntity) level.getBlockEntity(blockPos);

            if(ropeBlockEntity != null) {
                ropeBlockEntity.setFenceItemStack(new ItemStack(blockState.getBlock(), 1));
            }
        }

        return super.useOn(useOnContext);
    }
}
