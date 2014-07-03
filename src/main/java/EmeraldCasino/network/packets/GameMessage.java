package emeraldCasino.network.packets;

import net.minecraft.entity.player.*;
import net.minecraft.world.World;

import javax.vecmath.Point3d;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.tileEntities.GameEntity;

public class GameMessage implements IMessage {
	protected static JsonParser jsonReader = new JsonParser();
	World targetWorld;
	Point3d targetLocation;
	String packetPayload;
	JsonObject packetData;
	
	
	
	private boolean transferData()
	{
		GameEntity target = (GameEntity)targetWorld.getTileEntity((int)targetLocation.x, (int)targetLocation.y, (int)targetLocation.z);
		return target.processMessage(new GameUpdate(packetPayload));
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		packetPayload =  ByteBufUtils.readUTF8String(buf);
		packetData = jsonReader.parse(packetPayload).getAsJsonObject();
		packetData.get("world").getAsString();
		transferData();

	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		packetPayload = packetData.getAsString();
		ByteBufUtils.writeUTF8String(buf, packetPayload);

	}

}
