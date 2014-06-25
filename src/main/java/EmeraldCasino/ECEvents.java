package EmeraldCasino;

import cpw.mods.fml.common.FMLCommonHandler;
import EmeraldCasino.events.*;

public class ECEvents {

	public static void register() {
		
		FMLCommonHandler.instance().bus().register(new cardHandHandler());
		
	}

}
