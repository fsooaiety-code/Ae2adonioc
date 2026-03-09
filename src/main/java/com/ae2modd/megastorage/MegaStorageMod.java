package com.ae2modd.megastorage;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("megastorage")
public class MegaStorageMod {

    public MegaStorageMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            // Регистрируем твою радужную ячейку
            event.getRegistry().register(new MegaCellItem(new Item.Properties().tab(ItemGroup.TAB_MISC))
                    .setRegistryName("mega_cell"));
        }
    }
}
