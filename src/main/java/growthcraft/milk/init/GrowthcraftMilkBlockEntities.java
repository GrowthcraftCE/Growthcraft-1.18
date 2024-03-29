package growthcraft.milk.init;

import growthcraft.milk.block.entity.*;
import growthcraft.milk.shared.Reference;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GrowthcraftMilkBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITIES, Reference.MODID
    );

    public static final RegistryObject<BlockEntityType<CheesePressBlockEntity>> CHEESE_PRESS_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.CHEESE_PRESS,
            () -> BlockEntityType.Builder.of(
                    CheesePressBlockEntity::new,
                    GrowthcraftMilkBlocks.CHEESE_PRESS.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<CheeseWheelBlockEntity>> CHEESE_WHEEL_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.CHEESE_WHEEL_TILE_ENTITY,
            () -> BlockEntityType.Builder.of(
                    CheeseWheelBlockEntity::new,
                    GrowthcraftMilkBlocks.APPENZELLER_CHEESE.get(),
                    GrowthcraftMilkBlocks.ASIAGO_CHEESE.get(),
                    GrowthcraftMilkBlocks.CASU_MARZU_CHEESE.get(),
                    GrowthcraftMilkBlocks.CHEDDAR_CHEESE.get(),
                    GrowthcraftMilkBlocks.EMMENTALER_CHEESE.get(),
                    GrowthcraftMilkBlocks.GORGONZOLA_CHEESE.get(),
                    GrowthcraftMilkBlocks.GOUDA_CHEESE.get(),
                    GrowthcraftMilkBlocks.MONTEREY_CHEESE.get(),
                    GrowthcraftMilkBlocks.PARMESAN_CHEESE.get(),
                    GrowthcraftMilkBlocks.PROVOLONE_CHEESE.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<ChurnBlockEntity>> CHURN_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.CHURN,
            () -> BlockEntityType.Builder.of(
                    ChurnBlockEntity::new,
                    GrowthcraftMilkBlocks.CHURN.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<MixingVatBlockEntity>> MIXING_VAT_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.MIXING_VAT,
            () -> BlockEntityType.Builder.of(
                    MixingVatBlockEntity::new,
                    GrowthcraftMilkBlocks.MIXING_VAT.get()
            ).build(null)
    );

    public static final RegistryObject<BlockEntityType<PancheonBlockEntity>> PANCHEON_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            Reference.UnlocalizedName.PANCHEON,
            () -> BlockEntityType.Builder.of(
                    PancheonBlockEntity::new,
                    GrowthcraftMilkBlocks.PANCHEON.get()
            ).build(null)
    );

    public GrowthcraftMilkBlockEntities() {
        /* Disable automatic default public constructor */
    }

}
