package com.evans.playerai.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block {

    public RubyBlock() {
        super(
                // what is it based on?
                Block.Properties.create(Material.IRON)
                        // how easy to break / blow up
                .hardnessAndResistance(5.0f, 6.0f)
                        // walk sound
                .sound(SoundType.METAL)
                        // tool tier needed to mine
                .harvestLevel(2)

                .harvestTool(ToolType.PICKAXE)
        );

    }
}
