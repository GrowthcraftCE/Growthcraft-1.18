package growthcraft.lib.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.MOISTURE;

public class GrowthcraftCropsRopeBlock extends BushBlock implements BonemealableBlock {

    public static IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public static final VoxelShape KNOT_BOUNDING_BOX = Block.box(7.0D, 7.0D, 7.0D, 9.0D, 9.0D, 9.0D);
    public static final VoxelShape NORTH_BOUNDING_BOX = Block.box(7.0D, 7.0D, 0.0D, 9.0D, 9.0D, 7.0D);
    public static final VoxelShape EAST_BOUNDING_BOX = Block.box(9.0D, 7.0D, 7.0D, 16.0D, 9.0D, 9.0D);
    public static final VoxelShape SOUTH_BOUNDING_BOX = Block.box(7.0D, 7.0D, 9.0D, 9.0D, 9.0D, 16.0D);
    public static final VoxelShape WEST_BOUNDING_BOX = Block.box(0.0D, 7.0D, 7.0D, 7.0D, 9.0D, 9.0D);
    public static final VoxelShape UP_BOUNDING_BOX = Block.box(7.0D, 9.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    public static final VoxelShape DOWN_BOUNDING_BOX = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 7.0D, 9.0D);

    private Item seedsItem;

    public GrowthcraftCropsRopeBlock() {
        this(getInitProperties());
    }

    public GrowthcraftCropsRopeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(AGE, 0)
        );
    }

    public static Properties getInitProperties() {
        Properties properties = Properties.of(Material.PLANT);
        properties.randomTicks();
        properties.strength(0.2F, 0.2F);
        properties.sound(SoundType.CROP);
        properties.noOcclusion();
        return properties;
    }

    public BlockState getStateForAge(int i) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(i));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return super.getShape(p_60555_, p_60556_, p_60557_, p_60558_);
    }

    public boolean isMaxAge(BlockState blockState) {
        return blockState.getValue(this.getAgeProperty()) >= this.getMaxAge();
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    protected int getAge(BlockState blockState) {
        return blockState.getValue(this.getAgeProperty());
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 2, 5);
    }

    public void growCrops(Level level, BlockPos blockPos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        level.setBlock(blockPos, this.getStateForAge(i), 2);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos pos, BlockState state, boolean isClientSide) {
        return !this.isMaxAge(state);
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
        this.growCrops(level, pos, state);
    }


    protected static float getGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = blockGetter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(blockGetter, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) block)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(blockGetter, pos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockGetter.getBlockState(blockpos3).is(block) || blockGetter.getBlockState(blockpos4).is(block);
        boolean flag1 = blockGetter.getBlockState(blockpos1).is(block) || blockGetter.getBlockState(blockpos2).is(block);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = blockGetter.getBlockState(blockpos3.north()).is(block) || blockGetter.getBlockState(blockpos4.north()).is(block) || blockGetter.getBlockState(blockpos4.south()).is(block) || blockGetter.getBlockState(blockpos3.south()).is(block);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f * 2.0F;
    }


    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof Ravager && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, entity)) {
            level.destroyBlock(pos, true, entity);
        }

        super.entityInside(blockState, level, pos, entity);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(state.getValue(AGE) == this.getMaxAge()) {
            level.destroyBlock(pos, true);
            // TODO: Pull loot from loot table.
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.APPLE));
            level.addFreshEntity(itemEntity);
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).hasProperty(MOISTURE) && level.getBlockState(pos.below()).getValue(MOISTURE) > 0;
    }
}
