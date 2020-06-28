package com.evans.playerai.client.renders;

import com.evans.playerai.PlayerAiMod;
import com.evans.playerai.client.models.PlayerEntityModel;
import com.evans.playerai.entities.PlayerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
@OnlyIn(Dist.CLIENT)
public class PlayerEntityRender extends LivingRenderer<PlayerEntity, PlayerEntityModel> {

    public PlayerEntityRender(EntityRendererManager manager){
        super(manager, new PlayerEntityModel(), 0f);
    }

    @Override
    public ResourceLocation getEntityTexture(PlayerEntity entity) {

        return PlayerAiMod.location("textures/entity/player.png");
    }

    public static class RenderFactory implements IRenderFactory<PlayerEntity> {

        @Override
        public EntityRenderer<? super PlayerEntity> createRenderFor(EntityRendererManager manager) {
            return new PlayerEntityRender(manager);
        }
    }
}
