package com.ptk671.dhgloader.api.registry;

import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.util.DhgIdentifier;

import java.util.function.Supplier;

public class RegistryHelper {

     public static class Item {

         private final Supplier<DhgItem> item;
         private final DhgIdentifier itemId;

         public Item(DhgItem item, DhgIdentifier itemId) {
             this.item = () -> item;
             this.itemId = itemId;
         }

         public DhgIdentifier getItemId() {
             return itemId;
         }

         public Supplier<DhgItem> getItem() {
             return item;
         }
     }
 }