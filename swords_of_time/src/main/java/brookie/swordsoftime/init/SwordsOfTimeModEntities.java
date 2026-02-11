/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package brookie.swordsoftime.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import brookie.swordsoftime.entity.VenomshankPoisonEntity;
import brookie.swordsoftime.entity.ThrownSuperballEntity;
import brookie.swordsoftime.entity.ThrownHyperballEntity;
import brookie.swordsoftime.entity.FirebrandFlamesEntity;
import brookie.swordsoftime.SwordsOfTimeMod;

public class SwordsOfTimeModEntities {
	public static EntityType<VenomshankPoisonEntity> VENOMSHANK_POISON;
	public static EntityType<FirebrandFlamesEntity> FIREBRAND_FLAMES;
	public static EntityType<ThrownSuperballEntity> THROWN_SUPERBALL;
	public static EntityType<ThrownHyperballEntity> THROWN_HYPERBALL;

	public static void load() {
		VENOMSHANK_POISON = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(SwordsOfTimeMod.MODID, "venomshank_poison"), createArrowEntityType(VenomshankPoisonEntity::new));
		FIREBRAND_FLAMES = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(SwordsOfTimeMod.MODID, "firebrand_flames"), createArrowEntityType(FirebrandFlamesEntity::new));
		THROWN_SUPERBALL = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(SwordsOfTimeMod.MODID, "thrown_superball"), createArrowEntityType(ThrownSuperballEntity::new));
		THROWN_HYPERBALL = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(SwordsOfTimeMod.MODID, "thrown_hyperball"), createArrowEntityType(ThrownHyperballEntity::new));
	}

	private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
		return FabricEntityTypeBuilder.create(MobCategory.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(1).trackedUpdateRate(64).build();
	}
}