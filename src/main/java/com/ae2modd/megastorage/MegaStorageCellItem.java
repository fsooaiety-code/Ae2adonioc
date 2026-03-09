package com.ae2modd.megastorage;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MegaStorageCellItem extends Item {

    public MegaStorageCellItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

}