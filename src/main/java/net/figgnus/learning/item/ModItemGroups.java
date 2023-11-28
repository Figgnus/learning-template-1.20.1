package net.figgnus.learning.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.figgnus.learning.Learning;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Learning.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
            .icon(()-> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                entries.add(ModItems.RUBY);
                entries.add(ModItems.RAW_RUBY);

            }).build());

    public static void registerItemGroups(){
        Learning.LOGGER.info("Registering Item Groups " + Learning.MOD_ID);
    }
}