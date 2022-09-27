package growthcraft.core.item;

import growthcraft.core.block.RopeBlock;
import growthcraft.core.block.entity.RopeBlockEntity;
import growthcraft.lib.item.GrowthcraftBlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RopeItem extends GrowthcraftBlockItem {

    public RopeItem(RopeBlock block) {
        super(block);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if(!level.isClientSide) {
            BlockPos blockPos = useOnContext.getClickedPos();
            BlockState blockState = level.getBlockState(blockPos);

            if (blockState.is(BlockTags.FENCES)) {
                level.setBlock(blockPos, this.getBlock().defaultBlockState(), 11);
                RopeBlockEntity ropeBlockEntity = (RopeBlockEntity) level.getBlockEntity(blockPos);
                if (ropeBlockEntity != null) {
                    ropeBlockEntity.setFenceItemStack(new ItemStack(blockState.getBlock(), 1));
                    useOnContext.getItemInHand().shrink(1);
                }
            } else {
                InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));
                return interactionResult;
            }
        }
        return InteractionResult.PASS;
    }
}
