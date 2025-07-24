package stan.ripto.riptoadditionalhealth.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HealthDataProvider implements ICapabilitySerializable<CompoundTag> {
    private final HealthData healthData = new HealthData();
    private final LazyOptional<IHealthData> option = LazyOptional.of(() -> healthData);

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == RiptoAdditionalHealthCapabilities.INSTANCE ? option.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("health_count", healthData.getHealth());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        healthData.setHealth(nbt.getInt("health_count"));
    }
}
