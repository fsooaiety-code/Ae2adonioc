package com.ae2modd.megastorage;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("megastorage")
public class MegaStorage {
    public MegaStorage() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Регистрируем предметы
        ModItems.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}