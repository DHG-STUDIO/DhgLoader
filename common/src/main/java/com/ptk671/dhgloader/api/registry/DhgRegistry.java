package com.ptk671.dhgloader.api.registry;

import com.ptk671.dhgloader.DhgLoader;

public class DhgRegistry {

    public static void register(CompatDhgRegistry registry) {

        DhgLoader.registries.add(registry);

    }
}
