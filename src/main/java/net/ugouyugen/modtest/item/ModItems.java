package net.ugouyugen.modtest.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.ugouyugen.modtest.ModTest;

import java.util.function.Function;

public class ModItems {

    // Item instance is defined as constant singleton value
    public static final Item PINK_GARNET = register(
            "pink_garnet",
            Item::new,
            new Item.Settings()
    );

    // register method of Item Object
    public static Item register(
            // name:String id
            String name,
            // itemFactory:Function to create Item instance
            Function<Item.Settings, Item> itemFactory,
            // settings:Settings to be passed to itemFactory
            Item.Settings settings) {
        // create RegistryKey for "Item Registry"
        RegistryKey<Item> itemKey = RegistryKey.of(
                // Registry type
                RegistryKeys.ITEM,
                // id, which has modId(as NameSpace) and String name
                Identifier.of(ModTest.MOD_ID, name));
        // create Item instance with Item.Settings and RegistryKey
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        // register Item Object to Item Registry
        Registry.register(Registries.ITEM, itemKey, item);
        // return this Item instance
        return item;
    }

    // initialize method, which is to be passed onInitialize method of ModTest class
    public static void registerModItems() {
        ModTest.LOGGER.info("Registering ModItems for" + ModTest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> {
            itemGroup.add(PINK_GARNET);
        });
    }
}
