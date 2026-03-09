package com.ae2modd.megastorage;

import appeng.api.config.FuzzyMode;
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

public class MegaCellItem extends Item implements ICellWorkbenchItem {

    public MegaCellItem(Properties props) {
        super(props.stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        tooltip.add(new StringTextComponent("536,870,912 Bytes").withStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("523 Types").withStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("Mega Storage Cell").withStyle(TextFormatting.AQUA));

    }

    public int getBytes() {
        return 536870912;
    }

    public int getTypes() {
        return 523;
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

        CompoundNBT tag = stack.getOrCreateTag();
        tag.putString("FuzzyMode", mode.name());

    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack stack) {
        return FuzzyMode.IGNORE_ALL;
    }
}