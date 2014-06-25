package EmeraldCasino.proxies;

import net.minecraft.client.renderer.ItemRenderer;
import EmeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import EmeraldCasino.renderers.blocks.*;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCardBlock.class, new TileEntityCardBlockRenderer());
        
}
}
