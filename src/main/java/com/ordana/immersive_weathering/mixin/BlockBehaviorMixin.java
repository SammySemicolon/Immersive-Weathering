package com.ordana.immersive_weathering.mixin;

import com.ordana.immersive_weathering.data.BlockGrowthHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviorMixin{

    @Inject(method = "randomTick", at = @At("TAIL"))
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random, CallbackInfo ci) {
        BlockGrowthHandler.tickBlock(state, level, pos);
    }

}
