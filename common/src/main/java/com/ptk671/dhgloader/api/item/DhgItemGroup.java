package com.ptk671.dhgloader.api.item;

import com.ptk671.dhgloader.api.util.DhgIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DhgItemGroup {
    private final DhgIdentifier identifier;
    private final List<ItemStack> stacks2 = new ArrayList<>();
    private final List<DhgItem> dhgItemStack = new ArrayList<>();
    private ItemGroup buildedItemGroup;
    private DhgItem dhgItemIcon;
    private ItemStack itemIcon = Items.AIR.getDefaultStack();
    private RegistryKey<ItemGroup> registryKey;

    public DhgItemGroup (DhgIdentifier identifier)  {
        this.identifier = identifier;
        registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), this.getId().toMinecraft());

    }

    public DhgItemGroup icon(DhgItem item) {
        this.dhgItemIcon = item;
        return this;
    }

    public DhgItemGroup icon(Item item) {
        this.itemIcon = new ItemStack(item);
        return this;
    }

    public DhgItemGroup appendItems(Item item)  {
        stacks2.add(new ItemStack(item));
        return this;
    }

    public DhgItemGroup appendItems(DhgItem item)  {
        dhgItemStack.add(item);
        return this;
    }



    public DhgItem getDhgItemIcon() {
        return dhgItemIcon;
    }

    public Supplier<ItemStack> getItemIcon() {
        return () -> itemIcon;
    }

    public List<ItemStack> getStacks() {

        return stacks2;
    }

    public DhgIdentifier getId(){
        return identifier;
    }

    public void setItemGroup(ItemGroup itemGroup){
        this.buildedItemGroup = itemGroup;
    }

    public ItemGroup getItemGroup(){

        return buildedItemGroup;
    }

    public RegistryKey<ItemGroup> getRegistryKey() {

        return registryKey;
    }

    public List<DhgItem> getDhgItemStacks(){

        return dhgItemStack;
    }
}
