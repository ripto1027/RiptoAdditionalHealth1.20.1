package stan.ripto.riptoadditionalhealth.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;

public class RiptoAdditionalHealthLootModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, RiptoAdditionalHealth.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
                                            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);
}
