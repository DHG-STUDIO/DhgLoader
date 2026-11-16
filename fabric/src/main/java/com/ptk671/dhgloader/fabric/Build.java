package com.ptk671.dhgloader.fabric;

import static com.ptk671.dhgloader.api.Build.buildItemGroup;

public class Build {

    public static void init() {

        buildItemGroup = BuildItemGroup::build;

    }

}
