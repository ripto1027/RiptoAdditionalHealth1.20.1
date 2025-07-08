package stan.ripto.riptoadditionalhealth.event;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.capability.HealthDataProvider;
import stan.ripto.riptoadditionalhealth.command.RiptoAdditionalHealthCommands;
import stan.ripto.riptoadditionalhealth.util.HealthUtils;

@Mod.EventBusSubscriber(modid = RiptoAdditionalHealth.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RiptoAdditionalHealthForgeEvents {
    @SubscribeEvent
    public static void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        event.getEntity().getCapability(HealthDataProvider.INSTANCE).ifPresent(data -> HealthUtils.syncPlayerHealth(event.getEntity()));
    }

    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        event.getEntity().getCapability(HealthDataProvider.INSTANCE).ifPresent(data -> HealthUtils.syncPlayerHealth(event.getEntity()));
    }

    @SubscribeEvent
    public static void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        event.getEntity().getCapability(HealthDataProvider.INSTANCE).ifPresent(data -> HealthUtils.syncPlayerHealth(event.getEntity()));
    }

    @SubscribeEvent
    public static void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(ResourceLocation.fromNamespaceAndPath(RiptoAdditionalHealth.MODID, "health_count"), new HealthDataProvider());
        }
    }

    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(HealthDataProvider.INSTANCE)
                .ifPresent(o -> event.getEntity().getCapability(HealthDataProvider.INSTANCE)
                        .ifPresent(n -> {
                            if (event.isWasDeath()) {
                                n.setHealth(0);
                            } else {
                                n.setHealth(o.getHealth());
                            }
                        }));
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        RiptoAdditionalHealthCommands.register(dispatcher);
    }
}
