package com.evans.playerai.client.renders;

import com.evans.playerai.PlayerAiMod;
import com.evans.playerai.entities.PlayerAiEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class PlayerEntityRender extends LivingRenderer<PlayerAiEntity, PlayerModel<PlayerAiEntity>> {

    public PlayerEntityRender(EntityRendererManager manager){
        super(manager, new PlayerModel<>(1, true), 0.5f);
    }
    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull PlayerAiEntity entity) {

        return PlayerAiMod.location("textures/entity/steve.png");
    }

    public static class RenderFactory implements IRenderFactory<PlayerAiEntity> {

        @Override
        public EntityRenderer<? super PlayerAiEntity> createRenderFor(EntityRendererManager manager) {
            return new PlayerEntityRender(manager);
        }
    }
}
