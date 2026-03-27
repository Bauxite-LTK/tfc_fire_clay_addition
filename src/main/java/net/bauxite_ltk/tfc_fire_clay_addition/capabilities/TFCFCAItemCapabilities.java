package net.bauxite_ltk.tfc_fire_clay_addition.capabilities;

import net.bauxite_ltk.tfc_fire_clay_addition.component.mold.AdvancedVessel;
import net.bauxite_ltk.tfc_fire_clay_addition.item.AdvancedVesselItem;
import net.bauxite_ltk.tfc_fire_clay_addition.item.TFCFCAItems;
import net.dries007.tfc.common.component.heat.IHeat;
import net.dries007.tfc.common.component.mold.IMold;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.ItemCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

public class TFCFCAItemCapabilities {
    public static final ItemCapability<IHeat, @Nullable Void> HEAT = ItemCapability.createVoid(Helpers.identifier("heat"), IHeat.class);
    public static final ItemCapability<IMold, @Nullable Void> MOLD = ItemCapability.createVoid(Helpers.identifier("mold"), IMold.class);
    public static final ItemCapability<IFluidHandlerItem, @Nullable Void> FLUID = Capabilities.FluidHandler.ITEM;
    public static final ItemCapability<IItemHandler, @Nullable Void> ITEM = Capabilities.ItemHandler.ITEM;

    public static void register(RegisterCapabilitiesEvent event)
    {
        event.registerItem(MOLD, TFCFCAItemCapabilities::forAdvancedVessel, TFCFCAItems.ADVANCED_VESSEL);
        event.registerItem(HEAT, TFCFCAItemCapabilities::forAdvancedVessel, TFCFCAItems.ADVANCED_VESSEL);
        event.registerItem(FLUID, TFCFCAItemCapabilities::forAdvancedVessel, TFCFCAItems.ADVANCED_VESSEL);
        event.registerItem(ITEM, TFCFCAItemCapabilities::forAdvancedVessel, TFCFCAItems.ADVANCED_VESSEL);
    }

    public static @Nullable AdvancedVessel forAdvancedVessel(ItemStack stack, @Nullable Void context)
    {
        AdvancedVessel toReturn = stack.getItem() instanceof AdvancedVesselItem item ? new AdvancedVessel(stack, item.containerInfo()) : null;
        if (toReturn==null){
            throw new RuntimeException("IDK WHY IT IS NULL");
        }
        return toReturn;
    }
}
