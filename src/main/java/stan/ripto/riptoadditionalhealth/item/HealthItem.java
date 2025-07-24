package stan.ripto.riptoadditionalhealth.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import stan.ripto.riptoadditionalhealth.capability.RiptoAdditionalHealthCapabilities;
import stan.ripto.riptoadditionalhealth.util.HealthUtils;

import java.util.UUID;

public class HealthItem extends Item {
    public static final UUID UUID_ADDITIONAL_HEALTH = UUID.fromString("63fdd274-76a0-4686-9398-b98162b1019d");

    public HealthItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide() && !pPlayer.isCreative()) {
            int count = stack.getCount();
            pPlayer.getCapability(RiptoAdditionalHealthCapabilities.INSTANCE).ifPresent(data -> {
                data.addHealth(count);
                HealthUtils.syncPlayerHealth(pPlayer);
                pPlayer.heal((float) count * 2);
            });
            stack.shrink(count);
            return InteractionResultHolder.success(stack);
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }
}
