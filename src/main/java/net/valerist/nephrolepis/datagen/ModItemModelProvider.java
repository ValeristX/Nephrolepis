package net.valerist.nephrolepis.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.valerist.nephrolepis.Nephrolepis;
import net.valerist.nephrolepis.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Nephrolepis.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FERN_LEAF.get());
    }
}
