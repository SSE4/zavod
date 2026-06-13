package com.zavod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(zavod.MODID)
public class zavod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "zavod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "zavod" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "zavod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "zavod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block> POLISHED_DIAMOND = BLOCKS.registerSimpleBlock("polished_diamond",
            p -> p.mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_DIAMOND_ITEM = ITEMS.registerSimpleBlockItem("polished_diamond", POLISHED_DIAMOND);
    public static final DeferredBlock<Block> DIAMOND_BRICKS = BLOCKS.registerSimpleBlock("diamond_bricks",
            p -> p.mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> DIAMOND_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("diamond_bricks", DIAMOND_BRICKS);
    public static final DeferredBlock<Block> DIAMOND_TILES = BLOCKS.registerSimpleBlock("diamond_tiles",
            p -> p.mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> DIAMOND_TILES_ITEM = ITEMS.registerSimpleBlockItem("diamond_tiles", DIAMOND_TILES);

    public static final DeferredBlock<Block> POLISHED_IRON = BLOCKS.registerSimpleBlock("polished_iron",
            p -> p.mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_IRON_ITEM = ITEMS.registerSimpleBlockItem("polished_iron", POLISHED_IRON);
    public static final DeferredBlock<Block> IRON_BRICKS = BLOCKS.registerSimpleBlock("iron_bricks",
            p -> p.mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> IRON_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("iron_bricks", IRON_BRICKS);
    public static final DeferredBlock<Block> IRON_TILES = BLOCKS.registerSimpleBlock("iron_tiles",
            p -> p.mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> IRON_TILES_ITEM = ITEMS.registerSimpleBlockItem("iron_tiles", IRON_TILES);

    public static final DeferredBlock<Block> POLISHED_GOLD = BLOCKS.registerSimpleBlock("polished_gold",
            p -> p.mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_GOLD_ITEM = ITEMS.registerSimpleBlockItem("polished_gold", POLISHED_GOLD);
    public static final DeferredBlock<Block> GOLD_BRICKS = BLOCKS.registerSimpleBlock("gold_bricks",
            p -> p.mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> GOLD_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("gold_bricks", GOLD_BRICKS);
    public static final DeferredBlock<Block> GOLD_TILES = BLOCKS.registerSimpleBlock("gold_tiles",
            p -> p.mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> GOLD_TILES_ITEM = ITEMS.registerSimpleBlockItem("gold_tiles", GOLD_TILES);

    public static final DeferredBlock<Block> POLISHED_REDSTONE = BLOCKS.registerSimpleBlock("polished_redstone",
            p -> p.mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_REDSTONE_ITEM = ITEMS.registerSimpleBlockItem("polished_redstone", POLISHED_REDSTONE);
    public static final DeferredBlock<Block> REDSTONE_BRICKS = BLOCKS.registerSimpleBlock("redstone_bricks",
            p -> p.mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> REDSTONE_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("redstone_bricks", REDSTONE_BRICKS);
    public static final DeferredBlock<Block> REDSTONE_TILES = BLOCKS.registerSimpleBlock("redstone_tiles",
            p -> p.mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> REDSTONE_TILES_ITEM = ITEMS.registerSimpleBlockItem("redstone_tiles", REDSTONE_TILES);

    public static final DeferredBlock<Block> POLISHED_EMERALD = BLOCKS.registerSimpleBlock("polished_emerald",
            p -> p.mapColor(MapColor.EMERALD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_EMERALD_ITEM = ITEMS.registerSimpleBlockItem("polished_emerald", POLISHED_EMERALD);
    public static final DeferredBlock<Block> EMERALD_BRICKS = BLOCKS.registerSimpleBlock("emerald_bricks",
            p -> p.mapColor(MapColor.EMERALD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> EMERALD_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("emerald_bricks", EMERALD_BRICKS);
    public static final DeferredBlock<Block> EMERALD_TILES = BLOCKS.registerSimpleBlock("emerald_tiles",
            p -> p.mapColor(MapColor.EMERALD).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> EMERALD_TILES_ITEM = ITEMS.registerSimpleBlockItem("emerald_tiles", EMERALD_TILES);

    public static final DeferredBlock<Block> POLISHED_AMETHYST = BLOCKS.registerSimpleBlock("polished_amethyst",
            p -> p.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_AMETHYST_ITEM = ITEMS.registerSimpleBlockItem("polished_amethyst", POLISHED_AMETHYST);
    public static final DeferredBlock<Block> AMETHYST_BRICKS = BLOCKS.registerSimpleBlock("amethyst_bricks",
            p -> p.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> AMETHYST_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("amethyst_bricks", AMETHYST_BRICKS);
    public static final DeferredBlock<Block> AMETHYST_TILES = BLOCKS.registerSimpleBlock("amethyst_tiles",
            p -> p.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> AMETHYST_TILES_ITEM = ITEMS.registerSimpleBlockItem("amethyst_tiles", AMETHYST_TILES);

    public static final DeferredBlock<Block> POLISHED_LAPIS = BLOCKS.registerSimpleBlock("polished_lapis",
            p -> p.mapColor(MapColor.LAPIS).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> POLISHED_LAPIS_ITEM = ITEMS.registerSimpleBlockItem("polished_lapis", POLISHED_LAPIS);
    public static final DeferredBlock<Block> LAPIS_BRICKS = BLOCKS.registerSimpleBlock("lapis_bricks",
            p -> p.mapColor(MapColor.LAPIS).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> LAPIS_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("lapis_bricks", LAPIS_BRICKS);
    public static final DeferredBlock<Block> LAPIS_TILES = BLOCKS.registerSimpleBlock("lapis_tiles",
            p -> p.mapColor(MapColor.LAPIS).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> LAPIS_TILES_ITEM = ITEMS.registerSimpleBlockItem("lapis_tiles", LAPIS_TILES);

    public static final DeferredBlock<Block> POLISHED_NETHERITE = BLOCKS.registerSimpleBlock("polished_netherite",
            p -> p.mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredItem<BlockItem> POLISHED_NETHERITE_ITEM = ITEMS.registerSimpleBlockItem("polished_netherite", POLISHED_NETHERITE);
    public static final DeferredBlock<Block> NETHERITE_BRICKS = BLOCKS.registerSimpleBlock("netherite_bricks",
            p -> p.mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredItem<BlockItem> NETHERITE_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("netherite_bricks", NETHERITE_BRICKS);
    public static final DeferredBlock<Block> NETHERITE_TILES = BLOCKS.registerSimpleBlock("netherite_tiles",
            p -> p.mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredItem<BlockItem> NETHERITE_TILES_ITEM = ITEMS.registerSimpleBlockItem("netherite_tiles", NETHERITE_TILES);

    // Creates a new food item with the id "zavod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", p -> p.food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Creates a creative tab with the id "zavod:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.zavod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public zavod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (zavod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(POLISHED_DIAMOND_ITEM);
            event.accept(DIAMOND_BRICKS_ITEM);
            event.accept(DIAMOND_TILES_ITEM);
            event.accept(POLISHED_IRON_ITEM);
            event.accept(IRON_BRICKS_ITEM);
            event.accept(IRON_TILES_ITEM);
            event.accept(POLISHED_GOLD_ITEM);
            event.accept(GOLD_BRICKS_ITEM);
            event.accept(GOLD_TILES_ITEM);
            event.accept(POLISHED_REDSTONE_ITEM);
            event.accept(REDSTONE_BRICKS_ITEM);
            event.accept(REDSTONE_TILES_ITEM);
            event.accept(POLISHED_EMERALD_ITEM);
            event.accept(EMERALD_BRICKS_ITEM);
            event.accept(EMERALD_TILES_ITEM);
            event.accept(POLISHED_AMETHYST_ITEM);
            event.accept(AMETHYST_BRICKS_ITEM);
            event.accept(AMETHYST_TILES_ITEM);
            event.accept(POLISHED_LAPIS_ITEM);
            event.accept(LAPIS_BRICKS_ITEM);
            event.accept(LAPIS_TILES_ITEM);
            event.accept(POLISHED_NETHERITE_ITEM);
            event.accept(NETHERITE_BRICKS_ITEM);
            event.accept(NETHERITE_TILES_ITEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
