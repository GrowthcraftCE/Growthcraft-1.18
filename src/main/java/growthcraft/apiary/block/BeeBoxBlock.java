package growthcraft.apiary.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class BeeBoxBlock extends HorizontalDirectionalBlock {

    private static final VoxelShape VOXEL_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public BeeBoxBlock() {
        this(getInitProperties());
    }

    public BeeBoxBlock(Properties properties) {
        super(properties);
    }

    private static Properties getInitProperties() {
        Properties properties = BlockBehaviour.Properties.copy(Blocks.BEEHIVE);
        properties.strength(1.5F);
        properties.noOcclusion();
        return properties;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(HORIZONTAL_FACING);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }
}
