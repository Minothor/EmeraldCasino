package EmeraldCasino;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = EmeraldCasino.MODID, version = EmeraldCasino.VERSION)
public class EmeraldCasino
{
    public static final String MODID = "emeraldcasino";
    public static final String VERSION = "0.0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
