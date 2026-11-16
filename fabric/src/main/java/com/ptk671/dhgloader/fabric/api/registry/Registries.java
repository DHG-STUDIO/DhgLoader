package com.ptk671.dhgloader.fabric.api.registry;

import com.ptk671.dhgloader.api.registry.DhgRegistry;
import com.ptk671.dhgloader.fabric.BuildItem;
import com.ptk671.dhgloader.fabric.BuildItemGroup;
import net.minecraft.registry.Registry;

public class Registries {

    public static void init() {

        DhgRegistry.regItem = (item) ->  Registry.register(net.minecraft.registry.Registries.ITEM, (item.getId().toMinecraft()), BuildItem.build(item));
        DhgRegistry.regItemGroup = (itemGroup) ->  Registry.register(net.minecraft.registry.Registries.ITEM_GROUP, itemGroup.getId().toMinecraft(), itemGroup.getItemGroup());

    }

}
