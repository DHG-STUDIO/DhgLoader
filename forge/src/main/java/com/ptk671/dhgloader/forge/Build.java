package com.ptk671.dhgloader.forge;

import com.ptk671.dhgloader.api.registry.DhgRegistry;

public class Build {

public static void init(){

    com.ptk671.dhgloader.api.Build.buildItemGroup = BuildItemGroup::build;

}

}
