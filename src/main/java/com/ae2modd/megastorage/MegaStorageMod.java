package com.ae2modd.megastorage;

import appeng.api.AEApi;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.javafmlmod.FMLJavaModLoadingContext;

@Mod("megastorage")
public class MegaStorageMod {

    public MegaStorageMod() {
        // Это нужно, чтобы зарегистрировать обработчик ячеек в AE2
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Говорим AE2: "Эй, вот мой обработчик для мега-ячеек"
        AEApi.instance().registries().cell().registerHandler(new MegaCellHandler());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new MegaCellItem(new Item.Properties().tab(ItemGroup.TAB_MISC))
                    .setRegistryName("mega_cell"));
        }
    }
}
