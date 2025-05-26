package net.ugouyugen.modtest.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.ugouyugen.modtest.ModTest;
import net.ugouyugen.modtest.item.ModItemGroups;

import java.util.function.Function;

public class ModBlocks {

    // CONDENSED_DIRT:all the same image of six surfaces
    public static final Block CONDENSED_DIRT = register(
            "condensed_dirt",
            Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(1.0f, 6.0f)
                    .requiresTool(),
            true
    );
    // CONDENSED_OAK_LOG: This block has different images between top and side.
    public static final Block CONDENSED_OAK_LOG = register(
            "condensed_oak_log",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD),
            true
    );

    // register method of Block Object
    public static Block register(
            // name:String id
            String name,
            // blockFactory:Function to create Block instance
            Function<AbstractBlock.Settings, Block> blockFactory,
            // settings:Settings to be passed to blockFactory
            AbstractBlock.Settings settings,
            // shouldRegisterItem:a flag for the check of BlockItem
            boolean shouldRegisterItem) {
        // blockKey:RegistryKey for Block instance
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // block:block instance, not BlockItem instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        // whether register BlockItem object for this block or not
        if (shouldRegisterItem) {
            // itemKey:RegistryKey for Item instance, not BlockItem
            RegistryKey<Item> itemKey = keyOfItem(name);
            // blockItem:BlockItem instance for this block
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            // register BlockItem instance to ITEM Registry
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        // register Block instance to BLOCK Registry
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    // helper method:create RegistryKey of Block
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ModTest.MOD_ID, name));
    }

    // helper method:create RegistryKey of Item
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ModTest.MOD_ID, name));
    }

    // initialize method
    public static void registerModBlocks() {
        ModTest.LOGGER.info("Registering ModBlocks for " + ModTest.MOD_ID);
        // register itemGroup
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CONDENSED_DIRT);
            itemGroup.add(CONDENSED_OAK_LOG);
        });
    }
}
