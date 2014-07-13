package emeraldCasino.api.games;

import emeraldCasino.api.games.card.core.CardPlayer;
import emeraldCasino.api.games.core.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldSettings.GameType;

public interface IGame {
	public EGameType getType();
	public String getID();
	public IPlayer addPlayer(String username);
	public EntityPlayer getPlayer(String username);	
	public void removePlayer(String username);
	public void EvalGame();
	public String getName();
	public void setOwner(EntityPlayer owner);
	public String getOwner();
}
