package growthcraft.cellar.block;

import growthcraft.cellar.init.GrowthcraftCellarItems;
import growthcraft.cellar.init.config.GrowthcraftCellarConfig;
import growthcraft.core.init.GrowthcraftTags;
import growthcraft.lib.block.GrowthcraftCropsRopeBlock;
import growthcraft.lib.utils.BlockStateUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Map;

public class HopsCropBlock extends GrowthcraftCropsRopeBlock {

    protected static final VoxelShape[] CUSTOM_SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)
    };

    private static final int fruitMax = GrowthcraftCellarConfig.getHopsCropMaxFruitYield();
    private static final int fruitMin = GrowthcraftCellarConfig.getHopsCropMinFruitYield();

    public HopsCropBlock() {
        super();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        VoxelShape ropeVoxel = super.getShape(state, worldIn, pos, context);

        ArrayList<VoxelShape> voxelShapeArrayList = new ArrayList<VoxelShape>();
        Map<String, BlockState> blockMap = BlockStateUtils.getSurroundingBlockState(worldIn, pos);

        if (blockMap.get("north").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(NORTH_BOUNDING_BOX);
        if (blockMap.get("east").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(EAST_BOUNDING_BOX);
        if (blockMap.get("south").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(SOUTH_BOUNDING_BOX);
        if (blockMap.get("west").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(WEST_BOUNDING_BOX);
        if (blockMap.get("up").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(UP_BOUNDING_BOX);
        if (blockMap.get("down").is(GrowthcraftTags.Blocks.ROPE)) voxelShapeArrayList.add(DOWN_BOUNDING_BOX);

        voxelShapeArrayList.add(ropeVoxel);

        VoxelShape[] voxelShapes = new VoxelShape[voxelShapeArrayList.size()];
        voxelShapes = voxelShapeArrayList.toArray(voxelShapes);

        return Shapes.or(KNOT_BOUNDING_BOX, voxelShapes);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter p_52254_, BlockPos p_52255_, BlockState p_52256_) {
        return new ItemStack(this.getBaseSeedId());
    }

    protected ItemLike getBaseSeedId() {
        return GrowthcraftCellarItems.HOPS_SEED.get();
    }
}
