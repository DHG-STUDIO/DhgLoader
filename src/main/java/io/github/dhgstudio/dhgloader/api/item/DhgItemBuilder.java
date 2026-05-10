package io.github.dhgstudio.dhgloader.api.item;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DhgItemBuilder {

    private DhgItemSettings settings;
    private ExtendItem buildedItem;

    public DhgItemBuilder(DhgItem dhgItem){
    this.settings = dhgItem.getSettings();

    }
public void build() {

        buildedItem = new ExtendItem(settings);

    }
public ExtendItem getBuildedItem(){
        return buildedItem;
}


}
