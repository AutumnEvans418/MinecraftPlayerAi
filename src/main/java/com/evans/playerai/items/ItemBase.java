package com.evans.playerai.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase(){
        super(new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }
}
