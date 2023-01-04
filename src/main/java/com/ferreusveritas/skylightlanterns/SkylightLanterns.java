package com.ferreusveritas.skylightlanterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ferreusveritas.skylightlanterns.init.BlockInit;
import com.ferreusveritas.skylightlanterns.init.ItemInit;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SkylightLanterns.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkylightLanterns {
	public static final String MODID = "skylightlanterns";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public SkylightLanterns() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
	}
	
	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
	}
	
	@SubscribeEvent
	public static void onCommonSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.SKYLIGHT_LANTERN.get(), RenderType.cutout());
	}
	
}
