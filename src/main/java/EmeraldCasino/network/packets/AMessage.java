package emeraldCasino.network.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import javax.vecmath.Point3d;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.blocks.tileEntities.GameEntity;

public abstract class AMessage implements IMessage {
	protected static JsonParser jsonReader = new JsonParser();
	World targetWorld = MinecraftServer.getServer().getEntityWorld();
	protected int targetX,targetY,targetZ;
	public String packetPayload;
	protected JsonObject packetData;

	protected boolean transferData()
	{
		return false;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		packetPayload =  ByteBufUtils.readUTF8String(buf);
		//packetData = jsonReader.parse(packetPayload).getAsJsonObject();

	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		//packetPayload = packetData.getAsString();
		ByteBufUtils.writeUTF8String(buf, packetPayload);

	}

}
