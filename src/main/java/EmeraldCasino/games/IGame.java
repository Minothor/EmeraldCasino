package EmeraldCasino.games;

import net.minecraft.entity.player.EntityPlayer;

public interface IGame {
	public void addPlayer(String username);
	public EntityPlayer getPlayer(String username);	
	public void removePlayer(String username);
	public void EvalGame();
	public String getName();
	public void setOwner(EntityPlayer owner);
	public String getOwner();
}
