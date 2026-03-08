package com.ae2modd.megastorage;

import appeng.api.storage.cells.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBytes(ItemStack cellItem) {
        return 536_870_912; // 512 MiB
    }

    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    @Override
    public double getIdleDrain(ItemStack cellItem) {
        return 4.0;
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }
}