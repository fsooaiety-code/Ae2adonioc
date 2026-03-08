package com.ae2modd.megastorage;

import appeng.api.storage.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * MegaCellItem — простая реализация ячейки AE2.
 * Пакет и имя класса согласованы с ModItems.java (com.ae2modd.megastorage).
 */
public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    /**
     * Вместимость в байтах.
     * Здесь задано 512 MiB = 512 * 1024 * 1024 = 536870912 байт.
     */
    @Override
    public int getBytes(ItemStack cellItem) {
        return 536_870_912;
    }

    /**
     * Максимальное количество типов предметов, которые может хранить ячейка.
     */
    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    /**
     * Пассивное потребление энергии (idle drain).
     * Значение в логике AE2 обычно double.
     */
    @Override
    public double getIdleDrain(ItemStack cellItem) {
        return 4.0;
    }

    /**
     * Разрешить ли редактирование ячейки в верстаке ячеек.
     */
    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }
}