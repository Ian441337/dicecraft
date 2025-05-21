package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TrickCoinItem extends Item {
    public TrickCoinItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            String catPrefix = GoldenLuckyCatItem.hasLuckyCat(player) ? "🐱 " : "";
            String catSuffix = GoldenLuckyCatItem.hasLuckyCat(player) ? " 🐱" : "";
            
            player.displayClientMessage(Component.literal(
                catPrefix + "⚪ Kopf ⚪" + catSuffix + " ✨"), true);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
