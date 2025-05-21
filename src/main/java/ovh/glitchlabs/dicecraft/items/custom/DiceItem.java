package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class DiceItem extends Item {
    public static final String LAST_ROLL_TAG = "LastRoll";

    public DiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Random random = new Random();
            int diceRoll;
            
            if (GoldenLuckyCatItem.hasLuckyCat(player)) {
                diceRoll = random.nextDouble() < 0.7 ?
                    random.nextInt(3) + 4 :
                    random.nextInt(3) + 1;
            } else {
                diceRoll = random.nextInt(6) + 1;
            }

            CompoundTag playerData = player.getPersistentData();
            playerData.putInt(LAST_ROLL_TAG, diceRoll);

            String prefix = GoldenLuckyCatItem.hasLuckyCat(player) ? "🐱 " : "";
            String suffix = GoldenLuckyCatItem.hasLuckyCat(player) ? " 🐱" : "";
            player.displayClientMessage(Component.literal(prefix + "- " + diceRoll + " -" + suffix), true);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    public static int getLastRoll(Player player) {
        CompoundTag playerData = player.getPersistentData();
        return playerData.contains(LAST_ROLL_TAG) ? playerData.getInt(LAST_ROLL_TAG) : -1;
    }
}
