package net.bauxite_ltk.tfc_fire_clay_addition.gui;

import net.bauxite_ltk.tfc_fire_clay_addition.container.AdvancedVesselInventoryContainer;
import net.dries007.tfc.client.screen.TFCContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AdvancedVesselInventoryScreen extends TFCContainerScreen<AdvancedVesselInventoryContainer> {

    public static final ResourceLocation ADVANCED_VESSEL_INVENTORY = ResourceLocation.fromNamespaceAndPath("tfc_fire_clay_addition","textures/gui/advanced_vessel.png");
    public AdvancedVesselInventoryScreen(AdvancedVesselInventoryContainer container, Inventory playerInventory, Component name) {
        super(container, playerInventory, name, ADVANCED_VESSEL_INVENTORY);
    }
}
