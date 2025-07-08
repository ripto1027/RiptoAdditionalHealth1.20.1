package stan.ripto.riptoadditionalhealth.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.datagen.global_loot.RiptoAdditionalHealthGlobalLootModifierProvider;
import stan.ripto.riptoadditionalhealth.datagen.item.RiptoAdditionalHealthItemModelProvider;
import stan.ripto.riptoadditionalhealth.datagen.lang.ENUSLanguageProvider;
import stan.ripto.riptoadditionalhealth.datagen.lang.JAJPLanguageProvider;

@Mod.EventBusSubscriber(modid = RiptoAdditionalHealth.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RiptoAdditionalHealthDataGenerator {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(output));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(output));
        generator.addProvider(event.includeClient(), new RiptoAdditionalHealthItemModelProvider(output, efh));
        generator.addProvider(event.includeServer(), new RiptoAdditionalHealthGlobalLootModifierProvider(output));
    }
}
