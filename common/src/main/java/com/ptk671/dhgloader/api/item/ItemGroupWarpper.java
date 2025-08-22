package com.ptk671.dhgloader.api.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;

public class ItemGroupWarpper {
    private ItemGroup itemGroup;
    private RegistryKey<ItemGroup> itemGroupRegistryKey;

    public ItemGroupWarpper(ItemGroup itemGroup){

        this.itemGroup = itemGroup;
    }

    public ItemGroupWarpper(RegistryKey<ItemGroup> itemGroup){

        this.itemGroup = Registries.ITEM_GROUP.get(itemGroup);
        this.itemGroupRegistryKey = itemGroup;
    }

    public ItemGroup getItemGroup ()  {
        return itemGroup;
    }

    public RegistryKey<ItemGroup> getItemGroupRegistryKey ()  {
        return itemGroupRegistryKey;
    }
}
