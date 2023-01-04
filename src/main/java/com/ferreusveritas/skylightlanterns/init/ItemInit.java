package com.ferreusveritas.skylightlanterns.init;

import com.ferreusveritas.skylightlanterns.SkylightLanterns;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkylightLanterns.MODID);
	
	public static final RegistryObject<Item> SKYLIGHT_LANTERN = ITEMS.register("skylight_lantern",()-> new BlockItem(BlockInit.SKYLIGHT_LANTERN.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
}
