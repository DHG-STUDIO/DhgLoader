package com.ptk671.dhgloader.fabric;

import com.ptk671.dhgloader.api.item.DhgItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class BuildItemGroup {
    public static ItemGroup build(DhgItemGroup itemGroup) {
        ItemGroup.Builder settings = FabricItemGroup.builder();
        if (itemGroup.getDhgItemIcon() != null) settings.icon(() -> new ItemStack( itemGroup.getDhgItemIcon().getMcItem()));
        if (itemGroup.getItemIcon() != null) settings.icon(itemGroup.getItemIcon());

        settings.displayName(Text.translatable("itemGroup."+itemGroup.getId().getNamespace()+itemGroup.getId().getPath()));
        ItemGroup buildedItemGroup = settings.build();
        //if (itemGroup.getStacks() != null) settings.entries((context, entries) -> {entries.addAll(itemGroup.getStacks());});
        itemGroup.setItemGroup(buildedItemGroup);
        return buildedItemGroup;
    }

}
