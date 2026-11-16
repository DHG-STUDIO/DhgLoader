package com.ptk671.dhgloader.fabric;

import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BuildItem {

    public static ExtendVanilaItem build(DhgItem item) {
        Item.Settings settings = new Item.Settings();
        settings.maxCount(item.getSettings().getMaxCount());
        ExtendVanilaItem buildedItem = new ExtendVanilaItem(settings);
        item.setMcItem(buildedItem);

        if (item.getSettings().getDhgItemGroup() != null) {
            ItemGroupEvents.modifyEntriesEvent(item.getSettings().getDhgItemGroup().getRegistryKey()).register(group -> {

                group.add(buildedItem);
            });
        }
        return buildedItem;
    }
}