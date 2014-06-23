package EmeraldCasino.games;

import java.util.List;
import java.util.Map;

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
	
	public boolean registerGame(IGame game)
	{
	
		return false;
	}
	
	public boolean getGame(IGame game)
	{
	
		return false;
	}
	
	
	
}
