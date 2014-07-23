package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.BiMap;

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
	private String gameNBTcondensed="";
	private String playersNBTcondensed="";
	private HashMap<String, CardPlayer> players;


	public TileEntityCardBlock() {
		super();
		System.out.println("Tile Entity Created!");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
	    super.readFromNBT(nbt);
	    this.playersNBTcondensed = nbt.getString("playerList");
	    this.gameNBTcondensed = nbt.getString("gameID");
	    resolveGameType();
	    expandPlayers();
	    
	}
	
	private void resolveGameType() {
		this.game=(ICardGame) emeraldCasino.CasinoRegistry.getGame(EGameType.CARD,gameNBTcondensed);
		
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		condensePlayers();
	    super.writeToNBT(nbt);
	    nbt.setString("playerList", playersNBTcondensed);
	    nbt.setString("gameID", emeraldCasino.CasinoRegistry.getGameID(this.game));
	}

	private void condensePlayers()
	{
		for (CardPlayer player : players.values()) {
			playersNBTcondensed+=(player.getPlayer().getDisplayName()+",");
		}
		playersNBTcondensed=playersNBTcondensed.substring(0, playersNBTcondensed.lastIndexOf(','));
	}
	
	private void expandPlayers()
	{
		players.clear();
		String[] playerList = playersNBTcondensed.split(",");
		for (String player : playerList) {
			players.put(player, (CardPlayer) game.addPlayer(player));
		}
	}
	
	
	
	
	


	

}
