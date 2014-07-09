package emeraldCasino.proxies;

import sun.java2d.pipe.RenderingEngine;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import emeraldCasino.ECItems;
import emeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import emeraldCasino.renderers.blocks.*;
import emeraldCasino.renderers.items.ItemCardHandRenderer;

public class ClientProxy extends CommonProxy {
	public static ItemCardHandRenderer cardHandRenderer;
	
	@Override
	public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCardBlock.class, new TileEntityCardBlockRenderer());
        
        cardHandRenderer = new ItemCardHandRenderer();
  		
  		MinecraftForgeClient.registerItemRenderer(ECItems.itemCardHand, cardHandRenderer);
}
}
