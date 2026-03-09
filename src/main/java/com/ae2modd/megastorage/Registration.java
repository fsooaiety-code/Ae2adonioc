package com.ae2modd.megastorage;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "megastorage");

    public static final RegistryObject<Item> MEGA_CELL =
            ITEMS.register("mega_cell",
                    () -> new MegaStorageCellItem(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}