/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package brookie.swordsoftime.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

import brookie.swordsoftime.client.particle.VenomshankParticlesParticle;
import brookie.swordsoftime.client.particle.FirebrandFireParticle;

public class SwordsOfTimeModParticleTypes {
	public static final SimpleParticleType VENOMSHANK_PARTICLES = FabricParticleTypes.simple(false);
	public static final SimpleParticleType FIREBRAND_FIRE = FabricParticleTypes.simple(false);

	public static void clientLoad() {
		ParticleFactoryRegistry.getInstance().register(VENOMSHANK_PARTICLES, VenomshankParticlesParticle::provider);
		ParticleFactoryRegistry.getInstance().register(FIREBRAND_FIRE, FirebrandFireParticle::provider);
	}

	public static void load() {
		Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation("swords_of_time", "venomshank_particles"), VENOMSHANK_PARTICLES);
		Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation("swords_of_time", "firebrand_fire"), FIREBRAND_FIRE);
	}
}