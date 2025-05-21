package ovh.glitchlabs.dicecraft.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ovh.glitchlabs.dicecraft.Dicecraft;
import ovh.glitchlabs.dicecraft.items.custom.CursedDiceItem;
import ovh.glitchlabs.dicecraft.items.custom.DiceInspectorItem;
import ovh.glitchlabs.dicecraft.items.custom.DiceItem;
import ovh.glitchlabs.dicecraft.items.custom.LootBagItem;
import ovh.glitchlabs.dicecraft.items.custom.LuckyDiceItem;
import ovh.glitchlabs.dicecraft.items.custom.CoinItem;
import ovh.glitchlabs.dicecraft.items.custom.GoldenLuckyCatItem;
import ovh.glitchlabs.dicecraft.items.custom.TrickCoinItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Dicecraft.MODID);

    public static final DeferredItem<Item> POKER_CHIP_GREEN = ITEMS.register("poker_chip_green",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_BLUE = ITEMS.register("poker_chip_blue",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_CYAN = ITEMS.register("poker_chip_cyan",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_PURPLE = ITEMS.register("poker_chip_purple",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_RED = ITEMS.register("poker_chip_red",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_YELLOW = ITEMS.register("poker_chip_yellow",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POKER_CHIP_BLACK = ITEMS.register("poker_chip_black",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties()));

    public static final DeferredItem<Item> CURSED_DICE = ITEMS.register("cursed_dice",
            () -> new CursedDiceItem(new Item.Properties()));

    public static final DeferredItem<Item> LUCKY_DICE = ITEMS.register("lucky_dice",
            () -> new LuckyDiceItem(new Item.Properties()));

    public static final DeferredItem<Item> DICE_INSPECTOR = ITEMS.register("dice_inspector",
            () -> new DiceInspectorItem(new Item.Properties()));

    public static final DeferredItem<Item> COIN = ITEMS.register("coin",
            () -> new CoinItem(new Item.Properties()));

    public static final DeferredItem<Item> LOOT_BAG = ITEMS.register("loot_bag",
            () -> new LootBagItem(new Item.Properties()));

    public static final DeferredItem<Item> GOLDEN_LUCKY_CAT = ITEMS.register("golden_lucky_cat",
            () -> new GoldenLuckyCatItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> TRICK_COIN = ITEMS.register("trick_coin",
            () -> new TrickCoinItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
};
