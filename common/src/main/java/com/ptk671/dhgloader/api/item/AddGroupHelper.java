package com.ptk671.dhgloader.api.item;

import java.util.function.Supplier;

public class AddGroupHelper {

    private DhgItemGroup dhgItemGroup;
    private DhgItem dhgItem;

    public AddGroupHelper(DhgItem dhgItem) {

        this.dhgItem = dhgItem;
    }

    public AddGroupHelper(DhgItemGroup dhgItemGroup) {

        this.dhgItemGroup = dhgItemGroup;
    }

    public AddGroupHelper tab(DhgItemGroup dhgItemGroup){

        this.dhgItemGroup = dhgItemGroup;
        return this;
    }

    public AddGroupHelper item(DhgItem dhgItem){

        this.dhgItem = dhgItem;
        return this;
    }

    public DhgItem getDhgItem(){
        return dhgItem;
    }

    public AddGroupHelper addTabItem() {
        DhgItemGroup itemGroup;
        itemGroup = this.dhgItemGroup;
       // itemGroup.appendItems(dhgItem);
        return this;
    }

    public void addItemToTab() {

    }


}
