package emeraldCasino;

import emeraldCasino.api.games.card.*;
import emeraldCasino.games.cards.*;

public class ECGames {
	private static ICardGame poker5Card;
	
	static void register(){
	poker5Card = new Poker();
	
	emeraldCasino.CasinoRegistry.registerGame(poker5Card);
	}	
}
