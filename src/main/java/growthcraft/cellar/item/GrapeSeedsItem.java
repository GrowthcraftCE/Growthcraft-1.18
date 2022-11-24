package growthcraft.cellar.item;

import growthcraft.cellar.block.GrapeVineCropBlock;
import growthcraft.cellar.block.GrapeVineFruitBlock;
import growthcraft.cellar.block.GrapeVineLeavesCropBlock;
import growthcraft.cellar.init.GrowthcraftCellarBlocks;
import growthcraft.core.block.RopeBlock;
import growthcraft.lib.item.GrowthcraftItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;

public class GrapeSeedsItem extends GrowthcraftItem {

    private GrapeVineCropBlock grapeVineCropBlock;

    public GrapeSeedsItem(GrapeVineCropBlock grapeVineCropBlock, GrapeVineLeavesCropBlock grapeVineLeavesCropBlock, GrapeVineFruitBlock grapeVineFruitBlock) {
        super();
        this.grapeVineCropBlock = grapeVineCropBlock;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Block block = level.getBlockState(blockPos).getBlock();

        if (block instanceof FarmBlock && level.getBlockState(blockPos.above()).getBlock() instanceof RopeBlock) {
            level.setBlock(
                    blockPos.above(),
                    GrowthcraftCellarBlocks.RED_GRAPE_VINE.get().defaultBlockState(),
                    Block.UPDATE_ALL
            );
            context.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public GrapeVineCropBlock getGrapeVineCropBlock() {
        return this.grapeVineCropBlock;
    }

}
