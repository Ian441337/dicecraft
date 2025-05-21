package ovh.glitchlabs.dicecraft.items.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResultHolder;

import java.util.List;


public class DiceInspectorItem extends Item {
    public DiceInspectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            Vec3 eyePos = player.getEyePosition();
            Vec3 lookVec = player.getLookAngle();
            double range = 5.0;
            Vec3 endPos = eyePos.add(lookVec.scale(range));
            
            // Erstelle eine Box entlang der Sichtlinie des Spielers
            AABB searchBox = new AABB(
                eyePos.x - 0.5, eyePos.y - 0.5, eyePos.z - 0.5,
                endPos.x + 0.5, endPos.y + 0.5, endPos.z + 0.5
            );
            
            // Suche nach Spielern in dieser Box
            List<Entity> entities = level.getEntities(player, searchBox, 
                entity -> entity instanceof Player && entity != player);
            
            if (!entities.isEmpty()) {
                Entity nearestEntity = entities.get(0);
                if (nearestEntity instanceof Player targetPlayer) {
                    int lastRoll = DiceItem.getLastRoll(targetPlayer);
                    if (lastRoll != -1) {
                        player.displayClientMessage(Component.literal(
                            "Spieler " + targetPlayer.getName().getString() + 
                            " würfelte zuletzt eine " + lastRoll), true);
                    } else {
                        player.displayClientMessage(Component.literal(
                            "Spieler " + targetPlayer.getName().getString() + 
                            " hat noch nicht gewürfelt."), true);
                    }
                }
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
