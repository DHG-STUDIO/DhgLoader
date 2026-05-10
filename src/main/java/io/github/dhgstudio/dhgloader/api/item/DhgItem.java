package io.github.dhgstudio.dhgloader.api.item;

import io.github.dhgstudio.dhgloader.api.util.DhgIdentifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class DhgItem {
    private DhgItemSettings settings;
    private DhgItemBuilder builder;

    public DhgItem(DhgItemSettings settings){

        this.settings = settings;
        builder = new DhgItemBuilder(this);
        builder.build();
    }

    public DhgItemSettings getSettings(){
        return settings;
    }

    public DhgItemBuilder getBuilder(){

        return builder;

    }



}
