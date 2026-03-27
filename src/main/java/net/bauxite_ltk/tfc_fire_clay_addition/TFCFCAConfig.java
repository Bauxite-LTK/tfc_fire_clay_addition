package net.bauxite_ltk.tfc_fire_clay_addition;

import java.util.List;

import net.dries007.tfc.common.component.size.Size;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class TFCFCAConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue THERMAL_VESSEL_FLUID_CAPACITY = BUILDER
            .comment("the fluid capacity of thermal vessel (mB)")
            .defineInRange("thermal_vessel_fluid_capacity", 3000, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue THERMAL_VESSEL_SLOT_CAPACITY = BUILDER
            .comment("the slot capacity of thermal vessel")
            .defineInRange("thermal_vessel_slot_capacity", 4, 1, 64);

    public static final ModConfigSpec.ConfigValue<Size> THERMAL_VESSEL_MAXIMUM_ITEM_SIZE = BUILDER
            .comment("The largest (inclusive) size of an item that is allowed in a small vessel.")
            .defineEnum("thermal_vessel_maximum_item_size", Size.LARGE);


    static final ModConfigSpec SPEC = BUILDER.build();


}
