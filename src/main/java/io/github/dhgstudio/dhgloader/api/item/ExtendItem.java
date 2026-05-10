package io.github.dhgstudio.dhgloader.api.item;

import net.minecraft.item.Item;

public class ExtendItem extends Item {
    public ExtendItem(Settings settings) {
        super(settings);
    }

    public ExtendItem(DhgItemSettings settings){
        super(settings.getVanillaSettings());
    }
}
