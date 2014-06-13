package EmeraldCasino.renderers.blocks;

import org.lwjgl.opengl.GL11;

import com.jcraft.jorbis.Block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import EmeraldCasino.models.modelCardDeck;

/**
 * 
 * @author Minothor, Flenix
 *Renders the card Decks in the world
 *Adapted from Flenix's Tutorial at:
 *http://www.minecraftforge.net/wiki/Rendering_a_Techne_Model_as_a_Block
 */
public class blockCardDeckRenderer extends TileEntitySpecialRenderer {
	private final modelCardDeck model;
	
	public blockCardDeckRenderer() {
		model = new modelCardDeck();
	}



	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y,
			double z, float scale) {
		GL11.glPushMatrix();
		//initial location (what's up with the 0.5 and 1.5 difference I wonder)
		 GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		 ResourceLocation texture = (new ResourceLocation("emeraldcasino:textures/blocks/tileDeck.png"));
		//binding the textures
         Minecraft.getMinecraft().renderEngine.bindTexture(texture);
         //let LWGL know we're doing more matixy manipulation stuff
         GL11.glPushMatrix();
         //rotate to avoid model rendering upside down
         GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
         
         //pop both sections off the render stack
         GL11.glPopMatrix();
         GL11.glPopMatrix();
	}
	 private void adjustLightFixture(World world, int i, int j, int k, Block block) {
         Tessellator tess = Tessellator.instance;
         float brightness = block.getBlockBrightness(world, i, j, k);
         int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
         int modulousModifier = skyLight % 65536;
         int divModifier = skyLight / 65536;
         tess.setColorOpaque_F(brightness, brightness, brightness);
         OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
 }

}