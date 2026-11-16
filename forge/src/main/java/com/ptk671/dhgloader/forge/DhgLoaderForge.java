package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.DhgLoader;
import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.DhgItemGroup;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import com.ptk671.dhgloader.api.registry.DhgRegistry;
import com.ptk671.dhgloader.forge.api.registry.Registries;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;


@Mod(DhgLoader.MOD_ID)
public final class DhgLoaderForge {
    public static final List<DhgItem> ITEMS = new ArrayList<>();
    public static final List<DhgItemGroup> GROUPS = new ArrayList<>();
    public static final List<QueueTabAddItem> TABITEMS = new ArrayList<>();

    public static final RegistryObject<ItemGroup> EXAMPLE_TAB = null;
    public DhgLoaderForge(FMLJavaModLoadingContext context) {
        // Run our common setup.
        Build.init();

        Registries.init();

        DhgLoader.init();
        context.getModEventBus().addListener(this::registryItems);
        context.getModEventBus().addListener(this::registryItemGroups);
        context.getModEventBus().addListener(this::addCreativeContents);
    }

    @SubscribeEvent
    public void registryItems(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS,

                helper -> {

                    for (DhgItem dhgItem :ITEMS) {
                        ExtendVanilaItem buildItem;
                        buildItem = BuildItem.build(dhgItem);
                        Identifier id = dhgItem.getId().toMinecraft();
                        if (dhgItem.getSettings().getDhgItemGroup() != null) {
                            TABITEMS.add(new QueueTabAddItem(() -> buildItem, dhgItem.getSettings().getDhgItemGroup()));

                        }

                        if (dhgItem.getSettings().getVanilaItemGroup() != null){
                            TABITEMS.add(new QueueTabAddItem(() -> buildItem, dhgItem.getSettings().getVanilaItemGroup().getItemGroup()));
                        }
                        helper.register(id, buildItem);
                    }
                });
    }

    @SubscribeEvent
    public void registryItemGroups(RegisterEvent event) {
        //test event resigter itemgroup

        for (DhgItemGroup dhgItemGroup : GROUPS) {

            ItemGroup builded = dhgItemGroup.getItemGroup();
            event.register(net.minecraft.registry.Registries.ITEM_GROUP.getKey(), dhgItemGroup.getRegistryKey().getRegistry(), () -> builded);

        }
    }
        @SubscribeEvent
        public void addCreativeContents (BuildCreativeModeTabContentsEvent event){
     for (QueueTabAddItem item : TABITEMS) {

         if (event.getTab() == item.getItemGroup()) {

             event.accept(item.getItem());

         }


     }

    }


}




