package io.github.dhgstudio.dhgloader;

import io.github.dhgstudio.dhgloader.api.item.DhgItem;
import io.github.dhgstudio.dhgloader.api.item.DhgItemSettings;
import io.github.dhgstudio.dhgloader.api.util.DhgIdentifier;
import io.github.dhgstudio.dhgloader.api.util.DhgRegistry;
import net.fabricmc.api.ModInitializer;

public class Dhgloader implements ModInitializer {
public static DhgItem dhgItem = new DhgItem(new DhgItemSettings());

    @Override
    public void onInitialize() {
        //smaple
        DhgRegistry.ITEM.register(dhgItem,DhgIdentifier.of("test","test"));

    }
}
