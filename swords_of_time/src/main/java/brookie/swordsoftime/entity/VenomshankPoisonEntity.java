package brookie.swordsoftime.entity;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import brookie.swordsoftime.procedures.VenomshankPoisonWhileProjectileFlyingTickProcedure;
import brookie.swordsoftime.procedures.VenomshankPoisonProjectileHitsLivingEntityProcedure;
import brookie.swordsoftime.init.SwordsOfTimeModItems;
import brookie.swordsoftime.init.SwordsOfTimeModEntities;

public class VenomshankPoisonEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(SwordsOfTimeModItems.NONEXISTANT_ITEM);

	public VenomshankPoisonEntity(EntityType<? extends VenomshankPoisonEntity> type, Level world) {
		super(type, world);
	}

	public VenomshankPoisonEntity(EntityType<? extends VenomshankPoisonEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public VenomshankPoisonEntity(EntityType<? extends VenomshankPoisonEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		VenomshankPoisonProjectileHitsLivingEntityProcedure.execute(entityHitResult.getEntity());
	}

	@Override
	public void tick() {
		super.tick();
		VenomshankPoisonWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static VenomshankPoisonEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 18f, 2, 5);
	}

	public static VenomshankPoisonEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		VenomshankPoisonEntity entityarrow = new VenomshankPoisonEntity(SwordsOfTimeModEntities.VENOMSHANK_POISON, entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("swords_of_time:venomshank")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static VenomshankPoisonEntity shoot(LivingEntity entity, LivingEntity target) {
		VenomshankPoisonEntity entityarrow = new VenomshankPoisonEntity(SwordsOfTimeModEntities.VENOMSHANK_POISON, entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 18f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("swords_of_time:venomshank")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}