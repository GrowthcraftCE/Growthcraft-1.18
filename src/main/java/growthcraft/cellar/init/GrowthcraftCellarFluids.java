package growthcraft.cellar.init;

import growthcraft.cellar.fluid.AmberAleFluid;
import growthcraft.cellar.shared.Reference;
import growthcraft.lib.utils.FluidUtils;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftCellarFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(
            ForgeRegistries.FLUIDS, Reference.MODID
    );

    public static final RegistryObject<AmberAleFluid.Source> AMBER_ALE_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_ALE).get(FluidUtils.STILL), AmberAleFluid.Source::new);
    public static final RegistryObject<AmberAleFluid.Flowing> AMBER_ALE_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_ALE).get(FluidUtils.FLOWING), AmberAleFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> AMBER_ALE_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_ALE).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(AMBER_ALE_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    private GrowthcraftCellarFluids() {
        /* Prevent default public constructor */
    }
}
