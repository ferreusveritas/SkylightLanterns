package com.ferreusveritas.skylightlanterns.init;

import com.ferreusveritas.skylightlanterns.SkylightLanterns;
import com.ferreusveritas.skylightlanterns.block.SkylightLanternBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkylightLanterns.MODID);
	
	public static final RegistryObject<Block> SKYLIGHT_LANTERN = BLOCKS.register("skylight_lantern",()-> new SkylightLanternBlock(
		BlockBehaviour.Properties
			.of(Material.METAL, MaterialColor.COLOR_GRAY)
			.requiresCorrectToolForDrops()
			.strength(4.5F)
			.sound(SoundType.LANTERN)
			.lightLevel(blockState ->  15 )
			.noOcclusion())
	);
}
