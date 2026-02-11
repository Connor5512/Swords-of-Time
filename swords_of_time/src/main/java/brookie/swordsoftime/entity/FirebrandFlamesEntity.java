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

import brookie.swordsoftime.procedures.FirebrandFlamesWhileProjectileFlyingTickProcedure;
import brookie.swordsoftime.procedures.FirebrandFlamesProjectileHitsLivingEntityProcedure;
import brookie.swordsoftime.init.SwordsOfTimeModItems;
import brookie.swordsoftime.init.SwordsOfTimeModEntities;

public class FirebrandFlamesEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(SwordsOfTimeModItems.NONEXISTANT_ITEM);

	public FirebrandFlamesEntity(EntityType<? extends FirebrandFlamesEntity> type, Level world) {
		super(type, world);
	}

	public FirebrandFlamesEntity(EntityType<? extends FirebrandFlamesEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FirebrandFlamesEntity(EntityType<? extends FirebrandFlamesEntity> type, LivingEntity entity, Level world) {
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
		FirebrandFlamesProjectileHitsLivingEntityProcedure.execute(entityHitResult.getEntity());
	}

	@Override
	public void tick() {
		super.tick();
		FirebrandFlamesWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static FirebrandFlamesEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 18f, 2, 5);
	}

	public static FirebrandFlamesEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		FirebrandFlamesEntity entityarrow = new FirebrandFlamesEntity(SwordsOfTimeModEntities.FIREBRAND_FLAMES, entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("swords_of_time:firebrand")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static FirebrandFlamesEntity shoot(LivingEntity entity, LivingEntity target) {
		FirebrandFlamesEntity entityarrow = new FirebrandFlamesEntity(SwordsOfTimeModEntities.FIREBRAND_FLAMES, entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 18f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("swords_of_time:firebrand")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}