/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package brookie.swordsoftime.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;

import brookie.swordsoftime.item.VenomshankItem;
import brookie.swordsoftime.item.SuperballItem;
import brookie.swordsoftime.item.NonexistantItemItem;
import brookie.swordsoftime.item.NetheriteShaftItem;
import brookie.swordsoftime.item.LinkedSwordItem;
import brookie.swordsoftime.item.IceShaftItem;
import brookie.swordsoftime.item.IceDaggerItem;
import brookie.swordsoftime.item.HyperballItem;
import brookie.swordsoftime.item.GhostwalkerItem;
import brookie.swordsoftime.item.FirebrandItem;
import brookie.swordsoftime.SwordsOfTimeMod;

public class SwordsOfTimeModItems {
	public static Item ICE_DAGGER;
	public static Item VENOMSHANK;
	public static Item NONEXISTANT_ITEM;
	public static Item GHOSTWALKER;
	public static Item FIREBRAND;
	public static Item SUPERBALL;
	public static Item HYPERBALL;
	public static Item ICE_SHAFT;
	public static Item NETHERITE_SHAFT;
	public static Item LINKED_SWORD;

	public static void load() {
		ICE_DAGGER = register("ice_dagger", new IceDaggerItem());
		VENOMSHANK = register("venomshank", new VenomshankItem());
		NONEXISTANT_ITEM = register("nonexistant_item", new NonexistantItemItem());
		GHOSTWALKER = register("ghostwalker", new GhostwalkerItem());
		FIREBRAND = register("firebrand", new FirebrandItem());
		SUPERBALL = register("superball", new SuperballItem());
		HYPERBALL = register("hyperball", new HyperballItem());
		ICE_SHAFT = register("ice_shaft", new IceShaftItem());
		NETHERITE_SHAFT = register("netherite_shaft", new NetheriteShaftItem());
		LINKED_SWORD = register("linked_sword", new LinkedSwordItem());
	}

	public static void clientLoad() {
	}

	private static Item register(String registryName, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SwordsOfTimeMod.MODID, registryName), item);
	}

	private static void registerBlockingProperty(Item item) {
		ItemProperties.register(item, new ResourceLocation("blocking"), (ClampedItemPropertyFunction) ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
	}
}