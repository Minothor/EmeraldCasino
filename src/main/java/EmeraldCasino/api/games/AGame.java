package emeraldCasino.api.games;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldSettings.GameType;

public abstract class AGame implements IGame {
	protected String gameName;
	protected String ownerName;
	protected EGameType type;
	
	public String getName() {
		return gameName;
	}
	
	public void setOwner(EntityPlayer owner) {
		this.ownerName = owner.getDisplayName();
	}
	public String getOwner() {
		return ownerName;
	}
	
	public EGameType getType()
	{
		return this.type;
	}
	
	public String getID()
	{
		return this.getType().toString()+"."+this.gameName.trim();
	}
	
}
