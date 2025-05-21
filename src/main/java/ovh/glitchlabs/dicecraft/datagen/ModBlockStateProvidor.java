package ovh.glitchlabs.dicecraft.datagen;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import ovh.glitchlabs.dicecraft.Dicecraft;

public class ModBlockStateProvidor extends BlockStateProvider {
    public ModBlockStateProvidor(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Dicecraft.MODID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
    }

    private void BlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
