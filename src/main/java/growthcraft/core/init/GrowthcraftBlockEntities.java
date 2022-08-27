package growthcraft.core.init;

import growthcraft.core.block.entity.RopeBlockEntity;
import growthcraft.core.shared.Reference;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITIES, Reference.MODID
    );

    public static final RegistryObject<BlockEntityType<RopeBlockEntity>> ROPE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.ROPE,
            () -> BlockEntityType.Builder.of(RopeBlockEntity::new,
                    GrowthcraftBlocks.ROPE_LINEN.get()
            ).build(null)
    );

    private GrowthcraftBlockEntities() {
        /* Disable automatic default public constructor */
    }
}
