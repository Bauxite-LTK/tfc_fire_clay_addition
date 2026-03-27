package net.bauxite_ltk.tfc_fire_clay_addition.component;

import com.mojang.serialization.Codec;
import net.bauxite_ltk.tfc_fire_clay_addition.component.mold.AdvancedVesselComponent;
import net.dries007.tfc.util.registry.RegistryHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.bauxite_ltk.tfc_fire_clay_addition.TFCFireClayAddition.MODID;

public class TFCFCAComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MODID);

    public static final Id<AdvancedVesselComponent> ADVANCED_VESSEL = register("advanced_vessel", AdvancedVesselComponent.CODEC, AdvancedVesselComponent.STREAM_CODEC);


    private static <T> Id<T> register(String name, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec)
    {
        return new Id<>(COMPONENTS.register(name, () -> new DataComponentType.Builder<T>()
                .persistent(codec)
                .networkSynchronized(streamCodec)
                .build()));
    }

    public record Id<T>(DeferredHolder<DataComponentType<?>, DataComponentType<T>> holder)
            implements RegistryHolder<DataComponentType<?>, DataComponentType<T>> {}

    public static void init(IEventBus modEventBus){
        COMPONENTS.register(modEventBus);
    }
}
