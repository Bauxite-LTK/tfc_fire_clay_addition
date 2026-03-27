package net.bauxite_ltk.tfc_fire_clay_addition.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.bauxite_ltk.tfc_fire_clay_addition.TFCFireClayAddition.MODID;

public class TFCFCAItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static  final DeferredItem<Item> ADVANCED_VESSEL = ITEMS.register("advanced_vessel", ()-> new AdvancedVesselItem(new Item.Properties()));
    public static  final DeferredItem<Item> UNFIRED_ADVANCED_VESSEL = ITEMS.registerSimpleItem("unfired_advanced_vessel");

    public static void init(IEventBus modEventBus){
        ITEMS.register(modEventBus);
    }
}
