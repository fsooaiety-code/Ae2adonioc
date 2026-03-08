package com.example.myaddon.items;

import appeng.api.storage.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    // Количество байтов: 512 * 1024 * 1024 = 536870912
    @Override
    public int getBytes(ItemStack cellItem) {
        return 536870912; 
    }

    // Количество типов предметов (как ты и просил — 523)
    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    // Множитель потребления энергии (можно настроить)
    @Override
    public double getIdleDrain(ItemStack cellItem) {
        return 4.0; 
    }

    // Нужно ли показывать ячейку в верстаке ячеек
    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }
}