package brookie.swordsoftime.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

import brookie.swordsoftime.init.SwordsOfTimeModSounds;

public class GhostwalkerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 2) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SwordsOfTimeModSounds.GHOSTWALKER, SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SwordsOfTimeModSounds.GHOSTWALKER, SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(2));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 600, 1, true, false));
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SwordsOfTimeModSounds.ACTION_BLOCKED, SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SwordsOfTimeModSounds.ACTION_BLOCKED, SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}