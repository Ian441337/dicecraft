package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class CoinItem extends Item {
    public CoinItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Random random = new Random();
            boolean isHeads = random.nextBoolean();

            String result = isHeads ? "Kopf" : "Zahl";
            String symbol = isHeads ? "⚪" : "⚫";

            player.displayClientMessage(Component.literal(symbol + " " + result + " " + symbol), true);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
