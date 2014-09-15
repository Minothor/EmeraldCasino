package emeraldCasino;

import cpw.mods.fml.common.FMLCommonHandler;
import emeraldCasino.events.*;

public class ECEvents {

	public static void register() {
		
		FMLCommonHandler.instance().bus().register(new cardHandHandler());
		
	}

}
