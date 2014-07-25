package emeraldCasino.api.games.card.core;

import emeraldCasino.EmeraldCasino;

public class DeckStandard extends ADeck{	
	public DeckStandard(){
		textureLocation= EmeraldCasino.MODID+":textures/cardDecks/deck_standard.png";
		build(4,52);
	}
	
	@Override
	public void addCard(ICard card)
	{
		if (card instanceof CardStandard)
		{	
			this.cards.add(card);
		} else {
			System.err.println("Error adding card - Incompatible Card Class.\n Expected cards to be an instance of '"+DeckStandard.class.getSimpleName()+"'\nCard recieved was an instance of: "+ card.getClass().getSimpleName());
		}
	}
	
	@Override
	public void addCards(java.util.List<ICard> cards)
	{
		for (ICard iCard : cards) {
			addCard(iCard);
		}
	}
}
