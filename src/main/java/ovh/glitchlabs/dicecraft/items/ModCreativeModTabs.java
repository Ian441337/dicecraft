package ovh.glitchlabs.dicecraft.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ovh.glitchlabs.dicecraft.Dicecraft;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dicecraft.MODID);

    public static final Supplier<CreativeModeTab> DICECRAFT_TAB = CREATIVE_MODE_TAB.register("dicecraft_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DICE.get()))
                    .title(Component.translatable("creativetab.dicecraft.tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.POKER_CHIP_GREEN);
                        output.accept(ModItems.POKER_CHIP_BLACK);
                        output.accept(ModItems.POKER_CHIP_BLUE);
                        output.accept(ModItems.POKER_CHIP_CYAN);
                        output.accept(ModItems.POKER_CHIP_PURPLE);
                        output.accept(ModItems.POKER_CHIP_YELLOW);
                        output.accept(ModItems.POKER_CHIP_RED);
                        output.accept(ModItems.DICE);
                        output.accept(ModItems.CURSED_DICE);
                        output.accept(ModItems.LUCKY_DICE);
                        output.accept(ModItems.DICE_INSPECTOR);
                        output.accept(ModItems.COIN);
                        output.accept(ModItems.TRICK_COIN);
                        output.accept(ModItems.GOLDEN_LUCKY_CAT);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
