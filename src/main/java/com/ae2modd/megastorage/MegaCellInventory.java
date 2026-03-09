package com.ae2modd.megastorage;

import appeng.api.storage.cells.ICellInventoryHandler;
import appeng.api.storage.data.IAEStack;
import appeng.api.storage.cells.ISaveProvider;

import net.minecraft.item.ItemStack;

public class MegaCellInventory<T extends IAEStack<T>> implements ICellInventoryHandler<T> {

    private final ItemStack stack;
    private final ISaveProvider saveProvider;

    public MegaCellInventory(ItemStack stack, ISaveProvider saveProvider) {
        this.stack = stack;
        this.saveProvider = saveProvider;
    }

    @Override
    public int getStatusForCell() {
        return 0;
    }

}