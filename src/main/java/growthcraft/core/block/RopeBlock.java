package growthcraft.core.block;

import growthcraft.core.Growthcraft;
import growthcraft.core.block.entity.RopeBlockEntity;
import growthcraft.core.init.GrowthcraftBlockEntities;
import growthcraft.core.utils.BlockPropertiesUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class RopeBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty KNOT = BooleanProperty.create("knot");

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape KNOT_BOUNDING_BOX = Block.box(7.0D, 7.0D, 7.0D, 9.0D, 9.0D, 9.0D);
    public static final VoxelShape NORTH_BOUNDING_BOX = Block.box(7.0D, 7.0D, 0.0D, 9.0D, 9.0D, 7.0D);
    public static final VoxelShape EAST_BOUNDING_BOX = Block.box(9.0D, 7.0D, 7.0D, 16.0D, 9.0D, 9.0D);
    public static final VoxelShape SOUTH_BOUNDING_BOX = Block.box(7.0D, 7.0D, 9.0D, 9.0D, 9.0D, 16.0D);
    public static final VoxelShape WEST_BOUNDING_BOX = Block.box(0.0D, 7.0D, 7.0D, 7.0D, 9.0D, 9.0D);
    public static final VoxelShape UP_BOUNDING_BOX = Block.box(7.0D, 9.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    public static final VoxelShape DOWN_BOUNDING_BOX = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 7.0D, 9.0D);
    public static final VoxelShape KNOT_FENCE_BOUNDING_BOX = Block.box(5.0D, 6.0D, 5.0D, 11.0D, 14.0D, 11.0D);
    public static final VoxelShape FENCE_POST_BOUNDING_BOX = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public RopeBlock() {
        this(BlockPropertiesUtils.getInitProperties("rope_block", Blocks.TRIPWIRE));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(KNOT, false)
                .setValue(WATERLOGGED, Boolean.valueOf(false))
        );

    }

    public RopeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockState = this.defaultBlockState();

        // TODO: Create methods to determine connectiveness to neighbors

        return blockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, KNOT, WATERLOGGED);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return Boolean.TRUE.equals(blockState.getValue(WATERLOGGED))
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(blockState);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return GrowthcraftBlockEntities.ROPE_BLOCK_ENTITY.get().create(blockPos, blockState);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean isMoving) {
        if (blockState.getBlock() != newBlockState.getBlock()) {
            try {
                RopeBlockEntity blockEntity = (RopeBlockEntity) level.getBlockEntity(blockPos);
                blockEntity.dropItems();
            } catch (Exception ex) {
                Growthcraft.LOGGER.error(String.format("Invalid blockEntity type at %s, expected RopeBlockEntity", blockPos.toString()));
            }
        }
        super.onRemove(blockState, level, blockPos, newBlockState, isMoving);
    }

}
