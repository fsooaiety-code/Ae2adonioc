
package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.util.inventory.AppEngInternalInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    private static final String TAG_AE2 = "AE2";
    private static final String TAG_FUZZY = "FuzzyMode";

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBytes(ItemStack cellItem) {
        return 536_870_912; // 512 MiB
    }

    @Override
    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    @Override
    public double getIdleDrain(ItemStack cellItem) {
        return 4.0;
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }

    /**
     * Возвращает инвентарь настроек (фильтров) ячейки.
     * Используем стандартный внутренний инвентарь AE2 на 63 слота.
     */
    @Override
    public IInventory getConfigInventory(ItemStack is) {
        return new AppEngInternalInventory(is, 63);
    }

    /**
     * Возвращает инвентарь улучшений (карт).
     * Обычно для ячеек это 0-2 слота.
     */
    @Override
    public IInventory getUpgradesInventory(ItemStack is) {
        return new AppEngInternalInventory(is, 2);
    }

    /**
     * Устанавливает режим fuzzy для данной ячейки.
     */
    @Override
    public void setFuzzyMode(ItemStack stack, FuzzyMode mode) {
        CompoundNBT root = stack.getOrCreateTag();
        CompoundNBT ae2 = root.contains(TAG_AE2) ? root.getCompound(TAG_AE2) : new CompoundNBT();
        ae2.putString(TAG_FUZZY, mode == null ? "NONE" : mode.name());
        root.put(TAG_AE2, ae2);
    }

    /**
     * Возвращает текущий режим fuzzy.
     */
    @Override
    public FuzzyMode getFuzzyMode(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains(TAG_AE2)) {
            CompoundNBT ae2 = stack.getTag().getCompound(TAG_AE2);
            if (ae2.contains(TAG_FUZZY)) {
                try {
                    return FuzzyMode.valueOf(ae2.getString(TAG_FUZZY));
                } catch (IllegalArgumentException e) {
                    return FuzzyMode.NONE;
                }
            }
        }
        return FuzzyMode.NONE;
    }
}
