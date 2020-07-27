package com.evans.playerai;

import com.evans.playerai.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("playerai")
@Mod.EventBusSubscriber(modid = PlayerAiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerAiMod
{
    public static final String MOD_ID = "playerai";
    private static final Logger LOGGER = LogManager.getLogger();

    public PlayerAiMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        RegistryHandler.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RegistryHandler.SetupSpawning();
        //Blocks.DIRT
    }

    public static final ItemGroup TAB = new ItemGroup("playeraiTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }


}
