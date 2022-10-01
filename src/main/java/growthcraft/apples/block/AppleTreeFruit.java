package growthcraft.apples.block;

import growthcraft.apples.init.GrowthcraftApplesItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class AppleTreeFruit extends CropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(6.0D, 10.0D, 6.0D, 10.0D, 14.0D, 10.0D),
            Block.box(6.0D, 10.0D, 6.0D, 10.0D, 14.0D, 10.0D),
            Block.box(6.0D, 10.0D, 6.0D, 10.0D, 14.0D, 10.0D),
            Block.box(5.0D, 9.0D, 5.0D, 11.0D, 14.0D, 11.0D),
            Block.box(5.0D, 9.0D, 5.0D, 11.0D, 14.0D, 11.0D),
            Block.box(5.0D, 9.0D, 5.0D, 11.0D, 14.0D, 11.0D),
            Block.box(5.0D, 9.0D, 5.0D, 11.0D, 14.0D, 11.0D),
            Block.box(4.0D, 7.0D, 4.0D, 12.0D, 14.0D, 12.0D)};

    public AppleTreeFruit() {
        super(getInitProperties());
    }

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return GrowthcraftApplesItems.APPLE_SEEDS.get();
    }

    private static Properties getInitProperties() {
        Properties properties = Properties.of(Material.LEAVES);
        properties.randomTicks();
        properties.sound(SoundType.CROP);
        properties.noOcclusion();
        properties.instabreak();
        return properties;
    }
}
