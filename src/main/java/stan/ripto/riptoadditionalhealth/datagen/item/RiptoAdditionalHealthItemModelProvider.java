package stan.ripto.riptoadditionalhealth.datagen.item;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;

public class RiptoAdditionalHealthItemModelProvider extends ItemModelProvider {
    public RiptoAdditionalHealthItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RiptoAdditionalHealth.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(RiptoAdditionalHealthItems.ADDITIONAL_HEART.get());
    }
}
