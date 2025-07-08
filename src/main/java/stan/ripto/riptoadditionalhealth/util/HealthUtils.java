package stan.ripto.riptoadditionalhealth.util;

import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import stan.ripto.riptoadditionalhealth.capability.HealthDataProvider;

public class HealthUtils {
    public static void syncPlayerHealth(Player player) {
        player.getCapability(HealthDataProvider.INSTANCE).ifPresent(data -> {
            double base = 20.0 + data.getHealth() * 2;
            AttributeInstance attribute = player.getAttribute(Attributes.MAX_HEALTH);
            if (attribute != null) {
                attribute.setBaseValue(base);
            }
            if (player instanceof ServerPlayer p) {
                p.connection.send(new ClientboundSetHealthPacket(p.getHealth(), p.getFoodData().getFoodLevel(), p.getFoodData().getSaturationLevel()));
            }
        });
    }
}
