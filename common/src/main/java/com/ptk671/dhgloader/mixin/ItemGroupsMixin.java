package com.ptk671.dhgloader.mixin;

import com.ptk671.dhgloader.api.item.VanilaItemGroups;
import com.ptk671.dhgloader.api.item.ItemGroupWarpper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemGroups.class)

public class ItemGroupsMixin {


    @Shadow @Final private static RegistryKey<ItemGroup> BUILDING_BLOCKS;
    @Shadow @Final private static RegistryKey<ItemGroup> NATURAL;
    @Shadow @Final private static RegistryKey<ItemGroup> COLORED_BLOCKS;
    @Shadow @Final private static RegistryKey<ItemGroup> FUNCTIONAL;
    @Shadow @Final private static RegistryKey<ItemGroup> REDSTONE;
    @Shadow @Final private static RegistryKey<ItemGroup> HOTBAR;
    @Shadow @Final private static RegistryKey<ItemGroup> SEARCH;
    @Shadow @Final private static RegistryKey<ItemGroup> TOOLS;
    @Shadow @Final private static RegistryKey<ItemGroup> COMBAT;
    @Shadow @Final private static RegistryKey<ItemGroup> FOOD_AND_DRINK;
    @Shadow @Final private static RegistryKey<ItemGroup> INGREDIENTS;
    @Shadow @Final private static RegistryKey<ItemGroup> SPAWN_EGGS;
    @Shadow @Final private static RegistryKey<ItemGroup> OPERATOR;
    @Shadow @Final private static RegistryKey<ItemGroup> INVENTORY;

    @Inject(method = "registerAndGetDefault", at = @At("HEAD"))
     private static void registerAndGetDefault(Registry<ItemGroup> registry, CallbackInfoReturnable<ItemGroup> cir) {

        VanilaItemGroups.BUILDING_BLOCKS = new ItemGroupWarpper(BUILDING_BLOCKS);
        VanilaItemGroups.COLORED_BLOCKS = new ItemGroupWarpper(COLORED_BLOCKS);
        VanilaItemGroups.NATURAL = new ItemGroupWarpper(NATURAL);
        VanilaItemGroups.FUNCTIONAL = new ItemGroupWarpper(FUNCTIONAL);
        VanilaItemGroups.REDSTONE = new ItemGroupWarpper(REDSTONE);
        VanilaItemGroups.HOTBAR = new ItemGroupWarpper(HOTBAR);
        VanilaItemGroups.SEARCH = new ItemGroupWarpper(SEARCH);
        VanilaItemGroups.TOOLS = new ItemGroupWarpper(TOOLS);
        VanilaItemGroups.COMBAT = new ItemGroupWarpper(COMBAT);
        VanilaItemGroups.FOOD_AND_DRINK = new ItemGroupWarpper(FOOD_AND_DRINK);
        VanilaItemGroups.INGREDIENTS = new ItemGroupWarpper(INGREDIENTS);
        VanilaItemGroups.SPAWN_EGGS = new ItemGroupWarpper(SPAWN_EGGS);
        VanilaItemGroups.OPERATOR = new ItemGroupWarpper(OPERATOR);
        VanilaItemGroups.INVENTORY = new ItemGroupWarpper(INVENTORY);


    }


}
