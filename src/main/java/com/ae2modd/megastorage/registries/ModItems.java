package com.ae2modd.megastorage.registries;

import com.ae2modd.megastorage.MegaCellItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    // Регистрация всех предметов мода
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "megastorage");

    // Регистрация ячейки "mega_cell_512"
    public static final RegistryObject<Item> MEGA_CELL_512 = ITEMS.register(
            "mega_cell_512",
            () -> new MegaCellItem(
                    new Item.Properties()
                            .tab(ItemGroup.TAB_MISC)   // правильная группа для 1.16.5
                            .stacksTo(1)
            )
    );

    // Подключение регистра к шине событий
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}