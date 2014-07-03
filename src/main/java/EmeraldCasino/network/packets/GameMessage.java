package emeraldCasino.network.packets;

import net.minecraft.world.World;

import javax.vecmath.Point3d;

import com.google.gson.JsonParser;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import emeraldCasino.blocks.tileEntities.GameEntity;

public class GameMessage implements IMessage {
	World targetWorld;
	Point3d targetLocation;
	String packetPayload;
	
	
	
	private boolean transferData()
	{
		GameEntity target = (GameEntity)targetWorld.getTileEntity((int)targetLocation.x, (int)targetLocation.y, (int)targetLocation.z);
		return target.processMessage(new GameUpdate(packetPayload));
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		packetPayload =  ByteBufUtils.readUTF8String(buf);
		transferData();

	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		

	}

}
