package com.ptk671.dhgloader.api.item;


import com.ptk671.dhgloader.api.util.DhgIdentifier;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class DhgItemSettings {
    private int maxCount = 64;
    private ItemGroupWarpper itemGroup;
    private Supplier<DhgItemGroup> dhgItemGroup;
    private int maxDamage;
    private boolean maxDamage_boolen = false;
    private boolean maxDamageIfAbsent_boolen = false;
    private DhgIdentifier dhgIdentifier;
    private Identifier vanilaIdentifier;

    private boolean fireproof_boolen = false;
    private int maxDamageIfAbsent;

    public DhgItemSettings()    {

    }

    public DhgItemSettings maxCount(int maxcount)
    {
        this.maxCount = maxcount;
        return this;
    }

    public DhgItemSettings maxDamageIfAbsent(int maxDamageIfAbsent)
    {
        this.maxDamageIfAbsent_boolen = true;
        this.maxDamageIfAbsent = maxDamageIfAbsent;
        return this;
    }

    public DhgItemSettings maxDamage(int maxDamage)
    {
        this.maxDamage_boolen = true;
        this.maxDamage = maxDamage;
        return this;
    }


    public DhgItemSettings group(ItemGroupWarpper itemGroup)
    {
        this.itemGroup = itemGroup;
        return this;
    }


    public DhgItemSettings group(DhgItemGroup itemGroup)
    {
        this.dhgItemGroup = () -> itemGroup;
        return this;
    }

    public DhgItemSettings fireproof()
    {
        //>=1.16
        this.fireproof_boolen = true;
        return this;
    }

    public int getMaxCount(){

        return maxCount;
    }
    public int getMaxDamageIfAbsent(){

        return maxDamageIfAbsent;
    }

    public ItemGroupWarpper getVanilaItemGroup(){

        return itemGroup;
    }

    public Supplier<DhgItemGroup> getDhgItemGroup(){

        return dhgItemGroup;
    }

}