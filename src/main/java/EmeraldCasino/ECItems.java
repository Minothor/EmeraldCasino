package emeraldCasino;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.items.*;
import emeraldCasino.renderers.items.ItemCardHandRenderer;

public class ECItems {
	public static Item itemCardDeck;
	public static Item itemCardHand;
	
	private ECItems() {}
	
	public static void register(CreativeTabs tabEC)
	{
		//Initalise Items
  		itemCardDeck = new itemCardDeck().setUnlocalizedName("cardDeck").setTextureName(EmeraldCasino.MODID + ":" + "CardDeck").setMaxStackSize(1);
  		itemCardHand = new itemCardHand().setUnlocalizedName("cardHand").setTextureName(EmeraldCasino.MODID + ":" + "CardDeck").setMaxStackSize(1);
  		
  		itemCardDeck.setCreativeTab(tabEC);
  		itemCardHand.setCreativeTab(tabEC);//to be removed once testing is complete
  		
  		GameRegistry.registerItem(itemCardDeck, "cardDeck");
  		GameRegistry.registerItem(itemCardHand, "cardHand");
	}
}
