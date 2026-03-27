package net.bauxite_ltk.tfc_fire_clay_addition;

import net.bauxite_ltk.tfc_fire_clay_addition.capabilities.TFCFCAItemCapabilities;
import net.bauxite_ltk.tfc_fire_clay_addition.component.TFCFCAComponents;
import net.bauxite_ltk.tfc_fire_clay_addition.container.TFCFCAContainerTypes;
import net.bauxite_ltk.tfc_fire_clay_addition.item.TFCFCAItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TFCFireClayAddition.MODID)
public class TFCFireClayAddition {

    public static final String MODID = "tfc_fire_clay_addition";

    public static final Logger LOGGER = LogUtils.getLogger();


    public TFCFireClayAddition(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);


        TFCFCAItems.init(modEventBus);
        TFCFCACreativeModeTab.init(modEventBus);

        TFCFCAComponents.init(modEventBus);
        TFCFCAContainerTypes.init(modEventBus);
        modEventBus.addListener(TFCFCAItemCapabilities::register);

        NeoForge.EVENT_BUS.register(this);




        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, TFCFCAConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
