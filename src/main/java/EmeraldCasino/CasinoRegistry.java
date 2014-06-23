package EmeraldCasino;

import java.util.List;
import java.util.Map;

import EmeraldCasino.games.*;

public class CasinoRegistry {
	private static CasinoRegistry instance;
	private Map<String, List<IGame>> CasinoGames;
	
	private CasinoRegistry(){
		
	}
	
	public static synchronized CasinoRegistry getInstance(){
		if(instance==null)
			instance= new CasinoRegistry();
		return instance;
	}
	
	public boolean registerGame(gameType type, IGame game)
	{
	
		return false;
	}
	
	public boolean getGame(IGame game)
	{
	
		return false;
	}
	
	
	
}
