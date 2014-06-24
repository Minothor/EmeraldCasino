package EmeraldCasino;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import EmeraldCasino.blocks.blockCardDeck;
import EmeraldCasino.items.itemCardDeck;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECBlocks {
	public static Block blockCardDeck;
	private ECBlocks() {}
	
	public static void register(CreativeTabs tabEC)
	{
		//Initialise Blocks
  		blockCardDeck = new blockCardDeck().setBlockName("CardDeckBlock");
  		if(tabEC!=null)
  			//blockCardDeck.setCreativeTab(tabEC); //Commented out to stop card deck blocks being in creative
  		GameRegistry.registerBlock(blockCardDeck, "cardDeckBlock");
	}
}
