package emeraldCasino.renderers.items;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.FIRST_PERSON_MAP;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ItemCardHandRenderer implements IItemRenderer {
	
	public ItemCardHandRenderer() {
		//itemRenderId = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return (type==ItemRenderType.EQUIPPED_FIRST_PERSON);
	}

	@Override
	public void renderItem(ItemRenderType renderType, ItemStack itemstack, Object... obj) {
		
		
		/*
		 * Vanilla Map Rendering -- to Modify
		 *
		if (itemstack != null && itemstack.getItem() instanceof itemCardHand)
        {
        	//GET PARENT GAME FROM HAND
        	//GET DECK TEXTURE FROM GAME
        	//BIND DECK TEXTURE FROM GAME
        	//GET CARDS & CARD DATA FROM HAND
        	
            GL11.glPushMatrix();
            f13 = 0.8F;
            swingProgress = entityclientplayermp.getSwingProgress(par1);
            f6 = MathHelper.sin(swingProgress * (float)Math.PI);
            f7 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI);
            GL11.glTranslatef(-f7 * 0.4F, MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI * 2.0F) * 0.2F, -f6 * 0.2F);
            swingProgress = 1.0F - f2 / 45.0F + 0.1F;

            if (swingProgress < 0.0F)
            {
                swingProgress = 0.0F;
            }

            if (swingProgress > 1.0F)
            {
                swingProgress = 1.0F;
            }

            swingProgress = -MathHelper.cos(swingProgress * (float)Math.PI) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, 0.0F * f13 - (1.0F - f1) * 1.2F - swingProgress * 0.5F + 0.04F, -0.9F * f13);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(swingProgress * -85.0F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            this.mc.getTextureManager().bindTexture(entityclientplayermp.getLocationSkin());
			
			
			//RENDER CARD RECTS IN ARC -- INCREASE DISTANCE FROM ORIGIN FOR ACTIVE CARDS
			
			
            for (int i1 = 0; i1 < 2; ++i1)
            {
                int j1 = i1 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)j1);
                GL11.glRotatef((float)(-45 * j1), 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef((float)(-65 * j1), 0.0F, 1.0F, 0.0F);
                render = RenderManager.instance.getEntityRenderObject(this.mc.thePlayer);
                renderplayer = (RenderPlayer)render;
                f10 = 1.0F;
                GL11.glScalef(f10, f10, f10);
                renderplayer.renderFirstPersonArm(this.mc.thePlayer);
                GL11.glPopMatrix();
            }

            f6 = entityclientplayermp.getSwingProgress(par1);
            f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            f8 = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI);
            GL11.glRotatef(-f7 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f8 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f8 * 80.0F, 1.0F, 0.0F, 0.0F);
            f9 = 0.38F;
            GL11.glScalef(f9, f9, f9);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
            f10 = 0.015625F;
            GL11.glScalef(f10, f10, f10);
            this.mc.getTextureManager().bindTexture(deckTexture);
            Tessellator tessellator = Tessellator.instance;
            GL11.glNormal3f(0.0F, 0.0F, -1.0F);
            tessellator.startDrawingQuads();
            byte b0 = 7;
            tessellator.addVertexWithUV((double)(0 - b0), (double)(128 + b0), 0.0D, 0.0D, 1.0D);
            tessellator.addVertexWithUV((double)(128 + b0), (double)(128 + b0), 0.0D, 1.0D, 1.0D);
            tessellator.addVertexWithUV((double)(128 + b0), (double)(0 - b0), 0.0D, 1.0D, 0.0D);
            tessellator.addVertexWithUV((double)(0 - b0), (double)(0 - b0), 0.0D, 0.0D, 0.0D);
            tessellator.draw();

            GL11.glPopMatrix();
        }
		 */
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType arg0, ItemStack arg1,
			ItemRendererHelper arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
