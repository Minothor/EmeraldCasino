package emeraldCasino.api.games;

import net.minecraft.entity.player.EntityPlayer;

public abstract class AGame implements IGame {
	protected String gameName;
	protected String ownerName;
	
	public String getName() {
		return gameName;
	}
	
	public void setOwner(EntityPlayer owner) {
		this.ownerName = owner.getDisplayName();
	}
	public String getOwner() {
		return ownerName;
	}
	
}
