package emeraldCasino.proxies;

import sun.java2d.pipe.RenderingEngine;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import emeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import emeraldCasino.renderers.blocks.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCardBlock.class, new TileEntityCardBlockRenderer());
}
}
