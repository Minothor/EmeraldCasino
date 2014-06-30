package emeraldCasino.api.games.card.core;

public interface IDeck {

	void build(int houseLimit, int deckSize);
	
	void addCustomHouse(int houseID, int houseSize);
	
	void burn(ICard card);
	
	void burn();

	String getTexture();

	ICard takeCard();

	void shuffle();

}
