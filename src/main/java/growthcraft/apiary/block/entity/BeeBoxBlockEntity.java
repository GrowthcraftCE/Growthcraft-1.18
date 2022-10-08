package growthcraft.apiary.block.entity;

import growthcraft.apiary.init.GrowthcraftApiaryItems;
import growthcraft.apiary.init.GrowthcraftApiaryTags;
import growthcraft.lib.utils.TickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BeeBoxBlockEntity extends BlockEntity implements BlockEntityTicker<BeeBoxBlockEntity>, MenuProvider {

    private final int TICK_MIN = TickUtils.toTicks(10, "seconds");
    private final int TICK_MAX = TickUtils.toTicks(1, "minutes");

    private int TICK_CLOCK = 0;
    private int TICK_COOLDOWN = 0;

    private Component customName;

    private final ItemStackHandler itemStackHandler = new ItemStackHandler(28) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return (slot == 0 && stack.is(GrowthcraftApiaryTags.Items.BEE)) ||
                    ( slot > 0 && slot <=27 && stack.is(GrowthcraftApiaryTags.Items.HONEY_COMB)) ;
        }
    };

    private LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.empty();

    public BeeBoxBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
        super(entityType, pos, state);
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.growthcraft_apiary.bee_box");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        // TODO: return new BeeBoxMenu(containerId, inventory, this);
        return null;
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState blockState, BeeBoxBlockEntity beeBoxBlockEntity) {
        // TODO: BeeBoxBlockEntity Ticking
    }

    private int getSlotWithVanillaHoneyComb() {
        for(int slotID = 1; slotID < this.itemStackHandler.getSlots(); slotID++) {
            if(this.itemStackHandler.getStackInSlot(slotID).getItem() == Items.HONEYCOMB) return slotID;
        }
        return -1;
    }

    private int getSlotWithEmptyHoneyComb() {
        for(int slotID = 1; slotID < this.itemStackHandler.getSlots(); slotID++) {
            if(this.itemStackHandler.getStackInSlot(slotID).getItem() == GrowthcraftApiaryItems.HONEY_COMB_EMPTY.get()) return slotID;
        }
        return -1;
    }

    private int getEmptySlot() {
        for(int slotID = 1; slotID < this.itemStackHandler.getSlots(); slotID++) {
            if(this.itemStackHandler.getStackInSlot(slotID).isEmpty()) return slotID;
        }
        return -1;
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.serializeNBT();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        this.load(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        if (nbt.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson(nbt.getString("CustomName"));
        }
        this.itemStackHandler.deserializeNBT(nbt.getCompound("inventory"));
        this.TICK_CLOCK = nbt.getInt("CurrentProcessTicks");
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    public void onLoad() {
        super.onLoad();
        itemHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);

        nbt.put("inventory", this.itemStackHandler.serializeNBT());

        if (this.customName != null) {
            nbt.putString("CustomName", Component.Serializer.toJson(this.customName));
        }

        nbt.putInt("CurrentProcessTicks", this.TICK_CLOCK);

    }

    private void tryReplicateFlower(BlockPos pos) {
        // TODO: tryReplicateFlower
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandlerLazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    public void dropItems() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.getLevel(), this.worldPosition, inventory);
    }

}
