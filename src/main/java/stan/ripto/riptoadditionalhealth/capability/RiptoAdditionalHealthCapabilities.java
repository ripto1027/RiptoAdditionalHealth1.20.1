package stan.ripto.riptoadditionalhealth.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class RiptoAdditionalHealthCapabilities {
    public static final Capability<IHealthData> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
}
