package emeraldCasino.network.packets;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.*;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.MinecraftForge;

import javax.vecmath.Point3d;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;


import emeraldCasino.api.games.EGameType;
import emeraldCasino.blocks.tileEntities.GameEntity;
import emeraldCasino.items.IGameInterfaceItem;


public class PlayerMessage extends AMessage {
	protected EntityClientPlayerMP player;
	private Item gameItems;
	public PlayerMessage() {
		EGameType gameType = EGameType.CARD;
		player = Minecraft.getMinecraft().thePlayer;
		gameItems=emeraldCasino.CasinoRegistry.getGame(gameType, "Poker").getInterfaceItem();
	}
	
	public PlayerMessage(String string) {
		this();
		this.packetPayload=string;
	}
	
	@Override
	public boolean transferData()
	{
		
		return true;
	}
}
