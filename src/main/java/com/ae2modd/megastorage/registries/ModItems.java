package com.ae2modd.megastorage.registries;

import com.ae2modd.megastorage.MegaCellItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "megastorage");

    // Регистрация ячейки под именем "mega_cell_512"
    public static final RegistryObject<Item> MEGA_CELL_512 = ITEMS.register("mega_cell_512",
            () -> new MegaCellItem(new Item.Properties().group(ItemGroup.MISC).stacksTo(1)));

    /**
     * Регистрирует DeferredRegister на шине событий мода.
     * Вызывается из основного класса мода, например:
     * ModItems.register(FMLJavaModLoadingContext.get().getModEventBus());
     */
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}