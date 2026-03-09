package com.ae2modd.megastorage;

import appeng.api.storage.IStorageChannel;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ICellInventory;
import appeng.api.storage.cells.ISaveProvider;
import net.minecraft.item.ItemStack;

public class MegaCellHandler implements ICellHandler {

    @Override
    public boolean isCell(ItemStack stack) {
        return stack.getItem() instanceof MegaCellItem;
    }

    @Override
    public <T extends appeng.api.storage.data.IAEStack<T>> ICellInventory<T> getCellInventory(
            ItemStack stack,
            ISaveProvider host,
            IStorageChannel<T> channel
    ) {
        return null;
    }

}