package emeraldCasino;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.blockCardDeck;
import emeraldCasino.items.itemCardDeck;

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
