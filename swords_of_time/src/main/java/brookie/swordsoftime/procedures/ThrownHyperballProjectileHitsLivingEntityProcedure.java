package brookie.swordsoftime.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

import brookie.swordsoftime.init.SwordsOfTimeModSounds;
import brookie.swordsoftime.init.SwordsOfTimeModItems;

public class ThrownHyperballProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), SwordsOfTimeModSounds.BALL, SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, SwordsOfTimeModSounds.BALL, SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (sourceentity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(SwordsOfTimeModItems.HYPERBALL);
			_setstack.setCount(1);
			_player.getInventory().add(_setstack);
		}
	}
}