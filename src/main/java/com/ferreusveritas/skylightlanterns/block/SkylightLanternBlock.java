package com.ferreusveritas.skylightlanterns.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;


public class SkylightLanternBlock extends LanternBlock implements SkylightSource {
	
	protected static final VoxelShape HANGING_AABB = Shapes.or(
		Block.box(4.5D, 3.0D, 4.5D, 11.5D, 12.0D, 11.5D),
		Block.box(3.0D, 3.0D, 3.0D, 13.0D, 10.0D, 13.0D),
		Block.box(6.0D, 3.0D, 6.0D, 10.0D, 13.0D, 10.0D),
		Block.box(5.5D, 2.0D, 5.5D, 10.5D, 4.0D, 10.5D)
	);
	
	protected static final VoxelShape AABB = Shapes.or(
		Block.box(4.5D, 1.0D, 4.5D, 11.5D, 10.0D, 11.5D),
		Block.box(3.0D, 1.0D, 3.0D, 13.0D, 8.0D, 13.0D),
		Block.box(6.0D, 1.0D, 6.0D, 10.0D, 11.0D, 10.0D),
		Block.box(5.5D, 0.0D, 5.5D, 10.5D, 2.0D, 10.5D)
	);
	
	public SkylightLanternBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return pState.getValue(HANGING) ? HANGING_AABB : AABB;
	}
	
	public int getSkylightValue(BlockState blockState) {
		return 15;
	}
	
}
