package emeraldCasino.api.games.core;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract class APlayer implements IPlayer{

	@Override
	public EntityPlayerMP getPlayer(String playerName) {
		Minecraft.getMinecraft();
		return null;
	}

}
