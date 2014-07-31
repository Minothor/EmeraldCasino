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

public class GameMessage extends AMessage {
	World targetWorld = MinecraftServer.getServer().getEntityWorld();
	protected int targetX,targetY,targetZ;
	
	public GameMessage() {}
	
	public GameMessage(String string) {
		this.packetPayload=string;
	}
	
	@Override
	public boolean transferData()
	{
		GameEntity target = (GameEntity)targetWorld.getTileEntity(targetX, targetY, targetZ);
		return target.processMessage(new GameUpdate(packetPayload));
	}
}
