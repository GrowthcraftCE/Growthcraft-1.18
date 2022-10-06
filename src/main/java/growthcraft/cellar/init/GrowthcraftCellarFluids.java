package growthcraft.cellar.init;

import growthcraft.cellar.fluid.*;
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

    public static final RegistryObject<AmberLagerFluid.Source> AMBER_LAGER_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_LAGER).get(FluidUtils.STILL), AmberLagerFluid.Source::new);
    public static final RegistryObject<AmberLagerFluid.Flowing> AMBER_LAGER_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_LAGER).get(FluidUtils.FLOWING), AmberLagerFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> AMBER_LAGER_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_LAGER).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(AMBER_LAGER_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<AmberWortFluid.Source> AMBER_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_WORT).get(FluidUtils.STILL), AmberWortFluid.Source::new);
    public static final RegistryObject<AmberWortFluid.Flowing> AMBER_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_WORT).get(FluidUtils.FLOWING), AmberWortFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> AMBER_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.AMBER_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(AMBER_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<BrownAleFluid.Source> BROWN_ALE_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_ALE).get(FluidUtils.STILL), BrownAleFluid.Source::new);
    public static final RegistryObject<BrownAleFluid.Flowing> BROWN_ALE_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_ALE).get(FluidUtils.FLOWING), BrownAleFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> BROWN_ALE_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_ALE).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(BROWN_ALE_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<BrownLagerFluid.Source> BROWN_LAGER_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_LAGER).get(FluidUtils.STILL), BrownLagerFluid.Source::new);
    public static final RegistryObject<BrownLagerFluid.Flowing> BROWN_LAGER_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_LAGER).get(FluidUtils.FLOWING), BrownLagerFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> BROWN_LAGER_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_LAGER).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(BROWN_LAGER_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<BrownWortFluid.Source> BROWN_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_WORT).get(FluidUtils.STILL), BrownWortFluid.Source::new);
    public static final RegistryObject<BrownWortFluid.Flowing> BROWN_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_WORT).get(FluidUtils.FLOWING), BrownWortFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> BROWN_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.BROWN_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(BROWN_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<CopperAleFluid.Source> COPPER_ALE_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_ALE).get(FluidUtils.STILL), CopperAleFluid.Source::new);
    public static final RegistryObject<CopperAleFluid.Flowing> COPPER_ALE_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_ALE).get(FluidUtils.FLOWING), CopperAleFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> COPPER_ALE_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_ALE).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(COPPER_ALE_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<CopperLagerFluid.Source> COPPER_LAGER_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_LAGER).get(FluidUtils.STILL), CopperLagerFluid.Source::new);
    public static final RegistryObject<CopperLagerFluid.Flowing> COPPER_LAGER_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_LAGER).get(FluidUtils.FLOWING), CopperLagerFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> COPPER_LAGER_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_LAGER).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(COPPER_LAGER_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<CopperWortFluid.Source> COPPER_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_WORT).get(FluidUtils.STILL), CopperWortFluid.Source::new);
    public static final RegistryObject<CopperWortFluid.Flowing> COPPER_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_WORT).get(FluidUtils.FLOWING), CopperWortFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> COPPER_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.COPPER_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(COPPER_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<DarkLagerFluid.Source> DARK_LAGER_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_LAGER).get(FluidUtils.STILL), DarkLagerFluid.Source::new);
    public static final RegistryObject<DarkLagerFluid.Flowing> DARK_LAGER_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_LAGER).get(FluidUtils.FLOWING), DarkLagerFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> DARK_LAGER_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_LAGER).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(DARK_LAGER_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<DarkWortFluid.Source> DARK_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_WORT).get(FluidUtils.STILL), DarkWortFluid.Source::new);
    public static final RegistryObject<DarkWortFluid.Flowing> DARK_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_WORT).get(FluidUtils.FLOWING), DarkWortFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> DARK_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.DARK_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(DARK_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<DeepAmberWort.Source> DEEP_AMBER_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_AMBER_WORT).get(FluidUtils.STILL), DeepAmberWort.Source::new);
    public static final RegistryObject<DeepAmberWort.Flowing> DEEP_AMBER_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_AMBER_WORT).get(FluidUtils.FLOWING), DeepAmberWort.Flowing::new);
    public static final RegistryObject<LiquidBlock> DEEP_AMBER_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_AMBER_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(DEEP_AMBER_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<DeepCopperWort.Source> DEEP_COPPER_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_COPPER_WORT).get(FluidUtils.STILL), DeepCopperWort.Source::new);
    public static final RegistryObject<DeepCopperWort.Flowing> DEEP_COPPER_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_COPPER_WORT).get(FluidUtils.FLOWING), DeepCopperWort.Flowing::new);
    public static final RegistryObject<LiquidBlock> DEEP_COPPER_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.DEEP_COPPER_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(DEEP_COPPER_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<GoldenWort.Source> GOLDEN_WORT_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.GOLDEN_WORT).get(FluidUtils.STILL), GoldenWort.Source::new);
    public static final RegistryObject<GoldenWort.Flowing> GOLDEN_WORT_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.GOLDEN_WORT).get(FluidUtils.FLOWING), GoldenWort.Flowing::new);
    public static final RegistryObject<LiquidBlock> GOLDEN_WORT_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.GOLDEN_WORT).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(GOLDEN_WORT_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    public static final RegistryObject<IpaAleFluid.Source> IPA_ALE_FLUID_STILL = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.IPA_ALE).get(FluidUtils.STILL), IpaAleFluid.Source::new);
    public static final RegistryObject<IpaAleFluid.Flowing> IPA_ALE_FLUID_FLOWING = FLUIDS.register(
            FluidUtils.getFluidNames(Reference.UnlocalizedName.IPA_ALE).get(FluidUtils.FLOWING), IpaAleFluid.Flowing::new);
    public static final RegistryObject<LiquidBlock> IPA_ALE_FLUID_BLOCK =
            GrowthcraftCellarBlocks.BLOCKS.register(FluidUtils.getFluidNames(Reference.UnlocalizedName.IPA_ALE).get(FluidUtils.BLOCK),
                    () -> new LiquidBlock(IPA_ALE_FLUID_STILL, BlockBehaviour.Properties.of(Material.WATER)));

    private GrowthcraftCellarFluids() {
        /* Prevent default public constructor */
    }
}
