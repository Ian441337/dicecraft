package ovh.glitchlabs.dicecraft.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ovh.glitchlabs.dicecraft.Dicecraft;
import ovh.glitchlabs.dicecraft.blocks.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, Dicecraft.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, Dicecraft.MODID);

    public static final Holder<PoiType> CASINO_POI = POI_TYPES.register("casino_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.BEDROCK.getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> CASINO = VILLAGER_PROFESSIONS.register("casino",
            () -> new VillagerProfession("casino", holder -> holder.value() == CASINO_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == CASINO_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.IRON_DOOR_CLOSE));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
