package com.ptk671.dhgloader.forge.api.registry;

import com.ptk671.dhgloader.api.registry.DhgRegistry;
import com.ptk671.dhgloader.forge.DhgLoaderForge;

public class Registries {

    public static void init() {

        DhgRegistry.regItem = DhgLoaderForge.ITEMS::add;
        DhgRegistry.regItemGroup = DhgLoaderForge.GROUPS::add;

    }

}
