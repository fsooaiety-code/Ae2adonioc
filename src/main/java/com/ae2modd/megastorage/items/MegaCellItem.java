package com.yourname.megastorage.items;

import appeng.api.storage.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    // 512 * 1024 * 1024 байт
    @Override
    public int getBytes(ItemStack cellItem) {
        return 536870912; 
    }

    // Твое количество типов
    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    @Override
    public double getIdleDrain(ItemStack cellItem) {
        return 8.0; // Энергопотребление в тик
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }
}