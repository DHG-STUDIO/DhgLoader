package com.ptk671.dhgloader.api.registry;

import com.ptk671.dhgloader.api.Build;
import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.DhgItemGroup;

import java.util.function.Consumer;

public class DhgRegistry {

    public static Consumer<DhgItem> regItem;
    public static Consumer<DhgItemGroup> regItemGroup;


    //Not Good Code↓(OLD)
    @Deprecated
    public static void register(CompatDhgRegistry registry) {

        //DhgLoader.registries.add(registry);

    }

    public static void registerItem(DhgItem item) {
        regItem.accept(item);

    }

    public static void registerItemGroup(DhgItemGroup dhgItemGroup) {
        Build.buildItemGroup.apply(dhgItemGroup);
        regItemGroup.accept(dhgItemGroup);

    }

}
