package com.ae2modd.megastorage;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, "megastorage");

    public static final RegistryObject<Item> MEGA_CELL = ITEMS.register("mega_cell", 
            () -> new MegaCellItem(new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
