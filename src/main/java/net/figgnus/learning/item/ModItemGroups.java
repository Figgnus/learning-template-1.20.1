package net.figgnus.learning.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.figgnus.learning.Learning;
import net.figgnus.learning.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //custom item group for new items/blocks

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Learning.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
            .icon(()-> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                entries.add(ModItems.RUBY);
                entries.add(ModItems.RAW_RUBY);
                entries.add(ModBlocks.RUBY_BLOCK);
                entries.add(ModBlocks.RAW_RUBY_BLOCK);
                entries.add(ModBlocks.RUBY_ORE);
                entries.add(ModBlocks.NETHER_RUBY_ORE);
                entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                entries.add(ModBlocks.END_RUBY_ORE);
                entries.add(ModItems.METAL_DETECTOR);
                entries.add(ModBlocks.SOUND_BLOCK);
                entries.add(ModItems.TOMATO);

            }).build());

    public static void registerItemGroups(){
        Learning.LOGGER.info("Registering Item Groups " + Learning.MOD_ID);
    }
}
