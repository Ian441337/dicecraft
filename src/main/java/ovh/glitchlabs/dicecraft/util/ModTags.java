package ovh.glitchlabs.dicecraft.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import ovh.glitchlabs.dicecraft.Dicecraft;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Dicecraft.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DICE = createTag("dice");
        public static final TagKey<Item> GAMBLING_ITEMS = createTag("gambling_items");
        public static final TagKey<Item> POKER_CHIPS = createTag("poker_chips");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Dicecraft.MODID, name));
        }
    }
}
