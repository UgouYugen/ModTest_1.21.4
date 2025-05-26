package net.ugouyugen.modtest.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ugouyugen.modtest.ModTest;
import net.ugouyugen.modtest.effect.TaterEffect;

public class ModPotions {
    public static final Potion TATER_POTION = Registry.register(
            Registries.POTION,
            Identifier.of(ModTest.MOD_ID, "tater"),
            new Potion("tater", new StatusEffectInstance(
                    TaterEffect.TATER,
                    3600, 0
            ))
    );

    public static void registerModPotions() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    // Input potion.
                    Potions.WATER,
                    // Ingredient
                    Items.POTATO,
                    // Output potion.
                    Registries.POTION.getEntry(TATER_POTION)
            );
        });
    }
}
