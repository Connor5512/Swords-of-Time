/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package brookie.swordsoftime.init;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class SwordsOfTimeModEntityRenderers {
	public static void load() {
		EntityRendererRegistry.register(SwordsOfTimeModEntities.VENOMSHANK_POISON, ThrownItemRenderer::new);
		EntityRendererRegistry.register(SwordsOfTimeModEntities.FIREBRAND_FLAMES, ThrownItemRenderer::new);
		EntityRendererRegistry.register(SwordsOfTimeModEntities.THROWN_SUPERBALL, ThrownItemRenderer::new);
		EntityRendererRegistry.register(SwordsOfTimeModEntities.THROWN_HYPERBALL, ThrownItemRenderer::new);
	}
}