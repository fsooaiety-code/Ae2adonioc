package com.ae2modd.megastorage;

import appeng.api.storage.IStorageChannel;
import appeng.api.storage.cells.ICellInventoryHandler;
import appeng.api.storage.data.IAEStack;
import net.minecraft.item.ItemStack;

public class MegaCellInventory<T extends IAEStack<T>> implements ICellInventoryHandler<T> {

    private final IStorageChannel<T> channel;
    private final ItemStack stack;

    public MegaCellInventory(IStorageChannel<T> channel, ItemStack stack) {
        this.channel = channel;
        this.stack = stack;
    }

    @Override public IStorageChannel<T> getChannel() { return this.channel; }

    // Эти методы — заглушки для совместимости с 1.16.5
    public boolean isPreformatted() { return false; }
    public boolean isFuzzy() { return false; }
}
