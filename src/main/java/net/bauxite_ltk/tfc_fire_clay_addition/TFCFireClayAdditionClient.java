package net.bauxite_ltk.tfc_fire_clay_addition;

import net.bauxite_ltk.tfc_fire_clay_addition.container.TFCFCAContainerTypes;
import net.bauxite_ltk.tfc_fire_clay_addition.gui.AdvancedVesselInventoryScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = TFCFireClayAddition.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = TFCFireClayAddition.MODID, value = Dist.CLIENT)
public class TFCFireClayAdditionClient {
    public TFCFireClayAdditionClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerContainersAndScreens(RegisterMenuScreensEvent event)
    {
        event.register(TFCFCAContainerTypes.ADVANCED_VESSEL_INVENTORY.get(), AdvancedVesselInventoryScreen::new);

    }
}
