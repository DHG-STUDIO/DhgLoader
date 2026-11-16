package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.api.item.DhgItemGroup;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import java.util.function.Supplier;

public class QueueTabAddItem {

    private final Supplier<ExtendVanilaItem> item;
    private Supplier<ItemGroup> itemGroup;
    private DhgItemGroup dhgItemGroup;
    private boolean isVanila = false;
    public QueueTabAddItem(Supplier<ExtendVanilaItem> item, DhgItemGroup dhgItemGroup) {
        this.item = item;
        this.dhgItemGroup = dhgItemGroup;
        this.itemGroup = dhgItemGroup::getItemGroup;
        this.isVanila = false;
    }

    public QueueTabAddItem(Supplier<ExtendVanilaItem> item, ItemGroup itemGroup) {
        this.item = item;
        this.itemGroup = () -> itemGroup;
        this.isVanila = true;
    }

    public Supplier<ExtendVanilaItem> getItem() {
        return  item;
    }

    public ItemGroup getItemGroup() {
        return dhgItemGroup.getItemGroup();
    }
}
