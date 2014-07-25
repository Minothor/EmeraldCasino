package emeraldCasino.api.games.card.core;

import java.util.List;

public interface IDeck {

	void build(int houseLimit, int deckSize);
	
	void addCustomHouse(int houseID, int houseSize);
	
	void addCard(ICard card);
	
	void addCards(List<ICard> cards);
	
	void burn(ICard card);
	
	void burn();

	String getTexture();

	ICard takeCard();

	void shuffle();

}
