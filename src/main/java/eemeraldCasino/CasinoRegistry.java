package emeraldCasino;

import java.util.Map;

import net.minecraft.item.Item;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashBiMap;

import emeraldCasino.api.games.EGameType;
import emeraldCasino.api.games.IGame;

public class CasinoRegistry { 
	private static CasinoRegistry instance;
	//	private BiMap<String, IGame> CasinoGames;
	private HashMultimap<EGameType, Map<String, IGame>> CasinoGames;

	private CasinoRegistry()
	{
		CasinoGames=HashMultimap.create(); 
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
		HashBiMap<String, IGame> gameEntry = HashBiMap.create();
		gameEntry.put(ID, game);
		return getInstance().CasinoGames.put(type, gameEntry);
	}

	public static IGame getGame(EGameType gameType, String gameNBTcondensed)
	{
		Iterable<Map<String,IGame>> typeResults = getInstance().CasinoGames.get(gameType);
		for (Map<String, IGame> map : typeResults) {
			if(map.containsKey(gameNBTcondensed))
				return map.get(gameNBTcondensed);
		}
		return null;
	}

	public static String getGameID(IGame game) {
		if(game!=null)
		{
			EGameType gameType = game.getType();
			Iterable<Map<String,IGame>> typeResults = getInstance().CasinoGames.get(gameType);
			for (Map<String, IGame> map : typeResults) {
				BiMap<IGame, String> invMap = ((BiMap)map).inverse();
				if(invMap.containsKey(game))
					return invMap.get(game);
			}
		}
		return null;
	}




}
