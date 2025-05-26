package net.ugouyugen.modtest.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.ugouyugen.modtest.ModTest;

import java.util.Map;

public class GuiditeArmorMaterial {

    // base durability:the durability of all items created by this Material
    public static final int BASE_DURABILITY = 15;

    // RegistryKey of EquipmentAsset named "guidite", not ArmorMaterial
    public static final RegistryKey<EquipmentAsset> GUIDITE_ARMOR_MATERIAL_KEY = RegistryKey.of(
            EquipmentAssetKeys.REGISTRY_KEY,
            Identifier.of(ModTest.MOD_ID, "guidite"));

    // define new Item Tags that can be used to repair equipments made with this material
    public static final TagKey<Item> REPAIRS_GUIDITE_ARMOR = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(ModTest.MOD_ID, "guidite"));

    // Inctance of ArmorMaterial made with this GuiditeArmorMaterial data
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_GUIDITE_ARMOR,
            GUIDITE_ARMOR_MATERIAL_KEY
            );
}