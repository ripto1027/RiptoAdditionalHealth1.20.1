package stan.ripto.riptoadditionalhealth.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.command.RiptoAdditionalHealthCommands;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, RiptoAdditionalHealth.MODID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(RiptoAdditionalHealthItems.ADDITIONAL_HEART, "アディショナルハート");
        add(RiptoAdditionalHealthCommands.getSuccessKey(), "体力が正常にリセットされました。");
        add(RiptoAdditionalHealthCommands.getFailKey(), "体力のリセットに失敗しました。");
    }
}
