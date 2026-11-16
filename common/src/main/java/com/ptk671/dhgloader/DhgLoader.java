package com.ptk671.dhgloader;

import com.ptk671.dhgloader.api.item.*;
import com.ptk671.dhgloader.api.registry.DhgRegistry;
import com.ptk671.dhgloader.api.util.DhgIdentifier;
import net.minecraft.item.Items;

public final class DhgLoader {
    public static final String MOD_ID = "dhgloader";

    //Item
    public static DhgItemGroup dhgItemGroup = new DhgItemGroup(DhgIdentifier.of("test","testtab")).icon(Items.STONE);


    public static DhgItem test = new DhgItem(DhgIdentifier.of("test","test"), new DhgItemSettings().maxCount(1).group(() -> dhgItemGroup));
    public static DhgItemGroup dhgItemGroup2 = new DhgItemGroup(DhgIdentifier.of("test","testtab2")).icon(DhgLoader.test);

    public static DhgItem test2 = new DhgItem(DhgIdentifier.of("test","test2"), new DhgItemSettings().maxCount(1).group(DhgLoader.dhgItemGroup2));

    public static void init() {
        //登録
        DhgRegistry.registerItemGroup(dhgItemGroup);
        DhgRegistry.registerItemGroup(dhgItemGroup2);

        DhgRegistry.registerItem(test);
        DhgRegistry.registerItem(test2);

    }
}


