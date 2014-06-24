package EmeraldCasino;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import EmeraldCasino.blocks.blockCardDeck;
import EmeraldCasino.items.itemCardDeck;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECItems {
	public static Item itemCardDeck;
	
	private ECItems() {}
	
	public static void register(CreativeTabs tabEC)
	{
		//Initalise Items
  		itemCardDeck = new itemCardDeck().setUnlocalizedName("cardDeck").setCreativeTab(tabEC).setTextureName(EmeraldCasino.MODID + ":" + "CardDeck").setMaxStackSize(1);
  		
  		itemCardDeck.setCreativeTab(tabEC);
  		
  		GameRegistry.registerItem(itemCardDeck, "cardDeck");
	}
}
