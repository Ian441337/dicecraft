package ovh.glitchlabs.dicecraft.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import ovh.glitchlabs.dicecraft.Dicecraft;
import ovh.glitchlabs.dicecraft.items.ModItems;

public class ModItemProvidor extends ItemModelProvider {
    public ModItemProvidor(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Dicecraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.POKER_CHIP_GREEN.get());
        basicItem(ModItems.POKER_CHIP_BLACK.get());
        basicItem(ModItems.POKER_CHIP_BLUE.get());
        basicItem(ModItems.POKER_CHIP_YELLOW.get());
        basicItem(ModItems.POKER_CHIP_PURPLE.get());
        basicItem(ModItems.POKER_CHIP_RED.get());
        basicItem(ModItems.POKER_CHIP_CYAN.get());
        basicItem(ModItems.DICE.get());
        basicItem(ModItems.DICE_INSPECTOR.get());
        basicItem(ModItems.CURSED_DICE.get());
        basicItem(ModItems.LUCKY_DICE.get());
    }
}
