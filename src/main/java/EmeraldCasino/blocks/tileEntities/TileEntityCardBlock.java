package emeraldCasino.blocks.tileEntities;

import java.util.HashMap;
import java.util.List;

import emeraldCasino.api.games.card.ACardGame;
import emeraldCasino.api.games.card.ICardGame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCardBlock extends GameEntity{
	
	private ACardGame game;
	
	private HashMap<String, Integer[][]> playerHands;


	public TileEntityCardBlock() {
		super();
		System.out.println("Tile Entity Created!");
	}
	
	


	

}
