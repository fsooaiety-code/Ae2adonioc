package com.yourname.megastorage.registries;

import com.yourname.megastorage.items.MegaCellItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "megastorage");

    // Регистрация ячейки под именем "mega_cell_512"
    public static final RegistryObject<Item> MEGA_CELL_512 = ITEMS.register("mega_cell_512", 
            () -> new MegaCellItem(new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));
}