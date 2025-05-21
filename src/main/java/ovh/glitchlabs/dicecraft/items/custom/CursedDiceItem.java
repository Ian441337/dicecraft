package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class CursedDiceItem extends DiceItem {
    public CursedDiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Random random = new Random();
            double cursedChance = GoldenLuckyCatItem.hasLuckyCat(player) ? 0.5 : 0.7;
            int roll = random.nextDouble() < cursedChance ?
                    random.nextInt(3) + 1 :
                    random.nextInt(3) + 4;

            player.getPersistentData().putInt(LAST_ROLL_TAG, roll);
            String prefix = GoldenLuckyCatItem.hasLuckyCat(player) ? "🐱" : "☠";
            player.displayClientMessage(Component.literal(prefix + " " + roll + " " + prefix), true);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
