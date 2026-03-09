package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.cells.ICellWorkbenchItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties properties) {
        // Устанавливаем редкость EPIC, чтобы имя было фиолетовым/сияющим
        super(properties.stacksTo(1).rarity(Rarity.EPIC)); 
    }

    // Делаем название золотым (или можно настроить любой цвет)
    @Override
    public ITextComponent getName(ItemStack stack) {
        return new TranslationTextComponent(this.getDescriptionId())
                .withStyle(TextFormatting.GOLD)
                .withStyle(TextFormatting.BOLD);
    }

    // Добавляем описание веса ячейки
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Емкость: 536,870,912 байт").withStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("Типы: 523").withStyle(TextFormatting.GRAY));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    // --- Остальные методы из прошлого шага ---
    public int getBytes(ItemStack cellItem) { return 536870912; }
    public int getTotalTypes(ItemStack cellItem) { return 523; }
    
    @Override
    public boolean isEditable(ItemStack is) { return true; }

    @Override
    public IItemHandler getConfigInventory(ItemStack is) { return new ItemStackHandler(63); }

    @Override
    public IItemHandler getUpgradesInventory(ItemStack is) { return new ItemStackHandler(2); }

    @Override
    public void setFuzzyMode(ItemStack stack, FuzzyMode mode) {
        CompoundNBT root = stack.getOrCreateTag();
        CompoundNBT ae2 = root.contains("AE2") ? root.getCompound("AE2") : new CompoundNBT();
        ae2.putString("FuzzyMode", mode == null ? "IGNORE_ALL" : mode.name());
        root.put("AE2", ae2);
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack stack) {
        return FuzzyMode.IGNORE_ALL;
    }
}