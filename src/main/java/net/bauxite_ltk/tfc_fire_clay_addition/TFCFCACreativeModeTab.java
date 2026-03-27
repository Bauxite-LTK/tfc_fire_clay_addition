package net.bauxite_ltk.tfc_fire_clay_addition;

import net.bauxite_ltk.tfc_fire_clay_addition.item.TFCFCAItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.bauxite_ltk.tfc_fire_clay_addition.TFCFireClayAddition.MODID;

public class TFCFCACreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TFC_FCA_TAB = CREATIVE_MODE_TABS.register("tfc_fca_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tfc_fire_clay_addition")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> TFCFCAItems.ADVANCED_VESSEL.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(TFCFCAItems.ADVANCED_VESSEL.get());
                output.accept(TFCFCAItems.UNFIRED_ADVANCED_VESSEL.get());
            }).build());

    public static void init(IEventBus modEventBus){
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
