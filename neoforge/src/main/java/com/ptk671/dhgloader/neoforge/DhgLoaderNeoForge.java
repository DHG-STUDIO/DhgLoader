package com.ptk671.dhgloader.neoforge;

import com.ptk671.dhgloader.DhgLoader;
import net.neoforged.fml.common.Mod;


@Mod(DhgLoader.MOD_ID)
public final class DhgLoaderNeoForge {
    public DhgLoaderNeoForge() {
        // Run our common setup.
        DhgLoader.init();
    }
}
