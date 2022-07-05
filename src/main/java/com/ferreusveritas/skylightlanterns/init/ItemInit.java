package com.ferreusveritas.skylightlanterns.init;

import com.ferreusveritas.skylightlanterns.SkylightLanterns;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkylightLanterns.MODID);
	
	public static final RegistryObject<Item> SKYLIGHT_LANTERN = ITEMS.register("skylight_lantern",()-> new BlockItem(BlockInit.SKYLIGHT_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
}
