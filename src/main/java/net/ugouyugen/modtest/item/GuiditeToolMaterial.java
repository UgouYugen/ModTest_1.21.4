package net.ugouyugen.modtest.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class GuiditeToolMaterial {
    public static final ToolMaterial INSTANCE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            455,
            5.0F,
            1.5F,
            22,
            GuiditeArmorMaterial.REPAIRS_GUIDITE_ARMOR
    );
}
