package brookie.swordsoftime.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import brookie.swordsoftime.init.SwordsOfTimeModParticleTypes;

public class FirebrandFlamesWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (SwordsOfTimeModParticleTypes.FIREBRAND_FIRE), x, y, z, 2, 3, 3, 3, 1);
	}
}