package brookie.swordsoftime.item;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.api.EnvType;

import java.util.List;

import brookie.swordsoftime.procedures.VenomshankRightclickedProcedure;
import brookie.swordsoftime.procedures.VenomshankLivingEntityIsHitWithToolProcedure;

public class VenomshankItem extends SwordItem {
	public VenomshankItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.VINE), new ItemStack(Blocks.WEEPING_VINES), new ItemStack(Blocks.TWISTING_VINES), new ItemStack(Blocks.OAK_LEAVES), new ItemStack(Blocks.SPRUCE_LEAVES), new ItemStack(Blocks.BIRCH_LEAVES),
						new ItemStack(Blocks.JUNGLE_LEAVES), new ItemStack(Blocks.ACACIA_LEAVES), new ItemStack(Blocks.DARK_OAK_LEAVES), new ItemStack(Blocks.MANGROVE_LEAVES), new ItemStack(Blocks.AZALEA_LEAVES),
						new ItemStack(Blocks.FLOWERING_AZALEA_LEAVES), new ItemStack(Blocks.CHERRY_LEAVES));
			}

			public int getLevel() {
				return 1;
			}
		}, 3, 11f, new Item.Properties().fireResistant());
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(content -> content.accept(this));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level();
		VenomshankLivingEntityIsHitWithToolProcedure.execute(world, entity, itemstack);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		VenomshankRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getRecipeRemainder(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Deals 2 damage and poisons all enemies. Requires 1 XP level."));
	}

	@Override
	@net.fabricmc.api.Environment(EnvType.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}