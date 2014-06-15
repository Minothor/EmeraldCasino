package EmeraldCasino;

//Mod Imports
import EmeraldCasino.blocks.tileEntities.*;
import EmeraldCasino.blocks.*;
import EmeraldCasino.items.*;
import EmeraldCasino.proxies.*;
import EmeraldCasino.financial.*;

//Item/Block related Imports
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

//Forge Imports
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = EmeraldCasino.MODID, name = EmeraldCasino.NAME, version = EmeraldCasino.VERSION)
public class EmeraldCasino
{
    public static final String MODID = "emeraldcasino";
    public static final String NAME = "Emerald Casino";
    public static final String VERSION = "1.7.2 - 1.0.0";
    
    @Instance(value = "emeraldcasino")
	public static EmeraldCasino instance;
    
    @SidedProxy(clientSide="EmeraldCasino.proxies.ClientProxy", serverSide="EmeraldCasino.proxies.CommonProxy")
    public static CommonProxy proxy;
    
  //Declare Tab
  	//Set Creative Tab Icon
  	public static CreativeTabs tabEC;

  	//Declare Items
  	public static Item itemCardDeck;

  	//Declare Blocks
  	public static Block blockCardDeck;
    
  	@EventHandler
  	public void preInit(FMLPreInitializationEvent event)
  	{
  		tabEC = new CreativeTabs("tabEC"){
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.emerald_block);
			}
		};
		//Initalise Items
  		itemCardDeck = new itemCardDeck().setUnlocalizedName("cardDeck").setCreativeTab(tabEC).setTextureName(MODID + ":" + "CardDeck");
  		GameRegistry.registerItem(itemCardDeck, "cardDeck");
  		
  		//Initialise Blocks and TileEntities
  		blockCardDeck = new blockCardDeck().setBlockName("CardDeckBlock").setCreativeTab(tabEC);
  		GameRegistry.registerBlock(blockCardDeck, "cardDeckBlock");
  		//GameRegistry.registerTileEntity(TileEntityCardBlock.class, "tileEntityCardDeck");
    	
  	}
  	
  	@EventHandler
  	public void init(FMLInitializationEvent event)
  	{
  	//Add Relevant Recipes
  			proxy.registerRenderers();
  			GameRegistry.registerTileEntity(TileEntityCardBlock.class, "tileEntityCardDeck");
  			
  			GameRegistry.addRecipe(new ShapelessOreRecipe( new ItemStack(itemCardDeck), "dyeBlack", "dyeRed", new ItemStack(Items.paper,52)));
  	  		
  	}
    
    @EventHandler
	public void load(FMLLoadEvent event)
  	{
		

	}
  	
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    	
    }
    
}
