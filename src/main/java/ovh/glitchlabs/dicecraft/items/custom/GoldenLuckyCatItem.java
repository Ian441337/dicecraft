package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

public class GoldenLuckyCatItem extends Item {
    public GoldenLuckyCatItem(Properties properties) {
        super(properties);
    }

    public static boolean hasLuckyCat(Player player) {
        return player.getMainHandItem().getItem() instanceof GoldenLuckyCatItem ||
               player.getOffhandItem().getItem() instanceof GoldenLuckyCatItem;
    }
}
