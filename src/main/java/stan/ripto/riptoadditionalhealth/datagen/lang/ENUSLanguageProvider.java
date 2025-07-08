package stan.ripto.riptoadditionalhealth.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.command.RiptoAdditionalHealthCommands;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, RiptoAdditionalHealth.MODID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(RiptoAdditionalHealthItems.ADDITIONAL_HEART, "Additional Heart");
        add(RiptoAdditionalHealthCommands.getSuccessKey(), "Health has been reset successfully.");
        add(RiptoAdditionalHealthCommands.getFailKey(), "Failed to reset health.");
    }
}
