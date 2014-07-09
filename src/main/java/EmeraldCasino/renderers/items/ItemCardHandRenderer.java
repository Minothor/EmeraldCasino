package emeraldCasino.renderers.items;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emeraldCasino.items.itemCardHand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class ItemCardHandRenderer implements IItemRenderer {
	int itemRenderId;
	
	public ItemCardHandRenderer() {
		itemRenderId = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return (type==EQUIPPED_FIRST_PERSON);
	}
	
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		
		
		/*
		 * Vanilla Map Rendering -- to Modify
		 */
		float f1 = 1.0F;
		float par1 = 0.5F;//temp testing
		Minecraft minecraft = Minecraft.getMinecraft();
		EntityClientPlayerMP entityclientplayermp = minecraft.thePlayer;
		ResourceLocation deckTexture = new ResourceLocation(emeraldCasino.EmeraldCasino.MODID,"textures/cardDecks/deck_standard.png");
		float f2 = entityclientplayermp.prevRotationPitch + (entityclientplayermp.rotationPitch - entityclientplayermp.prevRotationPitch) * par1;
        
        	//GET PARENT GAME FROM HAND
        	//GET DECK TEXTURE FROM GAME
        	//BIND DECK TEXTURE FROM GAME
        	//GET CARDS & CARD DATA FROM HAND
        	
            GL11.glPushMatrix();
            float f13 = 0.8F;
            float swingProgress = entityclientplayermp.getSwingProgress(par1);
            float f6 = MathHelper.sin(swingProgress * (float)Math.PI);
            float f7 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI);
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
            minecraft.getTextureManager().bindTexture(entityclientplayermp.getLocationSkin());
			
			
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
                Render render = RenderManager.instance.getEntityRenderObject(entityclientplayermp);
                RenderPlayer renderplayer = (RenderPlayer)render;
                float f10 = 1.0F;
                GL11.glScalef(f10, f10, f10);
                renderplayer.renderFirstPersonArm(entityclientplayermp);
                GL11.glPopMatrix();
            }

            f6 = entityclientplayermp.getSwingProgress(par1);
            f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI);
            GL11.glRotatef(-f7 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f8 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f8 * 80.0F, 1.0F, 0.0F, 0.0F);
            float f9 = 0.38F;
            GL11.glScalef(f9, f9, f9);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
            float f10 = 0.015625F;
            GL11.glScalef(f10, f10, f10);
            minecraft.getTextureManager().bindTexture(deckTexture);
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
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType arg0, ItemStack arg1,
			ItemRendererHelper arg2) {
		return arg0==EQUIPPED_FIRST_PERSON;
	}



}
