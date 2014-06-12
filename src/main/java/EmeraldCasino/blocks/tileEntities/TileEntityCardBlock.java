package EmeraldCasino.blocks.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCardBlock extends TileEntity {
	 @Override
	   public void writeToNBT(NBTTagCompound par1)
	   {
	      super.writeToNBT(par1);
	   }
	 
	 public Packet getDescriptionPacket() {
	        NBTTagCompound nbtTag = new NBTTagCompound();
	        this.writeToNBT(nbtTag);
	        
	        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	        }
	 
	   @Override
	   public void readFromNBT(NBTTagCompound par1)
	   {
	      super.readFromNBT(par1);
	   }
	   
}
