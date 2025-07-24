package stan.ripto.riptoadditionalhealth.datagen.global_loot;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import stan.ripto.riptoadditionalhealth.RiptoAdditionalHealth;
import stan.ripto.riptoadditionalhealth.item.RiptoAdditionalHealthItems;
import stan.ripto.riptoadditionalhealth.loot.AddItemModifier;

public class RiptoAdditionalHealthGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public RiptoAdditionalHealthGlobalLootModifierProvider(PackOutput output) {
        super(output, RiptoAdditionalHealth.MODID);
    }

    @Override
    protected void start() {
        add(EntityType.ZOMBIE);
        add(EntityType.SKELETON);
        add(EntityType.CREEPER);
        add(EntityType.SPIDER);
        add(EntityType.ENDERMAN);
        add(EntityType.DROWNED);
        add(EntityType.STRAY);
        add(EntityType.BLAZE);
        add(EntityType.CAVE_SPIDER);
        add(EntityType.ELDER_GUARDIAN, 0.5F);
        add(EntityType.ENDER_DRAGON, 1.0F);
        add(EntityType.ENDERMITE);
        add(EntityType.EVOKER, 0.3F);
        add(EntityType.GHAST, 0.1F);
        add(EntityType.GUARDIAN);
        add(EntityType.HOGLIN);
        add(EntityType.HUSK);
        add(EntityType.ILLUSIONER, 0.3F);
        add(EntityType.IRON_GOLEM, 0.1F);
        add(EntityType.MAGMA_CUBE);
        add(EntityType.PHANTOM);
        add(EntityType.PIGLIN);
        add(EntityType.PIGLIN_BRUTE, 0.1F);
        add(EntityType.PILLAGER);
        add(EntityType.RAVAGER, 0.5F);
        add(EntityType.SHULKER);
        add(EntityType.SILVERFISH);
        add(EntityType.SLIME);
        add(EntityType.VINDICATOR);
        add(EntityType.WARDEN, 1.0F);
        add(EntityType.WITCH);
        add(EntityType.WITHER, 1.0F);
        add(EntityType.WITHER_SKELETON);
        add(EntityType.ZOGLIN);
        add(EntityType.ZOMBIE_VILLAGER);
        add(EntityType.ZOMBIFIED_PIGLIN);
    }

    private void add(EntityType<?> entity, float rate) {
        String name = EntityType.getKey(entity).getPath();
        add(
                "additional_heart_from_" + name,
                new AddItemModifier(
                        new LootItemCondition[]{
                                new LootTableIdCondition.Builder(ResourceLocation.parse("entities/" + name)).build(),
                                LootItemKilledByPlayerCondition.killedByPlayer().build(),
                                LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(rate, 0.03F).build()
                        },
                        RiptoAdditionalHealthItems.ADDITIONAL_HEART.get()
                )
        );
    }

    private void add(EntityType<?> entity) {
        add(entity, 0.01F);
    }
}
