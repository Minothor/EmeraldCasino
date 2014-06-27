package emeraldCasino.proxies;

import net.minecraft.client.renderer.ItemRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import emeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import emeraldCasino.renderers.blocks.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCardBlock.class, new TileEntityCardBlockRenderer());
}
}
