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
		//Register Channel
		ECchannel = NetworkRegistry.INSTANCE.newSimpleChannel(EmeraldCasino.MODID);
		
		//register Packets
		ECchannel.registerMessage(ECMessageHandler.class, GameMessage.class, 0, Side.SERVER); 
		
	}

}
