package com.ae2modd.megastorage;

import appeng.api.AEApi;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("megastorage")
public class MegaStorage {

    public MegaStorage() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // регистрация предметов
        ModItems.register(eventBus);

        // РЕГИСТРАЦИЯ ЯЧЕЙКИ В AE2
        AEApi.instance().registries().cell().addCellHandler(new MegaCellHandler());

        MinecraftForge.EVENT_BUS.register(this);
    }
}