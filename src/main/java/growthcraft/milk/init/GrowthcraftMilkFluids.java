package growthcraft.milk.init;

import growthcraft.milk.shared.Reference;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GrowthcraftMilkFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(
            ForgeRegistries.FLUIDS, Reference.MODID
    );


    /*
        public static final RegistryObject<RiceWaterFluid.Source> RICE_WATER_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.RICE_WATER).get(FluidUtils.STILL), RiceWaterFluid.Source::new);
    public static final RegistryObject<RiceWaterFluid.Flowing> RICE_WATER_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.RICE_WATER).get(FluidUtils.FLOWING), RiceWaterFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> RICE_WATER_FLUID_BLOCK =
            GrowthcraftRiceBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.RICE_WATER).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(RICE_WATER_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

     */

    private GrowthcraftMilkFluids() {
        /* Prevent default public constructor */
    }
}
