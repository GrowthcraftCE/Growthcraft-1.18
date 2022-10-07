package growthcraft.cellar.fluid;

import growthcraft.cellar.init.GrowthcraftCellarFluids;
import growthcraft.cellar.init.GrowthcraftCellarItems;
import growthcraft.lib.item.GrowthcraftBucketItem;
import growthcraft.lib.utils.ColorUtils;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;

import static growthcraft.cellar.shared.Reference.FluidColor.PALE_ALE_FLUID_COLOR;

public class PaleAleFluid extends ForgeFlowingFluid {

    private static final RegistryObject<PaleAleFluid.Flowing> REGISTRY_FLUID_FLOWING = GrowthcraftCellarFluids.PALE_ALE_FLUID_FLOWING;
    private static final RegistryObject<PaleAleFluid.Source> REGISTRY_FLUID_STILL = GrowthcraftCellarFluids.PALE_ALE_FLUID_STILL;
    private static final RegistryObject<LiquidBlock> block = GrowthcraftCellarFluids.PALE_ALE_FLUID_BLOCK;
    private static final ColorUtils.GrowthcraftColor color = PALE_ALE_FLUID_COLOR;
    private static final RegistryObject<GrowthcraftBucketItem> registry_bucket = GrowthcraftCellarItems.BUCKET_PALE_ALE;

    public static final Properties FLUID_PROPERTIES = new Properties(
            REGISTRY_FLUID_STILL,
            REGISTRY_FLUID_FLOWING,
            FluidAttributes.builder(FluidUtils.FluidResource.STILL, FluidUtils.FluidResource.FLOWING)
                    .color(color.toIntValue())
                    .density(3000).luminosity(2).viscosity(1000)
                    .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
                    .overlay(FluidUtils.FluidResource.OVERLAY))
            .block(block)
            .bucket(registry_bucket);

    protected PaleAleFluid(Properties properties) {
        super(properties);
    }

    public static Color getColor() {
        return color.getColor();
    }

    @Override
    public Fluid getFlowing() {
        return REGISTRY_FLUID_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return REGISTRY_FLUID_STILL.get();
    }

    @Override
    public int getAmount(FluidState state) {
        return state.getValue(LEVEL);
    }

    @Override
    public Item getBucket() {
        return registry_bucket != null ? registry_bucket.get() : Items.AIR;
    }

    @Override
    public boolean isSource(@NotNull FluidState state) {
        return false;
    }

    public static class Flowing extends PaleAleFluid {
        public Flowing() {
            super(FLUID_PROPERTIES);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        @Override
        @ParametersAreNonnullByDefault
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState state) {
            return false;
        }
    }

    public static class Source extends PaleAleFluid {
        public Source() {
            super(FLUID_PROPERTIES);
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(@NotNull FluidState state) {
            return true;
        }
    }

}