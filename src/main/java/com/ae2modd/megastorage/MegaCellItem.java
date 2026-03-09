package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.cells.ICellItem;
import appeng.api.storage.cells.ICellWorkbenchItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

public class MegaCellItem extends Item implements ICellWorkbenchItem, ICellItem {

    public MegaCellItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    // --- РАДУЖНОЕ НАЗВАНИЕ ---
    @Override
    public ITextComponent getName(ItemStack stack) {
        String name = new TranslationTextComponent(this.getDescriptionId()).getString();
        // В 1.16.5 MCP используем IFormattableTextComponent для сборки цветного текста
        IFormattableTextComponent rainbowName = new StringTextComponent("");
        
        long time = System.currentTimeMillis() / 80; 
        
        for (int i = 0; i < name.length(); i++) {
            int color = java.awt.Color.HSBtoRGB((float) ((time + i * 4) % 100) / 100F, 0.8F, 1.0F);
            rainbowName.append(new StringTextComponent(String.valueOf(name.charAt(i)))
                    .withStyle(Style.EMPTY.withColor(Color.fromRgb(color & 0xFFFFFF))));
        }
        return rainbowName.withStyle(TextFormatting.BOLD);
    }

    // --- ОТОБРАЖЕНИЕ СТАТИСТИКИ (Как в AE2) ---
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        // Добавляем строки, которые имитируют стандартный вид ячеек AE2
        tooltip.add(new StringTextComponent("0 из 536,870,912 байт использовано").withStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("0 из 523 типов").withStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("AE2 Extras").withStyle(TextFormatting.AQUA));
    }

    // --- МЕТОДЫ ДЛЯ СОВМЕСТИМОСТИ С МЭ-НАКОПИТЕЛЕМ ---
    @Override
    public int getBytes(ItemStack cellItem) {
        return 536870912;
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

    @Override
    public IItemHandler getConfigInventory(ItemStack is) {
        return new ItemStackHandler(63);
    }

    @Override
    public IItemHandler getUpgradesInventory(ItemStack is) {
        return new ItemStackHandler(2);
    }

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