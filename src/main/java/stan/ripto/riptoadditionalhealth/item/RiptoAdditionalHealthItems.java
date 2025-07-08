package stan.ripto.riptoadditionalhealth.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;

public class RiptoAdditionalHealthItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RiptoAdditionalHealth.MODID);

    public static final RegistryObject<Item> ADDITIONAL_HEART = ITEMS.register("additional_heart", () -> new HealthItem(new Item.Properties()));
}
