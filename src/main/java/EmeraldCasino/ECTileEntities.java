package emeraldCasino;

import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.tileEntities.TileEntityCardBlock;

public class ECTileEntities {

	private ECTileEntities() {}
	
	public static void register() {
		
		GameRegistry.registerTileEntity(TileEntityCardBlock.class, "tileEntityCardDeck");
		
	}

}
