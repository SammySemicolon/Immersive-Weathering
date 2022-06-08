package com.ordana.immersive_weathering.registry.blocks.mossable;

import java.util.Random;

import com.ordana.immersive_weathering.registry.blocks.ModStairs;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MossyStairsBlock extends ModStairs implements Mossable, Fertilizable {

    private final MossLevel mossLevel;

    public MossyStairsBlock(MossLevel mossLevel, BlockState state, Settings properties) {
        super(state,properties);
        this.mossLevel = mossLevel;
    }

    @Override
    public MossSpreader getMossSpreader() {
        return MossSpreader.INSTANCE;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return this.mossLevel == MossLevel.MOSSY;
    }

    @Override
    public boolean canGrow(World world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        MossSpreader.growNeighbors(world, random, pos);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return isWeatherable(state);
    }


    @Override
    public boolean isWeatherable(BlockState state) {
        return false;
    }

    @Override
    public MossLevel getMossLevel() {
        return mossLevel;
    }

}