package com.frunnkis.firstmod.items;

import com.frunnkis.firstmod.FirstMod;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(FirstMod.setup.itemGroup));
        setRegistryName("firstitem");
    }
}
