package stan.ripto.riptoadditionalhealth.tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;

public class RiptoAdditionalHealthTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RiptoAdditionalHealth.MODID);

    public static final RegistryObject<CreativeModeTab> MY_TAB =
            TABS.register(
                    "ripto_additional_health_tab",
                    () -> CreativeModeTab
                            .builder()
                            .title(Component.literal("Ripto Additional Health"))
                            .icon(RiptoAdditionalHealthItems.ADDITIONAL_HEART.get()::getDefaultInstance)
                            .displayItems((pParameters, pOutput) ->
                                    pOutput.accept(RiptoAdditionalHealthItems.ADDITIONAL_HEART.get()))
                            .build());
}
