package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.BiMap;

import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.EmeraldCasino;
import emeraldCasino.api.games.EGameType;
import emeraldCasino.api.games.core.*;
import emeraldCasino.api.games.card.*;
import emeraldCasino.api.games.card.core.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCardBlock extends GameEntity{
	
	private ICardGame game;
	private IDeck deck;
	private String gameNBTcondensed="";
	private String playersNBTcondensed="";
	private HashMap<String, CardPlayer> players;


	public TileEntityCardBlock() {
		super();
		players = new HashMap<String, CardPlayer>();
		System.out.println("Tile Entity Created!");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
	    super.readFromNBT(nbt);
	    
	    if(nbt.hasKey("playerList"))
	    {
	    	this.playersNBTcondensed = nbt.getString("playerList");
	    	expandPlayers();
		}
	    
	    if(nbt.hasKey("gameID"))
	    {
	    this.gameNBTcondensed = nbt.getString("gameID");
	    System.out.println("GameID: "+gameNBTcondensed);
	    resolveGame();
	    }
	    
	    
	}
	
	private void resolveGame() {
		this.game=(ICardGame) emeraldCasino.CasinoRegistry.getGame(EGameType.CARD,gameNBTcondensed);
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		condensePlayers();
	    super.writeToNBT(nbt);
	    if(!playersNBTcondensed.equals(""))
	    {
	    nbt.setString("playerList", playersNBTcondensed);
	    }
	    
	    if( this.game!=null)
	    {
	    nbt.setString("gameID", emeraldCasino.CasinoRegistry.getGameID(this.game));
	    }
	}

	private void condensePlayers()
	{
		if(!players.isEmpty())
		{
			for (CardPlayer player : players.values())
			{
				playersNBTcondensed+=(player.getPlayer().getDisplayName()+",");
			}
			playersNBTcondensed=playersNBTcondensed.substring(0, playersNBTcondensed.lastIndexOf(','));
		} else {
			playersNBTcondensed = "";
		}
		
	}
	
	private void expandPlayers()
	{
		players.clear();
		String[] playerList = playersNBTcondensed.split(",");
		if (playerList.length>0)
		{
			for (String player : playerList) {
				players.put(player, (CardPlayer) game.addPlayer(player));
			}
		}
	}
	
	public List<ICard> getPlayerHand(String displayName) {
		return getPlayerHand(displayName, 0);
	}
	
	public List<ICard> getPlayerHand(String displayName, int handID) {
		if (this.players.containsKey(displayName))
		{
			return this.players.get(displayName).getHand(handID);
		}
		return null;
	}
	
	@Override
	public void activatedBy(EntityPlayer player) {
		if(player.isClientWorld()&&player.inventory.getStackInSlot(player.inventory.currentItem)==null)
		{
			if(!(players.containsKey(player.getDisplayName())))
			{
				players.put(player.getDisplayName(), new CardPlayer(new Hand(),player));
				int[] gameCoords = new int[3];
				gameCoords[0]=this.xCoord;
				gameCoords[1]=this.yCoord;
				gameCoords[2]=this.zCoord;
				ItemStack hand =new ItemStack(game.getInterfaceItem());
				hand.stackTagCompound = new NBTTagCompound();
				hand.getTagCompound().setIntArray("gameCoords", gameCoords);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, hand);
				//super.activatedBy(player);
			}
		}
	}
	
	
	


	

}
