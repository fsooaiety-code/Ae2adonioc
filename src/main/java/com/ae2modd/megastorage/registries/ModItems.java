package com.ae2modd.megastorage;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static Item MEGA_CELL;

    public static void register(Object bus) {}

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        MEGA_CELL = new MegaCellItem(new Item.Properties())
                .setRegistryName("megastorage", "mega_cell");

        event.getRegistry().register(MEGA_CELL);
    }
}