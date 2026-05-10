package io.github.dhgstudio.dhgloader.api.util;

import io.github.dhgstudio.dhgloader.api.item.DhgItem;
import io.github.dhgstudio.dhgloader.api.item.ExtendItem;
import net.minecraft.registry.Registry;

public enum DhgRegistry {
    ITEM {
        public void register(Object item, DhgIdentifier identifier) {

            if (item instanceof DhgItem) {
                DhgItem dhgItem = (DhgItem) item;

                ExtendItem extendItem = dhgItem.getBuilder().getBuildedItem();

                Registry.register(net.minecraft.registry.Registries.ITEM, (identifier.toMinecraft()), extendItem);
            }
        }

    };

    public abstract void register(Object type, DhgIdentifier identifier);



}







