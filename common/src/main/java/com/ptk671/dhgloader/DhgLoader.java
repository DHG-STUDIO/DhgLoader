package com.ptk671.dhgloader;

import com.ptk671.dhgloader.api.item.*;
import com.ptk671.dhgloader.api.registry.CompatDhgRegistry;
import com.ptk671.dhgloader.api.registry.DhgRegistry;
import com.ptk671.dhgloader.api.util.DhgIdentifier;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public final class DhgLoader {
    public static final String MOD_ID = "dhgloader";
    private static CompatDhgRegistry registry;
    public static List<CompatDhgRegistry> registries = new ArrayList<>();
    public static List<AddGroupHelper> addGroupHelper = new ArrayList<>();


    public static DhgItemGroup group = new DhgItemGroup(new DhgIdentifier("test","test_group")).icon(DhgLoader.test).appendItems(Items.STONE);
    public static DhgItem test = new DhgItem(DhgIdentifier.of("test","test"), new DhgItemSettings().maxCount(1).group(DhgLoader.group));

    public static void init() {
        //てすと
        registry = new CompatDhgRegistry();
        registry.registryItem(test);

        registry.registryItemGroup(group);

        DhgRegistry.register(registry);

    }
}


