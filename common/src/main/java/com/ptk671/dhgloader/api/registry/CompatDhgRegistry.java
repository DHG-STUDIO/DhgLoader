package com.ptk671.dhgloader.api.registry;

import com.ptk671.dhgloader.BuildItem;
import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.DhgItemGroup;

import java.util.ArrayList;
import java.util.List;

public class CompatDhgRegistry {
    private final List<RegistryHelper.Item> dhgItemList = new ArrayList<>();
    private final List<DhgItemGroup> dhgItemGroupList = new ArrayList<>();
    private RegistryHelper items;
    public void registryItem(DhgItem item) {

        BuildItem.build(item);

        if(item == null) {
            return;
        }

        dhgItemList.add(new RegistryHelper.Item(item,item.getId()));
    }

    public void registryItemGroup(DhgItemGroup itemGroup) {


        dhgItemGroupList.add(itemGroup);
    }

    public List<RegistryHelper.Item> getItems(){
        return dhgItemList;
    }

    public List<DhgItemGroup> getItemGroups(){
        return dhgItemGroupList;
    }
}
