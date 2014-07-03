package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;
import com.google.common.collect.BiMap;

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
	
	private HashMap<String, CardPlayer> players;


	public TileEntityCardBlock() {
		super();
		System.out.println("Tile Entity Created!");
	}
	
	


	

}
