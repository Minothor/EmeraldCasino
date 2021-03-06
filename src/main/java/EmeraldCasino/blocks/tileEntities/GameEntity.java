package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;

import emeraldCasino.api.games.IGame;
import emeraldCasino.network.packets.GameMessage;
import emeraldCasino.network.packets.GameUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public abstract class GameEntity extends TileEntity{
	protected String gameID;
	protected IGame gameInst; 
	protected String ownerDisplayName;
	protected List<String> players;
	protected HashMap<String, Integer> playerBalances;
	
	//handle most common packet JSON->NBT transfers here, override function for game specific data.
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		//TODO: Get this damn working!
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTag)
	{
		super.writeToNBT(nbtTag);
		if(!(gameID==null)&&!gameID.equals(""))
		{
			nbtTag.setString("gameID", this.gameID);
		}
		
		if(!(players==null)&&!players.isEmpty())
		{
			nbtTag.setString("playerList", condensePlayers());
		}
	}
	
	public void setOwner(EntityPlayer owner)
	{
		String ownerName = owner.getDisplayName();
		if (ownerName!=null)
			this.ownerDisplayName = ownerName;
	}
	
	public String getOwner()
	{
		return this.ownerDisplayName;
	}

	public boolean processMessage(GameUpdate data)
	{
		
		return true;
	}

	@Override
	public boolean canUpdate()
	{
		return false;
	};
	
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTag)
	{
		super.readFromNBT(nbtTag);
		
		if(nbtTag.hasKey("gameID"))
		{
			this.gameID = nbtTag.getString("gameID");
		}
	}
	
	private String condensePlayers() {
		String playerList="";
		/*int count=1;
		for (String playerName : players) {
			playerList+=playerName;
			count++;
			if(count<players.size())
				playerList+=",";
		}*/
		return playerList;
	}
	
	private boolean expandPlayers(String playerList) {
		String[] playerArray = playerList.split(",");
		players.clear();
		boolean successful= true;
		for (String playerName : playerArray) {
			successful = (successful && players.add(playerName));
		}
		return successful;
	}



	public void activatedBy(EntityPlayer player) {
		if (player.isClientWorld())
		{
			System.out.println("All Alone?");
		} else {
			System.out.println("Let's play a game "+player.getDisplayName()+"!");
		}
	}
	
}
