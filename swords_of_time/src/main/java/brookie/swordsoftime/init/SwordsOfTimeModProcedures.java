/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package brookie.swordsoftime.init;

import brookie.swordsoftime.procedures.VenomshankRightclickedProcedure;
import brookie.swordsoftime.procedures.VenomshankPoisonWhileProjectileFlyingTickProcedure;
import brookie.swordsoftime.procedures.VenomshankPoisonProjectileHitsLivingEntityProcedure;
import brookie.swordsoftime.procedures.VenomshankLivingEntityIsHitWithToolProcedure;
import brookie.swordsoftime.procedures.ThrownSuperballProjectileHitsLivingEntityProcedure;
import brookie.swordsoftime.procedures.ThrownSuperballProjectileHitsBlockProcedure;
import brookie.swordsoftime.procedures.ThrownHyperballProjectileHitsLivingEntityProcedure;
import brookie.swordsoftime.procedures.ThrownHyperballProjectileHitsBlockProcedure;
import brookie.swordsoftime.procedures.LinkedSwordRightclickedProcedure;
import brookie.swordsoftime.procedures.IceScepterLivingEntityIsHitWithItemProcedure;
import brookie.swordsoftime.procedures.IceDaggerRightclickedProcedure;
import brookie.swordsoftime.procedures.IceDaggerLivingEntityIsHitWithToolProcedure;
import brookie.swordsoftime.procedures.GhostwalkerToolInHandTickProcedure;
import brookie.swordsoftime.procedures.GhostwalkerRightclickedProcedure;
import brookie.swordsoftime.procedures.GhostwalkerLivingEntityIsHitWithToolProcedure;
import brookie.swordsoftime.procedures.FirebrandRightclickedProcedure;
import brookie.swordsoftime.procedures.FirebrandLivingEntityIsHitWithToolProcedure;
import brookie.swordsoftime.procedures.FirebrandFlamesWhileProjectileFlyingTickProcedure;
import brookie.swordsoftime.procedures.FirebrandFlamesProjectileHitsLivingEntityProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SwordsOfTimeModProcedures {
	public static void load() {
		new IceDaggerRightclickedProcedure();
		new IceDaggerLivingEntityIsHitWithToolProcedure();
		new VenomshankPoisonProjectileHitsLivingEntityProcedure();
		new VenomshankPoisonWhileProjectileFlyingTickProcedure();
		new VenomshankRightclickedProcedure();
		new VenomshankLivingEntityIsHitWithToolProcedure();
		new GhostwalkerRightclickedProcedure();
		new GhostwalkerLivingEntityIsHitWithToolProcedure();
		new GhostwalkerToolInHandTickProcedure();
		new FirebrandFlamesWhileProjectileFlyingTickProcedure();
		new FirebrandFlamesProjectileHitsLivingEntityProcedure();
		new FirebrandRightclickedProcedure();
		new FirebrandLivingEntityIsHitWithToolProcedure();
		new ThrownSuperballProjectileHitsLivingEntityProcedure();
		new ThrownHyperballProjectileHitsLivingEntityProcedure();
		new ThrownSuperballProjectileHitsBlockProcedure();
		new ThrownHyperballProjectileHitsBlockProcedure();
		new IceScepterLivingEntityIsHitWithItemProcedure();
		new LinkedSwordRightclickedProcedure();
	}
}