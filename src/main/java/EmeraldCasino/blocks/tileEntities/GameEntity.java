package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;

import emeraldCasino.network.packets.GameMessage;
import emeraldCasino.network.packets.GameUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class GameEntity extends TileEntity{
	protected int gameID;
	protected String ownerDisplayName;
	protected List<String> players;
	protected HashMap<String, Integer> playerBalances;
	
	
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
		nbtTag.setInteger("gameID", this.gameID);
		nbtTag.setString("playerList", condensePlayers());
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
	public void readFromNBT(NBTTagCompound nbtTag)
	{
		super.readFromNBT(nbtTag);
		this.gameID = nbtTag.getInteger("gameID");
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
