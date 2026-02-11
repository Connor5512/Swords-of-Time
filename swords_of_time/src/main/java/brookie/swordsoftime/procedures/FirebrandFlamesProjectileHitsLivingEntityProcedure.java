package brookie.swordsoftime.procedures;

import net.minecraft.world.entity.Entity;

public class FirebrandFlamesProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(30);
	}
}