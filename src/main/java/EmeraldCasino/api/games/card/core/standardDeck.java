package emeraldCasino.api.games.card.core;

import emeraldCasino.EmeraldCasino;

public class standardDeck extends ADeck{	
	public standardDeck(){
		textureLocation= EmeraldCasino.MODID+":textures/cardDecks/deck_standard.png";
		build(4,52);
	}
}
