package emeraldCasino.api.games.core;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IPlayer {
	
	EntityPlayerMP getPlayer(String playerName);

}
