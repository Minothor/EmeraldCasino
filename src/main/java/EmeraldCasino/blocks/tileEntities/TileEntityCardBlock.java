package EmeraldCasino.blocks.tileEntities;

import EmeraldCasino.games.cards.ICardGame;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCardBlock extends TileEntity {
	private int GameID;
	private ICardGame game;


	public TileEntityCardBlock() {
		super();
		System.out.println("Tile Entity Created!");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTag)
	{
		super.writeToNBT(nbtTag);
		nbtTag.setInteger("GameID", this.GameID);
	}


	@Override
	public void readFromNBT(NBTTagCompound nbtTag)
	{
		super.readFromNBT(nbtTag);
		this.GameID = nbtTag.getInteger("GameID");
	}

}
