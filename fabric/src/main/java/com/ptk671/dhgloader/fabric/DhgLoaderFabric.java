package com.ptk671.dhgloader.fabric;

import com.ptk671.dhgloader.DhgLoader;
import com.ptk671.dhgloader.api.item.AddGroupHelper;
import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.DhgItemGroup;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import com.ptk671.dhgloader.api.registry.CompatDhgRegistry;
import com.ptk671.dhgloader.api.registry.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public final class DhgLoaderFabric implements ModInitializer {


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        DhgLoader.init();

        for (CompatDhgRegistry registry : DhgLoader.registries) {


            //Itemの登録
            for (RegistryHelper.Item item : registry.getItems()) {

                if (item.getItem().get().getSettings().getDhgItemGroup() != null){
                DhgLoader.addGroupHelper.add(new AddGroupHelper(item.getItem().get()));
                }

                Registry.register(Registries.ITEM, (item.getItemId().toMinecraft()), item.getItem().get().getMcItem().get());

                //(Vanilla)ItemGroupに追加する処理
                if (item.getItem().get().getSettings().getVanilaItemGroup() != null) {
                    ItemGroupEvents.modifyEntriesEvent(item.getItem().get().getSettings().getVanilaItemGroup().getItemGroupRegistryKey()).register(itemGroup -> {
                        itemGroup.add(item.getItem().get().getMcItem().get());
                    });
                }
            }

            //ItemGroupの登録

            for (DhgItemGroup dhgItemGroup : registry.getItemGroups()) {

                for (AddGroupHelper groupHelper : DhgLoader.addGroupHelper) {
                    groupHelper.tab(groupHelper.getDhgItem().getSettings().getDhgItemGroup());
                    groupHelper.addTabItem();
                }

                ItemGroup itemGroup = BuildItemGroup.build(dhgItemGroup);
                Registry.register(Registries.ITEM_GROUP, dhgItemGroup.getRegistryKey(), itemGroup);

                for (DhgItem dhgItemStack : dhgItemGroup.getDhgItemStacks()) {
                    ExtendVanilaItem extendVanilaItem = dhgItemStack.getMcItem().get();
                    dhgItemGroup.appendItems(extendVanilaItem);
                }

                if (dhgItemGroup.getStacks() != null) {
                    ItemGroupEvents.modifyEntriesEvent(dhgItemGroup.getRegistryKey()).register(itemGroup1 -> {
                        itemGroup1.addAll(dhgItemGroup.getStacks());

                    });
                }
            }
        }
    }
}