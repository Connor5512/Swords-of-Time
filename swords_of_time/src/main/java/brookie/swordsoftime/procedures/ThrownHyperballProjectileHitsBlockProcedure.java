package brookie.swordsoftime.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import brookie.swordsoftime.init.SwordsOfTimeModSounds;
import brookie.swordsoftime.init.SwordsOfTimeModItems;

public class ThrownHyperballProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), SwordsOfTimeModSounds.BALL, SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, SwordsOfTimeModSounds.BALL, SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SwordsOfTimeModItems.HYPERBALL));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn);
		}
	}
}