package com.ptk671.dhgloader.api.item;

import com.ptk671.dhgloader.api.util.DhgIdentifier;

import java.util.function.Supplier;

public class DhgItem {
    private DhgItemSettings itemSettings;
    private ExtendVanilaItem mcItem;
    private DhgIdentifier itemIdentifier;

    public DhgItem(DhgIdentifier identifier, DhgItemSettings settings) {
        this.itemIdentifier = identifier;
        this.itemSettings = settings;
    }

public void setMcItem(ExtendVanilaItem item){
        this.mcItem = item;
}

    public ExtendVanilaItem getMcItem() {
        if(mcItem == null) {
            throw new IllegalArgumentException("マインクラフトのアイテムを取得するのに失敗しました。");
        }


        return mcItem;
    }

    public DhgIdentifier getId(){
        return itemIdentifier;
    }

    public DhgItemSettings getSettings(){
        return itemSettings;
    }


}
