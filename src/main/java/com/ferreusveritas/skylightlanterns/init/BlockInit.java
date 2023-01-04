package com.ferreusveritas.skylightlanterns.init;

import com.ferreusveritas.skylightlanterns.SkylightLanterns;
import com.ferreusveritas.skylightlanterns.block.SkylightLanternBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkylightLanterns.MODID);
	
	public static final RegistryObject<Block> SKYLIGHT_LANTERN = BLOCKS.register("skylight_lantern",()-> new SkylightLanternBlock(
		AbstractBlock.Properties
			.of(Material.METAL, MaterialColor.COLOR_GRAY)
			.strength(4.5F)
			.sound(SoundType.LANTERN)
			.lightLevel(blockState ->  15 )
			.noOcclusion())
	);
}
