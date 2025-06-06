package ovh.glitchlabs.dicecraft.datagen;

import net.minecraft.tags.BlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import ovh.glitchlabs.dicecraft.blocks.ModBlocks;
import ovh.glitchlabs.dicecraft.Dicecraft;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvidor extends BlockTagsProvider {
    public ModBlockTagProvidor(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Dicecraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }

}
