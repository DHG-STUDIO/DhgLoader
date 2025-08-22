package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import net.minecraft.item.Item;

public class BuildItemImpl {
    public static ExtendVanilaItem build(DhgItem item){

        Item.Settings settings = new Item.Settings();
        settings.maxCount(item.getSettings().getMaxCount());
        ExtendVanilaItem buildedItem;
        buildedItem = new ExtendVanilaItem(settings);
        item.setMcItem(buildedItem);
        return buildedItem;
    }
}
