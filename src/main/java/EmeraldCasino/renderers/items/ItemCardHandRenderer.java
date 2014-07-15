package emeraldCasino.renderers.items;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import emeraldCasino.api.games.card.ICardGame;
import emeraldCasino.api.games.card.core.*;
import emeraldCasino.items.itemCardHand;
import emeraldCasino.CasinoRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class ItemCardHandRenderer implements IItemRenderer {
	int itemRenderId;
	Tessellator tessellator;
	Minecraft minecraft;
	ICardGame gameMethods;
	TileEntity parentBlock;
	RenderManager renderManager;
	Render render;
	ResourceLocation deckTexture;
	EntityClientPlayerMP entityclientplayer;
	int totalCards;
	
	public ItemCardHandRenderer() {
		itemRenderId = RenderingRegistry.getNextAvailableRenderId();
		tessellator = Tessellator.instance;
		minecraft = Minecraft.getMinecraft();
		renderManager = RenderManager.instance;
		deckTexture = new ResourceLocation(emeraldCasino.EmeraldCasino.MODID,"textures/cardDecks/deck_standard.png");
		entityclientplayer = minecraft.thePlayer;
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return (type==EQUIPPED_FIRST_PERSON);
	}
	
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{	
		//renderArm('R');
		
		renderCardHand(item);

       
	}

	private void renderCardHand(ItemStack item) {
		//String targetX = item.readFromNBT(par1NBTTagCompound);
		int house = 1;
		int value = 1;
		totalCards=7;
		
		GL11.glPushMatrix();
		GL11.glRotatef((float)(totalCards/Math.PI)*15F, 0F, 1F, 0F);
		float xPos = 0F;//renderManager.playerViewX;
		float yPos = 0F;//renderManager.playerViewY;
		for(int cardIndex=1;cardIndex<=totalCards;cardIndex++)
		{
		if(house>4)
			house=1;
		if(value>13)
			value=13;
		renderCard(house,value,xPos,yPos,cardIndex);
		xPos+=0.5F;
		house++;
		value++;
		}
		
		GL11.glTranslatef(0F, -2F, 0F);
		GL11.glPopMatrix();
	}

	private void renderCard(int house, int value, float xPos, float yPos, int cardIndex) {
		float zPos = (0F-totalCards)+(0.1F*cardIndex); 
		float xUnit = 1.0F/256, yUnit = 1.0F/256;
		float xCorrection = 0F;
		if (value>1)
			xCorrection=(value-1)*xUnit;
		float startX = (((value-1)*18)*xUnit)+xCorrection;
		float endX = ((value*18)*xUnit)+xCorrection;
		
			
		
		float startY = ((house-1)*32)*yUnit;
		float endY = (house*32)*yUnit;
		
		/*System.out.println("House: "+house
				+"\nValue: "+value
				+"\n---"
				+"\nstartX: "+startX
				+"\nendX: "+endX
				+"\nstartY: "+startY
				+"\nendY: "+endY
				+"\n==============");
		*/
		GL11.glPushMatrix();
		GL11.glRotatef(cardIndex*-15F, 0F, 1F, 0F);
		minecraft.getTextureManager().bindTexture(deckTexture);
		tessellator.startDrawingQuads();
		float scale=0.1F;//for testing but proved useful for tweaking
		//draw card vertices here
		tessellator.addVertexWithUV(scale*(xPos+18), scale*yPos, zPos, endX+xUnit, endY); //lower right
		tessellator.addVertexWithUV(scale*(xPos+18), scale*(yPos+32), zPos, endX+xUnit, startY); //upper right
		tessellator.addVertexWithUV(scale*xPos, scale*(yPos+32), zPos, startX, startY);//upper left
		tessellator.addVertexWithUV(scale*xPos, scale*yPos, zPos, startX, endY);//lower left
		tessellator.draw();
		
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glPopMatrix();
	}

	private void renderArm(char arm) {
		minecraft.getTextureManager().bindTexture(entityclientplayer.getLocationSkin());
		
		GL11.glPushMatrix();
		
		render = renderManager.getEntityRenderObject(entityclientplayer);
		RenderPlayer renderplayer = (RenderPlayer)render;
		if(arm=='R')
		{
		GL11.glRotatef(30.0F, -1.0F, 1.0F, -0.4F);
		GL11.glTranslatef(0.6F, 0.6F, 0.9F);
		//GL11.glRotatef(30.0F, 0.0F, 0.0F, 1.0F);
		//GL11.glRotatef(-20.0F, 0.0F, 1F, 0.0F);
		//GL11.glRotatef(-25.0F, 1F, 0.0F, 0.0F);
		//GL11.glTranslatef(0.2F, -0.1F, -0.2F);
		renderplayer.renderFirstPersonArm(entityclientplayer);
//		GL11.glTranslatef(0.0F, -0.5F, 0.0F);
//		GL11.glRotatef(90.0F, 1.0F, 1.0F, 0.0F);
		} else if (arm=='L')
		{
			
		}
		GL11.glPopMatrix();
	}

	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType arg0, ItemStack arg1,
			ItemRendererHelper arg2) {
		return arg0==EQUIPPED_FIRST_PERSON;
	}



}
