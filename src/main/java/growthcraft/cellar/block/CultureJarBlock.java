package growthcraft.cellar.block;

import org.jetbrains.annotations.Nullable;

import growthcraft.cellar.GrowthcraftCellar;
import growthcraft.cellar.block.entity.CultureJarBlockEntity;
import growthcraft.cellar.init.GrowthcraftCellarBlockEntities;
import growthcraft.core.utils.BlockPropertiesUtils;
import growthcraft.lib.utils.BlockStateUtils;
import growthcraft.milk.init.GrowthcraftMilkFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.network.NetworkHooks;

public class CultureJarBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    private static final VoxelShape VOXEL_SHAPE = Block.box(
            5.0D, 0.0D, 5.0D,
            11.0D, 8.0D, 11.0D
    );

    public CultureJarBlock() {
        this(getInitProperties());
    }

    public CultureJarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(LIT, false)
        );
    }

    private static Properties getInitProperties() {
        Properties properties = Properties.copy(Blocks.GLASS);
        properties.strength(0.5F);
        properties.noOcclusion();
        properties.isValidSpawn(BlockPropertiesUtils::never);
        properties.isRedstoneConductor(BlockPropertiesUtils::never);
        properties.isSuffocating(BlockPropertiesUtils::never);
        properties.isViewBlocking(BlockPropertiesUtils::never);
        return properties;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter level, BlockPos blockPos, CollisionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder.add(FACING).add(LIT));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return GrowthcraftCellarBlockEntities.CULTURE_JAR_BLOCK_ENTITY.get().create(blockPos, blockState);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(LIT, BlockStateUtils.isHeated(context.getLevel(), context.getClickedPos()));
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState p_60584_) {
        return PushReaction.DESTROY;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING))).setValue(LIT, state.getValue(LIT));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING))).setValue(LIT, state.getValue(LIT));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(
                blockEntityType,
                GrowthcraftCellarBlockEntities.CULTURE_JAR_BLOCK_ENTITY.get(),
                (worldLevel, pos, blockState, blockEntity) -> (blockEntity).tick()
        );
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide && player.isCrouching()) {
            try {
                // Play sound
                level.playSound(player, blockPos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                CultureJarBlockEntity blockEntity = (CultureJarBlockEntity) level.getBlockEntity(blockPos);
                NetworkHooks.openGui(((ServerPlayer) player), blockEntity, blockPos);
            } catch (Exception ex) {
                GrowthcraftCellar.LOGGER.error(String.format("%s unable to open CultureJarBlockEntity GUI at %s.", player.getDisplayName().getString(), blockPos));
                GrowthcraftCellar.LOGGER.error(ex.getMessage());
                GrowthcraftCellar.LOGGER.error(ex.fillInStackTrace());
            }
            return InteractionResult.SUCCESS;
        }

        if (!level.isClientSide) {
            try {
                // Handling of Vanilla Milk Bucket
                if (player.getItemInHand(interactionHand).getItem() == Items.MILK_BUCKET) {
                    CultureJarBlockEntity blockEntity = (CultureJarBlockEntity) level.getBlockEntity(blockPos);

                    int capacity = blockEntity.getFluidTank(0).getCapacity();
                    int amount = blockEntity.getFluidTank(0).getFluidAmount();
                    int remainingFill = capacity - amount;

                    if (blockEntity.getFluidTank(0).isEmpty()
                            || (remainingFill >= 1000
                            && blockEntity.getFluidStackInTank(0).getFluid() == GrowthcraftMilkFluids.MILK.get().getSource())
                    ) {
                        FluidStack fluidStack = new FluidStack(GrowthcraftMilkFluids.MILK.get().getSource(), 1000);
                        blockEntity.getFluidTank(0).fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
                        player.setItemInHand(interactionHand, new ItemStack(Items.BUCKET));
                    }
                } else if (
                        FluidUtil.interactWithFluidHandler(player, interactionHand, level, blockPos, blockHitResult.getDirection())
                                || player.getItemInHand(interactionHand).getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).isPresent()
                ) {
                    return InteractionResult.SUCCESS;
                }
            } catch (Exception ex) {
                GrowthcraftCellar.LOGGER.error(String.format("Exception Thrown: %s unable to place fluid in CultureJarBlockEntity at %s.", player.getDisplayName().getString(), blockPos));
                GrowthcraftCellar.LOGGER.error(ex.getMessage());
                GrowthcraftCellar.LOGGER.error(ex.fillInStackTrace());
            }
        }
        return InteractionResult.SUCCESS;
    }
}
