package stan.ripto.riptoadditionalhealth;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import stan.ripto.riptoadditionalhealth.capability.IHealthData;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;
import stan.ripto.riptoadditionalhealth.loot.RiptoAdditionalHealthLootModifier;
import stan.ripto.riptoadditionalhealth.tab.RiptoAdditionalHealthTabs;

@Mod(RiptoAdditionalHealth.MODID)
public class RiptoAdditionalHealth {
    public static final String MODID = "riptoadditionalhealth";

    public RiptoAdditionalHealth(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        RiptoAdditionalHealthItems.ITEMS.register(bus);
        RiptoAdditionalHealthTabs.TABS.register(bus);
        RiptoAdditionalHealthLootModifier.LOOT_MODIFIER_SERIALIZERS.register(bus);
        bus.addListener(this::onRegisterCapabilities);
    }

    public void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IHealthData.class);
    }
}
