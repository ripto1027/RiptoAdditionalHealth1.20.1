package stan.ripto.riptoadditionalhealth.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import stan.ripto.riptoadditionalhealth.capability.HealthDataProvider;
import stan.ripto.riptoadditionalhealth.util.HealthUtils;

public class RiptoAdditionalHealthCommands {
    private static final String MESSAGE_COMMAND_SUCCESS_KEY = "message.command.result.riptoadditionalhealth.success";
    private static final String MESSAGE_COMMAND_FAIL_KEY = "message.command.result.riptoadditionalhealth.fail";

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("health_reset")
                .executes(context -> {
                    Player player = context.getSource().getPlayerOrException();
                    player.getCapability(HealthDataProvider.INSTANCE).ifPresent(data -> {
                        if (data.getHealth() > 0) {
                            data.setHealth(0);
                            player.setHealth(20.0F);
                            HealthUtils.syncPlayerHealth(player);
                            context.getSource().sendSuccess(() -> Component.translatable(MESSAGE_COMMAND_SUCCESS_KEY), true);
                        } else {
                            context.getSource().sendFailure(Component.translatable(MESSAGE_COMMAND_FAIL_KEY));
                        }
                    });
                    return 1;
                }));
    }

    public static String getSuccessKey() {
        return MESSAGE_COMMAND_SUCCESS_KEY;
    }

    public static String getFailKey() {
        return MESSAGE_COMMAND_FAIL_KEY;
    }
}
