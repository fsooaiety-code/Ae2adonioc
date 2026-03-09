package com.ae2modd.megastorage;

import appeng.api.storage.IStorageChannel;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ICellInventoryHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.data.IAEStack;
import net.minecraft.item.ItemStack;

public class MegaCellHandler implements ICellHandler {

    @Override
    public boolean isCell(ItemStack stack) {
        return stack.getItem() instanceof MegaCellItem;
    }

    @Override
    public <T extends IAEStack<T>> ICellInventoryHandler<T> getCellInventory(ItemStack stack, ISaveProvider saveProvider, IStorageChannel<T> channel) {
        if (!isCell(stack)) return null;
        // Здесь мы возвращаем инвентарь, который будет реально хранить вещи
        return new MegaCellInventory<>(channel, stack);
    }
}
