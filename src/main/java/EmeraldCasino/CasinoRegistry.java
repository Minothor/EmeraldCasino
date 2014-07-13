package emeraldCasino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.world.WorldSettings.GameType;

import com.google.common.collect.BiMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import emeraldCasino.api.games.EGameType;
import emeraldCasino.api.games.IGame;
import emeraldCasino.games.*;

public class CasinoRegistry { 
	private static CasinoRegistry instance;
//	private BiMap<String, IGame> CasinoGames;
	private Map<EGameType, Map<String,IGame>> CasinoGames;
	
	private CasinoRegistry()
	{
		CasinoGames=new HashMap<EGameType, Map<String,IGame>>();
	}
	
	private static synchronized CasinoRegistry getInstance(){
		if(instance==null)
			instance= new CasinoRegistry();
		return instance;
	}
	
	public static boolean registerGame(IGame game)
	{
		EGameType type = game.getType();
		String ID = game.getID();
		HashMap<String, IGame> gameEntry = new HashMap<String, IGame>();
		gameEntry.put(ID, game);
		boolean result =((getInstance().CasinoGames.put(type, gameEntry))!=null);
		return result;
	}
	
	public static IGame getGame(EGameType gameType, String gameNBTcondensed)
	{
		return getInstance().CasinoGames.get(gameType).get(gameNBTcondensed);
	}

	
	
	
}
