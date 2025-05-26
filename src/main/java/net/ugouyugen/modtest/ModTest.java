package net.ugouyugen.modtest;

import net.fabricmc.api.ModInitializer;

import net.ugouyugen.modtest.block.ModBlocks;
import net.ugouyugen.modtest.item.ModItemGroups;
import net.ugouyugen.modtest.item.ModItems;
import net.ugouyugen.modtest.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModTest implements ModInitializer {
	public static final String MOD_ID = "modtest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModPotions.registerModPotions();
	}
}