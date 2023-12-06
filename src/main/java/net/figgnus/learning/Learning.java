package net.figgnus.learning;

import net.fabricmc.api.ModInitializer;

import net.figgnus.learning.block.ModBlocks;
import net.figgnus.learning.item.ModItemGroups;
import net.figgnus.learning.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Learning implements ModInitializer {
	public static final String MOD_ID = "learning";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}