package com.ae2modd.megastorage;

import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ICellInventory;
import appeng.api.storage.cells.CellInventory;
import net.minecraft.item.ItemStack;

public class MegaCellHandler implements ICellHandler {

    @Override
    public boolean isCell(ItemStack stack) {
        return stack.getItem() instanceof MegaCellItem;
    }

    @Override
    public ICellInventory getCellInventory(ItemStack stack, Object host) {
        return CellInventory.create(stack, host);
    }
}