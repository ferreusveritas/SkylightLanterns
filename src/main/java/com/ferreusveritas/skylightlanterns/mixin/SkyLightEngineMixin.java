package com.ferreusveritas.skylightlanterns.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ferreusveritas.skylightlanterns.block.SkylightSource;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.chunk.LightChunkGetter;
import net.minecraft.world.level.lighting.SkyLightEngine;

@Mixin(SkyLightEngine.class)
public abstract class SkyLightEngineMixin {
	
	private final long[] lastChunkPos = new long[2];
	private final BlockGetter[] lastChunk = new BlockGetter[2];
	protected LightChunkGetter chunkSource = null;
	protected final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
	
	@Inject(method = "<init>", at = @At("TAIL"))
	public void init(LightChunkGetter lightProvider, CallbackInfo ci) {
		this.chunkSource = lightProvider;
	}
	
	@Inject(method = "computeLevelFromNeighbor", at = @At("HEAD"), cancellable = true)
	public void getBrightness(long pStartPos, long pEndPos, int pStartLevel, CallbackInfoReturnable<Integer> cir) {
		if(pStartPos != Long.MAX_VALUE && pEndPos != Long.MAX_VALUE && pStartLevel != 0) {
			pos.set(pEndPos);
			BlockGetter iblockreader = getChunk(pos.getX() >> 4, pos.getZ() >> 4);
			if(iblockreader != null) {
				BlockState blockState = iblockreader.getBlockState(pos);
				Block block = blockState.getBlock();
				if(block instanceof SkylightSource) {
					cir.setReturnValue(15 - ((SkylightSource)block).getSkylightValue(blockState));
				}
			}
		}
	}
	
	private BlockGetter getChunk(int pChunkX, int pChunkZ) {
		long i = ChunkPos.asLong(pChunkX, pChunkZ);
		
		for(int j = 0; j < 2; ++j) {
			if (i == lastChunkPos[j]) {
				return lastChunk[j];
			}
		}
		
		BlockGetter iblockreader = this.chunkSource.getChunkForLighting(pChunkX, pChunkZ);
		
		for(int k = 1; k > 0; --k) {
			lastChunkPos[k] = lastChunkPos[k - 1];
			lastChunk[k] = lastChunk[k - 1];
		}
		
		lastChunkPos[0] = i;
		lastChunk[0] = iblockreader;
		return iblockreader;
	}
	
}
