package com.ptk671.dhgloader;

import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.DhgItemGroup;
import com.ptk671.dhgloader.api.item.DhgItemSettings;
import com.ptk671.dhgloader.api.item.VanilaItemGroups;
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
    public static DhgItem test = new DhgItem(DhgIdentifier.of("test","test"), new DhgItemSettings().maxCount(1).group(DhgLoader.group).group(VanilaItemGroups.BUILDING_BLOCKS));

    public static DhgItemGroup group = new DhgItemGroup(new DhgIdentifier("test","test_group")).icon(DhgLoader.test).appendItems(Items.STONE);

    public static void init() {
        //てすと
        registry = new CompatDhgRegistry();
        registry.registryItem(test);

        registry.registryItemGroup(group);

        DhgRegistry.register(registry);

    }
}


