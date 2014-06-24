package EmeraldCasino;

import EmeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECTileEntities {

	private ECTileEntities() {}
	
	public static void register() {
		
		GameRegistry.registerTileEntity(TileEntityCardBlock.class, "tileEntityCardDeck");
		
	}

}
