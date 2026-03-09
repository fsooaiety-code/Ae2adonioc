package com.ae2modd.megastorage;

import appeng.api.storage.cells.ICellInventory;
import appeng.api.storage.data.IAEStack;
import net.minecraft.item.ItemStack;

public class MegaCellInventory<T extends IAEStack<T>> implements ICellInventory<T> {

    private final ItemStack stack;

    public MegaCellInventory(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getItemStack() {
        return stack;
    }

    @Override
    public void persist() {
    }

}