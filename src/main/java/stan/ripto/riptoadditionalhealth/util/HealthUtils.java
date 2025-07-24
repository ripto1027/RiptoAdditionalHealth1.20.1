package stan.ripto.riptoadditionalhealth.util;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import stan.ripto.riptoadditionalhealth.capability.RiptoAdditionalHealthCapabilities;
import stan.ripto.riptoadditionalhealth.item.HealthItem;

import java.util.UUID;

public class HealthUtils {
    public static void syncPlayerHealth(Player player) {
        player.getCapability(RiptoAdditionalHealthCapabilities.INSTANCE).ifPresent(data -> {
            double bonus = data.getHealth() * 2;
            AttributeInstance attribute = player.getAttribute(Attributes.MAX_HEALTH);
            UUID uuid = HealthItem.UUID_ADDITIONAL_HEALTH;
            if (attribute != null) {
                if (attribute.getModifier(uuid) != null) {
                    attribute.removeModifier(uuid);
                }
                if (bonus > 0) {
                    AttributeModifier modifier = new AttributeModifier(uuid, "health_bonus", bonus, AttributeModifier.Operation.ADDITION);
                    attribute.addPermanentModifier(modifier);
                }
            }
        });
    }
}
