package emeraldCasino.api.games;

import emeraldCasino.api.games.core.IPlayer;
import emeraldCasino.items.IGameInterfaceItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.WorldSettings.GameType;

public abstract class AGame implements IGame {
	protected String gameName;
	protected String ownerName;
	protected EGameType type;
	protected IGameInterfaceItem interfaceItem;
	
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

	public IPlayer addPlayer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityPlayer getPlayer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removePlayer(String username) {
		// TODO Auto-generated method stub
		
	}

	public void EvalGame() {
		// TODO Auto-generated method stub
		
	}

	public Item getInterfaceItem() {
		return (Item) interfaceItem;
	}
	
}
