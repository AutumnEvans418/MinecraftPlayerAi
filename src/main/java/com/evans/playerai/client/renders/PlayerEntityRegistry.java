package com.evans.playerai.client.renders;

import com.evans.playerai.entities.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class PlayerEntityRegistry {
    public static void RegisterEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(PlayerEntity.class, new PlayerEntityRender.RenderFactory());
    }
}
