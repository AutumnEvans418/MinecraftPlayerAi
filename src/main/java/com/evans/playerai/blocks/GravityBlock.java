package com.evans.playerai.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;

public class GravityBlock extends FallingBlock {

    public GravityBlock(Block block) {
        super(
                Properties.create(block.getMaterial(block.getDefaultState()))
                .harvestTool(block.getHarvestTool(block.getDefaultState()))
                .harvestLevel(block.getHarvestLevel(block.getDefaultState()))
                .sound(block.getSoundType(block.getDefaultState()))

        );

    }
}
