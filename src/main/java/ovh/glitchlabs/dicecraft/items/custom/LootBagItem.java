package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Random;

public class LootBagItem extends Item {
    private static final Item[] POSSIBLE_LOOT = {
            Items.WOODEN_SWORD,
            Items.WOODEN_AXE,
            Items.LEATHER_HELMET,
            Items.LEATHER_CHESTPLATE,
            Items.LEATHER_LEGGINGS,
            Items.LEATHER_BOOTS,
            Items.BREAD,
            Items.APPLE,
            Items.COAL,
            Items.IRON_INGOT,
            Items.STRING,
            Items.STICK,
            Items.STONE
    };

    public LootBagItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            Random random = new Random();
            int itemCount = random.nextInt(3) + 1; // 1-3 Items

            for (int i = 0; i < itemCount; i++) {
                Item randomItem = POSSIBLE_LOOT[random.nextInt(POSSIBLE_LOOT.length)];
                ItemEntity itemEntity = new ItemEntity(
                    level,
                    player.getX(), player.getY(), player.getZ(),
                    new ItemStack(randomItem)
                );
                level.addFreshEntity(itemEntity);
            }


            itemStack.shrink(1);
        }

        return InteractionResultHolder.success(itemStack);
    }
}
