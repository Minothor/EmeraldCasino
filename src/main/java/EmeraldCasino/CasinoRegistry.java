package emeraldCasino;

import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import emeraldCasino.api.games.EGameType;
import emeraldCasino.api.games.IGame;
import emeraldCasino.games.*;

public class CasinoRegistry { 
	private static CasinoRegistry instance;
	private BiMap<String, IGame> CasinoGames;
	
	private CasinoRegistry(){
		
	}
	
	private static synchronized CasinoRegistry getInstance(){
		if(instance==null)
			instance= new CasinoRegistry();
		return instance;
	}
	
	public static boolean registerGame(EGameType type, IGame game)
	{
		getInstance();
		return false;
	}
	
	public static boolean getGame(IGame game)
	{
		getInstance();
		return false;
	}

	
	
	
}
