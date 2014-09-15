package emeraldCasino;

//FML imports
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

//
import emeraldCasino.network.*;
import emeraldCasino.network.packets.*;

public class ECNetworking {
	
	public static void register(SimpleNetworkWrapper ECchannel) {
		
		
		//register Packets
		ECchannel.registerMessage(ECServerMessageHandler.class, GameMessage.class, 0, Side.SERVER);
		ECchannel.registerMessage(ECClientMessageHandler.class, PlayerMessage.class, 0, Side.CLIENT); 
		
	}

}
