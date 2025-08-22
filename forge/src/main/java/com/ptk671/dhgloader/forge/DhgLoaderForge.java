package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.DhgLoader;
import com.ptk671.dhgloader.api.item.DhgItem;
import com.ptk671.dhgloader.api.item.ExtendVanilaItem;
import com.ptk671.dhgloader.api.registry.CompatDhgRegistry;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;


@Mod(DhgLoader.MOD_ID)
public final class DhgLoaderForge {
    public DhgLoaderForge(FMLJavaModLoadingContext context) {
        // Run our common setup.
        DhgLoader.init();
        context.getModEventBus().addListener(this::registry);

    }

    @SubscribeEvent
    public void registry(RegisterEvent event) {
        for (CompatDhgRegistry registry : DhgLoader.registries) {
            for (DhgItem item : registry.getItems()) {

                event.register(ForgeRegistries.Keys.ITEMS,

                helper -> {
                    ExtendVanilaItem buildItem;
                    buildItem = BuildItemImpl.build(item);
                    Identifier id = item.getId().toMinecraft();
                    helper.register(id, buildItem);
                });
            }
        }
    }
}