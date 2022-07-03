package com.ferreusveritas.skylightlanterns.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class SkylightLanternBlock extends LanternBlock implements SkylightSource {
	
	protected static final VoxelShape HANGING_AABB = VoxelShapes.or(
		Block.box(4.5D, 3.0D, 4.5D, 11.5D, 12.0D, 11.5D),
		Block.box(3.0D, 3.0D, 3.0D, 13.0D, 10.0D, 13.0D),
		Block.box(6.0D, 3.0D, 6.0D, 10.0D, 13.0D, 10.0D),
		Block.box(5.5D, 2.0D, 5.5D, 10.5D, 4.0D, 10.5D)
	);
	
	protected static final VoxelShape AABB = VoxelShapes.or(
		Block.box(4.5D, 1.0D, 4.5D, 11.5D, 10.0D, 11.5D),
		Block.box(3.0D, 1.0D, 3.0D, 13.0D, 8.0D, 13.0D),
		Block.box(6.0D, 1.0D, 6.0D, 10.0D, 11.0D, 10.0D),
		Block.box(5.5D, 0.0D, 5.5D, 10.5D, 2.0D, 10.5D)
	);
	
	public SkylightLanternBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
		return pState.getValue(HANGING) ? HANGING_AABB : AABB;
	}
	
	public int getSkylightValue(BlockState blockState) {
		return 15;
	}
	
}
