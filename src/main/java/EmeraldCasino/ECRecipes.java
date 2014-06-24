package EmeraldCasino;

import javax.imageio.spi.RegisterableService;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECRecipes {
	private ECRecipes() {}
	
	public static void register()
	{
		GameRegistry.addRecipe(new ShapelessOreRecipe( new ItemStack(ECItems.itemCardDeck), "dyeBlack", "dyeRed", new ItemStack(Items.paper,52)));
	}
}
