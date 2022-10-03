package growthcraft.rice.init;

import growthcraft.apples.shared.Reference;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GrowthcraftRiceFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(
            ForgeRegistries.FLUIDS, Reference.MODID
    );

    // Rice Water

    // Sake

    private GrowthcraftRiceFluids() {
        /* Prevent default public constructor */
    }
}
