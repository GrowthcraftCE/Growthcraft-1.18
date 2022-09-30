package growthcraft.apples.init;

import growthcraft.apiary.init.GrowthcraftApiaryBlocks;
import growthcraft.apples.fluid.AppleJuiceFluid;
import growthcraft.apples.shared.Reference;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftApplesFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(
            ForgeRegistries.FLUIDS, Reference.MODID
    );

    public static final RegistryObject<AppleJuiceFluid.Source> APPLE_JUICE_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_JUICE).get(FluidUtils.STILL), AppleJuiceFluid.Source::new);
    public static final RegistryObject<AppleJuiceFluid.Flowing> APPLE_JUICE_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_JUICE).get(FluidUtils.FLOWING), AppleJuiceFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> APPLE_JUICE_FLUID_BLOCK =
            GrowthcraftApiaryBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.APPLE_JUICE).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(APPLE_JUICE_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    private GrowthcraftApplesFluids() {
        /* Prevent default public constructor */
    }
}
