package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.ICellItem;
import appeng.api.storage.cells.ICellWorkbenchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class MegaCellItem extends Item implements ICellWorkbenchItem, ICellItem {

    public MegaCellItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public ITextComponent getName(ItemStack stack) {
        String name = new TranslationTextComponent(this.getDescriptionId()).getString();
        IFormattableTextComponent rainbowName = new StringTextComponent("");
        long time = System.currentTimeMillis() / 80; 
        for (int i = 0; i < name.length(); i++) {
            int color = java.awt.Color.HSBtoRGB((float) ((time + i * 4) % 100) / 100F, 0.8F, 1.0F);
            rainbowName.append(new StringTextComponent(String.valueOf(name.charAt(i)))
                    .withStyle(Style.EMPTY.withColor(Color.fromRgb(color & 0xFFFFFF))));
        }
        return rainbowName.withStyle(TextFormatting.BOLD);
    }

    @Override public int getBytes(ItemStack is) { return 536870912; }
    @Override public int getTotalTypes(ItemStack is) { return 523; }
    @Override public double getIdleDrain(ItemStack is) { return 4.0; }
    @Override public boolean isEditable(ItemStack is) { return true; }
    @Override public IItemHandler getConfigInventory(ItemStack is) { return new ItemStackHandler(63); }
    @Override public IItemHandler getUpgradesInventory(ItemStack is) { return new ItemStackHandler(2); }
    @Override public void setFuzzyMode(ItemStack stack, FuzzyMode mode) {
        stack.getOrCreateTagElement("AE2").putString("FuzzyMode", mode.name());
    }
    @Override public FuzzyMode getFuzzyMode(ItemStack stack) { return FuzzyMode.IGNORE_ALL; }
}