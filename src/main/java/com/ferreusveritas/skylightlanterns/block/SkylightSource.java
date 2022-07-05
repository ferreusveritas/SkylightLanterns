package com.ferreusveritas.skylightlanterns.block;

import net.minecraft.world.level.block.state.BlockState;

public interface SkylightSource {
	
	int getSkylightValue(BlockState blockState);
	
}
