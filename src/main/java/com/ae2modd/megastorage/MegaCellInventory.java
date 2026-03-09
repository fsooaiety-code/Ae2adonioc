package com.ae2modd.megastorage;

import appeng.api.storage.IStorageChannel;
import appeng.api.storage.cells.ICellInventoryHandler;
import appeng.api.storage.data.IAEStack;
import net.minecraft.item.ItemStack;

public class MegaCellInventory<T extends IAEStack<T>> implements ICellInventoryHandler<T> {

    private final IStorageChannel<T> channel;
    private final ItemStack cellItem;

    public MegaCellInventory(IStorageChannel<T> channel, ItemStack cellItem) {
        this.channel = channel;
        this.cellItem = cellItem;
    }

    @Override
    public boolean isFuzzy() {
        return false;
    }

    @Override
    public IStorageChannel<T> getChannel() {
        return this.channel;
    }

    // Если в твоем старом коде были другие методы (например, getAvailableStacks), 
    // они должны остаться здесь, но базово для исправления ошибки компиляции 
    // вышеуказанных методов достаточно.
}
