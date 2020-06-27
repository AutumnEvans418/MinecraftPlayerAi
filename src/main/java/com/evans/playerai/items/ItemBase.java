package com.evans.playerai.items;

import com.evans.playerai.PlayerAiMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase(){
        super(new Item.Properties().group(PlayerAiMod.TAB));
    }
}
