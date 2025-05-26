package net.ugouyugen.modtest.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.equipment.EquipmentType;
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
    //
    public static final Item GUIDITE_HELMET = register(
            "guidite_helmet",
            settings -> new ArmorItem(GuiditeArmorMaterial.INSTANCE, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(GuiditeArmorMaterial.BASE_DURABILITY))
    );
    public static final Item GUIDITE_CHESTPLATE = register(
            "guidite_chestplate",
            settings -> new ArmorItem(GuiditeArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(GuiditeArmorMaterial.BASE_DURABILITY))
    );
    public static final Item GUIDITE_LEGGINGS = register(
            "guidite_leggings",
            settings -> new ArmorItem(GuiditeArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(GuiditeArmorMaterial.BASE_DURABILITY))
    );
    public static final Item GUIDITE_BOOTS = register(
            "guidite_boots",
            settings -> new ArmorItem(GuiditeArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(GuiditeArmorMaterial.BASE_DURABILITY))
    );
    public static final Item GUIDITE_SWORD = register(
            "guidite_sword",
            settings -> new SwordItem(GuiditeToolMaterial.INSTANCE, 1f, 1f, settings),
            new Item.Settings()
    );
    public static final Item LIGHTNING_STICK = register(
            "lightning_stick",
            LightningStick::new,
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

    // initialize method
    public static void registerModItems() {
        ModTest.LOGGER.info("Registering ModItems for " + ModTest.MOD_ID);
        // register itemGroup
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(PINK_GARNET);
            itemGroup.add(GUIDITE_HELMET);
            itemGroup.add(GUIDITE_CHESTPLATE);
            itemGroup.add(GUIDITE_LEGGINGS);
            itemGroup.add(GUIDITE_BOOTS);
            itemGroup.add(GUIDITE_SWORD);
            itemGroup.add(LIGHTNING_STICK);
        });
    }
}
