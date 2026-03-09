package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.cells.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    private static final String TAG_AE2 = "AE2";
    private static final String TAG_FUZZY = "FuzzyMode";

    public MegaCellItem(Properties properties) {
        super(properties);
    }

    // Убрали @Override, так как эти методы не принадлежат ICellWorkbenchItem
    public int getBytes(ItemStack cellItem) {
        return 536_870_912; // 512 MiB
    }

    public int getTotalTypes(ItemStack cellItem) {
        return 523;
    }

    public double getIdleDrain(ItemStack cellItem) {
        return 4.0;
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return true;
    }

    // Возвращаем IItemHandler вместо IInventory
    @Override
    public IItemHandler getConfigInventory(ItemStack is) {
        // ВАЖНО: Для полноценного сохранения фильтров в будущем 
        // сюда нужно будет добавить логику чтения/записи в NBT предмета (is.getOrCreateTag())
        return new ItemStackHandler(63);
    }

    @Override
    public IItemHandler getUpgradesInventory(ItemStack is) {
        return new ItemStackHandler(2);
    }

    @Override
    public void setFuzzyMode(ItemStack stack, FuzzyMode mode) {
        CompoundTag root = stack.getOrCreateTag();
        CompoundTag ae2 = root.contains(TAG_AE2) ? root.getCompound(TAG_AE2) : new CompoundTag();
        // Используем IGNORE_ALL вместо NONE
        ae2.putString(TAG_FUZZY, mode == null ? "IGNORE_ALL" : mode.name());
        root.put(TAG_AE2, ae2);
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack stack) {
        if (stack.hasTag() && stack.getOrCreateTag().contains(TAG_AE2)) {
            CompoundTag ae2 = stack.getOrCreateTag().getCompound(TAG_AE2);
            if (ae2.contains(TAG_FUZZY)) {
                try {
                    return FuzzyMode.valueOf(ae2.getString(TAG_FUZZY));
                } catch (IllegalArgumentException e) {
                    return FuzzyMode.IGNORE_ALL; // Используем IGNORE_ALL
                }
            }
        }
        return FuzzyMode.IGNORE_ALL; // Используем IGNORE_ALL
    }
}
