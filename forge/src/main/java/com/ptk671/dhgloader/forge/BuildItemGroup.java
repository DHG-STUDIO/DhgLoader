package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.api.item.DhgItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;

public class BuildItemGroup {

    public static ItemGroup build(DhgItemGroup itemGroup) {
        ItemGroup.Builder settings = ItemGroup.builder();
        //if (itemGroup.getDhgItemIcon() != null) settings.icon(() -> new ItemStack( itemGroup.getDhgItemIcon().getMcItem()));
        if (itemGroup.getItemIcon() != null) settings.icon(itemGroup.getItemIcon());

        settings.displayName(Text.translatable("itemGroup."+itemGroup.getId().getNamespace()+itemGroup.getId().getPath()));
      /*  settings.entries((parameters,output) -> {



        });*/
        ItemGroup buildedItemGroup = settings.build();
        //if (itemGroup.getStacks() != null) settings.entries((context, entries) -> {entries.addAll(itemGroup.getStacks());});
        itemGroup.setItemGroup(buildedItemGroup);
        return buildedItemGroup;
    }

}
