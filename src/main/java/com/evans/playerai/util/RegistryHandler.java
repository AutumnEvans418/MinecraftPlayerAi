package com.evans.playerai.util;

import com.evans.playerai.PlayerAiMod;
import com.evans.playerai.blocks.BlockItemBase;
import com.evans.playerai.blocks.RubyBlock;
import com.evans.playerai.entities.PlayerAiEntity;
import com.evans.playerai.items.ItemBase;
import com.evans.playerai.items.ModdedSpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



//@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD, modid = PlayerAiMod.MOD_ID)
public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PlayerAiMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PlayerAiMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, PlayerAiMod.MOD_ID);

    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static void SetupSpawning(){
        ArrayList<Biome> biomes = new ArrayList<>();

        biomes.add(Biomes.FOREST);
        biomes.add(Biomes.BEACH);
        biomes.add(Biomes.JUNGLE);
        biomes.add(Biomes.PLAINS);

        RegisterSpawning(biomes, PLAYER.get());
    }


    public static EntityType<PlayerAiEntity> createPlayerAi(){
        String name = PlayerAiMod.location("player").toString();
        EntityType<PlayerAiEntity> build = EntityType.Builder.create(PlayerAiEntity::new, EntityClassification.CREATURE).build(name);
        //build.setRegistryName(name);
        return build;
    }

    //Entities
    public static final RegistryObject<EntityType<PlayerAiEntity>> PLAYER = ENTITY_TYPES.register("player", RegistryHandler::createPlayerAi);
    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> PLAYER_EGG = ITEMS.register("player_egg", () -> new ModdedSpawnEggItem(PLAYER, 0xffffff,0x000000, new Item.Properties().group(PlayerAiMod.TAB)));

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register(
            "ruby_block_item",
            () -> new BlockItemBase(RUBY_BLOCK.get()));

    public static Item RegisterSpawnEgg(EntityType<?> type, int color1, int color2){
        return new SpawnEggItem(type, color1, color2, new Item.Properties().group(PlayerAiMod.TAB));
    }

    public static void RegisterSpawning(Iterable<? extends Biome> biomes, EntityType<?> entityType){
        for(Biome biome : biomes){
            if(biome != null) {
                LOGGER.info("Adding " + entityType + " to biome " + biome);
                biome.getSpawns(entityType.getClassification()).add(new Biome.SpawnListEntry(entityType, 1, 1, 5));
            }
        }
    }
    private static final Logger LOGGER = LogManager.getLogger();

//    @SubscribeEvent
//    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
//    {
//        LOGGER.info("Registering entities...");
//        event.getRegistry().register(createPlayerAi());
//
//        //TutorialEntities.registerEntityWorldSpawns();
//    }
}
