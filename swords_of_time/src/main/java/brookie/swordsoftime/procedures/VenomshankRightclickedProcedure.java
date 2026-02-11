package brookie.swordsoftime.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;

import brookie.swordsoftime.init.SwordsOfTimeModSounds;
import brookie.swordsoftime.init.SwordsOfTimeModEntities;
import brookie.swordsoftime.entity.VenomshankPoisonEntity;

public class VenomshankRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), SwordsOfTimeModSounds.VENOMSHANK, SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, SwordsOfTimeModSounds.VENOMSHANK, SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(1));
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new VenomshankPoisonEntity(SwordsOfTimeModEntities.VENOMSHANK_POISON, level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setCritArrow(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 5, 1);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
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